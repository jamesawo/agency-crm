import {NbMenuItem} from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
    {
        title: 'Welcome',
        icon: 'home-outline',
        link: '/pages/welcome',
        home: true,
    },
    {
        title: 'MODULES',
        group: true,
    },
    {
        title: 'Dashboard',
        icon: 'activity-outline',
        link: '/pages/dashboard',
    },
    {
        title: 'PipeLine',
        icon: 'swap-outline',
        children: [
            // step represent a stage in the backend
            {title: 'manage steps', link: '/pages/pipeline/manage-steps'},
            {title: 'manage pipelines', link: '/pages/pipeline/manage-pipelines'},
        ],
    },
    {
        title: 'Task',
        icon: 'clipboard-outline',
        children: [
            {title: 'manage tasks', link: '/pages/task/manage-tasks'},
        ],
    },
    {
        title: 'Team',
        icon: 'umbrella-outline',
        children: [
            {title: 'manage teams', link: '/pages/team/manage-teams'},
        ],
    },
    {
        title: 'Supervisor',
        icon: 'monitor-outline',
        children: [
            // a supervisor is a manager in the backed
            {title: 'manage supervisors', link: '/pages/manage-supervisors'},
        ],
    },
    {
        title: 'Agent',
        icon: 'people-outline',
        children: [
            {title: 'manage agents', link: '/pages/agent/manage-agents'},
            {title: 'manage agent\'s task', link: '/pages/agent/manage-tasks'},
            {title: 'manage agent\'s team', link: '/pages/agent/manage-teams'},
            {title: 'manage agent\'s clients', link: '/pages/agent/manage-clients'},
            {title: 'view agent\'s performance', link: 'pages/agent/view-performances'},
        ],
    },
    {
        title: 'Client',
        icon: 'pantone-outline',
        children: [
            {title: 'manage clients', link: '/pages/client/manage-clients'},
        ],
    },
    {
        title: 'Authorization',
        icon: 'unlock-outline',
        children: [
            {title: 'manage users', link: '/pages/auth/users'},
            {title: 'manage roles ', link: '/pages/auth/roles'},
            {title: 'manage permission ', link: '/pages/auth/permissions'},
        ],
    },
];
