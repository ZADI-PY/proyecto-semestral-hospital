package ms_paciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"ms_paciente", "com.hospital_vm", "com.hospital_vm.cl.ms_paciente"})
@EnableJpaRepositories(basePackages = {"ms_paciente", "com.hospital_vm", "com.hospital_vm.cl.ms_paciente"})
public class MsPacienteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPacienteApplication.class, args);
    }
}