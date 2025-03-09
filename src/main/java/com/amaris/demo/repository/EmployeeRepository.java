package com.amaris.demo.repository;

import com.amaris.demo.dto.EmployeeDTO;
import com.amaris.demo.response.EmployeeListResponse;
import com.amaris.demo.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class EmployeeRepository
{
    private RestTemplate restTemplate;
    private final String BASE_URL = "https://dummy.restapiexample.com/api/v1";

    @Autowired
    public EmployeeRepository(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public EmployeeDTO findEmployeeById(Integer id)
    {
        String url = BASE_URL + "/employee/" + id;

        HttpEntity<String> requestEntity = new HttpEntity<>(this.getHeaders());

         ResponseEntity<EmployeeResponse> response = restTemplate
             .exchange(url, HttpMethod.GET, requestEntity, EmployeeResponse.class);

        if (response.getBody() == null && response.getBody().getData() == null)
            return null;

        EmployeeResponse body = response.getBody();

        return body.getData();
    }

    public List<EmployeeDTO> findAll()
    {
        String url = BASE_URL + "/employees";

        HttpEntity<String> requestEntity = new HttpEntity<>(this.getHeaders());

         ResponseEntity<EmployeeListResponse> response = restTemplate
             .exchange(url, HttpMethod.GET, requestEntity, EmployeeListResponse.class);

        if (response.getBody() == null && response.getBody().getEmployees() == null)
            return null;

        EmployeeListResponse body = response.getBody();

        return body.getEmployees();
    }

    private HttpHeaders getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.0.0 Safari/537.36");
        headers.set(HttpHeaders.ACCEPT, "application/json");
        headers.set(HttpHeaders.ACCEPT_ENCODING, "zip");
        headers.set("Cookie", "humans_21909=1");

        return headers;
    }
}
