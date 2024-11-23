package com.tomilyk.crudito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FisicaArray {
    private static ArrayList<PersonaFisica> personas = new ArrayList<PersonaFisica>();

    @GetMapping("/opcion")
    public String crudsito(String opcion, String name, String lastname, String ine, String rfc) {

        System.out.println(opcion);
            switch (opcion) {
                case "Anadir":
                    return createItem(name, lastname, ine, rfc);
                case "Leer":
                    return readItem(name);
                case "Actualizar":
                    return updateItem(name, lastname, ine, rfc);
                case "Borrar":
                    return deleteItem(name);
                default:
                    return "Opción inválida";
        }
    }

    private static String createItem(String name, String lastname, String ine, String rfc) {
        boolean repetido = false;
        String mensaje = " ";

        for (PersonaFisica item : personas)
        {
            if (item.getRfc().equals((rfc)))
            {
                repetido = true;
                mensaje = "¡¡¡ RFC YA EXISTE!!!";
            }
        }

        if(personas.isEmpty() == true || repetido == false)
        {
            System.out.println("entre al if");
            PersonaFisica persona = new PersonaFisica(name, lastname, ine, rfc);
            System.out.println(persona.toString());
            personas.add(persona);
            mensaje = "Item añadido : " + name + " " + lastname + " " + ine + " " + rfc;
        }
           return mensaje;
    }
    private static String readItem(String name) {
        for (PersonaFisica item : personas){
            if (item.getName().equals(name)){
                return "Item leído: " + item;
            }
        }
        return "Item no entocntrado";
    }
    private static String updateItem(String name, String lastname, String ine, String rfc) {
        for (PersonaFisica item : personas) {
            if (item.getName().equals(name)) {
                item.setLastname(lastname);
                item.setIne(ine);
                item.setRfc(rfc);
                return "Item actualizado: " + item;
            }
        }
        return "Item no encontrado";
    }

    private static String deleteItem(String name) {
        boolean removed = personas.removeIf(item -> item.getName().equals(name));
            personas.removeIf(item -> item.getName().equals(name));
        if (removed) {
            return "Item borrado: " + name;

        } else {
            return "Item no encontrado";
        }
    }
}