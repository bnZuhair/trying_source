import { useState, type ChangeEvent } from "react";
export default function App() {
   return (
      <div className="flex justify-center items-center h-screen">
         <Clock />
      </div>
   );
}


// const delay = (time: number) => { return new Promise(resolve => { setTimeout(resolve, time) }) };
//       await delay(1000);
function Clock() {
   const [min, setMin] = useState(0);
   const [sec, setSec] = useState(0);

   async function startTimer() {
      //maybe
      while (sec > 0) {
         await new Promise(resolve => { setTimeout(resolve, 1000) });
         setSec(sec => sec - 1);
      }
   }
   function restHandler() {
      setMin(0);
      setSec(0);
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
            <Button key='1' text="start" handler={startTimer} />
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
