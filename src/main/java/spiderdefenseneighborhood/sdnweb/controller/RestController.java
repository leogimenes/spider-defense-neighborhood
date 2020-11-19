//package spiderdefenseneighborhood.sdnweb.controller;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.validation.Valid;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@RestController
//public class RestController {
//
//	
//	@PostMapping("/api/login")
//    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody Errors errors) {
// 
//        AjaxResponseBody result = new AjaxResponseBody();
// 
//        //If error, just return a 400 bad request, along with the error message
//        if (errors.hasErrors()) {
// 
//            result.setMsg(errors.getAllErrors()
//                    .stream().map(x -> x.getDefaultMessage())
//                    .collect(Collectors.joining(",")));
//            return ResponseEntity.badRequest().body(result);
// 
//        }
// 
//        List<User> users = userService.login(loginForm);
//        if (users.isEmpty()) {
//            result.setMsg("no user found!");
//        } else {
//            result.setMsg("success");
//        }
//        result.setResult(users);
// 
//        return ResponseEntity.ok(result);
// 
//    }
//}
