import { getLocalData, setLocalData, setLocalTasks } from "./utils.js";
import { applyFontSize } from "./settings.js";

let filter = "all";
let taskId = parseInt(localStorage.getItem("taskId")) || 0;

window.addEventListener("load", () => {
  showTasks(filter);
});

const filterTasks = document.getElementById("filterTasks");
filterTasks.addEventListener("change", (e) => {
  filter = e.target.value;
  showTasks(filter);
});

const taskInput = document.getElementById("taskInput");
const addButton = document.getElementById("addButton");
addButton.addEventListener("click", () => {
  const value = taskInput.value;
  if (value) {
    taskId++;
    setLocalData("taskId", taskId);
    const tasks = addTask(getLocalData("pendingTasks"), value, taskId);
    setLocalData("pendingTasks", tasks);
    taskInput.value = "";
    showTasks(filter);
  }
});
document.addEventListener("keyup", (event) => {
  if (event.key === "Enter") {
    addButton.click();
  }
});

function addTask(tasks, content, taskId) {
  let tasks_copy = [...tasks];
  tasks_copy.push({ id: taskId, content: content });
  return tasks_copy;
}
function showTasks(filter) {
  const completed = getLocalData("compTasks");
  const pending = getLocalData("pendingTasks");
  clearTasks();
  if (filter == "all") {
    printTasks(pending);
    printTasks(completed, true);
  } else if (filter == "pending") {
    printTasks(pending);
  } else {
    printTasks(completed, true);
  }
}
function printTasks(tasks, iscompleted = false) {
  tasks.reverse().map((task) => {
    const list = document.getElementById("tasks-list");
    const div = document.createElement("div");
    const item = document.createElement("input");
    const label = document.createElement("label");
    const editButton = document.createElement("button");
    const removeButton = document.createElement("button");

    div.setAttribute("class", "task");

    item.setAttribute("type", "checkbox");
    item.setAttribute("id", task.id);

    label.textContent = task.content;
    label.setAttribute("for", task.id);

    editButton.setAttribute("class", "blue-button");
    removeButton.setAttribute("class", "red-button");

    if (iscompleted) {
      item.checked = true;
      label.classList.add("strikethrough");
    }

    editButton.innerHTML =
      '<span class="material-symbols-outlined">edit</span>';

    removeButton.innerHTML =
      '<span class="material-symbols-outlined">delete</span>';
    removeButton.setAttribute("onclick", `removeTaskById(${task.id})`);

    div.appendChild(item);
    div.appendChild(label);
    div.appendChild(editButton);
    div.appendChild(removeButton);
    list.appendChild(div);
  });
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
function removeTaskById(taskId) {
  const taskCheckbox = document.getElementById(taskId);
  const tasks = taskCheckbox.checked
    ? getLocalData("compTasks")
    : getLocalData("pendingTasks");

  const taskIndex = tasks.findIndex((task) => task.id == taskId);
  tasks.splice(taskIndex, 1);
  setLocalTasks(taskCheckbox.checked ? "compTasks" : "pendingTasks", tasks);

  showTasks(filter);
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
    ? getLocalData("pendingTasks")
    : getLocalData("compTasks");
  const taskIndex = tasks.findIndex((task) => task.id == id);

  addTask(tasks, tasks[taskIndex], iscompleted ? "compTasks" : "pendingTasks");
  tasks.splice(taskIndex, 1);
  setLocalTasks(iscompleted ? "pendingTasks" : "compTasks", tasks);
  showTasks(filter);
}
