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
}
