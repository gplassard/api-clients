const { GradleLibraryProject, GradleSubProject, ProjenSynthAction, NodeJSDependenciesUpgradeAction } = require('@gplassard/projen-extensions');
const { GitHub } = require('projen/lib/github');

const project = new GradleLibraryProject({
    name: 'api-clients',
    githubLint: {},
    gradleBuildAction: {},
});
const libraries = [
    'api-sports-rugby',
    'football-data',
    'odds-api',
]
for (const library of libraries) {
    new GradleSubProject(project, library, {
        gradleReleaseAction: {
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
