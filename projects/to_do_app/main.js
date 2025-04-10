function setFontSize(fontSize) {
   localStorage.setItem("fontSize", fontSize);
   applyFontSize();
}
function applyFontSize() {
   document.documentElement.setAttribute(
      "style",
      `font-size:${
         localStorage.getItem("fontSize") ||
         setFontSize(16)
      }px`,
   );
}

function setSlider() {
   return document.documentElement.style.fontSize;
}
