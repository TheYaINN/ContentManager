import { defineStore } from "pinia";
import axios from "axios";

export interface CmsKey {
    key: string;
    value: string;
    ValidFrom?: Date;
    child?: CmsKey;
    children: number;
    parent?: CmsKey;
}

interface Environment {
    name: string;
    order: number;
    keys?: Array<CmsKey>
}

interface Project {
    name: string;
    environments?: Array<Environment>
}

interface ProjectStoreState {
    projects: Array<Project>

}

export const useProjectStore = defineStore("ProjectStore", {
    state: (): ProjectStoreState => {
        return {
            projects: []
        }
    },
    getters: {
        getEnvironments: (state) => {
            return (projectName: string) => state.projects
                .find((project) => project.name === projectName).environments
                .sort((o1, o2) => (o1.order < o2.order ? -1 : 1));
        },
    },
    actions: {
        async load() {
            const result = await axios.get<any, any>("http://localhost:8080/projects/");
            if (result.data) {
                console.log(result.data)
                this.projects = result.data;
            }
        }
    }
})