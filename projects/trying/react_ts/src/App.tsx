export default function App() {
   return (
      <div className="flex justify-center items-center h-screen">

         <Clock min={"00"} sec={"10"} />

      </div>
   );
}

interface ClockProps {
   min: string;
   sec: string;
}

function Clock({ min = "00", sec = "00" }: ClockProps) {
   return (
      <div className="flex-col">
         <div>
            <Conter key='1' value={min} />
            <Conter key='0' value={sec} />
         </div>
         <div className="flex justify-around">
            <Button text="stop" />
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
      <button className="text-green-200" onClick={handler}>{text}</button>
   );
}

function Conter({ value }: { value: string }) {

   return (
      <input
         className="text-red-400 orbitron text-xl"
         value={value} />
   );
}
