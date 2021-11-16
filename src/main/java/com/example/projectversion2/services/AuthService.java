package com.example.projectversion2.services;
// todo: Serviço de autenticação do usuário;
import com.example.projectversion2.dto.UserDTO;
import com.example.projectversion2.entity.UserEntity;
import com.example.projectversion2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Scope("singleton")
public class AuthService {

   @Autowired
   private UserRepository userRepository;

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public String login(UserDTO user) {
        String CPF = user.getCPF();
        String pass = user.getPass();

        Optional<UserEntity> userFound = userRepository.findByCPFAndPass(CPF, pass);

        if (userFound.isPresent()) {
            userFound.get().setStatus(true);
            userRepository.save(userFound.get());
            return userFound.get().getToken();
        }

        return null;
    }

    public int signup(UserDTO user) {

        // Verificar os dados para criar login

        //NOME
        if (user.getName().trim().equals("") && user.getName().trim().split(" ").length < 2) {
            return 1;
        }
        //CPF
        if (user.getCPF().length() != 11) {

            return 2;
        } else {

            int[] arry;
            arry = ConverterCPF(user);

            int retorno = checkCPF(arry);

            if (retorno == 2){
                return 2;
            }

        }

        //EMAIL
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        if(!matcher.find()) {
            return 3;
        }
        //SENHA
        if (user.getPass().length() < 6) {
            return 4;
        }

        if (userRepository.existsByCPF(user.getCPF())) {
            return 5;
        }

        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPass(user.getPass());
        entity.setCPF(user.getCPF());
        entity.setStatus(false);
        entity.setPermission(1);

        String token = UUID.randomUUID().toString();
        entity.setID(token);


        userRepository.save(entity);

        return 0;
    }

    private int[] ConverterCPF(UserDTO user){
        int[] arry = new int[11];

        for(int i = 0; i < user.getCPF().length(); i++){
            arry[i] = Integer.parseInt(String.valueOf(user.getCPF().charAt(i)));
        }

        return arry;
    }

    private int checkCPF(int[] arry){
        int soma1 = (10*arry[0]) + (9*arry[1]) + (8*arry[2]) + (7*arry[3]) + (6*arry[4]) + (5*arry[5]) + (4*arry[6]) + (3*arry[7]) + (2*arry[8]) ;
        int soma2 = (11*arry[0]) + (10*arry[1]) + (9*arry[2]) + (8*arry[3]) + (7*arry[4]) + (6*arry[5]) + (5*arry[6]) + (4*arry[7]) + (3*arry[8]) + (2*arry[9]);
        int verificador1 = arry[9];
        int verificador2 = arry[10];


        if (soma1%11 == 0 || soma1%11 == 1){
            if(verificador1!=0){
                return 2;
            }
        }else if(verificador1 != 11-(soma1%11)){
            return 2;
        }

        if (soma2%11 == 0 || soma2%11 == 1){
            if(verificador2!=0){
                return 2;
            }
        }else if(verificador2 != 11-(soma2%11)){
            return 2;
        }
        return 0;
    }

    public int checkPermission(int userID) {
        Optional<UserEntity> ret = userRepository.findById(userID);
        if (ret.get().getPermission() == 1){
            return 1;
        }
        return 0;
    }
}

