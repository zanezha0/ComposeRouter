pluginManagement {
    repositories {
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.aliyun.com/nexus/content/groups/public/")
        }
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.aliyun.com/nexus/content/repositories/jcenter")
        }
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.aliyun.com/nexus/content/repositories/google")
        }
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.aliyun.com/nexus/content/repositories/gradle-plugin")
        }
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/central") }
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        google()
        mavenCentral()
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.aliyun.com/nexus/content/groups/public/")
        }
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.aliyun.com/nexus/content/repositories/jcenter")
        }
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.aliyun.com/nexus/content/repositories/google")
        }
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://maven.aliyun.com/nexus/content/repositories/gradle-plugin")
        }
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/central") }
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        google()
        mavenCentral()
    }
}

rootProject.name = "ComposeRouter"
include(":app")
include(":router")
