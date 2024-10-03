const { GradleLibraryProject, GradleSubProject } = require('@gplassard/projen-extensions');

const project = new GradleLibraryProject({
    name: 'api-clients',
    githubLint: {},
    gradleBuildActionOptions: {
        withCodeArtifactAccess: true,
        additionalEnvs: {
            APISPORT_KEY: '${{ secrets.APISPORT_KEY }}',
            FOOTBALL_DATA_KEY: '${{ secrets.FOOTBALL_DATA_KEY }}',
            ODDS_API_KEY: '${{ secrets.ODDS_API_KEY }}',
        }
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
