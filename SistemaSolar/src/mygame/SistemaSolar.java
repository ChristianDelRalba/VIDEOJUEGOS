package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;

public class SistemaSolar extends SimpleApplication {

    // Variables para los ángulos de los planetas
    private double anguloMercurio, anguloVenus, anguloTierra, anguloMarte, anguloJupiter = 0;
    
    // Esferas para el sol y los planetas
    private Sphere sol, mercurio, venus, tierra, marte, jupiter;
    
    // Geometrías para el sol y los planetas
    private Geometry geomSol, geomMercurio, geomVenus, geomTierra, geomMarte, geomJupiter;
    
    // Materiales para el sol y los planetas
    private Material matSol, matMercurio, matVenus, matTierra, matMarte, matJupiter;
    
    // Radio de las órbitas de los planetas
    private int rMercurio = 10;
    private int rVenus = 15;
    private int rTierra = 20;
    private int rMarte = 25;
    private int rJupiter = 35;
    
    // Velocidad angular de los planetas
    private double vMercurio = 0.05;
    private double vVenus = 0.03;
    private double vTierra = 0.02;
    private double vMarte = 0.015;
    private double vJupiter = 0.01;
    
    @Override
    public void simpleInitApp() {
        // Configurar la cámara y el ratón
        flyCam.setEnabled(true);
        flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);
        cam.setLocation(new Vector3f(0f, 0f, 100f));
        flyCam.setMoveSpeed(10);

        
        // Crear las esferas para el sol y los planetas
        sol = new Sphere(32, 32, 5f);
        mercurio = new Sphere(32, 32, 0.5f);
        venus = new Sphere(32, 32, 1f);
        tierra = new Sphere(32, 32, 1f);
        marte = new Sphere(32, 32, 0.8f);
        jupiter = new Sphere(32, 32, 3f);
        
        // Crear las geometrías para el sol y los planetas
        geomSol = new Geometry("Sol", sol);
        geomMercurio = new Geometry("Mercurio", mercurio);
        geomVenus = new Geometry("Venus", venus);
        geomTierra = new Geometry("Tierra", tierra);
        geomMarte = new Geometry("Marte", marte);
        geomJupiter = new Geometry("Jupiter", jupiter);
        
        // Crear los materiales para el sol y los planetas
        matSol = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matMercurio = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matVenus = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matTierra = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matMarte = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matJupiter = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        // Asignar los colores a los materiales
        matSol.setColor("Color", ColorRGBA.Yellow);
        matMercurio.setColor("Color", ColorRGBA.Gray);
        matVenus.setColor("Color", ColorRGBA.Brown);
        matTierra.setColor("Color", ColorRGBA.Blue);
        matMarte.setColor("Color", ColorRGBA.Red);
        matJupiter.setColor("Color", ColorRGBA.Orange);
        
        // Asignar los materiales a las geometrías
        geomSol.setMaterial(matSol);
        geomMercurio.setMaterial(matMercurio);
        geomVenus.setMaterial(matVenus);
        geomTierra.setMaterial(matTierra);
        geomMarte.setMaterial(matMarte);
        geomJupiter.setMaterial(matJupiter);
        
        // Añadir las geometrías al nodo raíz de la escena
        rootNode.attachChild(geomSol);
        rootNode.attachChild(geomMercurio);
        rootNode.attachChild(geomVenus);
        rootNode.attachChild(geomTierra);
        rootNode.attachChild(geomMarte);
        rootNode.attachChild(geomJupiter);
    }

    @Override
    public void simpleUpdate(float tpf) {
        // Actualizar los ángulos de los planetas según sus velocidades angulares
        anguloMercurio = anguloMercurio + vMercurio;
        anguloVenus = anguloVenus + vVenus;
        anguloTierra = anguloTierra + vTierra;
        anguloMarte = anguloMarte + vMarte;
        anguloJupiter = anguloJupiter + vJupiter;
        
        // Convertir los ángulos a radianes
        double radMercurio = FastMath.DEG_TO_RAD * anguloMercurio;
        double radVenus = FastMath.DEG_TO_RAD * anguloVenus;
        double radTierra = FastMath.DEG_TO_RAD * anguloTierra;
        double radMarte = FastMath.DEG_TO_RAD * anguloMarte;
        double radJupiter = FastMath.DEG_TO_RAD * anguloJupiter;
        
        // Calcular las coordenadas de los planetas según sus órbitas
        float xMercurio = (float) Math.sin(radMercurio) * rMercurio;
        float yMercurio = (float) Math.cos(radMercurio) * rMercurio;
        float xVenus = (float) Math.sin(radVenus) * rVenus;
        float yVenus = (float) Math.cos(radVenus) * rVenus;
        float xTierra = (float) Math.sin(radTierra) * rTierra;
        float yTierra = (float) Math.cos(radTierra) * rTierra;
        float xMarte = (float) Math.sin(radMarte) * rMarte;
        float yMarte = (float) Math.cos(radMarte) * rMarte;
        float xJupiter = (float) Math.sin(radMarte) * rJupiter;
        float yJupiter = (float) Math.cos(radJupiter) * rJupiter;
            // Actualizar las posiciones de los planetas según sus coordenadas
    geomMercurio.setLocalTranslation(xMercurio, yMercurio, 0f);
    geomVenus.setLocalTranslation(xVenus, yVenus, 0f);
    geomTierra.setLocalTranslation(xTierra, yTierra, 0f);
    geomMarte.setLocalTranslation(xMarte, yMarte, 0f);
    geomJupiter.setLocalTranslation(xJupiter, yJupiter, 0f);
    
    // Actualizar las rotaciones de los planetas según sus velocidades angulares
    geomMercurio.rotate(0f, 0f, (float) vMercurio);
    geomVenus.rotate(0f, 0f, (float) vVenus);
    geomTierra.rotate(0f, 0f, (float) vTierra);
    geomMarte.rotate(0f, 0f, (float) vMarte);
    geomJupiter.rotate(0f, 0f, (float) vJupiter);
}

public static void main(String[] args) {
    SistemaSolar app = new SistemaSolar();
    app.start();
}
}