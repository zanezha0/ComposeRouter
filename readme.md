# Compose 导航封装

### 导航带navOptions
```kotlin
val navOptions = navOptions {
    popUpTo<ThreeDestination> {
        saveState = true
        inclusive = true
    }
    launchSingleTop = true
    restoreState = true
}
Router.to(TwoDestination,navOptions)
```

### 导航
```kotlin
Router.to(TwoDestination)
```

### 切换tab
```kotlin
  Router.switchTab(Tab1Destination)
```


### 清除返回栈
```kotlin
Router.offAllTo(OneDestination)
```


### 返回
```kotlin
Router.back()
```

### 替换当前页面

```kotlin
Router.replace(ThreeDestination("replace来自Two"))
```

### 带数据返回

```kotlin
val bundle = Bundle().apply {
	putString("result", "Two Screen Back Result Data")
}
Router.backWithResult(result = bundle)


val result =  appState?.getBackResult()
	LaunchedEffect(result) {
		if (result != null) {
		viewModel.result.value = result.getString("result")
		println("A 页面收到数据: $result")
	}
}

```