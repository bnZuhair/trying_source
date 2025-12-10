export function getLocalTasks(type) {
  return JSON.parse(localStorage.getItem(type)) || [];
}

export function setLocalTasks(target, value) {
  localStorage.setItem(target, JSON.stringify(value) || []);
}

export function getFilter() {
  return localStorage.getItem("filter") || "all";
}

export function setFilter(filter = "all") {
  localStorage.setItem("filter", filter);
  document.getElementById(filter).checked = true;
}
