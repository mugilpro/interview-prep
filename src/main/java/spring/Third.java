package spring;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Third {

//    @Autowired
    private First first;

    public Third() {
        System.out.println("creating third");
    }

    public First getFirst() {
        System.out.println("third getting first");
        return first;
    }

    public void setFirst(First first) {
        System.out.println("third setting first");
        this.first = first;
    }

    public static void main(String[] args) {
        List<User> user = null;
        System.out.println(getUser(null));
       System.out.println(Optional.of(user).orElse(Collections.emptyList()).stream().map(u -> new UserDto(u.getId(),u.getName())).collect(Collectors.toList()));


    }

    public static ArrayList<UserDto> getUserList(List<User> userList){
        ArrayList<UserDto> userDto = new ArrayList<>();
            for(User u: userList){
                if(!u.isExpired()){
                    userDto.add(new UserDto(u.getId(),u.getName()));
                }
            }

        return userDto;
    }
    public static UserDto getUser(List<User> userList){
        ArrayList<UserDto> userDto = new ArrayList<>();
        for(User u: userList){
            if(!u.isExpired()){
                userDto.add(new UserDto(u.getId(),u.getName()));
            }
        }
        return userDto.size()> 0 ? userDto.get(userDto.size()-1): null;
    }
}

class User{
    public Long id;
    public String name;
    public String city;
    public String country;
    public boolean expired;

    public User(Long id, String name, String city, String country, boolean expired) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.expired = expired;
    }

public Long getId() {return id;}
public void setId(Long id) {this.id = id;}
public String getName() {   return name;}
public void setName(String name) {this.name = name;}
public String getCity() {return city;}
public void setCity(String city) {this.city = city;}
public String getCountry() {return country;}
public void setCountry(String country) {this.country = country;}
public boolean isExpired() {return expired;}
    public void setExpired(boolean expired) {this.expired = expired;}
}
class UserDto{
    public Long id;
    public String name;

    public UserDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {   return name;}
    public void setName(String name) {this.name = name;}

}