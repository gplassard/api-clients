const { GradleLibraryProject } = require('@gplassard/projen-extensions');

const project = new GradleLibraryProject({
    name: 'api-clients',
    githubLint: {},
    gradleBuildAction: {},
    gradleReleaseAction: {
        gradle: {
            codeArtifactPublishTasks: [
                'publishAllPublicationsToCodeArtifactRepository',
            ],
            githubRegistryPublishTasks: [
                'publishAllPublicationsToGithubPackagesRepository',
            ],
        },
        libraryName: 'my-awesome-library',
        tagPattern: 'v*',
    },
});
new GradleLibraryProject({
    parent: project,
    outdir: './api-sports-rugby',
    gradleReleaseAction: {
        libraryName: 'api-sports-rugby',
        tagPattern: 'api-sports-rugby-*',
        gradle: {
            codeArtifactPublishTasks: [
                'publishAllPublicationsToCodeArtifactRepository',
            ],
            githubRegistryPublishTasks: [
                'publishAllPublicationsToGithubPackagesRepository',
            ],
        }
    }
})
project.synth();
