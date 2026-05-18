 
import os
import shutil

# Rutas dentro de tu repositorio unificado
BASE_DIR = os.getcwd()
CARPETA_MICROSERVICIOS = os.path.join(BASE_DIR, "microservicios")
PLANTILLA_ORIGEN = os.path.join(CARPETA_MICROSERVICIOS, "ms-paciente")

# Lista con los 9 microservicios faltantes para completar los 10 exigidos por Duoc UC
nuevos_ms = [
    {"nombre": "ms-medico", "puerto": "8082"},
    {"nombre": "ms-reserva", "puerto": "8083"},
    {"nombre": "ms-inventario", "puerto": "8084"},
    {"nombre": "ms-historial", "puerto": "8085"},
    {"nombre": "ms-agendamiento", "puerto": "8086"},
    {"nombre": "ms-facturacion", "puerto": "8087"},
    {"nombre": "ms-pabellon", "puerto": "8088"},
    {"nombre": "ms-recetas", "puerto": "8089"},
    {"nombre": "ms-camas", "puerto": "8090"}
]

print("🚀 Iniciando clonación masiva de la arquitectura...")

for ms in nuevos_ms:
    ruta_destino = os.path.join(CARPETA_MICROSERVICIOS, ms["nombre"])
    
    if not os.path.exists(ruta_destino):
        # Clonar la estructura limpia de ms-paciente (sin archivos basura)
        shutil.copytree(PLANTILLA_ORIGEN, ruta_destino, ignore=shutil.ignore_patterns('target', '.git', '.settings', '.classpath', '.project'))
        print(f"📁 Estructura clonada con éxito: {ms['nombre']}")
        
        # Modificar el puerto automáticamente en application.properties para que no choquen
        ruta_properties = os.path.join(ruta_destino, "src", "main", "resources", "application.properties")
        if os.path.exists(ruta_properties):
            with open(ruta_properties, "r", encoding="utf-8") as f:
                lineas = f.readlines()
            
            with open(ruta_properties, "w", encoding="utf-8") as f:
                for linea in lineas:
                    if linea.startswith("server.port="):
                        f.write(f"server.port={ms['puerto']}\n")
                    else:
                        f.write(linea)
            print(f"   ⚓ Puerto configurado en: {ms['puerto']}")
    else:
        print(f"⚠️ {ms['nombre']} ya existía. Saltando...")

print("\n✨ ¡Ecosistema de 10 microservicios creado localmente de forma exitosa!")