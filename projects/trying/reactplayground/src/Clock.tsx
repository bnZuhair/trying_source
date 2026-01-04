import { useEffect, useRef, useState, type ChangeEvent } from "react";

export default function Clock() {
   const [time, setTime] = useState({ min: 0, sec: 0 });
   const [isActive, setIsActive] = useState(false);
   const timer = useRef<number | null>(null);

   function stopTimer() {
      if (timer.current !== null) {
         clearInterval(timer.current);
         timer.current = null;
         setIsActive(false);
      }
   }

   useEffect(() => {
      return () => stopTimer();
   }, []);

   function startTimer() {
      if (!isActive && (time.sec || time.min)) {
         timer.current = setInterval(updateTime, 1000);
         setIsActive(true);
      }
   }

   function updateTime() {
      setTime((time) => {
         if (time.sec > 1)
            return { ...time, sec: time.sec - 1 };
         else if (time.min > 0)
            return { min: time.min - 1, sec: 59 };
         else {
            stopTimer();
            return { ...time, sec: time.sec - 1 };
         }
      });
   }

   function resetHandler() {
      setTime({ min: 0, sec: 0 });
      if (isActive)
         stopTimer();
   }

   function setSec(num: number) {
      setTime(prev => ({ ...prev, sec: num }));
   }

   function setMin(num: number) {
      setTime(prev => ({ ...prev, min: num }));
   }

   return (
      <div className="flex flex-col bg-black p-8 rounded-lg border-2 border-green-500">
         <div className="text-green-400 orbitron">
            <Counter value={time.min} onChange={setMin} />
            <span className="text-9xl ">:</span>
            <Counter value={time.sec} onChange={setSec} />
         </div>
         <div className="flex justify-around">
            <Button text="reset" handler={resetHandler} />
            <Button text={isActive ? "pause" : "start"} handler={isActive ? stopTimer : startTimer} />
         </div>
      </div>
   );
}

interface ButtonProps {
   text: string;
   handler: () => void;
}

function Button({ text, handler = () => { } }: ButtonProps) {
   return (
      <button className="text-green-400 bg-gray-800 hover:text-shadow-[0_0_10px_#00ff00] hover:shadow-[0_0_10px_#00ff00] rounded-md border border-green-500 p-1 text-2xl" onClick={handler}>{text}</button>
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

   const noInputDefaults = "focus:outline-0 box-border appearance-none [&::-webkit-inner-spin-button,&::-webkit-outer-spin-button]:appearance-none";

   return (
      <input type="number" min={0} max={59}
         className={`text-9xl w-[2ch] ${noInputDefaults}`}
         value={value.toString().padStart(2, '0')}
         onChange={changeHandler} />
   );
}
