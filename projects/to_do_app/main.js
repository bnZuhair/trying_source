let taskId = parseInt(localStorage.getItem("taskId")) || 0;
function setFontSize(fontSize) {
   localStorage.setItem("fontSize", fontSize);
   applyFontSize();
}
function applyFontSize() {
   document.documentElement.setAttribute(
      "style",
      `font-size:${
         localStorage.getItem("fontSize") ||
         setFontSize(20)
      }px`,
   );
}

function addTask(task) {
   const tasks = JSON.parse(localStorage.getItem("pendingTasks")) || [];
   tasks.push({ id: taskId, content: task });
   taskId++;
   localStorage.setItem("taskId", taskId);
   localStorage.setItem("pendingTasks", JSON.stringify(tasks));
         label.classList.add("strikethrough");
document.addEventListener("DOMContentLoaded", () => {
   document.getElementById("tasks-list").addEventListener("change", (e) => {
      const checkbox = e.target;
      const label = checkbox.nextElementSibling;
      checkbox.checked
         ? label.classList.add("strikethrough")
         : label.classList.remove("strikethrough");
      updateTaskState(label.getAttribute("for"), checkbox.checked); // send the id of the task
   });
});
}
