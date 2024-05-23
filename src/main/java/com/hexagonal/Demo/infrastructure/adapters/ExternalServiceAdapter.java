package com.hexagonal.Demo.infrastructure.adapters;

import com.hexagonal.Demo.domain.models.AdditionalTaskInfo;
import com.hexagonal.Demo.domain.ports.out.ExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo get(Long id) {
        String url = "https://jsonplaceholder.typicode.com/todos/" + id;
        ResponseEntity<JsonPlaceholderTodo> response = restTemplate.getForEntity(url, JsonPlaceholderTodo.class);
        JsonPlaceholderTodo todo = response.getBody();

        if (todo == null) {
            return null;
        }

        url = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceholderUser> userResponse = restTemplate.getForEntity(url, JsonPlaceholderUser.class);
        JsonPlaceholderUser user = userResponse.getBody();

        if (user == null) {
            return null;
        }

        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
    }

    private static class JsonPlaceholderTodo {
        private Long id;
        private Long userId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    private static class JsonPlaceholderUser {
        private Long id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
