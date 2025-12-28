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
   return (
      <div className="flex flex-col">
         <div className="text-red-400 orbitron">
            <Counter key='0' value={min} />
            <span className="text-9xl">:</span>
            <Counter key='1' value={sec} />
         </div>
         <div className="flex justify-around">
            <Button text="rest" />
            <Button text="start" />
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

function Counter({ value }: { value: number }) {

   const [num, setNum] = useState(value);

   function changeHandler(e: ChangeEvent<HTMLInputElement>) {
      const rawValue = e.target.value;
      let value = parseInt(rawValue);
      if (value > 59) {
         value = 59;
      } else if (value < 0) {
         value = 0;
      }
      setNum(value);
   }
   const noButtonDefaults = "focus:outline-0 box-border appearance-none [&::-webkit-inner-spin-button,&::-webkit-outer-spin-button]:appearance-none";

   return (
      <input type="number" min={0} max={59}
         className={`text-9xl w-[2ch] ${noButtonDefaults}`}
         value={num.toString().padStart(2, '0')}
         onChange={changeHandler} />
   );
}
