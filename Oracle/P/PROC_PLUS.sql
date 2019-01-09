procedure proc_plus(num1 number,
		num2 in number, num3 out number)
is
      -- parameter명과 같은 변수는 작성할 수 없다.
      -- num1 varchar2(30);           
      -- 변수명을 선언할 때에는 프로시저명과 다르게 설정한다.
      
      
begin 
		-- in parameter 에는 값을 할당할 수 없다.  
		-- num1 :=100
       -- out parameter 에는 값할당이 된다.
 		num3 := num1+num2;
end;

-- 1. 소스 작성
-- 2. 컴파일
-- 3. 바인드 변수 선언 : var val number
-- 4. 실행 : exec proc_plus(11,7, :val)
--5. 바인드변수에 값 출력 : print val
