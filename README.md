Node.jsを使わずに、VSCodeでw2uiの開発環境を整える方法について説明します。ここでは、VSCodeの拡張機能を活用し、ローカルサーバーを使用せずに開発を行う方法を示します。

### 必要な拡張機能

1. **HTMLとCSSのサポート**
   - **HTML CSS Support**: HTMLファイル内でのCSSの補完を提供します。
   - **IntelliSense for CSS class names in HTML**: HTMLファイル内でCSSクラス名の補完を提供します。

2. **JavaScriptのサポート**
   - **JavaScript (ES6) code snippets**: ES6のコードスニペットを提供します。
   - **TypeScript and JavaScript Language Features**: TypeScriptとJavaScriptの言語機能を提供します（デフォルトでインストールされています）。

3. **ライブサーバー**
   - **Live Server**: ローカルの開発サーバーを起動し、ブラウザで自動的にページをリロードします。

### 拡張機能のインストール手順

1. **VSCodeの拡張機能ビューを開く**:
   - 左側のアクティビティバーで「拡張機能」アイコンをクリックするか、`Ctrl+Shift+X`を押します。

2. **拡張機能を検索してインストール**:
   - 検索バーに以下の拡張機能名を入力し、インストールボタンをクリックします。

   - `HTML CSS Support`
   - `IntelliSense for CSS class names in HTML`
   - `JavaScript (ES6) code snippets`
   - `Live Server`

### サンプルプロジェクトの設定

以下は、w2uiを使用したプロジェクトの設定手順です。

1. **プロジェクトフォルダの作成**:
   - 新しいプロジェクトフォルダを作成し、VSCodeで開きます。

2. **基本的なファイルの作成**:
   - `index.html`, `app.js`, `data.json`を作成します。

3. **`index.html`の設定**:

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>w2ui Layout Example</title>
       <link rel="stylesheet" type="text/css" href="https://rawgit.com/vitmalina/w2ui/master/dist/w2ui.min.css" />
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
       <script src="https://rawgit.com/vitmalina/w2ui/master/dist/w2ui.min.js"></script>
   </head>
   <body>
       <div id="layout" style="width: 100%; height: 400px;"></div>
       <script src="app.js"></script>
   </body>
   </html>
   ```

4. **`app.js`の設定**:

   ```javascript
   $(function () {
       $('#layout').w2layout({
           name: 'myLayout',
           panels: [
               { type: 'top', size: 50, resizable: true, style: 'border: 1px solid silver; padding: 5px;', content: 'Top Panel' },
               { type: 'left', size: 200, resizable: true, style: 'border: 1px solid silver; padding: 5px;', content: 'Left Panel' },
               { type: 'main', style: 'border: 1px solid silver; padding: 5px;', content: 'Main Panel' }
           ]
       });

       // JSONデータを取得
       $.getJSON('data.json', function(data) {
           // 取得したデータをレイアウトのパネルに表示
           w2ui['myLayout'].content('main', '<pre>' + JSON.stringify(data, null, 2) + '</pre>');
       });
   });
   ```

5. **`data.json`の作成**:

   ```json
   {
       "name": "John Doe",
       "age": 30,
       "email": "john.doe@example.com"
   }
   ```

6. **Live Serverの起動**:
   - VSCodeの下部にあるステータスバーの「Go Live」ボタンをクリックして、Live Serverを起動します。これでブラウザで`index.html`が自動的に開かれ、変更がリアルタイムに反映されます。

### 完全な開発環境の設定

1. **VSCodeを開き、プロジェクトフォルダを開く**。
2. **`index.html`, `app.js`, `data.json`のファイルをそれぞれ作成**。
3. **`index.html`にHTMLコードを貼り付ける**。
4. **`app.js`にJavaScriptコードを貼り付ける**。
5. **`data.json`にJSONデータを貼り付ける**。
6. **Live Serverを起動して、ブラウザで結果を確認**。

これで、Node.jsを使用せずにVSCodeでw2uiを使った開発環境を整えることができます。

---

## まとめ

### w2ui-2.0.jsファイル
**問題点:** 




結論：グローバル変数にクラスを宣言している。


- `w2ui-2.0.js`ファイルは、モジュールとして設計されていない。
- `export` 文はJavaScriptのモジュールシステムで使用されますが、このファイルは


layout4.htmlでのExtendedW2Layout.jsとlayout4.jsの読み込みを考慮すると、w2ui-2.0.jsを直接読み込む必要があるかどうかは、ExtendedW2Layout.jsとlayout4.jsの実装に依存します。

ExtendedW2Layout.jsがw2ui-2.0.jsを必要とする場合:

ExtendedW2Layoutクラスがw2ui-2.0.jsからw2layoutを拡張している場合、w2ui-2.0.jsは必要です。しかし、ExtendedW2Layout.js内でimport { w2layout } from '../libs/w2ui-2.0.js';のようにw2ui-2.0.jsからw2layoutをインポートしている場合、layout4.htmlでw2ui-2.0.jsを直接読み込む必要はありません。ExtendedW2Layout.jsが依存関係を解決します。
layout4.jsがw2ui-2.0.jsを必要とする場合:

layout4.jsがw2ui-2.0.jsの機能を直接使用する場合（w2layoutや他のw2uiのコンポーネントを使用する場合）、w2ui-2.0.jsが必要です。しかし、layout4.jsがExtendedW2Layoutクラスのインスタンスのみを使用し、ExtendedW2Layout.jsがすでにw2ui-2.0.jsをインポートしている場合、layout4.htmlでw2ui-2.0.jsを直接読み込む必要はありません。
結論:

ExtendedW2Layout.jsとlayout4.jsがw2ui-2.0.jsの機能をモジュールとして正しくインポートしている場合、layout4.htmlでw2ui-2.0.jsを直接読み込む必要はありません。これらのスクリプトはtype="module"としてマークされており、ESモジュールのインポート機能を利用して依存関係を解決できます。

ただし、ExtendedW2Layout.jsやlayout4.jsでw2ui-2.0.jsの機能をグローバルスコープから直接使用する（インポートせずに）場合、layout4.htmlでw2ui-2.0.jsを読み込む必要があります。このアプローチは推奨されませんが、既存のコードベースや特定の制約によっては必要になることがあります。




'''拡張クラス
export class ExtendedW2Layout extends w2layout {
    constructor(options) {
        super(options); // 親クラスのコンストラクタを呼び出し、初期化
        // ここにカスタムプロパティやメソッドを追加
    }

    // カスタムメソッドの例
    setRecord(record) {
        this.record = record;
    }
}
'''


'''javascript実装クラス
import { ExtendedW2Layout } from './libs/ExtendedW2Layout.js';

let pstyle = 'border: 1px solid #efefef; padding: 5px';
let myExtendedLayout = new ExtendedW2Layout({
    box: '#layout',
    name: 'myExtendedLayout',
    panels: [
        { type: 'top', size: 50, style: pstyle, html: 'top', resizable: true },
        { type: 'left', size: 300, style: pstyle, html: 'left', resizable: true },
        { type: 'main', style: pstyle, html: 'main' }
    ]
});

// recordプロパティに初期値を設定
myExtendedLayout.setRecord({
    name: "John Doe",
    age: 30
});

// 設定したrecordプロパティを使用
console.log(myExtendedLayout.record); // 出力: { name: "John Doe", age: 30 }

window.action = function(method, param1, param2) {
    myExtendedLayout[method](param1, param2);
};
'''

'''html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>w2ui Layout and Form Example</title>
    <link rel="stylesheet" type="text/css" href="https://rawgit.com/vitmalina/w2ui/master/dist/w2ui.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="../js/libs/w2ui-2.0.js"></script>
    <script src="../js/app.js"></script> <!-- パスを修正 -->
</head>
<body>
    <div id="layout" style="width: 100%; height: 100vh;"></div>
</body>
</html>
'''


クラス追加

w2fieldを継承したカスタムタイプを別ファイルに作成し、プラグインとして利用する方法を説明します。この方法を用いることで、w2fieldをベースにしたカスタムフィールドタイプを簡単に作成し、利用することができます。

### 手順

1. **カスタムフィールドクラスを作成**
2. **w2utils.extendを使用してカスタムフィールドタイプを追加**
3. **カスタムフィールドタイプをjQueryプラグインとして登録**
4. **レイアウトやフォームで新しいフィールドタイプを使用**

### 1. カスタムフィールドクラスの作成

まず、カスタムフィールドクラスを定義し、それを`w2field`から継承します。このクラスは別ファイルに保存します。

#### `customField.js`

```javascript
class CustomCalendarField extends w2field {
    constructor(options) {
        super(options);
        this.type = 'calendar'; // カスタムタイプの名前を設定
        this.render();
    }

    render() {
        // カレンダー入力フィールドのHTML生成
        const inputHtml = `<input type="text" class="w2ui-input" readonly>`;
        $(this.el).html(inputHtml);

        // カレンダーの初期化とイベントバインド（jQuery UIのDatepickerを使用）
        $(this.el).find('input').datepicker({
            dateFormat: 'yy-mm-dd',
            onSelect: (dateText) => {
                $(this.el).find('input').val(dateText);
                if (typeof this.options.onChange === 'function') {
                    this.options.onChange(dateText);
                }
            }
        });
    }
}

// 必要なライブラリを読み込む
if (typeof jQuery !== 'undefined') {
    $.getScript("https://code.jquery.com/ui/1.12.1/jquery-ui.js", function() {
        $('head').append('<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />');
    });
}

export default CustomCalendarField;
```

### 2. w2utils.extendを使用してカスタムフィールドタイプを追加

次に、カスタムフィールドタイプを`w2field`に追加します。このコードも別ファイルに保存します。

#### `registerCustomField.js`

```javascript
import CustomCalendarField from './customField.js';

(function($) {
    // w2utils.extendを使ってw2fieldにカスタムフィールドタイプを追加
    w2utils.extend(w2field.prototype, {
        calendar: function(options) {
            return new CustomCalendarField(options);
        }
    });

    // カスタムフィールドタイプをw2fieldに登録
    w2field.types.calendar = 'calendar';

})(jQuery);
```

### 3. カスタムフィールドタイプをjQueryプラグインとして登録

カスタムフィールドタイプをjQueryプラグインとして登録するために、次のコードを使用します。

#### `main.js`

```javascript
import './registerCustomField.js';

$(function () {
    // w2layoutの設定
    $('#layout').w2layout({
        name: 'myLayout',
        panels: [
            { type: 'main', content: '' }
        ]
    });

    // フォームの設定
    $('#form').w2form({
        name: 'myForm',
        fields: [
            { field: 'calendarField', type: 'calendar', required: true, html: { caption: 'Select Date' }, options: { onChange: function(date) { alert('Date selected: ' + date); } } }
        ],
        actions: {
            save: function () {
                this.save(function (data) {
                    if (data.status == 'success') {
                        w2alert('Saved successfully');
                    }
                });
            }
        }
    });

    // レイアウトのメインパネルにフォームを追加
    w2ui['myLayout'].content('main', '<div id="formContainer"></div>');

    // フォームのレンダリング
    $('#formContainer').w2render('myForm');
});
```

### 4. 必要なファイルをインクルードする

HTMLファイルで必要なJavaScriptファイルをインクルードします。

#### `index.html`

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Custom Field Example</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="path/to/w2ui.js"></script>
    <script type="module" src="path/to/main.js"></script>
    <link rel="stylesheet" href="path/to/w2ui.css">
</head>
<body>
    <div id="layout"></div>
    <div id="form"></div>
</body>
</html>
```

### まとめ

この手順を実行することで、w2fieldを継承したカスタムフィールドタイプを別ファイルで作成し、それをjQueryプラグインとして利用することができます。これにより、カスタムフィールドタイプを簡単に再利用し、他のプロジェクトでも活用することが可能になります。
