(this["webpackJsonpblog-frontend"]=this["webpackJsonpblog-frontend"]||[]).push([[0],{179:function(e,t,a){e.exports=a(401)},248:function(e,t,a){},399:function(e,t,a){},401:function(e,t,a){"use strict";a.r(t);var n=a(0),l=a.n(n),c=a(12),r=a.n(c),o=a(21),s=a(54),i=a.n(s),m="https://athenanetworks.herokuapp.com/post",u=function(){return function(e){e({type:"FETCH_POSTS_REQUEST",info:"Requesting Fetch posts",status:"orange"}),i.a.get(m).then((function(t){var a=t.data.map((function(e){return e}));e(function(e){return{type:"FETCH_POSTS_SUCCESS",info:"Fetched posts Successfully",payload:e,status:"green"}}(a))})).catch((function(t){e(function(e){return{type:"FETCH_POSTS_FAILURE",info:"Fetched posts Failed",payload:e,status:"red"}}(t.message))}))}},E=function(e){return function(t){t({type:"FETCH_SINGLE_POST_REQUEST",info:"Requesting to fetch post",status:"orange"}),i.a.get(m+"/".concat(e)).then((function(e){var a=e.data;t(function(e){return{type:"FECTH_SINGLE_POST_SUCCESS",info:"Post fetched successfully",payload:e,status:"green"}}(a))})).catch((function(e){t({type:"FECTH_SINGLE_POST_FAILUR",info:"failed to fetch post",payload:e.response.data,status:"red"})}))}},d=a(23),p=a(150),h=a.n(p),f=function(e){var t=e.post,a=h()(t.content);return l.a.createElement("div",{className:"post-detail-main"},l.a.createElement(d.b,{style:{textDecoration:"none",color:"#3d3d3d"},to:"/post/".concat(t.id)},l.a.createElement("div",{className:"post-detail"},l.a.createElement("img",{src:t.thumbnailImageUrl,className:"post-thumbnail"}),l.a.createElement("span",{className:"h ptitle"},t.title),l.a.createElement("h6",{className:"date"}," Published on ",t.postedOn),l.a.createElement("p",null,t.description)),l.a.createElement("div",{className:"comps"},l.a.createElement("ul",null,l.a.createElement("li",{className:"Reading-time"},a.text),l.a.createElement("li",null,l.a.createElement("img",{src:"https://img.icons8.com/fluent-systems-filled/12/000000/visible.png"})),l.a.createElement("li",{style:{}},t.views)))))},v=function(){var e=Object(o.c)((function(e){return e})).postReducer;return l.a.createElement("div",{className:"container"},l.a.createElement("div",{className:"row"},e.posts&&e.posts.map((function(e){return l.a.createElement(f,{post:e,key:e.id})}))))},b=a(405),g=function(){var e=Object(o.c)((function(e){return e})).postReducer;return l.a.createElement(b.a,{fade:!0,dotPosition:"right",autoplay:!0},e.posts.map((function(e){return l.a.createElement("div",{className:"car",key:e.id},l.a.createElement("img",{className:"car-image",src:e.imageUrl,atl:e.title}),l.a.createElement("h1",{className:"car-text heading"},e.title))})))},N=function(){return l.a.createElement("ul",{className:"follow"},l.a.createElement(d.b,{to:"/"},l.a.createElement("li",{className:"Facebook"},l.a.createElement("img",{src:"https://img.icons8.com/fluent/55/000000/facebook-new.png",alt:"Facebook"}))),l.a.createElement(d.b,{to:"/"},l.a.createElement("li",{className:"Twitter"},l.a.createElement("img",{src:"https://img.icons8.com/color/55/000000/twitter-circled.png",alt:"Twitter"}))),l.a.createElement(d.b,{to:"/"},l.a.createElement("li",{className:"Instagram"},l.a.createElement("img",{src:"https://img.icons8.com/fluent/55/000000/instagram-new.png",alt:"Instagram"}))),l.a.createElement(d.b,{to:"/"},l.a.createElement("li",{className:"MixCloud"},l.a.createElement("img",{src:"https://img.icons8.com/windows/55/000000/mixcloud.png",alt:"MixCloud"}))),l.a.createElement(d.b,{to:"/"},l.a.createElement("li",{className:"SoundCloud"},l.a.createElement("img",{src:"https://img.icons8.com/color/55/000000/soundcloud.png",alt:"SoundCloud"}))),l.a.createElement(d.b,{to:"/"},l.a.createElement("li",{className:"Spotify"},l.a.createElement("img",{src:"https://img.icons8.com/fluent/55/000000/spotify.png",alt:"Spotify"}))))},y=a(411),w=a(408),S=function(){return l.a.createElement("div",null,l.a.createElement(w.a,{fixed:"top",className:"navbar navbar-fixed-top"},l.a.createElement("div",{className:" container-fluid"},l.a.createElement(w.a.Brand,null,l.a.createElement(d.b,{to:"/",style:{color:"white",textDecoration:"none"}},"Athena Networks")),l.a.createElement("div",{className:"navbar-links"},l.a.createElement("ul",null,l.a.createElement("li",null,l.a.createElement(d.b,{to:"/"},"Home ")),l.a.createElement("li",null,l.a.createElement(d.b,{to:"/about"},"About ")),l.a.createElement("li",null,l.a.createElement(d.b,{to:"/contact"},"Contact ")))))))},O=a(59),k=a(38),C=a(42),T=a(409),j=function(){return l.a.createElement("blockquote",{className:"twitter-tweet","data-theme":"light"},l.a.createElement("p",{lang:"en",dir:"ltr"},"watched ",l.a.createElement("a",{href:"https://twitter.com/hashtag/FastFurious7?src=hash&ref_src=twsrc%5Etfw"},"#FastFurious7")," mov started with"," ",l.a.createElement("a",{href:"https://twitter.com/steveaoki?ref_src=twsrc%5Etfw"},"@steveaoki")," ",l.a.createElement("a",{href:"https://twitter.com/hashtag/Boneless?src=hash&ref_src=twsrc%5Etfw"},"#Boneless")," and"," ",l.a.createElement("a",{href:"https://twitter.com/davidguetta?ref_src=twsrc%5Etfw"},"@davidguetta")," ",l.a.createElement("a",{href:"https://twitter.com/kazjames?ref_src=twsrc%5Etfw"},"@kazjames")," ",l.a.createElement("a",{href:"https://twitter.com/hashtag/BlastOff?src=hash&ref_src=twsrc%5Etfw"},"#BlastOff")," &"," ",l.a.createElement("a",{href:"https://twitter.com/djsnake?ref_src=twsrc%5Etfw"},"@djsnake")," ",l.a.createElement("a",{href:"https://twitter.com/hashtag/getlow?src=hash&ref_src=twsrc%5Etfw"},"#getlow")," is awesome"," ",l.a.createElement("a",{href:"https://twitter.com/hashtag/OneLastRide?src=hash&ref_src=twsrc%5Etfw"},"#OneLastRide")),"\u2014 saiteja-konda (@kondasaitej)",l.a.createElement("a",{href:"https://twitter.com/kondasaitej/status/584062120267907073?ref_src=twsrc%5Etfw"},"April 3, 2015"))},_=function(){var e=Object(o.b)(),t=Object(n.useState)({name:"",email:""}),a=Object(C.a)(t,2),c=a[0],r=a[1];function s(e){r(Object(k.a)(Object(k.a)({},c),{},Object(O.a)({},e.target.name,e.target.value)))}return l.a.createElement("div",null,l.a.createElement("div",{className:" footer top"},l.a.createElement("div",{className:"threediv"},l.a.createElement("div",{className:"container innerdiv"},l.a.createElement("div",null,l.a.createElement("h5",null,"TWITTER FEED"),l.a.createElement("hr",null),l.a.createElement(j,null))),l.a.createElement("div",{className:"container innerdiv"},l.a.createElement("h5",null,"INSTAGRAM PHOTOS"),l.a.createElement("hr",null)),l.a.createElement("div",{className:"container innerdiv"},l.a.createElement("h5",null,"NEWSLETTER"),l.a.createElement("hr",null),l.a.createElement("form",{onSubmit:function(t){e(function(e){return function(t){i.a.post("https://athenanetworks.herokuapp.com/subscribers",e).then((function(e){t(function(e){return{type:"ADD_SUBSCRIBER",info:"Added new subscriber successfully",status:"green",payload:e}}(e.data))})).catch((function(e){console.error(e)}))}}(c)),t.preventDefault(),console.log(c),r({name:"",email:""})}},l.a.createElement(T.a,{name:"name",onChange:s,value:c.name,placeholder:"Name"}),l.a.createElement(T.a,{name:"email",onChange:s,value:c.email,placeholder:"Email"}),l.a.createElement("button",{className:"btn btn-dark btn-block sub"}," Subscribe"))))),l.a.createElement("div",{className:"footer bottom"},l.a.createElement("h1",{className:"Logo"},"Athena Networks"),l.a.createElement("hr",{className:"hr"}),l.a.createElement("ul",null,l.a.createElement("li",null,"Home"),l.a.createElement("li",null,"About"),l.a.createElement("li",null,"Contact")),l.a.createElement("li",{className:"copyright"},"Copyright saiteja All rights reserved")))},A=function(){var e=Object(o.b)();return Object(n.useEffect)((function(){e(u())})),l.a.createElement("div",null,l.a.createElement(S,null),l.a.createElement(g,null),l.a.createElement(y.a,null),l.a.createElement("strong",{className:"site-back-top-basic"}),l.a.createElement("div",{className:"container mycontainer"},l.a.createElement("div",{className:"row "},l.a.createElement("div",{className:"col-md-8"},l.a.createElement("h3",null,"NEWS"),l.a.createElement("hr",{className:"hr6"}),l.a.createElement(v,null),l.a.createElement("h3",{className:"controller"}," TRENDING"),l.a.createElement("hr",{className:"hr7"}),l.a.createElement(v,null)),l.a.createElement("div",{className:"col-md-4"},l.a.createElement("h3",null,"LATEST"),l.a.createElement("hr",{className:"hr8"}),l.a.createElement("div",{className:"scroll"},l.a.createElement(v,null),l.a.createElement(y.a,null)),l.a.createElement("div",null,l.a.createElement("h3",null,"SPOTIFY PLAYLIST"),l.a.createElement("hr",{className:"hr9"}),l.a.createElement("iframe",{title:"This is a unique title",className:"spotify-frame",src:"https://open.spotify.com/embed/playlist/3ehtiZyniZjVSs9Tv5BwCl",height:"380",width:"350",frameBorder:"0",allowtransparency:"true",allow:"encrypted-media"})),l.a.createElement("div",null,l.a.createElement("h3",{className:"controller"},"FIND US"),l.a.createElement("hr",{className:"hr10"}),l.a.createElement("div",null,l.a.createElement(N,null)))))),l.a.createElement(_,null))},U=(a(248),a(13)),D=a(159),F=a.n(D),I=a(174),R=a(117),x=a(407),P=a(406),L=a(410),B=a(412),H=a(413),W=a(414),M=a(415),q=a(416),z=function(e){var t,a,c,r=Object(o.b)(),s=e.match.params.id;Object(n.useEffect)((function(){r(E(s))}),[E]);var m=null===(t=Object(o.c)((function(e){return e})).postReducer.posts)||void 0===t?void 0:t.find((function(e){return e.id==s})),d=Object(n.useState)(m),p=Object(C.a)(d,1)[0],h=Object(n.useState)(p.likes),f=Object(C.a)(h,2),b=f[0],g=f[1],w=Object(n.useState)({comment:"",commentor:""}),j=Object(C.a)(w,2),A=j[0],U=j[1],D=T.a.TextArea,z=Object(n.useState)(0),G=Object(C.a)(z,2),Y=G[0],J=G[1],Q=Object(n.useState)(0),V=Object(C.a)(Q,2),Z=V[0],X=V[1],$=Object(n.useState)(null),K=Object(C.a)($,2),ee=K[0],te=K[1],ae=[l.a.createElement(I.a,{key:"comment-basic-like",title:"Like"},l.a.createElement("span",{onClick:function(){J(1),X(0),te("liked")}},Object(n.createElement)("liked"===ee?B.a:H.a),l.a.createElement("span",{className:"comment-action"},Y))),l.a.createElement(I.a,{key:"comment-basic-dislike",title:"Dislike"},l.a.createElement("span",{onClick:function(){J(0),X(1),te("disliked")}},l.a.createElement("disliked"===ee?W.a:M.a),l.a.createElement("span",{className:"comment-action"},Z))),l.a.createElement("span",{key:"comment-basic-reply-to"},"Reply to")];function ne(e){U(Object(k.a)(Object(k.a)({},A),{},Object(O.a)({},e.target.name,e.target.value)))}return l.a.createElement("div",null,l.a.createElement(S,null),l.a.createElement("div",{className:"container mycontainer"},l.a.createElement("div",{className:"row"},l.a.createElement("div",{className:"col-md-8"},l.a.createElement("div",{className:""},l.a.createElement("h4",{className:"h"},p.title),l.a.createElement("h6",{className:"date"}," Published on ",p.postedOn),l.a.createElement("div",null,l.a.createElement("h6",null,"Tags"),null===(a=p.tags)||void 0===a?void 0:a.map((function(e){return l.a.createElement("button",{className:" btn btn-small black",style:{marginRight:"5px",fontSize:"10px"},key:e.id},e.name)}))),l.a.createElement("div",{className:"comments-likes"},l.a.createElement("h6",{className:"h"},"Comments ",l.a.createElement("span",null,p.totalComments," ")),l.a.createElement("h6",{className:"h"},"Likes ",l.a.createElement("span",null,b)),l.a.createElement("h6",{className:"h"},"Views ",l.a.createElement("span",null,p.views))),l.a.createElement("img",{className:"postImage",src:p.imageUrl,alt:p.title}),l.a.createElement("section",null,l.a.createElement(F.a,{className:"content",escapeHtml:!1},p.content),l.a.createElement(R.a,{shape:"circle",icon:l.a.createElement(q.a,null),size:"large",className:"btn red",onClick:function(){g(b+1),r(function(e){return function(t){i.a.get("https://athenanetworks.herokuapp.com/like/".concat(e)).then((function(e){})).catch((function(e){}))}}(s))}})),l.a.createElement("div",null,l.a.createElement("div",{className:"comment-section"},l.a.createElement("h5",{className:"h"},"Add Comment"),l.a.createElement(x.a.Item,null,l.a.createElement(T.a,{type:"text",value:A.commentor,name:"commentor",onChange:ne,placeholder:"Enter you name"})),l.a.createElement(x.a.Item,null,l.a.createElement(D,{rows:4,name:"comment",onChange:ne,placeholder:"Enter your comment here",value:A.comment})),l.a.createElement(R.a,{className:"btn black",type:"submit",onClick:function(){r(function(e,t){return function(a){i.a.post("https://athenanetworks.herokuapp.com/comment/".concat(e),t).then((function(t){var n={id:e,upadatedComment:t.data};a(function(e){return{type:"ADD_COMMENT",info:"Comment added successfully",status:"green",payload:e}}(n))})).catch((function(e){}))}}(s,A),u()),U({comment:"",commentor:""})}},"Comment")),null===(c=p.comments)||void 0===c?void 0:c.map((function(e){var t;return l.a.createElement("div",{key:e.id},l.a.createElement(P.a,{actions:ae,avatar:l.a.createElement(L.a,{src:"https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png",alt:"Han Solo"}),key:e.id,author:e.commentor,content:e.comment,datetime:e.commentedOn}),l.a.createElement("div",{style:{backgroundColor:"floralwhite",display:"flex",justifyContent:"flex-end",flexDirection:"row"}},null===(t=e.replies)||void 0===t?void 0:t.map((function(e){return l.a.createElement("div",{key:e.id},l.a.createElement("p",null,e.reply),l.a.createElement("p",null,e.repliedBy),l.a.createElement("p",null,e.repliedOn))}))))}))))),l.a.createElement("div",{className:"col-md-4"},l.a.createElement("h3",null,"LATEST"),l.a.createElement("hr",{className:"hr8"}),l.a.createElement("div",{className:"scroll"},l.a.createElement(v,null),l.a.createElement(y.a,null)),l.a.createElement("div",null,l.a.createElement("h3",null,"SPOTIFY PLAYLIST"),l.a.createElement("hr",{className:"hr9"}),l.a.createElement("iframe",{title:"This is a unique title",className:"spotify-frame",src:"https://open.spotify.com/embed/playlist/3ehtiZyniZjVSs9Tv5BwCl",height:"380",width:"350",frameBorder:"0",allowtransparency:"true",allow:"encrypted-media"})),l.a.createElement("div",null,l.a.createElement("h3",{className:"controller"},"FIND US"),l.a.createElement("hr",{className:"hr10"}),l.a.createElement("div",null,l.a.createElement(N,null)))))),l.a.createElement(_,null))},G=function(){return l.a.createElement("div",{className:"mycontainer"},l.a.createElement("div",{className:""},l.a.createElement("h1",null,"About")))},Y=function(){return l.a.createElement("div",{className:"mycontainer"},l.a.createElement("div",{className:""},l.a.createElement("h1",null,"Contact")))},J=function(e){var t=e.post,a=Object(o.b)();return l.a.createElement("div",{className:"col s12 m6"},l.a.createElement("div",{className:"card"},l.a.createElement("div",{className:"card-content"},l.a.createElement(d.b,{to:"/post/".concat(t.id)},l.a.createElement("span",{className:"card-title"},t.title)),l.a.createElement("p",null,t.description)),l.a.createElement("div",{className:"card-action"},l.a.createElement("button",{onClick:function(){return a((e=t.id,function(t){t({type:"DELETE_POST_REQUEST",info:"Requesting to delete post",status:"orange"}),i.a.delete("https://athenanetworks.herokuapp.com/post/".concat(e)).then((function(a){t(function(e){return{type:"DELETE_POST_SUCCESS",info:"Deleted post Successfully",status:"green",payload:e}}(e))})).catch((function(e){t({type:"DELETE_POST_FAILURE",info:"Failed to delete post",status:"red",payload:e.response.data})}))}));var e},className:"btn red"},"Delete"))))},Q=function(){var e=Object(o.c)((function(e){return e})).postReducer;return l.a.createElement("div",{className:"container"},l.a.createElement("div",{className:"row"},e.posts&&e.posts.map((function(e){return l.a.createElement(J,{post:e,key:e.id})}))))},V=function(){var e=Object(n.useState)({title:"",description:"",content:"",categoryId:1}),t=Object(C.a)(e,2),a=t[0],c=t[1],r=Object(o.b)();Object(n.useEffect)((function(){r(u())}),[r]);var s=function(e){c(Object(k.a)(Object(k.a)({},a),{},Object(O.a)({},e.target.name,e.target.value)))};return l.a.createElement("div",{className:"container",style:{margin:"4rem auto"}},l.a.createElement("h5",{className:"blue-text center-align"},"Admin"),l.a.createElement("form",{onSubmit:function(e){e.preventDefault(),r(function(e){return function(t){t({type:"ADD_POST_REQUEST",info:" Requesting to add new post",status:"orange"}),i.a.post(m,e).then((function(e){t(function(e){return{type:"ADD_POST_SUCCESS",info:"Post added Successfully",status:"green",payload:e}}(e.data))})).catch((function(e){t(function(e){return{type:"ADD_POST_FAILURE",info:"Failed to add Post",status:"red",payload:e}}(e.response.data))}))}}(a)),c({title:"",description:"",content:"",categoryId:1,imageUrl:"",thumbnailImageUrl:""})}},l.a.createElement("div",{className:"input-field"},l.a.createElement("label",{htmlFor:"post_title"},"Title"),l.a.createElement("input",{onChange:s,value:a.title,type:"text",name:"title"})),l.a.createElement("div",{className:"input-field"},l.a.createElement("label",{htmlFor:"post_title"},"Description"),l.a.createElement("input",{onChange:s,value:a.description,type:"text",name:"description"})),l.a.createElement("div",{className:"input-field"},l.a.createElement("label",{htmlFor:"post_content"},"Content"),l.a.createElement("textarea",{onChange:s,value:a.content,name:"content",className:"materialize-textarea"})),l.a.createElement("div",{className:"input-field"},l.a.createElement("label",{htmlFor:"post_imageUrl"},"imageUrl"),l.a.createElement("input",{onChange:s,value:a.imageUrl,type:"text",name:"imageUrl"})),l.a.createElement("div",{className:"input-field"},l.a.createElement("label",{htmlFor:"post_thumbnailImageUrl"},"thumbnailImageUrl"),l.a.createElement("input",{onChange:s,value:a.thumbnailImageUrl,type:"text",name:"thumbnailImageUrl"})),l.a.createElement("div",{className:"input-field"},l.a.createElement("button",{className:"btn blue"},"Submit"))),l.a.createElement(Q,null))};var Z=function(){return l.a.createElement(d.a,null,l.a.createElement("div",null,l.a.createElement(U.c,null,l.a.createElement(U.a,{exact:!0,path:"/",component:A}),l.a.createElement(U.a,{exact:!0,path:"/about",component:G}),l.a.createElement(U.a,{exact:!0,path:"/contact",component:Y}),l.a.createElement(U.a,{exact:!0,path:"/post/:id",component:z}),l.a.createElement(U.a,{exact:!0,path:"/admin",component:V}),l.a.createElement(A,null))))},X=Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));function $(e,t){navigator.serviceWorker.register(e).then((function(e){e.onupdatefound=function(){var a=e.installing;null!=a&&(a.onstatechange=function(){"installed"===a.state&&(navigator.serviceWorker.controller?(console.log("New content is available and will be used when all tabs for this page are closed. See https://bit.ly/CRA-PWA."),t&&t.onUpdate&&t.onUpdate(e)):(console.log("Content is cached for offline use."),t&&t.onSuccess&&t.onSuccess(e)))})}})).catch((function(e){console.error("Error during service worker registration:",e)}))}var K=a(58),ee=a(167),te=a(168),ae=a.n(te),ne=a(169),le=(a(398),a(399),a(400),a(118)),ce={posts:[]},re=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:ce,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"FETCH_POSTS_SUCCESS":return Object(k.a)(Object(k.a)({},e),{},{loading:!1,posts:t.payload});case"SEARCH_POSTS":return{posts:t.payload};case"ADD_COMMENT":return{posts:Object(le.a)(e.posts)};case"ADD_POST_SUCCESS":return{posts:[t.payload].concat(Object(le.a)(e.posts))};case"DELETE_POST_SUCCESS":var a=e.posts.filter((function(e){return e.id!==t.payload}));return{posts:a};default:return e}},oe=Object(K.combineReducers)({postReducer:re}),se=a(170),ie=a.n(se),me=function(){try{var e=localStorage.getItem("state");if(null===e)return;return JSON.parse(e)}catch(t){return}}(),ue=Object(K.createStore)(oe,me,Object(ee.composeWithDevTools)(Object(K.applyMiddleware)(ae.a,ne.a)));ue.subscribe(ie()((function(){!function(e){try{var t=JSON.stringify(e);localStorage.setItem("state",t)}catch(a){}}(ue.getState())}),500)),r.a.render(l.a.createElement(o.a,{store:ue},l.a.createElement(l.a.StrictMode,null,l.a.createElement(Z,null))),document.getElementById("root")),function(e){if("serviceWorker"in navigator){if(new URL("",window.location.href).origin!==window.location.origin)return;window.addEventListener("load",(function(){var t="".concat("","/service-worker.js");X?(!function(e,t){fetch(e,{headers:{"Service-Worker":"script"}}).then((function(a){var n=a.headers.get("content-type");404===a.status||null!=n&&-1===n.indexOf("javascript")?navigator.serviceWorker.ready.then((function(e){e.unregister().then((function(){window.location.reload()}))})):$(e,t)})).catch((function(){console.log("No internet connection found. App is running in offline mode.")}))}(t,e),navigator.serviceWorker.ready.then((function(){console.log("This web app is being served cache-first by a service worker. To learn more, visit https://bit.ly/CRA-PWA")}))):$(t,e)}))}}()}},[[179,1,2]]]);
//# sourceMappingURL=main.96374956.chunk.js.map