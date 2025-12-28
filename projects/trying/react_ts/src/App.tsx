import { useState, type ChangeEvent } from "react";
export default function App() {
   return (
      <div className="flex justify-center items-center h-screen">
         <Clock min={0} sec={10} />
      </div>
   );
}

interface ClockProps {
   min: number;
   sec: number;
}

function Clock({ min = 0, sec = 0 }: ClockProps) {
   return (
      <div className="flex flex-col">
         <div>
            <Counter key='0' value={min} />
            <span className="text-red-400 orbitron text-9xl">:</span>
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
         className={`text-red-400 orbitron text-9xl w-[2ch] ${noButtonDefaults}`}
         value={num.toString().padStart(2, '0')}
         onChange={changeHandler} />
   );
}
