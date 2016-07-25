angular.module('appKitActivitiesDemo',[
	'appKitCommon',
	'appKit',
	'angular.filter'

]).controller('AppKitActivitiesDemo', function($scope, $sce) {
	'use strict';

	$scope.selected = 'all';

	$scope.items = [{
		'type': 'project',
		'class': 'icon_toolbox_alt',
		'time': "2 mins ago",
		'day': "Today",
		'user': {
			'avatar': 'assets/images/profiles/profile-1.png',
			'name': 'Ken D',
			'status': 'offline'
		},
		'summary': $sce.trustAsHtml('created a new project <a href="#">[Project fringilla vel aliquet nec]</a>')
	}, {
		'type': 'ticket',
		'class': 'icon_box-checked',
		'time': '30 mins ago',
		'day': 'Today',
		'user': {
			'avatar': 'assets/images/profiles/profile-4.png',
			'name': 'Kevin R',
			'status': 'online'
		},
		'summary': $sce.trustAsHtml('pushed to <a href="#">master</a> at <a href="#">[#23 Maecenas tempus adipiscing]</a>'),
		'excerpt': $sce.trustAsHtml('<a href="#"><span class="label label-default">a5dced8</span> Fixed drag and drop javascript bug</a>')
	}, {
		'type': 'ticket',
		'class': 'icon_box-checked',
		'time': '1 hr ago',
		'day': 'Today',
		'user': {
			'avatar': 'assets/images/profiles/profile-7.png',
			'name': 'Kathy D',
			'status': 'busy'
		},
		'summary': $sce.trustAsHtml('commented on ticket <a href="#">[#21 App page design]'),
		'excerpt': $sce.trustAsHtml('Can we have a screenshot of the current checkout page? Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes...')
	}, {
		'type': 'discussion',
		'class': 'icon_chat_alt',
		'time': '17:34am',
		'day': 'Yesterday',
		'user': {
			'avatar': 'assets/images/profiles/profile-10.png',
			'name': 'Jim T',
			'status': 'online'
		},
		'summary': $sce.trustAsHtml('started a new discussion <a href="#">[Sed sit amet ante eget ante]</a>'),
		'excerpt': $sce.trustAsHtml('Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula porttitor eu consequat vitae...')
	}, {
		'type': 'ticket',
		'class': 'icon_box-checked',
		'time': '14:30pm',
		'day': 'Yesterday',
		'user': {
			'avatar': 'assets/images/profiles/profile-13.png',
			'name': 'Mark A',
			'status': 'online'
		},
		'summary': $sce.trustAsHtml('created a new ticket <a href="#">[#28 Fringilla vel aliquet nec]</a>'),
		'excerpt': $sce.trustAsHtml('Aenean hendrerit, metus quis hendrerit tincidunt, ligula nisi egestas velit, vulputate porta nisi mi a magna. Etiam ultricies ipsum nec rhoncus rhoncus...')
	},{
		'type': 'file',
		'class': 'icon_paperclip',
		'time': '12:10pm',
		'day': 'Yesterday',
		'user': {
			'avatar': 'assets/images/profiles/profile-2.png',
			'name': 'Rachel W',
			'status': 'online'
		},
		'summary': $sce.trustAsHtml('shared a folder <a href="#">[UI mocks]</a>'),
		'excerpt': $sce.trustAsHtml('I’m sharing this folder ahead of the team meeting. Let me know if orem sed massa bibendum maximus quis sit amet diam...')
	}, {
		'type': 'ticket',
		'class': 'icon_box-checked',
		'time': '10:24am',
		'day': 'Yesterday',
		'user': {
			'avatar': 'assets/images/profiles/profile-18.png',
			'name': 'Jason B',
			'status': 'busy'
		},
		'summary': $sce.trustAsHtml('commented on ticket <a href="#">[#22 Maecenas tempus adipiscing]'),
		'excerpt': $sce.trustAsHtml('Pellentesque mattis libero at vestibulum vehicula. Lorem ipsum dolor sit amet, consectetur...')
	}, {
		'type': 'discussion',
		'class': 'icon_chat_alt',
		'time': '15:18pm',
		'day': 'June 23, 2015',
		'user': {
			'avatar': 'assets/images/profiles/profile-11.png',
			'name': 'James K',
			'status': 'online'
		},
		'summary': $sce.trustAsHtml('started a new discussion <a href="#">[Some suggestions regarding the code review process]</a>'),
		'excerpt': $sce.trustAsHtml('Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula porttitor eu consequat vitae...')
	}, {
		'type': 'project',
		'class': 'icon_toolbox_alt',
		'time': '13:26pm',
		'day': 'June 23, 2015',
		'user': {
			'avatar': 'assets/images/profiles/profile-8.png',
			'name': 'Nick M',
			'status': 'busy'
		},
		'summary': $sce.trustAsHtml('created a new project <a href="#">[Project Lorem Ipsum]</a>')
	}, {
		'type': 'ticket',
		'class': 'icon_box-checked',
		'time': '11:43am',
		'day': 'June 23, 2015',
		'user': {
			'avatar': 'assets/images/profiles/profile-12.png',
			'name': 'Tom W',
			'status': 'online'
		},
		'summary': $sce.trustAsHtml('commented on ticket <a href="#">[#103 Nullam dictum felis eu pede ]</a>'),
		'excerpt': $sce.trustAsHtml('Proin id risus diam. Sed diam dui, maximus mollis gravida sit amet, molestie id libero. Ut dictum id sapien sagittis condimentum. Nunc nec massa vel augue pharetra mattis hendrerit nec orci. Sed ultricies enim ac tincidunt efficitur. Curabitur varius, nibh ac ultricies lobortis...')
	}, {
		'type': 'ticket',
		'class': 'icon_box-checked',
		'time': '09:16am',
		'day': 'June 23, 2015',
		'user': {
			'avatar': 'assets/images/profiles/profile-4.png',
			'name': 'Ryan B',
			'status': 'offline'
		},
		'summary': $sce.trustAsHtml('pushed to <a href="#">master</a> at <a href="#">[#23 Maecenas nec odio et ante]</a>'),
		'excerpt': $sce.trustAsHtml('<span class="label label-default">f9f6228</span> Improved etiam ut facilisis neque')
	}];

});
