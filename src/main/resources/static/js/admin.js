document.addEventListener('DOMContentLoaded', function() {
    // Navegación entre secciones
    const menuItems = document.querySelectorAll('.menu-item');
    const contentSections = document.querySelectorAll('.content-section');

    menuItems.forEach(item => {
        item.addEventListener('click', function() {
            const targetSection = this.getAttribute('data-section');

            // Actualizar menú activo
            menuItems.forEach(mi => mi.classList.remove('active'));
            this.classList.add('active');

            // Mostrar sección correspondiente
            contentSections.forEach(section => {
                section.classList.remove('active');
                if (section.id === targetSection) {
                    section.classList.add('active');
                    
                    // Si la sección de ventas se muestra, inicializar la gráfica
                    if (section.id === 'ventas') {
                        initSalesChart();
                    }
                }
            });
        });
    });

    // Cambio de tema (modo oscuro/claro)
    const themeSwitch = document.getElementById('theme-switch');
    const themeIcon = themeSwitch.querySelector('i');
    
    // Verificar si hay una preferencia guardada
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme) {
        document.documentElement.setAttribute('data-theme', savedTheme);
        updateThemeIcon(savedTheme);
    }

    themeSwitch.addEventListener('click', function() {
        const currentTheme = document.documentElement.getAttribute('data-theme');
        const newTheme = currentTheme === 'dark' ? 'light' : 'dark';
        
        document.documentElement.setAttribute('data-theme', newTheme);
        localStorage.setItem('theme', newTheme);
        updateThemeIcon(newTheme);
        
        // Actualizar la gráfica si está visible
        if (document.getElementById('ventas').classList.contains('active')) {
            initSalesChart();
        }
    });

    function updateThemeIcon(theme) {
        if (theme === 'dark') {
            themeIcon.classList.remove('fa-moon');
            themeIcon.classList.add('fa-sun');
        } else {
            themeIcon.classList.remove('fa-sun');
            themeIcon.classList.add('fa-moon');
        }
    }

    // Manejo de formularios
    const forms = document.querySelectorAll('form');
    forms.forEach(form => {
        form.addEventListener('submit', function(e) {
            e.preventDefault();
            alert('Cambios guardados correctamente');
        });
    });

    // Navegación por categorías de productos
    const categoryButtons = document.querySelectorAll('.category-nav .btn');
    const categorySections = document.querySelectorAll('.category-section');

    categoryButtons.forEach(button => {
        button.addEventListener('click', function() {
            const targetCategory = this.getAttribute('data-category');
            
            // Actualizar botón activo
            categoryButtons.forEach(btn => btn.classList.remove('active'));
            this.classList.add('active');
            
            // Mostrar categoría correspondiente
            categorySections.forEach(section => {
                section.style.display = 'none';
                if (section.id === targetCategory) {
                    section.style.display = 'block';
                }
            });
        });
    });

    // Inicializar la gráfica de ventas si la sección está activa al cargar
    if (document.getElementById('ventas').classList.contains('active')) {
        initSalesChart();
    }

    // Función para inicializar la gráfica de ventas
    function initSalesChart() {
        // Verificar si el canvas ya existe
        if (document.getElementById('salesChart')) {
            const ctx = document.getElementById('salesChart').getContext('2d');
            
            // Destruir gráfica existente si hay una
            if (window.salesChartInstance) {
                window.salesChartInstance.destroy();
            }
            
            // Determinar colores según el tema actual
            const isDarkTheme = document.documentElement.getAttribute('data-theme') === 'dark';
            const gridColor = isDarkTheme ? 'rgba(255, 255, 255, 0.1)' : 'rgba(0, 0, 0, 0.1)';
            const textColor = isDarkTheme ? '#E0E0E0' : '#333333';
            
            // Datos de ejemplo para la gráfica
            const salesData = {
                labels: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
                datasets: [{
                    label: 'Ventas mensuales ($)',
                    data: [18500, 21200, 19800, 24500, 23100, 28900, 31200, 29800, 26700, 28500, 30100, 32400],
                    backgroundColor: 'rgba(112, 27, 164, 0.2)',
                    borderColor: 'rgba(112, 27, 164, 1)',
                    borderWidth: 2,
                    tension: 0.4,
                    fill: true
                }]
            };

            // Opciones de la gráfica
            const options = {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: true,
                        position: 'top',
                        labels: {
                            color: textColor
                        }
                    },
                    tooltip: {
                        mode: 'index',
                        intersect: false,
                        backgroundColor: isDarkTheme ? '#2a2a2a' : '#ffffff',
                        titleColor: textColor,
                        bodyColor: textColor,
                        borderColor: 'rgba(112, 27, 164, 0.5)',
                        borderWidth: 1
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        grid: {
                            color: gridColor
                        },
                        ticks: {
                            color: textColor,
                            callback: function(value) {
                                return '$' + value.toLocaleString();
                            }
                        }
                    },
                    x: {
                        grid: {
                            display: false
                        },
                        ticks: {
                            color: textColor
                        }
                    }
                }
            };

            // Crear la gráfica
            window.salesChartInstance = new Chart(ctx, {
                type: 'line',
                data: salesData,
                options: options
            });

            // Event listeners para los botones de período
            const dailyBtn = document.getElementById('daily-chart');
            const weeklyBtn = document.getElementById('weekly-chart');
            const monthlyBtn = document.getElementById('monthly-chart');
            const yearlyBtn = document.getElementById('yearly-chart');
            
            if (dailyBtn && weeklyBtn && monthlyBtn && yearlyBtn) {
                // Remover event listeners previos para evitar duplicados
                dailyBtn.replaceWith(dailyBtn.cloneNode(true));
                weeklyBtn.replaceWith(weeklyBtn.cloneNode(true));
                monthlyBtn.replaceWith(monthlyBtn.cloneNode(true));
                yearlyBtn.replaceWith(yearlyBtn.cloneNode(true));
                
                // Agregar nuevos event listeners
                document.getElementById('daily-chart').addEventListener('click', function() {
                    updateChartPeriod('daily');
                    setActiveButton(this);
                });
                
                document.getElementById('weekly-chart').addEventListener('click', function() {
                    updateChartPeriod('weekly');
                    setActiveButton(this);
                });
                
                document.getElementById('monthly-chart').addEventListener('click', function() {
                    updateChartPeriod('monthly');
                    setActiveButton(this);
                });
                
                document.getElementById('yearly-chart').addEventListener('click', function() {
                    updateChartPeriod('yearly');
                    setActiveButton(this);
                });
            }

            function setActiveButton(button) {
                // Remover clase active de todos los botones
                document.querySelectorAll('.chart-periods .btn').forEach(btn => {
                    btn.classList.remove('active');
                });
                
                // Agregar clase active al botón clickeado
                button.classList.add('active');
            }

            function updateChartPeriod(period) {
                let newData;
                
                switch(period) {
                    case 'daily':
                        newData = {
                            labels: ['8:00', '10:00', '12:00', '14:00', '16:00', '18:00', '20:00', '22:00'],
                            data: [1200, 2500, 4200, 3800, 5100, 7800, 9200, 6400]
                        };
                        break;
                    case 'weekly':
                        newData = {
                            labels: ['Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb', 'Dom'],
                            data: [8200, 9500, 11200, 10500, 13800, 18700, 15400]
                        };
                        break;
                    case 'monthly':
                        newData = {
                            labels: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
                            data: [18500, 21200, 19800, 24500, 23100, 28900, 31200, 29800, 26700, 28500, 30100, 32400]
                        };
                        break;
                    case 'yearly':
                        newData = {
                            labels: ['2020', '2021', '2022', '2023', '2024'],
                            data: [215000, 248000, 285000, 312000, 289000]
                        };
                        break;
                }
                
                // Actualizar la gráfica
                window.salesChartInstance.data.labels = newData.labels;
                window.salesChartInstance.data.datasets[0].data = newData.data;
                window.salesChartInstance.update();
            }
        }
    }

    // Función para cerrar sesión
    function logout() {
        if (confirm('¿Estás seguro de que deseas cerrar sesión?')) {
            // Aquí iría la lógica para cerrar sesión
            // Por ejemplo, redirigir a la página de login
            alert('Sesión cerrada con éxito');
            window.location.href = 'login.html'; // Cambia por tu URL de login
        }
    }
    
    // Agregar event listeners a los botones de cerrar sesión
    document.getElementById('logout-btn').addEventListener('click', logout);
    document.getElementById('logout-menu-item').addEventListener('click', logout);
});