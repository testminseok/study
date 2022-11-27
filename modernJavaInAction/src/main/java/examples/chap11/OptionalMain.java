package examples.chap11;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class OptionalMain {
    public static void main(String[] args) {

    }

    /*
    * NPE (NullPointException) 을 발생시킬 가능성이 높다.
    * */
    public String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }
    
    /*
    * NPE 를 피하기 위하여 null 체크를 하는 로직이 추가됨
    * */
    public String getCarInsuranceNameAfterNullCheck(Person person) {

        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        
        return "Unknown";
    }

    /*
    * NPE 를 피하고 들여쓰기를 줄이기 위해 구현되었다. 그러나 return 을 할 수 있는 곳이 4곳이나 되어 유지보수하기 힘들다.
    * */
    public String getCarInsuranceNameAfterBetterNullCheck(Person person) {

        if (person == null) {
            return "Unknown";
        }

        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }

        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }

        return insurance.getName();
    }

    public String getCarInsuranceNameAsOptionalFlatMap(PersonV2 person) {
        return Optional.of(person)
                .flatMap(PersonV2::getCar)
                .flatMap(CarV2::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    /*
    * 사람 목록을 이용해 가입한 보험 회사 이름 찾기
    * */
    public Set<String> getCarInsuranceNames(List<PersonV2> people) {
        return people.stream()
                .map(PersonV2::getCar)
                .map(optionalCar -> optionalCar.flatMap(CarV2::getInsurance))
                .map(optionalInsurance -> optionalInsurance.map(Insurance::getName))
//                .filter(Optional::isPresent)
//                .map(Optional::get)
                .flatMap(Optional::stream) // (isPresent -> map) 의 과정을 거친것과 동일한 결과를 반환한다.
                .collect(Collectors.toSet());
    }
}
