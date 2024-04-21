package cinema.Controller.User;

import cinema.DTO.Request.ChangePasswordRequest;
import cinema.DTO.Response.MessageResponse;
import cinema.Service.ServiceImpl.UserServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserServicesImpl userServices;
    @PostMapping("/changepassword")
    public ResponseEntity<MessageResponse> createNewPassword(
            @RequestBody ChangePasswordRequest request
    ) {
        return ResponseEntity.ok(userServices.changePassword(request));
    }
}
