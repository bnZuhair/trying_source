export function getLocalTasks(type) {
  return JSON.parse(localStorage.getItem(type)) || [];
}

export function setLocalTasks(target, value) {
  localStorage.setItem(target, JSON.stringify(value) || []);
}

export function getLocalData(target) {
  const data = localStorage.getItem(target);
  return JSON.parse(data);
}

export function setLocalData(target, value = null) {
  localStorage.setItem(target, JSON.stringify(value));
}
