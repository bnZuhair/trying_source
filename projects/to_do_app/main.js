import { getLocalData, setLocalData, setLocalTasks } from "./utils.js";
import { applyFontSize } from "./settings.js";

let filter = "all";

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
  const content = taskInput.value;
  if (content.trim()) {
    const tasks = getLocalData("pendingTasks") ?? [];
    const tasks_copy = addTask(tasks, content);
    setLocalData("pendingTasks", tasks_copy);
    taskInput.value = "";
    showTasks(filter);
  }
});
document.addEventListener("keyup", (event) => {
  if (event.key === "Enter") {
    addButton.click();
  }
});

function addTask(tasks, content) {
  let tasks_copy = [...tasks];
  tasks_copy.unshift(content);
  return tasks_copy;
}
function showTasks(filter) {
  const completed = getLocalData("compTasks") ?? [];
  const pending = getLocalData("pendingTasks") ?? [];
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
  let counter = 0;
  tasks.map((task) => {
    const list = document.getElementById("tasks-list");
    const div = document.createElement("div");
    const item = document.createElement("input");
    const label = document.createElement("label");
    const editButton = document.createElement("button");
    const removeButton = document.createElement("button");

    div.setAttribute("class", "task");

    item.setAttribute("type", "checkbox");
    item.setAttribute("id", counter);

    label.textContent = task;
    label.setAttribute("for", counter);

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

    div.appendChild(item);
    div.appendChild(label);
    div.appendChild(editButton);
    div.appendChild(removeButton);
    list.appendChild(div);

    counter++;
  });
}
function clearTasks() {
  const list = document.getElementById("tasks-list");
  list.replaceChildren();
}

// TODO: deal with task removing, editing and completion(updating)
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

  addTask(tasks, tasks[id]);
  tasks.splice(id, 1);
  setLocalTasks(iscompleted ? "pendingTasks" : "compTasks", tasks);
  showTasks(filter);
}
