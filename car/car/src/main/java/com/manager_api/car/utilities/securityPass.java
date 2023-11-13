package com.manager_api.car.utilities;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class securityPass {

    public String encrypt(String pass) throws NoSuchAlgorithmException {
        // Crear un objeto MessageDigest con el algoritmo SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Obtener los bytes del hash de la contraseña proporcionada
        byte[] hashedBytes = md.digest(pass.getBytes());

        // Convierte los bytes del hash a una representación hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            hexString.append(String.format("%02x", b));
        }

        // Devolver la representación hexadecimal del valor hash SHA-256
        return hexString.toString();
    }

    public String encodeToBase64(String input) {
        byte[] bytes = input.getBytes();
        byte[] encodedBytes = Base64.getEncoder().encode(bytes);

        String encodedString = new String(encodedBytes);

        return encodedString;
    }

    public String decodeToBase64(String cadena){
        String desencriptada = "";

        Base64.Decoder decoder = Base64.getDecoder();

        byte[] decodifica = decoder.decode(cadena);
        return desencriptada = new String(decodifica);
    }

}
