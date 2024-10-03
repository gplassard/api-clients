const { GradleLibraryProject, GradleSubProject } = require('@gplassard/projen-extensions');

const project = new GradleLibraryProject({
    name: 'api-clients',
    githubLint: {},
    gradleBuildActionOptions: {
        withCodeArtifactAccess: true,
    },
});
const libraries = [
    'api-sports-rugby',
    'football-data',
    'odds-api',
]
for (const library of libraries) {
    new GradleSubProject(project, library, {
        gradleReleaseActionOptions: {
            libraryName: library,
            tagPattern: `${library}-*`,
            gradle: {
                codeArtifactPublishTasks: [
                    `:${library}:java-client:publishAllPublicationsToCodeArtifactRepository`,
                    `:${library}:java-api:publishAllPublicationsToCodeArtifactRepository`,
                ],
                githubRegistryPublishTasks: [
                    `:${library}:java-client:publishAllPublicationsToGithubPackagesRepository`,
                    `:${library}:java-api:publishAllPublicationsToGithubPackagesRepository`,
                ],
            }
        }
    })
}
project.synth();
