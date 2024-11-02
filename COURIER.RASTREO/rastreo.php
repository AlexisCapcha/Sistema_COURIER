<?php
session_start();

// Verificar si hay datos en la sesión
if (!isset($_SESSION['estado']) || !isset($_SESSION['fecha_actualizacion']) || !isset($_SESSION['numero_orden'])) {
    echo "No hay información de rastreo disponible.";
    exit;
}
?>

<!DOCTYPE html> 
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="header.css">
    <style>
        /* Aplicar la fuente Open Sans a todo el contenido */
        body {
            font-family: 'Open Sans', sans-serif;
            margin: 0;
            padding: 0px;
            background: url('fondorastreo.png') no-repeat center center fixed;
            background-size: cover;
            height: 100%;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        /* Estilos para el header */
        header {
            background-color: #e30613;
            padding: 16px;
        }

        .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            height: 40px; 
        }

        .logo {
            height: 280px;
        }

        nav a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-weight: bold;
        }

        .icons i {
            font-size: 20px;
            color: white;
            margin-left: 15px;
        }

        /* Centrar el contenedor principal y añadir margen superior */
        .content-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-grow: 1; /* Hace que el contenido ocupe todo el espacio vertical disponible */
            padding: 20px;
        }

        .order-details {
            display: flex;
            align-items: center;
            justify-content: flex-start;
            gap: 20px;
            padding: 30px;
            background-color: rgba(249, 249, 249, 0.9); /* Fondo semitransparente */
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 1100px;
            margin: 0 auto;
        }

        .order-image {
            flex-shrink: 0;
            width: 150px;
        }

        .order-image img {
            width: 100%;
            height: auto;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .order-info {
            flex-grow: 1;
            padding-left: 20px;
        }

        .order-info h2 {
            color: #e30613;
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 15px;
        }

        .order-info p,
        .order-info div {
            font-size: 18px;
            margin-bottom: 10px;
            color: #333;
        }

        .order-info strong {
            font-weight: bold;
            color: #333;
        }

        .order-info span {
            display: inline-block;
            background-color: #e30613;
            color: white;
            padding: 8px 15px;
            border-radius: 12px;
            font-size: 16px;
        }

        /* Estilos del botón "Realizar otra consulta" */
        .btn-consulta {
            display: block;
            background-color: #e30613;
            color: white;
            padding: 15px 20px;
            border: none;
            border-radius: 5px;
            text-align: center;
            font-size: 16px;
            font-weight: bold;
            text-decoration: none;
            margin: 20px auto;
            max-width: 300px;
        }

        .btn-consulta:hover {
            background-color: #d00511;
        }

        /* Footer */
        footer {
            background-color: white;
            padding: 20px 0;
            text-align: center;
            margin-top: 20px;
        }

        footer .social-icons {
            display: flex;
            justify-content: center;
            gap: 20px;
            font-size: 24px;
        }

        footer .social-icons a {
            color: #e30613;
            text-decoration: none;
        }
    </style>
    <title>EntregaFacil Tracking</title>
</head>
<body>
    <!-- Header -->
    <header>
        <div class="container">
            <img src="logonave.png" alt="EntregaFacil Logo" class="logo">
            <nav>
                <a href="#"><i class="fas fa-home"></i>Inicio</a>
                <a href="#" class="border-b-2"><i class="fas fa-search"></i>Rastrea</a>
                <a href="#"><i class="fas fa-money-bill-wave"></i>Págalo</a>
                <a href="#"><i class="fas fa-map-marker-alt"></i>Agencias</a>
                <a href="#"><i class="fas fa-box"></i>Tarifas</a>
                <div class="icons">
                    <i class="fas fa-shopping-cart"></i>
                    <i class="fas fa-user-circle"></i>
                </div>
            </nav>
        </div>
    </header>

    <!-- Order Tracking Section -->
    <div class="content-container">
        <main>
            <div class="content">
                <div class="order-details">
                    <!-- Información del pedido -->
                    <div class="order-info">
                        <h2>Estado del pedido: <?php echo $_SESSION['estado']; ?></h2>
                        <div>
                            <span>N° DE ORDEN: <?php echo $_SESSION['numero_orden']; ?></span>
                        </div>
                        <p>Última actualización: <strong><?php echo $_SESSION['fecha_actualizacion']; ?></strong></p>
                        <p>Destinatario: <strong><?php echo $_SESSION['destinatario_nombre']; ?></strong></p>
                        <p>Dirección del destinatario: <strong><?php echo $_SESSION['destinatario_direccion']; ?></strong></p>
                        <p>Descripción del paquete: <strong><?php echo $_SESSION['descripcion']; ?></strong></p>
                    </div>

                    <!-- Imagen al costado de la información -->
                    <div class="order-image">
                        <img src="servicio-al-cliente.png" alt="Imagen del paquete">
                    </div>
                </div>

                <!-- Botón para realizar otra consulta -->
                <a href="courier.html" class="btn-consulta">Realizar otra consulta</a>
            </div>
        </main>
    </div>
    
    <!-- Footer -->
    <footer>
        <div class="social-icons">
            <a href="#"><i class="fab fa-facebook"></i></a>
            <a href="#"><i class="fab fa-instagram"></i></a>
            <a href="#"><i class="fab fa-youtube"></i></a>
            <a href="#"><i class="fab fa-tiktok"></i></a>
            <a href="#"><i class="fab fa-whatsapp"></i></a>
        </div>
    </footer>
</body>
</html>

<?php
// Limpiar la sesión después de mostrar los datos
session_unset();
session_destroy();
?>
