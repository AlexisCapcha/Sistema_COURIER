<?php
// Conexión a la base de datos
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "sistemacourier";
$port = 33065;

// Crear la conexión
$conn = new mysqli($servername, $username, $password, $dbname, $port);

// Verificar la conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

// Obtener el número de orden desde el formulario
$numero_orden = $_POST['numero_orden'];

// Consulta a la base de datos, incluyendo el destinatario y la descripción del paquete
$sql = "SELECT t.estado_actual, t.fecha_actualizacion, 
               p.destinatario_nombre, p.destinatario_direccion, p.descripcion
        FROM Tracking t
        INNER JOIN Envio e ON t.envio_id = e.id
        INNER JOIN Paquete p ON e.paquete_id = p.id
        INNER JOIN Pedido pd ON p.pedido_id = pd.id
        WHERE pd.claveOrden = ? 
        ORDER BY t.fecha_actualizacion DESC 
        LIMIT 1";

$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $numero_orden);
$stmt->execute();
$result = $stmt->get_result();

// Verificar si hay resultados
if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();

    // Iniciar sesión y guardar los datos del pedido
    session_start();
    $_SESSION['estado'] = $row['estado_actual'];
    $_SESSION['fecha_actualizacion'] = $row['fecha_actualizacion'];
    $_SESSION['numero_orden'] = $numero_orden;
    $_SESSION['destinatario_nombre'] = $row['destinatario_nombre'];
    $_SESSION['destinatario_direccion'] = $row['destinatario_direccion'];
    $_SESSION['descripcion'] = $row['descripcion'];

    // Redirigir a la página de rastreo
    header("Location: rastreo.php");
} else {
    echo "No se encontró ningún pedido con esa clave de orden.";
}

// Cerrar la conexión
$stmt->close();
$conn->close();
?>
