/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Estructuras.ArbolEstudiantesBST;
import Modelo.Estudiante;

/**
 *
 * @author Gael
 */
public class EDPF {

    public static void main(String[] args) {
    ArbolEstudiantesBST arbol = new ArbolEstudiantesBST();
    Estudiante e1 = new Estudiante();
    Estudiante e2 = new Estudiante();

    e1.setNombre("Juan Perez");
    e1.setMatricula(253298);
    e2.setNombre("Rosalba Villanueva");
    e2.setMatricula(253299);
    
        System.out.println("Insertando raíz...");
        arbol.insertar(e1);
        
        System.out.println("Insertando menor...");
        arbol.insertar(e2);
        

        System.out.println("¡Si lees esto, el código compiló y se ejecutó sin errores!");
    }
}
