package by.infosite.configuration;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.ByteBuffer;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new SHA256PasswordEncoder();
    }

    private class SHA256PasswordEncoder implements PasswordEncoder {

        @Override
        public String encode(CharSequence rawPassword) {
            return new DigestUtils("SHA3-256").digestAsHex((ByteBuffer) rawPassword);
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
           return encode(rawPassword).equals(encodedPassword);
        }
    }
}
