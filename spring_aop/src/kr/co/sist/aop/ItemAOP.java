package kr.co.sist.aop;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.ItemDomain;

@Aspect
@Component
public class ItemAOP {
   //@After("execution( * searchItem(String))")
   @Before("execution( * searchItem(String))")
   public void beforeItem( JoinPoint jp) {
   //   System.out.println("after advice");
      System.out.println("before advice");
      //target method의 매개변수를 처리 ( JoinPoint )
      Object[] params=jp.getArgs();
      //target method의 method정보 ( 매개변수, method명)
      Signature sig = jp.getSignature();
      System.out.println( "target method명 " + sig.getName());
      System.out.println( "target method 접근지정자 " +
         (Modifier.toString(sig.getModifiers()) ));
      
      if( params != null) {
         System.out.println( "매개변수 갯수 " +params.length);
         for(Object param: params) {
            System.out.println("매개변수 값 :"+ param);
         }//end for
      }//end if
   }//before
   
//   @Before("execution( * get*())") //모든 Spring Bean의 getter 호출
//   @Before("execution( * kr.co.sist.service.ItemServiceImpl.get*())")//ItemServiceImple의 getter 호출 
   @Before("execution( String kr.co.sist.service.ItemServiceImpl.get*())")//ItemServiceImple의 getter 호출
   //ItemServiceImpl 의 반환형이 String getter 호출
   public void getter() {
      System.out.println("getter before advice");
   }//getter
   
   @Around("execution(* searchData(..))")
   public ItemDomain around(ProceedingJoinPoint pjp) throws Throwable {
//      pjp.getArgs();//targer 파라메터 처리   
//      pjp.getSignature();//target method 정보
      //signature는 method에 이름과 return 값는 애들
         
         //target의 리턴형을 받아와서 리턴을 만든다.
      ItemDomain id= (ItemDomain)pjp.proceed(); //target method가 유일할 때는 굳이 object로 반환안해도됨.
      if(id!=null) {
         id.setItem(id.getItem()+" s('.  ^)v");
      }//end if
      return id;
   }//around
/*   public Object around(ProceedingJoinPoint pjp) throws Throwable {
      
      //target의 리턴형을 받아와서 리턴을 만든다.
      Object o= pjp.proceed(); //target method가 여러개 일 때
      
      return o;
   }//around
*/   
}//class