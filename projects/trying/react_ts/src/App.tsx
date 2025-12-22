export default function App() {
   return (
      <div className="flex justify-center items-center">

         <Clock min={"00"} sec={"10"} />

      </div>
   );
}

interface ClockProps {
   min: string;
   sec: string;
}

function Clock({ min, sec }: ClockProps) {
   return (
      <div className="">
         <Conter value={min} />
         <Conter value={sec} />
      </div>
   )
}

function Conter({ value }: { value: string }) {
   return (
      <input
         className="text-red-400 orbitron text-xl"
         value={value} />
   );
}
