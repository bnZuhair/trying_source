export function getLocalTasks(target) {
  return getLocalData(target) ?? [];
}

export function getLocalData(target) {
  const data = localStorage.getItem(target);
  return JSON.parse(data);
}

export function setLocalData(target, value = null) {
  localStorage.setItem(target, JSON.stringify(value));
}

export const addToList = (list, item) => [item, ...list];
//TODO: find by id => removebyid returns the value?

export const removeByContent = (list, content) =>
  list.filter((item) => item !== content);
