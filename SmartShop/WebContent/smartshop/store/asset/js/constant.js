/**
���ļ������г���Ϊȫ��ʹ��
ֻҪ��ʹ�õ�htmlҳ�����ñ��ļ����Ϳ���ֱ�ӵ���
*/
	/** ������IP */
	var HTTP = "";		//IP��ַ
	/** ������IP */
	var IP = "";		//IP��ַ
	/** �������˿� */
	var PORT = "";				//�˿�
	/** ������ */
	var NAME = "../../";		//Ŀ¼��
	/** �û���¼ {request{name,password} ,reponse{{success,telephone,room,name,id}}} */
	var LOGIN = HTTP+IP+PORT+NAME+"userManage/login.action";		//��¼��ַ
	/** �û�ע�� {} */
	var LOGOUT = HTTP+IP+PORT+NAME+"userManage/logout.action";	//ע���ַ
	
	
	
	///////////////////////////////�û����޹���////////////////////////////////////////////////////////////////////////
	/** �û����� ��ȡ�����豸�б�  {
		request:{null},
		response:{
			id,
			devicename}} 
	*/
	var URL_REPAIR_DEVICE = HTTP+IP+PORT+NAME+"repair/listDevices.action";//��ͨ�û���ñ����豸
	
	/** �û����� ��ȡ�����豸�����б�  {
		request:{
			id(�豸���id)
			},
		response:{
			id,
			deviceid,
			devicestate}} 
		*/
	var URL_REPAIR_DEVICEFAULT = HTTP+IP+PORT+NAME+"repair/listDeviceFault.action";//��ͨ�û���ȡ�豸����
	
	/** �û����� �ύ����  {
		request:{
			roomnumber,
			username(����������),
			phone,
			devicename, 
			description, 
			images(�ϴ���ͼƬ)(������ǰ�� repair.)},
		response:{}} */
	var URL_REPAIR_ADD = HTTP+IP+PORT+NAME+"repair/submitRepairInfo.action";//��ͨ�û���ӱ��޵�ַ
	
	
	/** �û����� �ύ����  {
		request:{
			id(������Ϣ�� id),
			feedback(��������Ϣ)(����ǰ�� repair.)},
		response:{}} */
	var URL_REPAIR_FEEDBACK = HTTP+IP+PORT+NAME+"repair/submitFeedback.action";//��ͨ�û���������
	
	/** �û����� ������  {
		request:{
			id(������Ϣ�� id)},
		response:{}} */
	var URL_REPAIR_CANCEL = HTTP+IP+PORT+NAME+"repair/cancelRepair.action";//��ͨ�û�������
	
	/** �û����� �鿴���޽��  {
		request:{
			pageSize(ÿҳ��С),
			pageNo(ҳ��),
			isFinished(�Ƿ������)},
		response:{
			id,
			roomnumber,
			username(����������),
			phone,
			devicename, 
			description, 
			date(��������),
			processedsituation, 
			processedstate(0:δ���,1:���ڴ���,2:�����), 
			serviceman,
			processedtime(��ɴ���ʱ��), 
			feedback(�û�����), 
			repairimages(ͼƬ��ַ)[id, repairid, url(ͼƬ��ַ)}} */
	var URL_REPAIR_VIEW = HTTP+IP+PORT+NAME+"repair/listRepairInfoByPage.action";//��ͨ�û��鿴���޵�ַ
	///////////////////////////////�û����޹���////////////////////////////////////////////////////////////////////////
	
	/** 更改用户报修状态  {
	request:{
		id,
		processedstate=1
		},
	response:{
		true
		}} */
var URL_REPAIR_STATE = HTTP+IP+PORT+NAME+"repair/setState.action";//更改用户报修状态
///////////////////////////////更改用户报修状态////////////////////////////////////////////////////////////////////////
	
	//////////////¥�����Ϣ����/////////////////////////////////////////////
	/** ��ӷ�����Ϣ  {
		request:{buildingnumber(* ����¥��),
		number(* �����),
		buildingarea(�������),
		innerarea(�������),
		publicarea(�����������),
		state(����״̬),
		type(��������),
		floor(����¥��),
		targetgroup(�������),
		startcharge(��ʼ�շ�����)(������ǰ��� room.)}
		response:{null}} */
	var URL_ADD_ROOM = HTTP+IP+PORT+NAME+"building/submitRoomInfo.action";	
	/**
		��ѯ������Ϣ{
		request{
			buildingNumber(¥��)
		},
		reponse{
			success,
			result:[ 
				buildingnumber(* ����¥��id) 
				number(* �����) 
				user 
				buildingarea 
				innerarea
				publicarea 
				state 
				type 
				floor 
				targetgroup 
				startcharge}}
	*/
	var URL_QUERY_ROOM = HTTP+IP+PORT+NAME+"room/list.action";	
	
	/**
		���¥����Ϣ{
		request{
			number(* ¥����),
			manager(���?),
			name(¥�����),
			address(¥���ַ),
			struct(¥��ṹ),
			orientation(¥��ṹ),
			type(¥������),
			remarks(��ע)(������ǰ�� building.)
			}
		reponse{
			success}
		}
	*/
	var URL_ADD_BUILDING = HTTP+IP+PORT+NAME+"building/submitBuildingInfo.action";	
	
	/**
		��ѯ¥����Ϣ¥����Ϣ{
		request{
			pageSize(ÿҳ��С),
			pageNo(ҳ��)
			}
		reponse{
			success,
			result[
				id,
				number(¥����),
				manager(���?),
				name(¥�����),
				address(¥���ַ),
				struct(¥��ṹ),
				orientation(¥��ṹ),
				type(¥������),
				remarks(��ע)
				]}
		}
	*/
	var URL_QUERY_BUILDING = HTTP+IP+PORT+NAME+"building/listBuildingInfoByPage.action";	
	//////////////¥�����Ϣ����/////////////////////////////////////////////
	
	
	//////////////�������/////////////////////////////////////////////
	/**
		�ύˮ�����Ϣ{
		request{
			roomnumber(* �����),
			waterconsum(* ˮ��),
			elecconsum(* ����),
			readman(������),
			readtime(����ʱ��)
			ע : ˮ�Ѻ͵��������дһ��
			}
		reponse{
			success,
			}
		}
	*/
	var URL_SUBMIT_METER = HTTP+IP+PORT+NAME+"meter/submitMeterInfo.action";	
	//////////////�������/////////////////////////////////////////////
	
	//////////////Ͷ�߹���/////////////////////////////////////////////
	
	/**
		��ѯͶ����Ϣ{
		request{
			pageSize(ÿҳ��С),
			pageNo(ҳ��),
			isFinished(�Ƿ������)
			}
		reponse{
			success,
			result:[
				id,
				roomnumber,
				name,
				phone,
				content, 
				requiredresult,
				keywords, 
				processedsituation, 
				processedstate, 
				requiredresult,
				time, 
				complaintsimages:[
					id,
					complaintsid,
					url]]} 
					(������ǰ�� complaints.)
			}
		}
	*/
	var URL_QUERY_COMPLAINT = HTTP+IP+PORT+NAME+"complaints/listComplaints.action";	
	
	/**
		�ύͶ����Ϣ{
		request{
			roomnumber(* ),
			name,
			phone(* ),
			content(*),
			requiredresult,
			remarks (������ǰ�� complaints.)
			images(ͼƬ)
			}
		reponse{
			success,
			}
		}
	*/
	var URL_SUBMIT_COMPLAINT = HTTP+IP+PORT+NAME+"complaints/submitComplaints.action";	
	//////////////Ͷ�߹���/////////////////////////////////////////////
	
	//////////////�ͻ�����/////////////////////////////////////////////
	/**
		�ύ�ͻ���Ϣ{
		request{
			roomnumber(*),
			name(*),
			sex,
			identity(* ���֤��),
			nativeplace(����),
			registeredresidence(�������ڵ�),
			nation(����),
			politicalaffiliation(������ò),
			educationlevel,
			company(�����Ĺ�˾),
			maritalstatus(����״��),
			hobbies,
			telephone,
			qq,
			mail,
			immigratedate(Ǩ������),
			quitdate(Ǩ������),
			propertyowner(* ��Ȩ��),
			propertyowneridentity(* ��Ȩ�����֤��)(����ǰ�� roomowner.)
			}
		reponse{
			success,
			}
		}
	*/
	var URL_SUBMIT_ROOMOWNER = HTTP+IP+PORT+NAME+"userManage/submitRoomownerInfo.action";	
	
	var URL_CHANGE_ROOMOWNER = HTTP+IP+PORT+NAME+"userManage/updateRoomownerInfo.action";
	/**
		��ѯ�ͻ���Ϣ{
		request{
			roomnumber(* ),
			name,
			phone(* ),
			content(*),
			requiredresult,
			remarks (������ǰ�� complaints.)
			images(ͼƬ)
			}
		reponse{
			success,
			}
		}
	*/
	var URL_QUERY_ROOMOWNER = HTTP+IP+PORT+NAME+"userManage/list.action";	
	//////////////�ͻ�����/////////////////////////////////////////////
	
	//////////////װ�޹���/////////////////////////////////////////////
	/**
		�ύװ����Ϣ{
		request{
			roomnumber(*)
			ownername
			phone 
			isjianzhuang 
			hasdecprotocol
			hasdecform
			hasdeclicence 
			remarks 
			iscomplete
			(������ǰ�� decorate.)
			}
		reponse{
			success,
			}
		}
	*/
	var URL_SUBMIT_DECORATE = HTTP+IP+PORT+NAME+"decorate/submitDecorate.actoin";	
	
	/**
		�ύװ�޷�����Ϣ{
		request{
			 roomnumber(*)
			 ownername
			 date 
			 deposit(Ѻ��) 
			 rabishfee(�������) 
			 elecfee(���) 
			 waterfee(ˮ��)
			 passfee(����֤��) 
			 remarks
			 (������ǰ�� decoratefee.)
			}
		reponse{
			success,
			}
		}
	*/
	var URL_SUBMIT_DECORATE_FEE = HTTP+IP+PORT+NAME+"decorate/submitdecoratefee.actoin";	
	
	/**
		��ѯװ����Ϣ{
		request{
			 roomnumber(*) 
			 ownername 
			 phone 
			 isjianzhuang 
			 hasdecprotocol
			 hasdecform 
			 hasdeclicence 
			 remarks
			 iscomplete
			}
		reponse{
			success, 
			result:[ 
				roomnumber,
				ownername,
				phone, 
				isjianzhuang, 
				hasdecprotocol,
				hasdecform, 
				hasdeclicence, 
				remarks, 
				iscomplete]}
			}
		}
	*/
	var URL_QUERY_DECORATE = HTTP+IP+PORT+NAME+"decorate/listdecorate.actoin";	
	
	/**
		��ѯװ�޷�����Ϣ{
		request{
			roomnumber
			}
		reponse{
			success, 
			result:[ 
				ownername, 
				date, 
				deposit(Ѻ��),
				rabishfee(�������),
				elecfee(���),
				waterfee(ˮ��), 
				passfee(����֤��), 
				remarks
			}
		}
	*/
	var URL_QUERY_DECORATE_FEE = HTTP+IP+PORT+NAME+"decorate/listdecoratefee.actoin";	
	//////////////װ�޹���/////////////////////////////////////////////
	
	
	
	var URL_QUERY_BUILD= HTTP+IP+PORT+NAME+"building/listBuildingNumber.action";
	var URL_QUERY_UNIT= HTTP+IP+PORT+NAME+"building/listUnitNumber.action";
	var URL_QUERY_ROOM= HTTP+IP+PORT+NAME+"building/listRoomNumber.action";

	
	/**
	��ѯˮ�����ʷ��Ϣ

	*/

	var URL_QUERY_METER_INFO= HTTP+IP+PORT+NAME+"meter/listMeterInfo.action";
	/////////////��ѯˮ�����ʷ��Ϣ//////////////////////////////////


	/**
	�ύˮ�����Ϣ
	
	requert{
		buildNo,
		unitNo,
		roomNo,
		waterconsum,
		elecconsum,
		}
		reponse{
			success
		}

	*/
	var URL_SUBMIT_METER_INFO= HTTP+IP+PORT+NAME+"meter/submitMeterInfo.action";
	/////////////�ύˮ�����Ϣ//////////////////////////////////

	/**
	��ѯ���й�����Ϣ{
								
	requert{
		keywords,
		pageNo,
		pageSize
		}
		reponse{
			
		}
			}
	*/
	var URL_QUERY_NOTICE= HTTP+IP+PORT+NAME+"notice/listNoticeByPage.action";
	/////////////��ѯ���й�����Ϣ//////////////////////////////////



	/**
	���ݹؼ��ֲ�ѯ������Ϣ{
								
	requert{
		keywords,
		pageNo,
		pageSize
		}
		reponse{
			
		}
			}
	*/
	var URL_QUERY_NOTICE_KEYWORDS= HTTP+IP+PORT+NAME+"notice/listNoticeByKeyWords.action";
	/////////////���ݹؼ��ֲ�ѯ������Ϣ//////////////////////////////////


	/**
	�ύ������Ϣ{
		request{
			 notice.title
			 notice.author
			 notice.content
			}
		reponse{
			success,
			}
		}
		
	*/
	var URL_SUBMIT_NOTICE= HTTP+IP+PORT+NAME+"notice/publishNotice.action";
	/////////////�ύ������Ϣ//////////////////////////////////




	var URL_SUBMIT_METER_FEE= HTTP+IP+PORT+NAME+"meter/paying.action";//交水电费

	var	URL_QUERY_METER_ACCOUNT= HTTP+IP+PORT+NAME+"meter/getAccount.action";//查询账户余额






