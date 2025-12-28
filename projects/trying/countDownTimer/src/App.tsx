import { useState, type ChangeEvent } from "react";
export default function App() {
   return (
      <div className="flex justify-center items-center h-screen">
         <Clock />
      </div>
   );
}


function Clock() {
   const [min, setMin] = useState(0);
   const [sec, setSec] = useState(0);
   const [isActive, setIsActive] = useState(false);
   let timer: number;

   function startTimer() {
      if (!isActive && (sec || min)) {
         timer = setInterval(updateTime, 1000);
         setIsActive(true);
      }
   }
   function updateTime() {
      if (sec || min) {
         if (sec) {
            setSec(sec => sec - 1);
         }
         else {
            setSec(59);
            setMin(min => min - 1);
         }
      } else {
         stopTimer();
      }
   }
   function stopTimer() {
      clearInterval(timer);
      setIsActive(false);
   }
   function restHandler() {
      setMin(0);
      setSec(0);
      if (isActive)
         stopTimer();
   }
   return (
      <div className="flex flex-col">
         <div className="text-red-400 orbitron">
            <Counter key='0' value={min} onChange={setMin} />
            <span className="text-9xl">:</span>
            <Counter key='1' value={sec} onChange={setSec} />
         </div>
         <div className="flex justify-around">
            <Button key='0' text="rest" handler={restHandler} />
            <Button key='1' text={isActive ? "pause" : "start"} handler={isActive ? stopTimer : startTimer} />
         </div>
      </div>
   );
}
interface ButtonProps {
   text: string,
   handler: () => void
}
function Button({ text, handler = () => { } }: ButtonProps) {
   return (
      <button className="text-gray-500 bg-white rounded-md" onClick={handler}>{text}</button>
   );
}

function Counter({ value, onChange }: { value: number, onChange: (numb: number) => void }) {

   function changeHandler(e: ChangeEvent<HTMLInputElement>) {
      const rawValue = e.target.value;
      let value = parseInt(rawValue);
      if (value > 59) {
         value = 59;
      } else if (value < 0) {
         value = 0;
      }
      onChange(value);
   }
   const noButtonDefaults = "focus:outline-0 box-border appearance-none [&::-webkit-inner-spin-button,&::-webkit-outer-spin-button]:appearance-none";

   return (
      <input type="number" min={0} max={59}
         className={`text-9xl w-[2ch] ${noButtonDefaults}`}
         value={value.toString().padStart(2, '0')}
         onChange={changeHandler} />
   );
}
