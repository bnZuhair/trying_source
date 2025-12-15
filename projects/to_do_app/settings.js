import { getLocalData, setLocalData } from "./utils.js";

document.addEventListener("DOMContentLoaded", () => {
  applyFontSize();
  const slider = document.getElementById("fontSlider");
  const resetButton = document.getElementById("resetButton");

  if (slider && resetButton) {
    slider.value = getFontSize();
    slider.addEventListener("input", (e) => {
      setFontSize(e.target.value);
      applyFontSize();
    });

    resetButton.addEventListener("click", () => {
      setFontSize(20);
      applyFontSize();
    });
  }
});

export function applyFontSize() {
  document.body.style.fontSize = `${getFontSize()}px`;
}

function getFontSize() {
  return getLocalData("fontSize") ?? 20;
}

function setFontSize(fontSize) {
  setLocalData("fontSize", fontSize);
}
