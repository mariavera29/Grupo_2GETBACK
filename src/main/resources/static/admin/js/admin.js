// Script para manejar la navegación entre secciones
document.addEventListener("DOMContentLoaded", function () {
  // Ocultar todas las secciones excepto la activa al cargar la página
  document.querySelectorAll(".content-section").forEach((section) => {
    if (!section.classList.contains("active")) {
      section.style.display = "none";
    }
  });

  // Manejar clics en los items del menú
  document.querySelectorAll(".sidebar-menu .menu-item").forEach((item) => {
    item.addEventListener("click", () => {
      // Remover clase active de todos los items del menú
      document
        .querySelectorAll(".sidebar-menu .menu-item")
        .forEach((menuItem) => {
          menuItem.classList.remove("active");
        });

      // Agregar clase active al item clickeado
      item.classList.add("active");

      // Ocultar todas las secciones
      document.querySelectorAll(".content-section").forEach((section) => {
        section.style.display = "none";
        section.classList.remove("active");
      });

      // Mostrar la sección correspondiente
      const sectionId = item.getAttribute("data-section");
      const targetSection = document.getElementById(sectionId);
      if (targetSection) {
        targetSection.style.display = "block";
        targetSection.classList.add("active");
      }

      // Actualizar el título de la página
      document.querySelector(".page-title").textContent = item.textContent;
    });
  });

  // Script para manejar la navegación entre categorías de productos
  document.querySelectorAll(".category-nav button").forEach((button) => {
    button.addEventListener("click", () => {
      // Remover clase active de todos los botones
      document.querySelectorAll(".category-nav button").forEach((btn) => {
        btn.classList.remove("active");
      });

      // Agregar clase active al botón clickeado
      button.classList.add("active");

      // Ocultar todas las secciones
      document.querySelectorAll(".category-section").forEach((section) => {
        section.classList.add("hidden");
      });

      // Mostrar la sección correspondiente
      const category = button.getAttribute("data-category");
      document.getElementById(category).classList.remove("hidden");
    });
  });
});
