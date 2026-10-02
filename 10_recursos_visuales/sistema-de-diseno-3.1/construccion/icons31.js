// Íconos nuevos de 3.1, en la retícula de 24 (área útil 2–22), trazo 1,75, extremos redondeados.
// Partes: { d } trazado, { c: [cx, cy, r] } círculo, { r: [x, y, w, h, rx] } rectángulo; accent = azul; fill: 'ink' | 'accent'; stroke: 'none'.
const FLOOR = { d: 'M3.5 21.1H20.5', accent: true }; // el renglón como suelo: el lugar donde empieza

module.exports = {
  // ----- Lugares de la casa (doc 23, «Dónde»): llevan el renglón como suelo -----
  puerta: { label: 'Junto a la puerta', group: 'lugares', parts: [
    { d: 'M7 18.6V4.9Q7 3.5 8.4 3.5H15.6Q17 3.5 17 4.9V18.6' },
    { d: 'M4.75 18.6H19.25' },
    { c: [14.4, 11.6, 0.95], fill: 'ink', stroke: 'none' },
    FLOOR] },
  cama: { label: 'En la cama o la pieza', group: 'lugares', parts: [
    { d: 'M4 6.5V18.6' },
    { d: 'M4 14.6H20V18.6' },
    { r: [6, 10.6, 4.5, 4, 1.5] },
    { d: 'M12.25 14.6V12.6Q12.25 11.4 13.45 11.4H18.8Q20 11.4 20 12.6V14.6' },
    FLOOR] },
  velador: { label: 'En el velador', group: 'lugares', parts: [
    { r: [6, 12.6, 12, 6, 1.4] },
    { d: 'M6 15.6H18' },
    { d: 'M11 14.1H13' },
    { d: 'M8.9 9.6L10.1 4.6H13.9L15.1 9.6Z' },
    { d: 'M12 9.6V12.6' },
    FLOOR] },
  escritorio: { label: 'En el escritorio', group: 'lugares', parts: [
    { d: 'M3.5 10.6H20.5' },
    { d: 'M5.5 10.6V18.6M18.5 10.6V18.6' },
    { r: [13.5, 10.6, 5, 4.25, 0] },
    { d: 'M15.25 12.75H16.75' },
    { r: [7, 6.85, 4.75, 3.75, 0.9] },
    FLOOR] },
  mesa: { label: 'En la mesa', group: 'lugares', parts: [
    { d: 'M3.5 10.6H20.5' },
    { d: 'M6.25 10.6L5.25 18.6M17.75 10.6L18.75 18.6' },
    { r: [8.6, 6.85, 4.5, 3.75, 0.9] },
    { d: 'M13.1 7.75H13.85Q15.1 7.75 15.1 8.75Q15.1 9.75 13.85 9.75H13.1' },
    FLOOR] },
  sillon: { label: 'En el sillón', group: 'lugares', parts: [
    { d: 'M6.5 11.6V8Q6.5 5.6 8.9 5.6H15.1Q17.5 5.6 17.5 8V11.6' },
    { d: 'M4 12.75Q4 11.1 5.6 11.1Q7.2 11.1 7.2 12.75V14.6H16.8V12.75Q16.8 11.1 18.4 11.1Q20 11.1 20 12.75V16.85Q20 17.35 19.5 17.35H4.5Q4 17.35 4 16.85Z' },
    { d: 'M6 17.35V18.6M18 17.35V18.6' },
    FLOOR] },
  estante: { label: 'Junto al estante', group: 'lugares', parts: [
    { d: 'M4.5 18.6V4.9Q4.5 3.5 5.9 3.5H18.1Q19.5 3.5 19.5 4.9V18.6' },
    { d: 'M4.5 10H19.5M4.5 15.5H19.5' },
    { d: 'M7.5 10V6.25M9.5 10V6.75M11.5 10V6.25M13.4 10L15.3 6.9' },
    { r: [7.25, 12.1, 4.75, 3.4, 0.6] },
    FLOOR] },
  cocina: { label: 'En la cocina', group: 'lugares', parts: [
    { r: [4.5, 12.1, 15, 6.5, 1.4] },
    { d: 'M4.5 14.85H19.5' },
    { c: [8, 16.75, 0.6], fill: 'ink', stroke: 'none' },
    { c: [12, 16.75, 0.6], fill: 'ink', stroke: 'none' },
    { c: [16, 16.75, 0.6], fill: 'ink', stroke: 'none' },
    { d: 'M8.25 8.85H15.75V10.85Q15.75 12.1 14.5 12.1H9.5Q8.25 12.1 8.25 10.85Z' },
    { d: 'M7.25 8.85H16.75M12 8.85V7.35' },
    FLOOR] },
  ventana: { label: 'Junto a la ventana', group: 'lugares', parts: [
    { r: [5, 3.5, 14, 13.6, 1.4] },
    { d: 'M12 3.5V17.1M5 10.3H19' },
    { d: 'M3.5 18.6H20.5' },
    FLOOR] },
  mochila: { label: 'Junto a la mochila', group: 'lugares', parts: [
    { r: [6, 6.1, 12, 12.5, 3.2] },
    { d: 'M9.75 6.1V5.1Q9.75 3.5 11.35 3.5H12.65Q14.25 3.5 14.25 5.1V6.1' },
    { r: [8.5, 12.1, 7, 4.5, 1.4] },
    { d: 'M6 10.1H18' },
    FLOOR] },
  canasto: { label: 'Junto al canasto', group: 'lugares', parts: [
    { d: 'M5 9.6H19L17.7 18.6H6.3Z' },
    { d: 'M5.6 13.6H18.4' },
    { d: 'M8.25 9.6Q8.75 6.6 11.75 7.1Q14.25 7.5 15.5 9.6' },
    FLOOR] },

  // ----- Actividades de doc 23 que no tenían ícono -----
  trotar: { label: 'Salir a trotar', group: 'actividades', parts: [
    { d: 'M5.5 16.5V9.6C5.5 8.6 6.6 8.1 7.4 8.6L9.9 10.2L12.9 7.6C14 9.7 16.1 11.1 19.1 11.6C21.2 11.9 22 13.2 22 15.1V16.5Z' },
    { d: 'M5.5 16.5V18.25A1 1 0 0 0 6.5 19.25H21A1 1 0 0 0 22 18.25V16.5' },
    { d: 'M2 11.5H3.5M2 14.5H3.5' }] },
  gimnasio: { label: 'Ir al gimnasio', group: 'actividades', parts: [
    { d: 'M7 9.5H17Q20.5 9.5 20.5 13.75Q20.5 18 17 18H7Q3.5 18 3.5 13.75Q3.5 9.5 7 9.5Z' },
    { d: 'M9 9.5V8Q9 6.5 10.5 6.5H13.5Q15 6.5 15 8V9.5' },
    { d: 'M7.25 12.6H16.75' }] },
  yoga: { label: 'Estirar o hacer yoga', group: 'actividades', parts: [
    { r: [2.75, 16.1, 13, 3.15, 0.9] },
    { c: [17.6, 14.4, 3.65] },
    { c: [17.6, 14.4, 1.2] }] },
  comic: { label: 'Leer un cómic o manga', group: 'actividades', parts: [
    { r: [3.5, 7, 11, 13.5, 1.6] },
    { d: 'M3.5 13.5H14.5M9 7V13.5' },
    { d: 'M17.25 3H19.5Q21 3 21 4.5V7.5Q21 9 19.5 9H19.25L17.75 10.5V9H17.25Q15.75 9 15.75 7.5V4.5Q15.75 3 17.25 3Z' }] },
  teclado: { label: 'Tocar teclado', group: 'actividades', parts: [
    { r: [2.75, 7, 18.5, 10, 1.75] },
    { d: 'M7.5 12V17M12 12V17M16.5 12V17' },
    { r: [6.25, 7, 2.5, 5, 0.6], fill: 'ink', stroke: 'none' },
    { r: [10.75, 7, 2.5, 5, 0.6], fill: 'ink', stroke: 'none' },
    { r: [15.25, 7, 2.5, 5, 0.6], fill: 'ink', stroke: 'none' }] },
  tejer: { label: 'Tejer o bordar', group: 'actividades', parts: [
    { c: [10, 14, 6] },
    { d: 'M4.6 11.6Q9.75 12.5 13.5 18.9' },
    { d: 'M6.6 9Q11.6 10.5 15.6 16.6' },
    { d: 'M12.9 9.1L20 3M15.2 11.3L20.75 6.6' }] },
  hornear: { label: 'Hornear', group: 'actividades', parts: [
    { d: 'M4.5 13Q4.5 7.5 12 7.5Q19.5 7.5 19.5 13V16.75Q19.5 18 18.25 18H5.75Q4.5 18 4.5 16.75Z' },
    { d: 'M8.5 10.75L10 12.5M12 10L13.5 11.75M15.5 10.75L17 12.5' }] },
  idioma: { label: 'Practicar un idioma', group: 'actividades', parts: [
    { d: 'M5 4.75H12.5Q14 4.75 14 6.25V11.25Q14 12.75 12.5 12.75H8.4L5.4 15.1V12.75H5Q3.5 12.75 3.5 11.25V6.25Q3.5 4.75 5 4.75Z' },
    { d: 'M17 9H19Q20.5 9 20.5 10.5V15.5Q20.5 17 19 17H18.6V19.3L15.6 17H11.5Q10 17 10 15.5V15.1' },
    { d: 'M6.5 8H11M6.5 10H9.25' }] },
  sudoku: { label: 'Hacer un sudoku', group: 'actividades', parts: [
    { r: [4, 4, 16, 16, 2] },
    { d: 'M9.33 4V20M14.67 4V20M4 9.33H20M4 14.67H20' },
    { c: [12, 12, 1.1], fill: 'ink', stroke: 'none' }] },
  proyecto: { label: 'Avanzar un proyecto propio', group: 'actividades', parts: [
    { d: 'M5 5.75H9.25L11 7.75H19Q20.5 7.75 20.5 9.25V17.25Q20.5 18.75 19 18.75H5Q3.5 18.75 3.5 17.25V7.25Q3.5 5.75 5 5.75Z' },
    { d: 'M10 15.5L14 11.5M11.25 11.5H14V14.25' }] },
  ropa: { label: 'Lavar la ropa', group: 'actividades', parts: [
    { r: [5, 3.5, 14, 17, 2.2] },
    { c: [12, 13.25, 4.25] },
    { d: 'M8.9 14.1Q10.45 12.85 12 14.1Q13.55 15.35 15.1 14.1' },
    { d: 'M11.5 6.6H16' },
    { c: [8, 6.6, 0.7], fill: 'ink', stroke: 'none' }] },
  taper: { label: 'Preparar la comida de mañana', group: 'actividades', parts: [
    { r: [4, 10.75, 16, 8.25, 2] },
    { r: [3.25, 7.5, 17.5, 3.25, 1.2] },
    { r: [10.4, 9.9, 3.2, 2.6, 0.6] },
    { d: 'M7.5 15H16.5' }] },
  huella: { label: 'Pasear al perro', group: 'actividades', parts: [
    { d: 'M8 16.1Q8 12.6 12 12.6Q16 12.6 16 16.1Q16 18.6 13.8 18.6Q13 18.6 12 18.1Q11 18.6 10.2 18.6Q8 18.6 8 16.1Z' },
    { c: [6.1, 10.6, 1.65] },
    { c: [9.6, 7, 1.65] },
    { c: [14.4, 7, 1.65] },
    { c: [17.9, 10.6, 1.65] }] },
  meditar: { label: 'Respirar o meditar', group: 'actividades', parts: [
    { d: 'M4 15.75Q4 12.75 12 12.75Q20 12.75 20 15.75Q20 18.75 12 18.75Q4 18.75 4 15.75Z' },
    { c: [12, 7.25, 2.6] }] },

  // ----- El ciclo (memoria, capítulo 11): armar y cerrar -----
  armar: { label: 'Armar el ciclo', group: 'ciclo', parts: [
    { r: [3, 7.5, 18, 9, 4.5] },
    { c: [16.5, 12, 2.6], fill: 'accent', stroke: 'none', accent: true }] },
  'cerrar-ciclo': { label: 'Cerrar el ciclo', group: 'ciclo', parts: [
    { d: 'M14.6 3.85A8.5 8.5 0 1 1 9.4 3.85' },
    { c: [12, 3.5, 1.6], fill: 'accent', stroke: 'none', accent: true }] },

  // ----- El testigo (el objeto, vista superior) y sus estados -----
  testigo: { label: 'El testigo en reposo', group: 'objeto', parts: [
    { c: [12, 12, 8.5] },
    { c: [9.5, 9.5, 0.8], fill: 'ink', stroke: 'none' }, { c: [12, 9.5, 0.8], fill: 'ink', stroke: 'none' }, { c: [14.5, 9.5, 0.8], fill: 'ink', stroke: 'none' },
    { c: [9.5, 12, 0.8], fill: 'ink', stroke: 'none' }, { c: [12, 12, 0.8], fill: 'ink', stroke: 'none' }, { c: [14.5, 12, 0.8], fill: 'ink', stroke: 'none' },
    { c: [9.5, 14.5, 0.8], fill: 'ink', stroke: 'none' }, { c: [12, 14.5, 0.8], fill: 'ink', stroke: 'none' }, { c: [14.5, 14.5, 0.8], fill: 'ink', stroke: 'none' }] },
  'testigo-sonando': { label: 'El testigo suena', group: 'objeto', parts: [
    { c: [10, 12, 6.5] },
    { c: [8.25, 10.25, 0.7], fill: 'accent', stroke: 'none', accent: true }, { c: [11.75, 10.25, 0.7], fill: 'accent', stroke: 'none', accent: true },
    { c: [8.25, 13.75, 0.7], fill: 'accent', stroke: 'none', accent: true }, { c: [11.75, 13.75, 0.7], fill: 'accent', stroke: 'none', accent: true },
    { d: 'M18.6 9A4.6 4.6 0 0 1 18.6 15' },
    { d: 'M21 6.9A7.6 7.6 0 0 1 21 17.1' }] },
  'testigo-problema': { label: 'Problema técnico del testigo', group: 'objeto', parts: [
    { d: 'M16.25 4.65A8.5 8.5 0 1 0 20.5 12' },
    { c: [9.5, 9.5, 0.8], fill: 'ink', stroke: 'none' }, { c: [12, 12, 0.8], fill: 'ink', stroke: 'none' }, { c: [9.5, 14.5, 0.8], fill: 'ink', stroke: 'none' }, { c: [14.5, 14.5, 0.8], fill: 'ink', stroke: 'none' },
    { d: 'M20 3.25V6.25' },
    { c: [20, 8.9, 0.95], fill: 'ink', stroke: 'none' }] },

  // ----- Los tres ámbitos del marco teórico (memoria, capítulo 6) -----
  'ocio-digital': { label: 'La experiencia del ocio digital', group: 'ambitos', parts: [
    { r: [7, 3, 10, 18, 2.5] },
    { d: 'M10.75 9.75V14.25L14.5 12Z' }] },
  'diseno-atencion': { label: 'El diseño de la atención', group: 'ambitos', parts: [
    { d: 'M7 17.5V5.5Q7 3 9.5 3H14.5Q17 3 17 5.5V17.5' },
    { d: 'M9.75 6.5H14.25M9.75 9.5H14.25M9.75 12.5H14.25' },
    { d: 'M9.5 18.5L12 21L14.5 18.5' }] },
  'objetos-lugares': { label: 'Recordar con objetos y lugares', group: 'ambitos', parts: [
    { d: 'M4 10.5L12 4L20 10.5V18.75Q20 20 18.75 20H5.25Q4 20 4 18.75Z' },
    { c: [12, 14.5, 2.4], fill: 'accent', stroke: 'none', accent: true }] },
};
