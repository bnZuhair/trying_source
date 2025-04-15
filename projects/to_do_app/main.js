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

function addnewTask(task, target = "pendingTasks") {
   const tasks = getLocalTasks(target);
   tasks.push({ id: taskId, content: task });
   taskId++;
   localStorage.setItem("taskId", taskId);
   setLocalTasks(target, tasks);
}
function addTaskto(task, target = "pendingTasks") {
   const tasks = getLocalTasks(target);
   tasks.push(task);
   setLocalTasks(target, tasks);
}
function showTasks(filter = "all") {
   clearTasks();
   if (filter == "all") {
      showPendingTasks();
      showCompTasks();
   } else if (filter == "pending") {
      showPendingTasks();
   } else {
      showCompTasks();
   }
}
function printTasks(tasks, iscompleted = false) {
   tasks.reverse().map((task) => {
      const list = document.getElementById("tasks-list");
      const div = document.createElement("div");
      const item = document.createElement("input");
      const label = document.createElement("label");

      div.setAttribute("class", "task");

      item.setAttribute("type", "checkbox");
      item.setAttribute("id", task.id);

      label.textContent = task.content;
      label.setAttribute("for", task.id);

      if (iscompleted) {
         item.checked = true;
         label.classList.add("strikethrough");
      }

      div.appendChild(item);
      div.appendChild(label);
      list.appendChild(div);
   });
}
function showPendingTasks() {
   const tasks = getLocalTasks("pendingTasks");
   printTasks(tasks);
}
function showCompTasks() {
   const tasks = getLocalTasks("compTasks");
   printTasks(tasks, iscompleted = true);
}
function clearTasks() {
   const list = document.getElementById("tasks-list");
   list.replaceChildren();
}
function removeTasks() {
   localStorage.removeItem("pendingTasks");
   localStorage.removeItem("compTasks");
   clearTasks();
}
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
function updateTaskState(id, iscompleted) {
   const tasks = iscompleted
      ? getLocalTasks("pendingTasks")
      : getLocalTasks("compTasks");
   const taskIndex = tasks.findIndex((task) => task.id == id);
   addTaskto(tasks[taskIndex], iscompleted ? "compTasks" : "pendingTasks");
   tasks.splice(taskIndex, 1);
   setLocalTasks(iscompleted ? "pendingTasks" : "compTasks", tasks);
   showTasks();
}

//utilites
function getLocalTasks(type) {
   return JSON.parse(localStorage.getItem(type)) || [];
}

function setLocalTasks(target, value) {
   localStorage.setItem(target, JSON.stringify(value) || []);
}
