import {
  addToList,
  getLocalTasks,
  removeByContent,
  setLocalData,
} from "./utils.js";
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
    const tasks = getLocalTasks("pendingTasks");
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
  return addToList(tasks, content);
}
function showTasks(filter) {
  const completed = getLocalTasks("compTasks") ?? [];
  const pending = getLocalTasks("pendingTasks") ?? [];
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
    const lable = checkbox.nextElementSibling;
    const content = lable.textContent;
    if (checkbox.checked) {
      lable.classList.add("strikethrough");
      let tasks = getLocalTasks("pendingTasks");
      let tasks_copy = removeByContent(tasks, content);
      setLocalData("pendingTasks", tasks_copy);

      tasks = getLocalTasks("compTasks");
      tasks_copy = addTask(tasks, content);
      setLocalData("compTasks", tasks_copy);
    } else {
      lable.classList.remove("strikethrough");
      let tasks = getLocalTasks("compTasks");
      let tasks_copy = removeByContent(tasks, content);
      setLocalData("compTasks", tasks_copy);

      tasks = getLocalTasks("pendingTasks");
      tasks_copy = addTask(tasks, content);
      setLocalData("pendingTasks", tasks_copy);
    }
    showTasks(filter);
  });
});
