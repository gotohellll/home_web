$(function(){
	
	//가격계산함수
	function cal(){
		sum = 0;
		
		$('.menuCount').each(function(){
			//수량
			var count = parseInt($(this).val());		
			//가격
			var price = parseInt($(this).closest('.menu').find('span[id^=price]').text());
			sum += count*price;
		})
		
	}
	
	
	$('.menuCount').change(function(){
		//수량
		var count =parseInt($(this).val());
		//메뉴 이름(span태그중 label로 시작하는 태그)
		var name = $(this).closest('.menu').find('span[id^=label]').text();
		//가격
		var price = parseInt($(this).closest('.menu').find('span[id^=price]').text());
		//alert(count);
	
		if(count>0){
			
			//중복 메뉴 찾기
			var sameMenu = $('#listTable tr.newList').filter(function(){
				 return $(this).find('td:first').text() === name;
			})
			//listTable안 newList tr태그에서 필터 -> 해당 태그에서 첫번째 td(name)의 text가져와 선택한 메뉴명이 같으면 sameMenu에 담음 
			//filter() : 각 요소마다 함수 실행하고 true/false로 어떤 요소 남길지 결정 
			
			//주문내역추가	
			if(sameMenu.length>0){
				//동일 메뉴 있으면 수량만 수정
				sameMenu.find('td:eq(1)').text(count);
				//수량 수정되면 가격도 변경
				sameMenu.find('td:eq(2)').text(price*count);
			}else{
				//없으면 새로 추가
				var newOrder = $('<tr class="newList"></tr>');
				newOrder.append('<td>'+name+'</td>')
				newOrder.append('<td>'+count+'</td>')
				newOrder.append('<td>'+(price*count)+'</td>')
				newOrder.append('<td><button class="deletebtn">삭제</button></td>')
				
				$('#listTable').append(newOrder);
			}	
				
		//수량 0이면 메뉴삭제		
		}else{
			$('#listTable tr.newList').filter(function(){
				 return $(this).find('td:first').text() === name;
			}).remove();	
		}
		
		cal();
	});//end of menuCount change
	
	//주문하기 버튼 클릭 시 
	$('#btn').click(function(){
		//alert('ok');
		//주문내역삭제
		$('#listTable tr.newList').remove();
		
		//최종총합계산
		cal();
		//가격표시
		$('#total').val(sum);	
		$('#listTable').append('<tr><td colspan="4">주문완료</td></tr>');
	}) 
	
	//삭제버튼 누르면 버튼에 가장가까운 tr삭제 
	$('#listTable').on('click','.deletebtn',function(){
		$(this).closest('tr').remove();
		
		//삭제하는 메뉴명
		var deleteMenu = $(this).closest('tr').find('td:first').text();
		
		$('.menu').each(function(){
			//menu각각의 이름 
			var menu = $(this).find('span[id^=label]').text();
			//삭제하는 메뉴와 같은 메뉴를 찾아 value를 0으로 변경
			if( deleteMenu === menu){
				$(this).find('.menuCount').val('0');
			}
			
		})
		cal();
	})
	//on 쓰는 이유 : 삭제하려는 tr이 주문할때 생성되는 태그라서 상위요소에 이벤트 걸어두고 나중에 태그가 생겼을때에도 이벤트전파(버블링)
	
	
});