# path variable 검증

## 일반적
```java
// UserController

@Validated
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("{id}")
    public ResponseEntity<Long> getUser(@PathVariable(name = "id") @Valid @Pattern(regexp = "(^[0-9]*$)", message = "숫자만 가능합니다.") String id) {

        return ResponseEntity.ok(userValid.getId());
    }
}
```

## 제안
```java
// UserController

@Validated
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("{id}")
    public ResponseEntity<Long> getUser(@PathVariable(name = "id") @Valid UserValid userValid) {
    
        return ResponseEntity.ok(userValid.getId());
    }
}

// UserValid

public class UserValid {

    @Pattern(regexp = "(^[0-9]*$)", message = "숫자만 가능합니다.")
    private final String id;

    public UserValid(String id) {
        this.id = id;
    }

    public Long getId() {
        return Long.valueOf(id);
    }
}

```
