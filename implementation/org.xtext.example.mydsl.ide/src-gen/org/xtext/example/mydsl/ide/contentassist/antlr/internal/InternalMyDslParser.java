package org.xtext.example.mydsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'H'", "'M'", "'L'", "'I'", "'C'", "'Av'", "'Ac'", "'Transport'", "'Architectural'", "'Application'", "'Store'", "'Comparator'", "'Discarder'", "'Joiner'", "'Copier'", "'Splitter'", "'Forward'", "'EncryptOrHash'", "'Decrypt'", "'Authenticator'", "'Authoriser'", "'Verifier'", "'User'", "'VLAN'", "'ETH'", "'WiFi'", "'EDFD'", "'['", "']'", "'assets:'", "','", "'elements:'", "'attack'", "'zones:'", "'attacker'", "'profiles:'", "'subzones:'", "'observation:'", "'Asset'", "'source:'", "'targets:'", "'values:'", "'Process'", "'responsibilities:'", "'assumption:'", "'incoming'", "'flows:'", "'outgoing'", "'attacker:'", "'::'", "'ExternalEntity'", "'num:'", "'channel'", "'DataStore'", "'layer:'", "'-'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }


    	private MyDslGrammarAccess grammarAccess;

    	public void setGrammarAccess(MyDslGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleEDFD"
    // InternalMyDsl.g:53:1: entryRuleEDFD : ruleEDFD EOF ;
    public final void entryRuleEDFD() throws RecognitionException {
        try {
            // InternalMyDsl.g:54:1: ( ruleEDFD EOF )
            // InternalMyDsl.g:55:1: ruleEDFD EOF
            {
             before(grammarAccess.getEDFDRule()); 
            pushFollow(FOLLOW_1);
            ruleEDFD();

            state._fsp--;

             after(grammarAccess.getEDFDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEDFD"


    // $ANTLR start "ruleEDFD"
    // InternalMyDsl.g:62:1: ruleEDFD : ( ( rule__EDFD__Group__0 ) ) ;
    public final void ruleEDFD() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:66:2: ( ( ( rule__EDFD__Group__0 ) ) )
            // InternalMyDsl.g:67:2: ( ( rule__EDFD__Group__0 ) )
            {
            // InternalMyDsl.g:67:2: ( ( rule__EDFD__Group__0 ) )
            // InternalMyDsl.g:68:3: ( rule__EDFD__Group__0 )
            {
             before(grammarAccess.getEDFDAccess().getGroup()); 
            // InternalMyDsl.g:69:3: ( rule__EDFD__Group__0 )
            // InternalMyDsl.g:69:4: rule__EDFD__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEDFDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEDFD"


    // $ANTLR start "entryRuleTrustZone"
    // InternalMyDsl.g:78:1: entryRuleTrustZone : ruleTrustZone EOF ;
    public final void entryRuleTrustZone() throws RecognitionException {
        try {
            // InternalMyDsl.g:79:1: ( ruleTrustZone EOF )
            // InternalMyDsl.g:80:1: ruleTrustZone EOF
            {
             before(grammarAccess.getTrustZoneRule()); 
            pushFollow(FOLLOW_1);
            ruleTrustZone();

            state._fsp--;

             after(grammarAccess.getTrustZoneRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrustZone"


    // $ANTLR start "ruleTrustZone"
    // InternalMyDsl.g:87:1: ruleTrustZone : ( ( rule__TrustZone__Group__0 ) ) ;
    public final void ruleTrustZone() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:91:2: ( ( ( rule__TrustZone__Group__0 ) ) )
            // InternalMyDsl.g:92:2: ( ( rule__TrustZone__Group__0 ) )
            {
            // InternalMyDsl.g:92:2: ( ( rule__TrustZone__Group__0 ) )
            // InternalMyDsl.g:93:3: ( rule__TrustZone__Group__0 )
            {
             before(grammarAccess.getTrustZoneAccess().getGroup()); 
            // InternalMyDsl.g:94:3: ( rule__TrustZone__Group__0 )
            // InternalMyDsl.g:94:4: rule__TrustZone__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrustZoneAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrustZone"


    // $ANTLR start "entryRuleAttackerProfile"
    // InternalMyDsl.g:103:1: entryRuleAttackerProfile : ruleAttackerProfile EOF ;
    public final void entryRuleAttackerProfile() throws RecognitionException {
        try {
            // InternalMyDsl.g:104:1: ( ruleAttackerProfile EOF )
            // InternalMyDsl.g:105:1: ruleAttackerProfile EOF
            {
             before(grammarAccess.getAttackerProfileRule()); 
            pushFollow(FOLLOW_1);
            ruleAttackerProfile();

            state._fsp--;

             after(grammarAccess.getAttackerProfileRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttackerProfile"


    // $ANTLR start "ruleAttackerProfile"
    // InternalMyDsl.g:112:1: ruleAttackerProfile : ( ( rule__AttackerProfile__Group__0 ) ) ;
    public final void ruleAttackerProfile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:116:2: ( ( ( rule__AttackerProfile__Group__0 ) ) )
            // InternalMyDsl.g:117:2: ( ( rule__AttackerProfile__Group__0 ) )
            {
            // InternalMyDsl.g:117:2: ( ( rule__AttackerProfile__Group__0 ) )
            // InternalMyDsl.g:118:3: ( rule__AttackerProfile__Group__0 )
            {
             before(grammarAccess.getAttackerProfileAccess().getGroup()); 
            // InternalMyDsl.g:119:3: ( rule__AttackerProfile__Group__0 )
            // InternalMyDsl.g:119:4: rule__AttackerProfile__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttackerProfile__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttackerProfileAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttackerProfile"


    // $ANTLR start "entryRuleAsset"
    // InternalMyDsl.g:128:1: entryRuleAsset : ruleAsset EOF ;
    public final void entryRuleAsset() throws RecognitionException {
        try {
            // InternalMyDsl.g:129:1: ( ruleAsset EOF )
            // InternalMyDsl.g:130:1: ruleAsset EOF
            {
             before(grammarAccess.getAssetRule()); 
            pushFollow(FOLLOW_1);
            ruleAsset();

            state._fsp--;

             after(grammarAccess.getAssetRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAsset"


    // $ANTLR start "ruleAsset"
    // InternalMyDsl.g:137:1: ruleAsset : ( ( rule__Asset__Group__0 ) ) ;
    public final void ruleAsset() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:141:2: ( ( ( rule__Asset__Group__0 ) ) )
            // InternalMyDsl.g:142:2: ( ( rule__Asset__Group__0 ) )
            {
            // InternalMyDsl.g:142:2: ( ( rule__Asset__Group__0 ) )
            // InternalMyDsl.g:143:3: ( rule__Asset__Group__0 )
            {
             before(grammarAccess.getAssetAccess().getGroup()); 
            // InternalMyDsl.g:144:3: ( rule__Asset__Group__0 )
            // InternalMyDsl.g:144:4: rule__Asset__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Asset__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAsset"


    // $ANTLR start "entryRuleProcess"
    // InternalMyDsl.g:153:1: entryRuleProcess : ruleProcess EOF ;
    public final void entryRuleProcess() throws RecognitionException {
        try {
            // InternalMyDsl.g:154:1: ( ruleProcess EOF )
            // InternalMyDsl.g:155:1: ruleProcess EOF
            {
             before(grammarAccess.getProcessRule()); 
            pushFollow(FOLLOW_1);
            ruleProcess();

            state._fsp--;

             after(grammarAccess.getProcessRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalMyDsl.g:162:1: ruleProcess : ( ( rule__Process__Group__0 ) ) ;
    public final void ruleProcess() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:166:2: ( ( ( rule__Process__Group__0 ) ) )
            // InternalMyDsl.g:167:2: ( ( rule__Process__Group__0 ) )
            {
            // InternalMyDsl.g:167:2: ( ( rule__Process__Group__0 ) )
            // InternalMyDsl.g:168:3: ( rule__Process__Group__0 )
            {
             before(grammarAccess.getProcessAccess().getGroup()); 
            // InternalMyDsl.g:169:3: ( rule__Process__Group__0 )
            // InternalMyDsl.g:169:4: rule__Process__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleResponsibility"
    // InternalMyDsl.g:178:1: entryRuleResponsibility : ruleResponsibility EOF ;
    public final void entryRuleResponsibility() throws RecognitionException {
        try {
            // InternalMyDsl.g:179:1: ( ruleResponsibility EOF )
            // InternalMyDsl.g:180:1: ruleResponsibility EOF
            {
             before(grammarAccess.getResponsibilityRule()); 
            pushFollow(FOLLOW_1);
            ruleResponsibility();

            state._fsp--;

             after(grammarAccess.getResponsibilityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResponsibility"


    // $ANTLR start "ruleResponsibility"
    // InternalMyDsl.g:187:1: ruleResponsibility : ( ( rule__Responsibility__Group__0 ) ) ;
    public final void ruleResponsibility() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:191:2: ( ( ( rule__Responsibility__Group__0 ) ) )
            // InternalMyDsl.g:192:2: ( ( rule__Responsibility__Group__0 ) )
            {
            // InternalMyDsl.g:192:2: ( ( rule__Responsibility__Group__0 ) )
            // InternalMyDsl.g:193:3: ( rule__Responsibility__Group__0 )
            {
             before(grammarAccess.getResponsibilityAccess().getGroup()); 
            // InternalMyDsl.g:194:3: ( rule__Responsibility__Group__0 )
            // InternalMyDsl.g:194:4: rule__Responsibility__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Responsibility__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResponsibilityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResponsibility"


    // $ANTLR start "entryRuleExternalEntity"
    // InternalMyDsl.g:203:1: entryRuleExternalEntity : ruleExternalEntity EOF ;
    public final void entryRuleExternalEntity() throws RecognitionException {
        try {
            // InternalMyDsl.g:204:1: ( ruleExternalEntity EOF )
            // InternalMyDsl.g:205:1: ruleExternalEntity EOF
            {
             before(grammarAccess.getExternalEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleExternalEntity();

            state._fsp--;

             after(grammarAccess.getExternalEntityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExternalEntity"


    // $ANTLR start "ruleExternalEntity"
    // InternalMyDsl.g:212:1: ruleExternalEntity : ( ( rule__ExternalEntity__Group__0 ) ) ;
    public final void ruleExternalEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:216:2: ( ( ( rule__ExternalEntity__Group__0 ) ) )
            // InternalMyDsl.g:217:2: ( ( rule__ExternalEntity__Group__0 ) )
            {
            // InternalMyDsl.g:217:2: ( ( rule__ExternalEntity__Group__0 ) )
            // InternalMyDsl.g:218:3: ( rule__ExternalEntity__Group__0 )
            {
             before(grammarAccess.getExternalEntityAccess().getGroup()); 
            // InternalMyDsl.g:219:3: ( rule__ExternalEntity__Group__0 )
            // InternalMyDsl.g:219:4: rule__ExternalEntity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExternalEntity"


    // $ANTLR start "entryRuleFlow"
    // InternalMyDsl.g:228:1: entryRuleFlow : ruleFlow EOF ;
    public final void entryRuleFlow() throws RecognitionException {
        try {
            // InternalMyDsl.g:229:1: ( ruleFlow EOF )
            // InternalMyDsl.g:230:1: ruleFlow EOF
            {
             before(grammarAccess.getFlowRule()); 
            pushFollow(FOLLOW_1);
            ruleFlow();

            state._fsp--;

             after(grammarAccess.getFlowRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFlow"


    // $ANTLR start "ruleFlow"
    // InternalMyDsl.g:237:1: ruleFlow : ( ( rule__Flow__Group__0 ) ) ;
    public final void ruleFlow() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:241:2: ( ( ( rule__Flow__Group__0 ) ) )
            // InternalMyDsl.g:242:2: ( ( rule__Flow__Group__0 ) )
            {
            // InternalMyDsl.g:242:2: ( ( rule__Flow__Group__0 ) )
            // InternalMyDsl.g:243:3: ( rule__Flow__Group__0 )
            {
             before(grammarAccess.getFlowAccess().getGroup()); 
            // InternalMyDsl.g:244:3: ( rule__Flow__Group__0 )
            // InternalMyDsl.g:244:4: rule__Flow__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFlow"


    // $ANTLR start "entryRuleDataStore"
    // InternalMyDsl.g:253:1: entryRuleDataStore : ruleDataStore EOF ;
    public final void entryRuleDataStore() throws RecognitionException {
        try {
            // InternalMyDsl.g:254:1: ( ruleDataStore EOF )
            // InternalMyDsl.g:255:1: ruleDataStore EOF
            {
             before(grammarAccess.getDataStoreRule()); 
            pushFollow(FOLLOW_1);
            ruleDataStore();

            state._fsp--;

             after(grammarAccess.getDataStoreRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDataStore"


    // $ANTLR start "ruleDataStore"
    // InternalMyDsl.g:262:1: ruleDataStore : ( ( rule__DataStore__Group__0 ) ) ;
    public final void ruleDataStore() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:266:2: ( ( ( rule__DataStore__Group__0 ) ) )
            // InternalMyDsl.g:267:2: ( ( rule__DataStore__Group__0 ) )
            {
            // InternalMyDsl.g:267:2: ( ( rule__DataStore__Group__0 ) )
            // InternalMyDsl.g:268:3: ( rule__DataStore__Group__0 )
            {
             before(grammarAccess.getDataStoreAccess().getGroup()); 
            // InternalMyDsl.g:269:3: ( rule__DataStore__Group__0 )
            // InternalMyDsl.g:269:4: rule__DataStore__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataStore"


    // $ANTLR start "entryRuleValue"
    // InternalMyDsl.g:278:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // InternalMyDsl.g:279:1: ( ruleValue EOF )
            // InternalMyDsl.g:280:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalMyDsl.g:287:1: ruleValue : ( ( rule__Value__Group__0 ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:291:2: ( ( ( rule__Value__Group__0 ) ) )
            // InternalMyDsl.g:292:2: ( ( rule__Value__Group__0 ) )
            {
            // InternalMyDsl.g:292:2: ( ( rule__Value__Group__0 ) )
            // InternalMyDsl.g:293:3: ( rule__Value__Group__0 )
            {
             before(grammarAccess.getValueAccess().getGroup()); 
            // InternalMyDsl.g:294:3: ( rule__Value__Group__0 )
            // InternalMyDsl.g:294:4: rule__Value__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Value__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleAssumption"
    // InternalMyDsl.g:303:1: entryRuleAssumption : ruleAssumption EOF ;
    public final void entryRuleAssumption() throws RecognitionException {
        try {
            // InternalMyDsl.g:304:1: ( ruleAssumption EOF )
            // InternalMyDsl.g:305:1: ruleAssumption EOF
            {
             before(grammarAccess.getAssumptionRule()); 
            pushFollow(FOLLOW_1);
            ruleAssumption();

            state._fsp--;

             after(grammarAccess.getAssumptionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssumption"


    // $ANTLR start "ruleAssumption"
    // InternalMyDsl.g:312:1: ruleAssumption : ( ( rule__Assumption__Group__0 ) ) ;
    public final void ruleAssumption() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:316:2: ( ( ( rule__Assumption__Group__0 ) ) )
            // InternalMyDsl.g:317:2: ( ( rule__Assumption__Group__0 ) )
            {
            // InternalMyDsl.g:317:2: ( ( rule__Assumption__Group__0 ) )
            // InternalMyDsl.g:318:3: ( rule__Assumption__Group__0 )
            {
             before(grammarAccess.getAssumptionAccess().getGroup()); 
            // InternalMyDsl.g:319:3: ( rule__Assumption__Group__0 )
            // InternalMyDsl.g:319:4: rule__Assumption__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Assumption__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssumptionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssumption"


    // $ANTLR start "entryRuleElement"
    // InternalMyDsl.g:328:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalMyDsl.g:329:1: ( ruleElement EOF )
            // InternalMyDsl.g:330:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalMyDsl.g:337:1: ruleElement : ( ( rule__Element__Alternatives ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:341:2: ( ( ( rule__Element__Alternatives ) ) )
            // InternalMyDsl.g:342:2: ( ( rule__Element__Alternatives ) )
            {
            // InternalMyDsl.g:342:2: ( ( rule__Element__Alternatives ) )
            // InternalMyDsl.g:343:3: ( rule__Element__Alternatives )
            {
             before(grammarAccess.getElementAccess().getAlternatives()); 
            // InternalMyDsl.g:344:3: ( rule__Element__Alternatives )
            // InternalMyDsl.g:344:4: rule__Element__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Element__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:353:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalMyDsl.g:354:1: ( ruleEString EOF )
            // InternalMyDsl.g:355:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalMyDsl.g:362:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:366:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalMyDsl.g:367:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalMyDsl.g:367:2: ( ( rule__EString__Alternatives ) )
            // InternalMyDsl.g:368:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalMyDsl.g:369:3: ( rule__EString__Alternatives )
            // InternalMyDsl.g:369:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEBoolean"
    // InternalMyDsl.g:378:1: entryRuleEBoolean : ruleEBoolean EOF ;
    public final void entryRuleEBoolean() throws RecognitionException {
        try {
            // InternalMyDsl.g:379:1: ( ruleEBoolean EOF )
            // InternalMyDsl.g:380:1: ruleEBoolean EOF
            {
             before(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getEBooleanRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalMyDsl.g:387:1: ruleEBoolean : ( ( rule__EBoolean__Alternatives ) ) ;
    public final void ruleEBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:391:2: ( ( ( rule__EBoolean__Alternatives ) ) )
            // InternalMyDsl.g:392:2: ( ( rule__EBoolean__Alternatives ) )
            {
            // InternalMyDsl.g:392:2: ( ( rule__EBoolean__Alternatives ) )
            // InternalMyDsl.g:393:3: ( rule__EBoolean__Alternatives )
            {
             before(grammarAccess.getEBooleanAccess().getAlternatives()); 
            // InternalMyDsl.g:394:3: ( rule__EBoolean__Alternatives )
            // InternalMyDsl.g:394:4: rule__EBoolean__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EBoolean__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEBooleanAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleEInt"
    // InternalMyDsl.g:403:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalMyDsl.g:404:1: ( ruleEInt EOF )
            // InternalMyDsl.g:405:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalMyDsl.g:412:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:416:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalMyDsl.g:417:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalMyDsl.g:417:2: ( ( rule__EInt__Group__0 ) )
            // InternalMyDsl.g:418:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalMyDsl.g:419:3: ( rule__EInt__Group__0 )
            // InternalMyDsl.g:419:4: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "rulePriority"
    // InternalMyDsl.g:428:1: rulePriority : ( ( rule__Priority__Alternatives ) ) ;
    public final void rulePriority() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:432:1: ( ( ( rule__Priority__Alternatives ) ) )
            // InternalMyDsl.g:433:2: ( ( rule__Priority__Alternatives ) )
            {
            // InternalMyDsl.g:433:2: ( ( rule__Priority__Alternatives ) )
            // InternalMyDsl.g:434:3: ( rule__Priority__Alternatives )
            {
             before(grammarAccess.getPriorityAccess().getAlternatives()); 
            // InternalMyDsl.g:435:3: ( rule__Priority__Alternatives )
            // InternalMyDsl.g:435:4: rule__Priority__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Priority__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPriorityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePriority"


    // $ANTLR start "ruleObjective"
    // InternalMyDsl.g:444:1: ruleObjective : ( ( rule__Objective__Alternatives ) ) ;
    public final void ruleObjective() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:448:1: ( ( ( rule__Objective__Alternatives ) ) )
            // InternalMyDsl.g:449:2: ( ( rule__Objective__Alternatives ) )
            {
            // InternalMyDsl.g:449:2: ( ( rule__Objective__Alternatives ) )
            // InternalMyDsl.g:450:3: ( rule__Objective__Alternatives )
            {
             before(grammarAccess.getObjectiveAccess().getAlternatives()); 
            // InternalMyDsl.g:451:3: ( rule__Objective__Alternatives )
            // InternalMyDsl.g:451:4: rule__Objective__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Objective__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getObjectiveAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjective"


    // $ANTLR start "ruleLayer"
    // InternalMyDsl.g:460:1: ruleLayer : ( ( rule__Layer__Alternatives ) ) ;
    public final void ruleLayer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:464:1: ( ( ( rule__Layer__Alternatives ) ) )
            // InternalMyDsl.g:465:2: ( ( rule__Layer__Alternatives ) )
            {
            // InternalMyDsl.g:465:2: ( ( rule__Layer__Alternatives ) )
            // InternalMyDsl.g:466:3: ( rule__Layer__Alternatives )
            {
             before(grammarAccess.getLayerAccess().getAlternatives()); 
            // InternalMyDsl.g:467:3: ( rule__Layer__Alternatives )
            // InternalMyDsl.g:467:4: rule__Layer__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Layer__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLayerAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLayer"


    // $ANTLR start "ruleResponsibilityType"
    // InternalMyDsl.g:476:1: ruleResponsibilityType : ( ( rule__ResponsibilityType__Alternatives ) ) ;
    public final void ruleResponsibilityType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:480:1: ( ( ( rule__ResponsibilityType__Alternatives ) ) )
            // InternalMyDsl.g:481:2: ( ( rule__ResponsibilityType__Alternatives ) )
            {
            // InternalMyDsl.g:481:2: ( ( rule__ResponsibilityType__Alternatives ) )
            // InternalMyDsl.g:482:3: ( rule__ResponsibilityType__Alternatives )
            {
             before(grammarAccess.getResponsibilityTypeAccess().getAlternatives()); 
            // InternalMyDsl.g:483:3: ( rule__ResponsibilityType__Alternatives )
            // InternalMyDsl.g:483:4: rule__ResponsibilityType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ResponsibilityType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getResponsibilityTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResponsibilityType"


    // $ANTLR start "ruleChannel"
    // InternalMyDsl.g:492:1: ruleChannel : ( ( rule__Channel__Alternatives ) ) ;
    public final void ruleChannel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:496:1: ( ( ( rule__Channel__Alternatives ) ) )
            // InternalMyDsl.g:497:2: ( ( rule__Channel__Alternatives ) )
            {
            // InternalMyDsl.g:497:2: ( ( rule__Channel__Alternatives ) )
            // InternalMyDsl.g:498:3: ( rule__Channel__Alternatives )
            {
             before(grammarAccess.getChannelAccess().getAlternatives()); 
            // InternalMyDsl.g:499:3: ( rule__Channel__Alternatives )
            // InternalMyDsl.g:499:4: rule__Channel__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Channel__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getChannelAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChannel"


    // $ANTLR start "rule__Element__Alternatives"
    // InternalMyDsl.g:507:1: rule__Element__Alternatives : ( ( ruleProcess ) | ( ruleExternalEntity ) | ( ruleFlow ) | ( ruleDataStore ) | ( ruleTrustZone ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:511:1: ( ( ruleProcess ) | ( ruleExternalEntity ) | ( ruleFlow ) | ( ruleDataStore ) | ( ruleTrustZone ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt1=1;
                }
                break;
            case 63:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
                {
                int LA1_3 = input.LA(2);

                if ( (LA1_3==40) ) {
                    int LA1_6 = input.LA(3);

                    if ( (LA1_6==44||LA1_6==47||LA1_6==49) ) {
                        alt1=5;
                    }
                    else if ( ((LA1_6>=41 && LA1_6<=42)||(LA1_6>=52 && LA1_6<=53)||LA1_6==57||(LA1_6>=64 && LA1_6<=65)) ) {
                        alt1=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 6, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA1_4 = input.LA(2);

                if ( (LA1_4==40) ) {
                    int LA1_6 = input.LA(3);

                    if ( (LA1_6==44||LA1_6==47||LA1_6==49) ) {
                        alt1=5;
                    }
                    else if ( ((LA1_6>=41 && LA1_6<=42)||(LA1_6>=52 && LA1_6<=53)||LA1_6==57||(LA1_6>=64 && LA1_6<=65)) ) {
                        alt1=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 6, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;
                }
                }
                break;
            case 66:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalMyDsl.g:512:2: ( ruleProcess )
                    {
                    // InternalMyDsl.g:512:2: ( ruleProcess )
                    // InternalMyDsl.g:513:3: ruleProcess
                    {
                     before(grammarAccess.getElementAccess().getProcessParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleProcess();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getProcessParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:518:2: ( ruleExternalEntity )
                    {
                    // InternalMyDsl.g:518:2: ( ruleExternalEntity )
                    // InternalMyDsl.g:519:3: ruleExternalEntity
                    {
                     before(grammarAccess.getElementAccess().getExternalEntityParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleExternalEntity();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getExternalEntityParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:524:2: ( ruleFlow )
                    {
                    // InternalMyDsl.g:524:2: ( ruleFlow )
                    // InternalMyDsl.g:525:3: ruleFlow
                    {
                     before(grammarAccess.getElementAccess().getFlowParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFlow();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getFlowParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:530:2: ( ruleDataStore )
                    {
                    // InternalMyDsl.g:530:2: ( ruleDataStore )
                    // InternalMyDsl.g:531:3: ruleDataStore
                    {
                     before(grammarAccess.getElementAccess().getDataStoreParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleDataStore();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getDataStoreParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:536:2: ( ruleTrustZone )
                    {
                    // InternalMyDsl.g:536:2: ( ruleTrustZone )
                    // InternalMyDsl.g:537:3: ruleTrustZone
                    {
                     before(grammarAccess.getElementAccess().getTrustZoneParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleTrustZone();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getTrustZoneParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalMyDsl.g:546:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:550:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyDsl.g:551:2: ( RULE_STRING )
                    {
                    // InternalMyDsl.g:551:2: ( RULE_STRING )
                    // InternalMyDsl.g:552:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:557:2: ( RULE_ID )
                    {
                    // InternalMyDsl.g:557:2: ( RULE_ID )
                    // InternalMyDsl.g:558:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__EBoolean__Alternatives"
    // InternalMyDsl.g:567:1: rule__EBoolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__EBoolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:571:1: ( ( 'true' ) | ( 'false' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMyDsl.g:572:2: ( 'true' )
                    {
                    // InternalMyDsl.g:572:2: ( 'true' )
                    // InternalMyDsl.g:573:3: 'true'
                    {
                     before(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:578:2: ( 'false' )
                    {
                    // InternalMyDsl.g:578:2: ( 'false' )
                    // InternalMyDsl.g:579:3: 'false'
                    {
                     before(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EBoolean__Alternatives"


    // $ANTLR start "rule__Priority__Alternatives"
    // InternalMyDsl.g:588:1: rule__Priority__Alternatives : ( ( ( 'H' ) ) | ( ( 'M' ) ) | ( ( 'L' ) ) );
    public final void rule__Priority__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:592:1: ( ( ( 'H' ) ) | ( ( 'M' ) ) | ( ( 'L' ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 15:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalMyDsl.g:593:2: ( ( 'H' ) )
                    {
                    // InternalMyDsl.g:593:2: ( ( 'H' ) )
                    // InternalMyDsl.g:594:3: ( 'H' )
                    {
                     before(grammarAccess.getPriorityAccess().getHEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:595:3: ( 'H' )
                    // InternalMyDsl.g:595:4: 'H'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getPriorityAccess().getHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:599:2: ( ( 'M' ) )
                    {
                    // InternalMyDsl.g:599:2: ( ( 'M' ) )
                    // InternalMyDsl.g:600:3: ( 'M' )
                    {
                     before(grammarAccess.getPriorityAccess().getMEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:601:3: ( 'M' )
                    // InternalMyDsl.g:601:4: 'M'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getPriorityAccess().getMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:605:2: ( ( 'L' ) )
                    {
                    // InternalMyDsl.g:605:2: ( ( 'L' ) )
                    // InternalMyDsl.g:606:3: ( 'L' )
                    {
                     before(grammarAccess.getPriorityAccess().getLEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:607:3: ( 'L' )
                    // InternalMyDsl.g:607:4: 'L'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getPriorityAccess().getLEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Priority__Alternatives"


    // $ANTLR start "rule__Objective__Alternatives"
    // InternalMyDsl.g:615:1: rule__Objective__Alternatives : ( ( ( 'I' ) ) | ( ( 'C' ) ) | ( ( 'Av' ) ) | ( ( 'Ac' ) ) );
    public final void rule__Objective__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:619:1: ( ( ( 'I' ) ) | ( ( 'C' ) ) | ( ( 'Av' ) ) | ( ( 'Ac' ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case 18:
                {
                alt5=3;
                }
                break;
            case 19:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalMyDsl.g:620:2: ( ( 'I' ) )
                    {
                    // InternalMyDsl.g:620:2: ( ( 'I' ) )
                    // InternalMyDsl.g:621:3: ( 'I' )
                    {
                     before(grammarAccess.getObjectiveAccess().getIntegrityEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:622:3: ( 'I' )
                    // InternalMyDsl.g:622:4: 'I'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getIntegrityEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:626:2: ( ( 'C' ) )
                    {
                    // InternalMyDsl.g:626:2: ( ( 'C' ) )
                    // InternalMyDsl.g:627:3: ( 'C' )
                    {
                     before(grammarAccess.getObjectiveAccess().getConfidentialityEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:628:3: ( 'C' )
                    // InternalMyDsl.g:628:4: 'C'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getConfidentialityEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:632:2: ( ( 'Av' ) )
                    {
                    // InternalMyDsl.g:632:2: ( ( 'Av' ) )
                    // InternalMyDsl.g:633:3: ( 'Av' )
                    {
                     before(grammarAccess.getObjectiveAccess().getAvailabilityEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:634:3: ( 'Av' )
                    // InternalMyDsl.g:634:4: 'Av'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getAvailabilityEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:638:2: ( ( 'Ac' ) )
                    {
                    // InternalMyDsl.g:638:2: ( ( 'Ac' ) )
                    // InternalMyDsl.g:639:3: ( 'Ac' )
                    {
                     before(grammarAccess.getObjectiveAccess().getAccountabilityEnumLiteralDeclaration_3()); 
                    // InternalMyDsl.g:640:3: ( 'Ac' )
                    // InternalMyDsl.g:640:4: 'Ac'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getAccountabilityEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Objective__Alternatives"


    // $ANTLR start "rule__Layer__Alternatives"
    // InternalMyDsl.g:648:1: rule__Layer__Alternatives : ( ( ( 'Transport' ) ) | ( ( 'Architectural' ) ) | ( ( 'Application' ) ) );
    public final void rule__Layer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:652:1: ( ( ( 'Transport' ) ) | ( ( 'Architectural' ) ) | ( ( 'Application' ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt6=1;
                }
                break;
            case 21:
                {
                alt6=2;
                }
                break;
            case 22:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:653:2: ( ( 'Transport' ) )
                    {
                    // InternalMyDsl.g:653:2: ( ( 'Transport' ) )
                    // InternalMyDsl.g:654:3: ( 'Transport' )
                    {
                     before(grammarAccess.getLayerAccess().getTransportEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:655:3: ( 'Transport' )
                    // InternalMyDsl.g:655:4: 'Transport'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLayerAccess().getTransportEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:659:2: ( ( 'Architectural' ) )
                    {
                    // InternalMyDsl.g:659:2: ( ( 'Architectural' ) )
                    // InternalMyDsl.g:660:3: ( 'Architectural' )
                    {
                     before(grammarAccess.getLayerAccess().getArchitecturalEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:661:3: ( 'Architectural' )
                    // InternalMyDsl.g:661:4: 'Architectural'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLayerAccess().getArchitecturalEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:665:2: ( ( 'Application' ) )
                    {
                    // InternalMyDsl.g:665:2: ( ( 'Application' ) )
                    // InternalMyDsl.g:666:3: ( 'Application' )
                    {
                     before(grammarAccess.getLayerAccess().getApplicationEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:667:3: ( 'Application' )
                    // InternalMyDsl.g:667:4: 'Application'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getLayerAccess().getApplicationEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Layer__Alternatives"


    // $ANTLR start "rule__ResponsibilityType__Alternatives"
    // InternalMyDsl.g:675:1: rule__ResponsibilityType__Alternatives : ( ( ( 'Store' ) ) | ( ( 'Comparator' ) ) | ( ( 'Discarder' ) ) | ( ( 'Joiner' ) ) | ( ( 'Copier' ) ) | ( ( 'Splitter' ) ) | ( ( 'Forward' ) ) | ( ( 'EncryptOrHash' ) ) | ( ( 'Decrypt' ) ) | ( ( 'Authenticator' ) ) | ( ( 'Authoriser' ) ) | ( ( 'Verifier' ) ) | ( ( 'User' ) ) );
    public final void rule__ResponsibilityType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:679:1: ( ( ( 'Store' ) ) | ( ( 'Comparator' ) ) | ( ( 'Discarder' ) ) | ( ( 'Joiner' ) ) | ( ( 'Copier' ) ) | ( ( 'Splitter' ) ) | ( ( 'Forward' ) ) | ( ( 'EncryptOrHash' ) ) | ( ( 'Decrypt' ) ) | ( ( 'Authenticator' ) ) | ( ( 'Authoriser' ) ) | ( ( 'Verifier' ) ) | ( ( 'User' ) ) )
            int alt7=13;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt7=1;
                }
                break;
            case 24:
                {
                alt7=2;
                }
                break;
            case 25:
                {
                alt7=3;
                }
                break;
            case 26:
                {
                alt7=4;
                }
                break;
            case 27:
                {
                alt7=5;
                }
                break;
            case 28:
                {
                alt7=6;
                }
                break;
            case 29:
                {
                alt7=7;
                }
                break;
            case 30:
                {
                alt7=8;
                }
                break;
            case 31:
                {
                alt7=9;
                }
                break;
            case 32:
                {
                alt7=10;
                }
                break;
            case 33:
                {
                alt7=11;
                }
                break;
            case 34:
                {
                alt7=12;
                }
                break;
            case 35:
                {
                alt7=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalMyDsl.g:680:2: ( ( 'Store' ) )
                    {
                    // InternalMyDsl.g:680:2: ( ( 'Store' ) )
                    // InternalMyDsl.g:681:3: ( 'Store' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getStoreEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:682:3: ( 'Store' )
                    // InternalMyDsl.g:682:4: 'Store'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getStoreEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:686:2: ( ( 'Comparator' ) )
                    {
                    // InternalMyDsl.g:686:2: ( ( 'Comparator' ) )
                    // InternalMyDsl.g:687:3: ( 'Comparator' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getComparatorEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:688:3: ( 'Comparator' )
                    // InternalMyDsl.g:688:4: 'Comparator'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getComparatorEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:692:2: ( ( 'Discarder' ) )
                    {
                    // InternalMyDsl.g:692:2: ( ( 'Discarder' ) )
                    // InternalMyDsl.g:693:3: ( 'Discarder' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getDiscarderEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:694:3: ( 'Discarder' )
                    // InternalMyDsl.g:694:4: 'Discarder'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getDiscarderEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:698:2: ( ( 'Joiner' ) )
                    {
                    // InternalMyDsl.g:698:2: ( ( 'Joiner' ) )
                    // InternalMyDsl.g:699:3: ( 'Joiner' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getJoinerEnumLiteralDeclaration_3()); 
                    // InternalMyDsl.g:700:3: ( 'Joiner' )
                    // InternalMyDsl.g:700:4: 'Joiner'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getJoinerEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:704:2: ( ( 'Copier' ) )
                    {
                    // InternalMyDsl.g:704:2: ( ( 'Copier' ) )
                    // InternalMyDsl.g:705:3: ( 'Copier' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getCopierEnumLiteralDeclaration_4()); 
                    // InternalMyDsl.g:706:3: ( 'Copier' )
                    // InternalMyDsl.g:706:4: 'Copier'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getCopierEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:710:2: ( ( 'Splitter' ) )
                    {
                    // InternalMyDsl.g:710:2: ( ( 'Splitter' ) )
                    // InternalMyDsl.g:711:3: ( 'Splitter' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getSplitterEnumLiteralDeclaration_5()); 
                    // InternalMyDsl.g:712:3: ( 'Splitter' )
                    // InternalMyDsl.g:712:4: 'Splitter'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getSplitterEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:716:2: ( ( 'Forward' ) )
                    {
                    // InternalMyDsl.g:716:2: ( ( 'Forward' ) )
                    // InternalMyDsl.g:717:3: ( 'Forward' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getForwardEnumLiteralDeclaration_6()); 
                    // InternalMyDsl.g:718:3: ( 'Forward' )
                    // InternalMyDsl.g:718:4: 'Forward'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getForwardEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:722:2: ( ( 'EncryptOrHash' ) )
                    {
                    // InternalMyDsl.g:722:2: ( ( 'EncryptOrHash' ) )
                    // InternalMyDsl.g:723:3: ( 'EncryptOrHash' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getEncryptOrHashEnumLiteralDeclaration_7()); 
                    // InternalMyDsl.g:724:3: ( 'EncryptOrHash' )
                    // InternalMyDsl.g:724:4: 'EncryptOrHash'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getEncryptOrHashEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:728:2: ( ( 'Decrypt' ) )
                    {
                    // InternalMyDsl.g:728:2: ( ( 'Decrypt' ) )
                    // InternalMyDsl.g:729:3: ( 'Decrypt' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getDecryptEnumLiteralDeclaration_8()); 
                    // InternalMyDsl.g:730:3: ( 'Decrypt' )
                    // InternalMyDsl.g:730:4: 'Decrypt'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getDecryptEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:734:2: ( ( 'Authenticator' ) )
                    {
                    // InternalMyDsl.g:734:2: ( ( 'Authenticator' ) )
                    // InternalMyDsl.g:735:3: ( 'Authenticator' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getAuthenticatorEnumLiteralDeclaration_9()); 
                    // InternalMyDsl.g:736:3: ( 'Authenticator' )
                    // InternalMyDsl.g:736:4: 'Authenticator'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getAuthenticatorEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:740:2: ( ( 'Authoriser' ) )
                    {
                    // InternalMyDsl.g:740:2: ( ( 'Authoriser' ) )
                    // InternalMyDsl.g:741:3: ( 'Authoriser' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getAuthoriserEnumLiteralDeclaration_10()); 
                    // InternalMyDsl.g:742:3: ( 'Authoriser' )
                    // InternalMyDsl.g:742:4: 'Authoriser'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getAuthoriserEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalMyDsl.g:746:2: ( ( 'Verifier' ) )
                    {
                    // InternalMyDsl.g:746:2: ( ( 'Verifier' ) )
                    // InternalMyDsl.g:747:3: ( 'Verifier' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getVerifierEnumLiteralDeclaration_11()); 
                    // InternalMyDsl.g:748:3: ( 'Verifier' )
                    // InternalMyDsl.g:748:4: 'Verifier'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getVerifierEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalMyDsl.g:752:2: ( ( 'User' ) )
                    {
                    // InternalMyDsl.g:752:2: ( ( 'User' ) )
                    // InternalMyDsl.g:753:3: ( 'User' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getUserEnumLiteralDeclaration_12()); 
                    // InternalMyDsl.g:754:3: ( 'User' )
                    // InternalMyDsl.g:754:4: 'User'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getUserEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResponsibilityType__Alternatives"


    // $ANTLR start "rule__Channel__Alternatives"
    // InternalMyDsl.g:762:1: rule__Channel__Alternatives : ( ( ( 'VLAN' ) ) | ( ( 'ETH' ) ) | ( ( 'WiFi' ) ) );
    public final void rule__Channel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:766:1: ( ( ( 'VLAN' ) ) | ( ( 'ETH' ) ) | ( ( 'WiFi' ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt8=1;
                }
                break;
            case 37:
                {
                alt8=2;
                }
                break;
            case 38:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:767:2: ( ( 'VLAN' ) )
                    {
                    // InternalMyDsl.g:767:2: ( ( 'VLAN' ) )
                    // InternalMyDsl.g:768:3: ( 'VLAN' )
                    {
                     before(grammarAccess.getChannelAccess().getVLANEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:769:3: ( 'VLAN' )
                    // InternalMyDsl.g:769:4: 'VLAN'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getChannelAccess().getVLANEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:773:2: ( ( 'ETH' ) )
                    {
                    // InternalMyDsl.g:773:2: ( ( 'ETH' ) )
                    // InternalMyDsl.g:774:3: ( 'ETH' )
                    {
                     before(grammarAccess.getChannelAccess().getETHEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:775:3: ( 'ETH' )
                    // InternalMyDsl.g:775:4: 'ETH'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getChannelAccess().getETHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:779:2: ( ( 'WiFi' ) )
                    {
                    // InternalMyDsl.g:779:2: ( ( 'WiFi' ) )
                    // InternalMyDsl.g:780:3: ( 'WiFi' )
                    {
                     before(grammarAccess.getChannelAccess().getWiFiEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:781:3: ( 'WiFi' )
                    // InternalMyDsl.g:781:4: 'WiFi'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getChannelAccess().getWiFiEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Channel__Alternatives"


    // $ANTLR start "rule__EDFD__Group__0"
    // InternalMyDsl.g:789:1: rule__EDFD__Group__0 : rule__EDFD__Group__0__Impl rule__EDFD__Group__1 ;
    public final void rule__EDFD__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:793:1: ( rule__EDFD__Group__0__Impl rule__EDFD__Group__1 )
            // InternalMyDsl.g:794:2: rule__EDFD__Group__0__Impl rule__EDFD__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__EDFD__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__0"


    // $ANTLR start "rule__EDFD__Group__0__Impl"
    // InternalMyDsl.g:801:1: rule__EDFD__Group__0__Impl : ( () ) ;
    public final void rule__EDFD__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:805:1: ( ( () ) )
            // InternalMyDsl.g:806:1: ( () )
            {
            // InternalMyDsl.g:806:1: ( () )
            // InternalMyDsl.g:807:2: ()
            {
             before(grammarAccess.getEDFDAccess().getEDFDAction_0()); 
            // InternalMyDsl.g:808:2: ()
            // InternalMyDsl.g:808:3: 
            {
            }

             after(grammarAccess.getEDFDAccess().getEDFDAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__0__Impl"


    // $ANTLR start "rule__EDFD__Group__1"
    // InternalMyDsl.g:816:1: rule__EDFD__Group__1 : rule__EDFD__Group__1__Impl rule__EDFD__Group__2 ;
    public final void rule__EDFD__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:820:1: ( rule__EDFD__Group__1__Impl rule__EDFD__Group__2 )
            // InternalMyDsl.g:821:2: rule__EDFD__Group__1__Impl rule__EDFD__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__EDFD__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__1"


    // $ANTLR start "rule__EDFD__Group__1__Impl"
    // InternalMyDsl.g:828:1: rule__EDFD__Group__1__Impl : ( 'EDFD' ) ;
    public final void rule__EDFD__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:832:1: ( ( 'EDFD' ) )
            // InternalMyDsl.g:833:1: ( 'EDFD' )
            {
            // InternalMyDsl.g:833:1: ( 'EDFD' )
            // InternalMyDsl.g:834:2: 'EDFD'
            {
             before(grammarAccess.getEDFDAccess().getEDFDKeyword_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getEDFDKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__1__Impl"


    // $ANTLR start "rule__EDFD__Group__2"
    // InternalMyDsl.g:843:1: rule__EDFD__Group__2 : rule__EDFD__Group__2__Impl rule__EDFD__Group__3 ;
    public final void rule__EDFD__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:847:1: ( rule__EDFD__Group__2__Impl rule__EDFD__Group__3 )
            // InternalMyDsl.g:848:2: rule__EDFD__Group__2__Impl rule__EDFD__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__EDFD__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__2"


    // $ANTLR start "rule__EDFD__Group__2__Impl"
    // InternalMyDsl.g:855:1: rule__EDFD__Group__2__Impl : ( ( rule__EDFD__NameAssignment_2 ) ) ;
    public final void rule__EDFD__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:859:1: ( ( ( rule__EDFD__NameAssignment_2 ) ) )
            // InternalMyDsl.g:860:1: ( ( rule__EDFD__NameAssignment_2 ) )
            {
            // InternalMyDsl.g:860:1: ( ( rule__EDFD__NameAssignment_2 ) )
            // InternalMyDsl.g:861:2: ( rule__EDFD__NameAssignment_2 )
            {
             before(grammarAccess.getEDFDAccess().getNameAssignment_2()); 
            // InternalMyDsl.g:862:2: ( rule__EDFD__NameAssignment_2 )
            // InternalMyDsl.g:862:3: rule__EDFD__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEDFDAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__2__Impl"


    // $ANTLR start "rule__EDFD__Group__3"
    // InternalMyDsl.g:870:1: rule__EDFD__Group__3 : rule__EDFD__Group__3__Impl rule__EDFD__Group__4 ;
    public final void rule__EDFD__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:874:1: ( rule__EDFD__Group__3__Impl rule__EDFD__Group__4 )
            // InternalMyDsl.g:875:2: rule__EDFD__Group__3__Impl rule__EDFD__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__EDFD__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__3"


    // $ANTLR start "rule__EDFD__Group__3__Impl"
    // InternalMyDsl.g:882:1: rule__EDFD__Group__3__Impl : ( '[' ) ;
    public final void rule__EDFD__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:886:1: ( ( '[' ) )
            // InternalMyDsl.g:887:1: ( '[' )
            {
            // InternalMyDsl.g:887:1: ( '[' )
            // InternalMyDsl.g:888:2: '['
            {
             before(grammarAccess.getEDFDAccess().getLeftSquareBracketKeyword_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__3__Impl"


    // $ANTLR start "rule__EDFD__Group__4"
    // InternalMyDsl.g:897:1: rule__EDFD__Group__4 : rule__EDFD__Group__4__Impl rule__EDFD__Group__5 ;
    public final void rule__EDFD__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:901:1: ( rule__EDFD__Group__4__Impl rule__EDFD__Group__5 )
            // InternalMyDsl.g:902:2: rule__EDFD__Group__4__Impl rule__EDFD__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__EDFD__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__4"


    // $ANTLR start "rule__EDFD__Group__4__Impl"
    // InternalMyDsl.g:909:1: rule__EDFD__Group__4__Impl : ( ( rule__EDFD__Group_4__0 )? ) ;
    public final void rule__EDFD__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:913:1: ( ( ( rule__EDFD__Group_4__0 )? ) )
            // InternalMyDsl.g:914:1: ( ( rule__EDFD__Group_4__0 )? )
            {
            // InternalMyDsl.g:914:1: ( ( rule__EDFD__Group_4__0 )? )
            // InternalMyDsl.g:915:2: ( rule__EDFD__Group_4__0 )?
            {
             before(grammarAccess.getEDFDAccess().getGroup_4()); 
            // InternalMyDsl.g:916:2: ( rule__EDFD__Group_4__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==42) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMyDsl.g:916:3: rule__EDFD__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDFD__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDFDAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__4__Impl"


    // $ANTLR start "rule__EDFD__Group__5"
    // InternalMyDsl.g:924:1: rule__EDFD__Group__5 : rule__EDFD__Group__5__Impl rule__EDFD__Group__6 ;
    public final void rule__EDFD__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:928:1: ( rule__EDFD__Group__5__Impl rule__EDFD__Group__6 )
            // InternalMyDsl.g:929:2: rule__EDFD__Group__5__Impl rule__EDFD__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__EDFD__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__5"


    // $ANTLR start "rule__EDFD__Group__5__Impl"
    // InternalMyDsl.g:936:1: rule__EDFD__Group__5__Impl : ( ( rule__EDFD__Group_5__0 )? ) ;
    public final void rule__EDFD__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:940:1: ( ( ( rule__EDFD__Group_5__0 )? ) )
            // InternalMyDsl.g:941:1: ( ( rule__EDFD__Group_5__0 )? )
            {
            // InternalMyDsl.g:941:1: ( ( rule__EDFD__Group_5__0 )? )
            // InternalMyDsl.g:942:2: ( rule__EDFD__Group_5__0 )?
            {
             before(grammarAccess.getEDFDAccess().getGroup_5()); 
            // InternalMyDsl.g:943:2: ( rule__EDFD__Group_5__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==44) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMyDsl.g:943:3: rule__EDFD__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDFD__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDFDAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__5__Impl"


    // $ANTLR start "rule__EDFD__Group__6"
    // InternalMyDsl.g:951:1: rule__EDFD__Group__6 : rule__EDFD__Group__6__Impl rule__EDFD__Group__7 ;
    public final void rule__EDFD__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:955:1: ( rule__EDFD__Group__6__Impl rule__EDFD__Group__7 )
            // InternalMyDsl.g:956:2: rule__EDFD__Group__6__Impl rule__EDFD__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__EDFD__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__6"


    // $ANTLR start "rule__EDFD__Group__6__Impl"
    // InternalMyDsl.g:963:1: rule__EDFD__Group__6__Impl : ( ( rule__EDFD__Group_6__0 )? ) ;
    public final void rule__EDFD__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:967:1: ( ( ( rule__EDFD__Group_6__0 )? ) )
            // InternalMyDsl.g:968:1: ( ( rule__EDFD__Group_6__0 )? )
            {
            // InternalMyDsl.g:968:1: ( ( rule__EDFD__Group_6__0 )? )
            // InternalMyDsl.g:969:2: ( rule__EDFD__Group_6__0 )?
            {
             before(grammarAccess.getEDFDAccess().getGroup_6()); 
            // InternalMyDsl.g:970:2: ( rule__EDFD__Group_6__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==45) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:970:3: rule__EDFD__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDFD__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDFDAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__6__Impl"


    // $ANTLR start "rule__EDFD__Group__7"
    // InternalMyDsl.g:978:1: rule__EDFD__Group__7 : rule__EDFD__Group__7__Impl ;
    public final void rule__EDFD__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:982:1: ( rule__EDFD__Group__7__Impl )
            // InternalMyDsl.g:983:2: rule__EDFD__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__7"


    // $ANTLR start "rule__EDFD__Group__7__Impl"
    // InternalMyDsl.g:989:1: rule__EDFD__Group__7__Impl : ( ']' ) ;
    public final void rule__EDFD__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:993:1: ( ( ']' ) )
            // InternalMyDsl.g:994:1: ( ']' )
            {
            // InternalMyDsl.g:994:1: ( ']' )
            // InternalMyDsl.g:995:2: ']'
            {
             before(grammarAccess.getEDFDAccess().getRightSquareBracketKeyword_7()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getRightSquareBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group__7__Impl"


    // $ANTLR start "rule__EDFD__Group_4__0"
    // InternalMyDsl.g:1005:1: rule__EDFD__Group_4__0 : rule__EDFD__Group_4__0__Impl rule__EDFD__Group_4__1 ;
    public final void rule__EDFD__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1009:1: ( rule__EDFD__Group_4__0__Impl rule__EDFD__Group_4__1 )
            // InternalMyDsl.g:1010:2: rule__EDFD__Group_4__0__Impl rule__EDFD__Group_4__1
            {
            pushFollow(FOLLOW_7);
            rule__EDFD__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4__0"


    // $ANTLR start "rule__EDFD__Group_4__0__Impl"
    // InternalMyDsl.g:1017:1: rule__EDFD__Group_4__0__Impl : ( 'assets:' ) ;
    public final void rule__EDFD__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1021:1: ( ( 'assets:' ) )
            // InternalMyDsl.g:1022:1: ( 'assets:' )
            {
            // InternalMyDsl.g:1022:1: ( 'assets:' )
            // InternalMyDsl.g:1023:2: 'assets:'
            {
             before(grammarAccess.getEDFDAccess().getAssetsKeyword_4_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getAssetsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4__0__Impl"


    // $ANTLR start "rule__EDFD__Group_4__1"
    // InternalMyDsl.g:1032:1: rule__EDFD__Group_4__1 : rule__EDFD__Group_4__1__Impl rule__EDFD__Group_4__2 ;
    public final void rule__EDFD__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1036:1: ( rule__EDFD__Group_4__1__Impl rule__EDFD__Group_4__2 )
            // InternalMyDsl.g:1037:2: rule__EDFD__Group_4__1__Impl rule__EDFD__Group_4__2
            {
            pushFollow(FOLLOW_8);
            rule__EDFD__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4__1"


    // $ANTLR start "rule__EDFD__Group_4__1__Impl"
    // InternalMyDsl.g:1044:1: rule__EDFD__Group_4__1__Impl : ( ( rule__EDFD__AssetAssignment_4_1 ) ) ;
    public final void rule__EDFD__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1048:1: ( ( ( rule__EDFD__AssetAssignment_4_1 ) ) )
            // InternalMyDsl.g:1049:1: ( ( rule__EDFD__AssetAssignment_4_1 ) )
            {
            // InternalMyDsl.g:1049:1: ( ( rule__EDFD__AssetAssignment_4_1 ) )
            // InternalMyDsl.g:1050:2: ( rule__EDFD__AssetAssignment_4_1 )
            {
             before(grammarAccess.getEDFDAccess().getAssetAssignment_4_1()); 
            // InternalMyDsl.g:1051:2: ( rule__EDFD__AssetAssignment_4_1 )
            // InternalMyDsl.g:1051:3: rule__EDFD__AssetAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__AssetAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getEDFDAccess().getAssetAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4__1__Impl"


    // $ANTLR start "rule__EDFD__Group_4__2"
    // InternalMyDsl.g:1059:1: rule__EDFD__Group_4__2 : rule__EDFD__Group_4__2__Impl ;
    public final void rule__EDFD__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1063:1: ( rule__EDFD__Group_4__2__Impl )
            // InternalMyDsl.g:1064:2: rule__EDFD__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4__2"


    // $ANTLR start "rule__EDFD__Group_4__2__Impl"
    // InternalMyDsl.g:1070:1: rule__EDFD__Group_4__2__Impl : ( ( rule__EDFD__Group_4_2__0 )* ) ;
    public final void rule__EDFD__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1074:1: ( ( ( rule__EDFD__Group_4_2__0 )* ) )
            // InternalMyDsl.g:1075:1: ( ( rule__EDFD__Group_4_2__0 )* )
            {
            // InternalMyDsl.g:1075:1: ( ( rule__EDFD__Group_4_2__0 )* )
            // InternalMyDsl.g:1076:2: ( rule__EDFD__Group_4_2__0 )*
            {
             before(grammarAccess.getEDFDAccess().getGroup_4_2()); 
            // InternalMyDsl.g:1077:2: ( rule__EDFD__Group_4_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==43) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMyDsl.g:1077:3: rule__EDFD__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__EDFD__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getEDFDAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4__2__Impl"


    // $ANTLR start "rule__EDFD__Group_4_2__0"
    // InternalMyDsl.g:1086:1: rule__EDFD__Group_4_2__0 : rule__EDFD__Group_4_2__0__Impl rule__EDFD__Group_4_2__1 ;
    public final void rule__EDFD__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1090:1: ( rule__EDFD__Group_4_2__0__Impl rule__EDFD__Group_4_2__1 )
            // InternalMyDsl.g:1091:2: rule__EDFD__Group_4_2__0__Impl rule__EDFD__Group_4_2__1
            {
            pushFollow(FOLLOW_7);
            rule__EDFD__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4_2__0"


    // $ANTLR start "rule__EDFD__Group_4_2__0__Impl"
    // InternalMyDsl.g:1098:1: rule__EDFD__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__EDFD__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1102:1: ( ( ',' ) )
            // InternalMyDsl.g:1103:1: ( ',' )
            {
            // InternalMyDsl.g:1103:1: ( ',' )
            // InternalMyDsl.g:1104:2: ','
            {
             before(grammarAccess.getEDFDAccess().getCommaKeyword_4_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4_2__0__Impl"


    // $ANTLR start "rule__EDFD__Group_4_2__1"
    // InternalMyDsl.g:1113:1: rule__EDFD__Group_4_2__1 : rule__EDFD__Group_4_2__1__Impl ;
    public final void rule__EDFD__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1117:1: ( rule__EDFD__Group_4_2__1__Impl )
            // InternalMyDsl.g:1118:2: rule__EDFD__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4_2__1"


    // $ANTLR start "rule__EDFD__Group_4_2__1__Impl"
    // InternalMyDsl.g:1124:1: rule__EDFD__Group_4_2__1__Impl : ( ( rule__EDFD__AssetAssignment_4_2_1 ) ) ;
    public final void rule__EDFD__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1128:1: ( ( ( rule__EDFD__AssetAssignment_4_2_1 ) ) )
            // InternalMyDsl.g:1129:1: ( ( rule__EDFD__AssetAssignment_4_2_1 ) )
            {
            // InternalMyDsl.g:1129:1: ( ( rule__EDFD__AssetAssignment_4_2_1 ) )
            // InternalMyDsl.g:1130:2: ( rule__EDFD__AssetAssignment_4_2_1 )
            {
             before(grammarAccess.getEDFDAccess().getAssetAssignment_4_2_1()); 
            // InternalMyDsl.g:1131:2: ( rule__EDFD__AssetAssignment_4_2_1 )
            // InternalMyDsl.g:1131:3: rule__EDFD__AssetAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__AssetAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEDFDAccess().getAssetAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_4_2__1__Impl"


    // $ANTLR start "rule__EDFD__Group_5__0"
    // InternalMyDsl.g:1140:1: rule__EDFD__Group_5__0 : rule__EDFD__Group_5__0__Impl rule__EDFD__Group_5__1 ;
    public final void rule__EDFD__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1144:1: ( rule__EDFD__Group_5__0__Impl rule__EDFD__Group_5__1 )
            // InternalMyDsl.g:1145:2: rule__EDFD__Group_5__0__Impl rule__EDFD__Group_5__1
            {
            pushFollow(FOLLOW_10);
            rule__EDFD__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5__0"


    // $ANTLR start "rule__EDFD__Group_5__0__Impl"
    // InternalMyDsl.g:1152:1: rule__EDFD__Group_5__0__Impl : ( 'elements:' ) ;
    public final void rule__EDFD__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1156:1: ( ( 'elements:' ) )
            // InternalMyDsl.g:1157:1: ( 'elements:' )
            {
            // InternalMyDsl.g:1157:1: ( 'elements:' )
            // InternalMyDsl.g:1158:2: 'elements:'
            {
             before(grammarAccess.getEDFDAccess().getElementsKeyword_5_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getElementsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5__0__Impl"


    // $ANTLR start "rule__EDFD__Group_5__1"
    // InternalMyDsl.g:1167:1: rule__EDFD__Group_5__1 : rule__EDFD__Group_5__1__Impl rule__EDFD__Group_5__2 ;
    public final void rule__EDFD__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1171:1: ( rule__EDFD__Group_5__1__Impl rule__EDFD__Group_5__2 )
            // InternalMyDsl.g:1172:2: rule__EDFD__Group_5__1__Impl rule__EDFD__Group_5__2
            {
            pushFollow(FOLLOW_8);
            rule__EDFD__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5__1"


    // $ANTLR start "rule__EDFD__Group_5__1__Impl"
    // InternalMyDsl.g:1179:1: rule__EDFD__Group_5__1__Impl : ( ( rule__EDFD__ElementsAssignment_5_1 ) ) ;
    public final void rule__EDFD__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1183:1: ( ( ( rule__EDFD__ElementsAssignment_5_1 ) ) )
            // InternalMyDsl.g:1184:1: ( ( rule__EDFD__ElementsAssignment_5_1 ) )
            {
            // InternalMyDsl.g:1184:1: ( ( rule__EDFD__ElementsAssignment_5_1 ) )
            // InternalMyDsl.g:1185:2: ( rule__EDFD__ElementsAssignment_5_1 )
            {
             before(grammarAccess.getEDFDAccess().getElementsAssignment_5_1()); 
            // InternalMyDsl.g:1186:2: ( rule__EDFD__ElementsAssignment_5_1 )
            // InternalMyDsl.g:1186:3: rule__EDFD__ElementsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__ElementsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getEDFDAccess().getElementsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5__1__Impl"


    // $ANTLR start "rule__EDFD__Group_5__2"
    // InternalMyDsl.g:1194:1: rule__EDFD__Group_5__2 : rule__EDFD__Group_5__2__Impl ;
    public final void rule__EDFD__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1198:1: ( rule__EDFD__Group_5__2__Impl )
            // InternalMyDsl.g:1199:2: rule__EDFD__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5__2"


    // $ANTLR start "rule__EDFD__Group_5__2__Impl"
    // InternalMyDsl.g:1205:1: rule__EDFD__Group_5__2__Impl : ( ( rule__EDFD__Group_5_2__0 )* ) ;
    public final void rule__EDFD__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1209:1: ( ( ( rule__EDFD__Group_5_2__0 )* ) )
            // InternalMyDsl.g:1210:1: ( ( rule__EDFD__Group_5_2__0 )* )
            {
            // InternalMyDsl.g:1210:1: ( ( rule__EDFD__Group_5_2__0 )* )
            // InternalMyDsl.g:1211:2: ( rule__EDFD__Group_5_2__0 )*
            {
             before(grammarAccess.getEDFDAccess().getGroup_5_2()); 
            // InternalMyDsl.g:1212:2: ( rule__EDFD__Group_5_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==43) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMyDsl.g:1212:3: rule__EDFD__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__EDFD__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getEDFDAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5__2__Impl"


    // $ANTLR start "rule__EDFD__Group_5_2__0"
    // InternalMyDsl.g:1221:1: rule__EDFD__Group_5_2__0 : rule__EDFD__Group_5_2__0__Impl rule__EDFD__Group_5_2__1 ;
    public final void rule__EDFD__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1225:1: ( rule__EDFD__Group_5_2__0__Impl rule__EDFD__Group_5_2__1 )
            // InternalMyDsl.g:1226:2: rule__EDFD__Group_5_2__0__Impl rule__EDFD__Group_5_2__1
            {
            pushFollow(FOLLOW_10);
            rule__EDFD__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_5_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5_2__0"


    // $ANTLR start "rule__EDFD__Group_5_2__0__Impl"
    // InternalMyDsl.g:1233:1: rule__EDFD__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__EDFD__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1237:1: ( ( ',' ) )
            // InternalMyDsl.g:1238:1: ( ',' )
            {
            // InternalMyDsl.g:1238:1: ( ',' )
            // InternalMyDsl.g:1239:2: ','
            {
             before(grammarAccess.getEDFDAccess().getCommaKeyword_5_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getCommaKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5_2__0__Impl"


    // $ANTLR start "rule__EDFD__Group_5_2__1"
    // InternalMyDsl.g:1248:1: rule__EDFD__Group_5_2__1 : rule__EDFD__Group_5_2__1__Impl ;
    public final void rule__EDFD__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1252:1: ( rule__EDFD__Group_5_2__1__Impl )
            // InternalMyDsl.g:1253:2: rule__EDFD__Group_5_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__Group_5_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5_2__1"


    // $ANTLR start "rule__EDFD__Group_5_2__1__Impl"
    // InternalMyDsl.g:1259:1: rule__EDFD__Group_5_2__1__Impl : ( ( rule__EDFD__ElementsAssignment_5_2_1 ) ) ;
    public final void rule__EDFD__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1263:1: ( ( ( rule__EDFD__ElementsAssignment_5_2_1 ) ) )
            // InternalMyDsl.g:1264:1: ( ( rule__EDFD__ElementsAssignment_5_2_1 ) )
            {
            // InternalMyDsl.g:1264:1: ( ( rule__EDFD__ElementsAssignment_5_2_1 ) )
            // InternalMyDsl.g:1265:2: ( rule__EDFD__ElementsAssignment_5_2_1 )
            {
             before(grammarAccess.getEDFDAccess().getElementsAssignment_5_2_1()); 
            // InternalMyDsl.g:1266:2: ( rule__EDFD__ElementsAssignment_5_2_1 )
            // InternalMyDsl.g:1266:3: rule__EDFD__ElementsAssignment_5_2_1
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__ElementsAssignment_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEDFDAccess().getElementsAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_5_2__1__Impl"


    // $ANTLR start "rule__EDFD__Group_6__0"
    // InternalMyDsl.g:1275:1: rule__EDFD__Group_6__0 : rule__EDFD__Group_6__0__Impl rule__EDFD__Group_6__1 ;
    public final void rule__EDFD__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1279:1: ( rule__EDFD__Group_6__0__Impl rule__EDFD__Group_6__1 )
            // InternalMyDsl.g:1280:2: rule__EDFD__Group_6__0__Impl rule__EDFD__Group_6__1
            {
            pushFollow(FOLLOW_11);
            rule__EDFD__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6__0"


    // $ANTLR start "rule__EDFD__Group_6__0__Impl"
    // InternalMyDsl.g:1287:1: rule__EDFD__Group_6__0__Impl : ( 'attack' ) ;
    public final void rule__EDFD__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1291:1: ( ( 'attack' ) )
            // InternalMyDsl.g:1292:1: ( 'attack' )
            {
            // InternalMyDsl.g:1292:1: ( 'attack' )
            // InternalMyDsl.g:1293:2: 'attack'
            {
             before(grammarAccess.getEDFDAccess().getAttackKeyword_6_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getAttackKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6__0__Impl"


    // $ANTLR start "rule__EDFD__Group_6__1"
    // InternalMyDsl.g:1302:1: rule__EDFD__Group_6__1 : rule__EDFD__Group_6__1__Impl rule__EDFD__Group_6__2 ;
    public final void rule__EDFD__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1306:1: ( rule__EDFD__Group_6__1__Impl rule__EDFD__Group_6__2 )
            // InternalMyDsl.g:1307:2: rule__EDFD__Group_6__1__Impl rule__EDFD__Group_6__2
            {
            pushFollow(FOLLOW_10);
            rule__EDFD__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6__1"


    // $ANTLR start "rule__EDFD__Group_6__1__Impl"
    // InternalMyDsl.g:1314:1: rule__EDFD__Group_6__1__Impl : ( 'zones:' ) ;
    public final void rule__EDFD__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1318:1: ( ( 'zones:' ) )
            // InternalMyDsl.g:1319:1: ( 'zones:' )
            {
            // InternalMyDsl.g:1319:1: ( 'zones:' )
            // InternalMyDsl.g:1320:2: 'zones:'
            {
             before(grammarAccess.getEDFDAccess().getZonesKeyword_6_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getZonesKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6__1__Impl"


    // $ANTLR start "rule__EDFD__Group_6__2"
    // InternalMyDsl.g:1329:1: rule__EDFD__Group_6__2 : rule__EDFD__Group_6__2__Impl rule__EDFD__Group_6__3 ;
    public final void rule__EDFD__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1333:1: ( rule__EDFD__Group_6__2__Impl rule__EDFD__Group_6__3 )
            // InternalMyDsl.g:1334:2: rule__EDFD__Group_6__2__Impl rule__EDFD__Group_6__3
            {
            pushFollow(FOLLOW_8);
            rule__EDFD__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6__2"


    // $ANTLR start "rule__EDFD__Group_6__2__Impl"
    // InternalMyDsl.g:1341:1: rule__EDFD__Group_6__2__Impl : ( ( rule__EDFD__TrustzonesAssignment_6_2 ) ) ;
    public final void rule__EDFD__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1345:1: ( ( ( rule__EDFD__TrustzonesAssignment_6_2 ) ) )
            // InternalMyDsl.g:1346:1: ( ( rule__EDFD__TrustzonesAssignment_6_2 ) )
            {
            // InternalMyDsl.g:1346:1: ( ( rule__EDFD__TrustzonesAssignment_6_2 ) )
            // InternalMyDsl.g:1347:2: ( rule__EDFD__TrustzonesAssignment_6_2 )
            {
             before(grammarAccess.getEDFDAccess().getTrustzonesAssignment_6_2()); 
            // InternalMyDsl.g:1348:2: ( rule__EDFD__TrustzonesAssignment_6_2 )
            // InternalMyDsl.g:1348:3: rule__EDFD__TrustzonesAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__TrustzonesAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getEDFDAccess().getTrustzonesAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6__2__Impl"


    // $ANTLR start "rule__EDFD__Group_6__3"
    // InternalMyDsl.g:1356:1: rule__EDFD__Group_6__3 : rule__EDFD__Group_6__3__Impl ;
    public final void rule__EDFD__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1360:1: ( rule__EDFD__Group_6__3__Impl )
            // InternalMyDsl.g:1361:2: rule__EDFD__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__Group_6__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6__3"


    // $ANTLR start "rule__EDFD__Group_6__3__Impl"
    // InternalMyDsl.g:1367:1: rule__EDFD__Group_6__3__Impl : ( ( rule__EDFD__Group_6_3__0 )* ) ;
    public final void rule__EDFD__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1371:1: ( ( ( rule__EDFD__Group_6_3__0 )* ) )
            // InternalMyDsl.g:1372:1: ( ( rule__EDFD__Group_6_3__0 )* )
            {
            // InternalMyDsl.g:1372:1: ( ( rule__EDFD__Group_6_3__0 )* )
            // InternalMyDsl.g:1373:2: ( rule__EDFD__Group_6_3__0 )*
            {
             before(grammarAccess.getEDFDAccess().getGroup_6_3()); 
            // InternalMyDsl.g:1374:2: ( rule__EDFD__Group_6_3__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==43) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMyDsl.g:1374:3: rule__EDFD__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__EDFD__Group_6_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getEDFDAccess().getGroup_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6__3__Impl"


    // $ANTLR start "rule__EDFD__Group_6_3__0"
    // InternalMyDsl.g:1383:1: rule__EDFD__Group_6_3__0 : rule__EDFD__Group_6_3__0__Impl rule__EDFD__Group_6_3__1 ;
    public final void rule__EDFD__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1387:1: ( rule__EDFD__Group_6_3__0__Impl rule__EDFD__Group_6_3__1 )
            // InternalMyDsl.g:1388:2: rule__EDFD__Group_6_3__0__Impl rule__EDFD__Group_6_3__1
            {
            pushFollow(FOLLOW_10);
            rule__EDFD__Group_6_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDFD__Group_6_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6_3__0"


    // $ANTLR start "rule__EDFD__Group_6_3__0__Impl"
    // InternalMyDsl.g:1395:1: rule__EDFD__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__EDFD__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1399:1: ( ( ',' ) )
            // InternalMyDsl.g:1400:1: ( ',' )
            {
            // InternalMyDsl.g:1400:1: ( ',' )
            // InternalMyDsl.g:1401:2: ','
            {
             before(grammarAccess.getEDFDAccess().getCommaKeyword_6_3_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getEDFDAccess().getCommaKeyword_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6_3__0__Impl"


    // $ANTLR start "rule__EDFD__Group_6_3__1"
    // InternalMyDsl.g:1410:1: rule__EDFD__Group_6_3__1 : rule__EDFD__Group_6_3__1__Impl ;
    public final void rule__EDFD__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1414:1: ( rule__EDFD__Group_6_3__1__Impl )
            // InternalMyDsl.g:1415:2: rule__EDFD__Group_6_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__Group_6_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6_3__1"


    // $ANTLR start "rule__EDFD__Group_6_3__1__Impl"
    // InternalMyDsl.g:1421:1: rule__EDFD__Group_6_3__1__Impl : ( ( rule__EDFD__TrustzonesAssignment_6_3_1 ) ) ;
    public final void rule__EDFD__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1425:1: ( ( ( rule__EDFD__TrustzonesAssignment_6_3_1 ) ) )
            // InternalMyDsl.g:1426:1: ( ( rule__EDFD__TrustzonesAssignment_6_3_1 ) )
            {
            // InternalMyDsl.g:1426:1: ( ( rule__EDFD__TrustzonesAssignment_6_3_1 ) )
            // InternalMyDsl.g:1427:2: ( rule__EDFD__TrustzonesAssignment_6_3_1 )
            {
             before(grammarAccess.getEDFDAccess().getTrustzonesAssignment_6_3_1()); 
            // InternalMyDsl.g:1428:2: ( rule__EDFD__TrustzonesAssignment_6_3_1 )
            // InternalMyDsl.g:1428:3: rule__EDFD__TrustzonesAssignment_6_3_1
            {
            pushFollow(FOLLOW_2);
            rule__EDFD__TrustzonesAssignment_6_3_1();

            state._fsp--;


            }

             after(grammarAccess.getEDFDAccess().getTrustzonesAssignment_6_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__Group_6_3__1__Impl"


    // $ANTLR start "rule__TrustZone__Group__0"
    // InternalMyDsl.g:1437:1: rule__TrustZone__Group__0 : rule__TrustZone__Group__0__Impl rule__TrustZone__Group__1 ;
    public final void rule__TrustZone__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1441:1: ( rule__TrustZone__Group__0__Impl rule__TrustZone__Group__1 )
            // InternalMyDsl.g:1442:2: rule__TrustZone__Group__0__Impl rule__TrustZone__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__TrustZone__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__0"


    // $ANTLR start "rule__TrustZone__Group__0__Impl"
    // InternalMyDsl.g:1449:1: rule__TrustZone__Group__0__Impl : ( () ) ;
    public final void rule__TrustZone__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1453:1: ( ( () ) )
            // InternalMyDsl.g:1454:1: ( () )
            {
            // InternalMyDsl.g:1454:1: ( () )
            // InternalMyDsl.g:1455:2: ()
            {
             before(grammarAccess.getTrustZoneAccess().getTrustZoneAction_0()); 
            // InternalMyDsl.g:1456:2: ()
            // InternalMyDsl.g:1456:3: 
            {
            }

             after(grammarAccess.getTrustZoneAccess().getTrustZoneAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__0__Impl"


    // $ANTLR start "rule__TrustZone__Group__1"
    // InternalMyDsl.g:1464:1: rule__TrustZone__Group__1 : rule__TrustZone__Group__1__Impl rule__TrustZone__Group__2 ;
    public final void rule__TrustZone__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1468:1: ( rule__TrustZone__Group__1__Impl rule__TrustZone__Group__2 )
            // InternalMyDsl.g:1469:2: rule__TrustZone__Group__1__Impl rule__TrustZone__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__TrustZone__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__1"


    // $ANTLR start "rule__TrustZone__Group__1__Impl"
    // InternalMyDsl.g:1476:1: rule__TrustZone__Group__1__Impl : ( ( rule__TrustZone__NameAssignment_1 ) ) ;
    public final void rule__TrustZone__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1480:1: ( ( ( rule__TrustZone__NameAssignment_1 ) ) )
            // InternalMyDsl.g:1481:1: ( ( rule__TrustZone__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:1481:1: ( ( rule__TrustZone__NameAssignment_1 ) )
            // InternalMyDsl.g:1482:2: ( rule__TrustZone__NameAssignment_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:1483:2: ( rule__TrustZone__NameAssignment_1 )
            // InternalMyDsl.g:1483:3: rule__TrustZone__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrustZoneAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__1__Impl"


    // $ANTLR start "rule__TrustZone__Group__2"
    // InternalMyDsl.g:1491:1: rule__TrustZone__Group__2 : rule__TrustZone__Group__2__Impl rule__TrustZone__Group__3 ;
    public final void rule__TrustZone__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1495:1: ( rule__TrustZone__Group__2__Impl rule__TrustZone__Group__3 )
            // InternalMyDsl.g:1496:2: rule__TrustZone__Group__2__Impl rule__TrustZone__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__TrustZone__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__2"


    // $ANTLR start "rule__TrustZone__Group__2__Impl"
    // InternalMyDsl.g:1503:1: rule__TrustZone__Group__2__Impl : ( '[' ) ;
    public final void rule__TrustZone__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1507:1: ( ( '[' ) )
            // InternalMyDsl.g:1508:1: ( '[' )
            {
            // InternalMyDsl.g:1508:1: ( '[' )
            // InternalMyDsl.g:1509:2: '['
            {
             before(grammarAccess.getTrustZoneAccess().getLeftSquareBracketKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getTrustZoneAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__2__Impl"


    // $ANTLR start "rule__TrustZone__Group__3"
    // InternalMyDsl.g:1518:1: rule__TrustZone__Group__3 : rule__TrustZone__Group__3__Impl rule__TrustZone__Group__4 ;
    public final void rule__TrustZone__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1522:1: ( rule__TrustZone__Group__3__Impl rule__TrustZone__Group__4 )
            // InternalMyDsl.g:1523:2: rule__TrustZone__Group__3__Impl rule__TrustZone__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__TrustZone__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__3"


    // $ANTLR start "rule__TrustZone__Group__3__Impl"
    // InternalMyDsl.g:1530:1: rule__TrustZone__Group__3__Impl : ( ( rule__TrustZone__Group_3__0 )? ) ;
    public final void rule__TrustZone__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1534:1: ( ( ( rule__TrustZone__Group_3__0 )? ) )
            // InternalMyDsl.g:1535:1: ( ( rule__TrustZone__Group_3__0 )? )
            {
            // InternalMyDsl.g:1535:1: ( ( rule__TrustZone__Group_3__0 )? )
            // InternalMyDsl.g:1536:2: ( rule__TrustZone__Group_3__0 )?
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_3()); 
            // InternalMyDsl.g:1537:2: ( rule__TrustZone__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==47) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:1537:3: rule__TrustZone__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrustZone__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTrustZoneAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__3__Impl"


    // $ANTLR start "rule__TrustZone__Group__4"
    // InternalMyDsl.g:1545:1: rule__TrustZone__Group__4 : rule__TrustZone__Group__4__Impl rule__TrustZone__Group__5 ;
    public final void rule__TrustZone__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1549:1: ( rule__TrustZone__Group__4__Impl rule__TrustZone__Group__5 )
            // InternalMyDsl.g:1550:2: rule__TrustZone__Group__4__Impl rule__TrustZone__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__TrustZone__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__4"


    // $ANTLR start "rule__TrustZone__Group__4__Impl"
    // InternalMyDsl.g:1557:1: rule__TrustZone__Group__4__Impl : ( ( rule__TrustZone__Group_4__0 )? ) ;
    public final void rule__TrustZone__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1561:1: ( ( ( rule__TrustZone__Group_4__0 )? ) )
            // InternalMyDsl.g:1562:1: ( ( rule__TrustZone__Group_4__0 )? )
            {
            // InternalMyDsl.g:1562:1: ( ( rule__TrustZone__Group_4__0 )? )
            // InternalMyDsl.g:1563:2: ( rule__TrustZone__Group_4__0 )?
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_4()); 
            // InternalMyDsl.g:1564:2: ( rule__TrustZone__Group_4__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==44) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMyDsl.g:1564:3: rule__TrustZone__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrustZone__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTrustZoneAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__4__Impl"


    // $ANTLR start "rule__TrustZone__Group__5"
    // InternalMyDsl.g:1572:1: rule__TrustZone__Group__5 : rule__TrustZone__Group__5__Impl rule__TrustZone__Group__6 ;
    public final void rule__TrustZone__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1576:1: ( rule__TrustZone__Group__5__Impl rule__TrustZone__Group__6 )
            // InternalMyDsl.g:1577:2: rule__TrustZone__Group__5__Impl rule__TrustZone__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__TrustZone__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__5"


    // $ANTLR start "rule__TrustZone__Group__5__Impl"
    // InternalMyDsl.g:1584:1: rule__TrustZone__Group__5__Impl : ( ( rule__TrustZone__Group_5__0 )? ) ;
    public final void rule__TrustZone__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1588:1: ( ( ( rule__TrustZone__Group_5__0 )? ) )
            // InternalMyDsl.g:1589:1: ( ( rule__TrustZone__Group_5__0 )? )
            {
            // InternalMyDsl.g:1589:1: ( ( rule__TrustZone__Group_5__0 )? )
            // InternalMyDsl.g:1590:2: ( rule__TrustZone__Group_5__0 )?
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_5()); 
            // InternalMyDsl.g:1591:2: ( rule__TrustZone__Group_5__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==49) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:1591:3: rule__TrustZone__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrustZone__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTrustZoneAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__5__Impl"


    // $ANTLR start "rule__TrustZone__Group__6"
    // InternalMyDsl.g:1599:1: rule__TrustZone__Group__6 : rule__TrustZone__Group__6__Impl ;
    public final void rule__TrustZone__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1603:1: ( rule__TrustZone__Group__6__Impl )
            // InternalMyDsl.g:1604:2: rule__TrustZone__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__6"


    // $ANTLR start "rule__TrustZone__Group__6__Impl"
    // InternalMyDsl.g:1610:1: rule__TrustZone__Group__6__Impl : ( ']' ) ;
    public final void rule__TrustZone__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1614:1: ( ( ']' ) )
            // InternalMyDsl.g:1615:1: ( ']' )
            {
            // InternalMyDsl.g:1615:1: ( ']' )
            // InternalMyDsl.g:1616:2: ']'
            {
             before(grammarAccess.getTrustZoneAccess().getRightSquareBracketKeyword_6()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTrustZoneAccess().getRightSquareBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group__6__Impl"


    // $ANTLR start "rule__TrustZone__Group_3__0"
    // InternalMyDsl.g:1626:1: rule__TrustZone__Group_3__0 : rule__TrustZone__Group_3__0__Impl rule__TrustZone__Group_3__1 ;
    public final void rule__TrustZone__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1630:1: ( rule__TrustZone__Group_3__0__Impl rule__TrustZone__Group_3__1 )
            // InternalMyDsl.g:1631:2: rule__TrustZone__Group_3__0__Impl rule__TrustZone__Group_3__1
            {
            pushFollow(FOLLOW_13);
            rule__TrustZone__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3__0"


    // $ANTLR start "rule__TrustZone__Group_3__0__Impl"
    // InternalMyDsl.g:1638:1: rule__TrustZone__Group_3__0__Impl : ( 'attacker' ) ;
    public final void rule__TrustZone__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1642:1: ( ( 'attacker' ) )
            // InternalMyDsl.g:1643:1: ( 'attacker' )
            {
            // InternalMyDsl.g:1643:1: ( 'attacker' )
            // InternalMyDsl.g:1644:2: 'attacker'
            {
             before(grammarAccess.getTrustZoneAccess().getAttackerKeyword_3_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getTrustZoneAccess().getAttackerKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3__0__Impl"


    // $ANTLR start "rule__TrustZone__Group_3__1"
    // InternalMyDsl.g:1653:1: rule__TrustZone__Group_3__1 : rule__TrustZone__Group_3__1__Impl rule__TrustZone__Group_3__2 ;
    public final void rule__TrustZone__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1657:1: ( rule__TrustZone__Group_3__1__Impl rule__TrustZone__Group_3__2 )
            // InternalMyDsl.g:1658:2: rule__TrustZone__Group_3__1__Impl rule__TrustZone__Group_3__2
            {
            pushFollow(FOLLOW_4);
            rule__TrustZone__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3__1"


    // $ANTLR start "rule__TrustZone__Group_3__1__Impl"
    // InternalMyDsl.g:1665:1: rule__TrustZone__Group_3__1__Impl : ( 'profiles:' ) ;
    public final void rule__TrustZone__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1669:1: ( ( 'profiles:' ) )
            // InternalMyDsl.g:1670:1: ( 'profiles:' )
            {
            // InternalMyDsl.g:1670:1: ( 'profiles:' )
            // InternalMyDsl.g:1671:2: 'profiles:'
            {
             before(grammarAccess.getTrustZoneAccess().getProfilesKeyword_3_1()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getTrustZoneAccess().getProfilesKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3__1__Impl"


    // $ANTLR start "rule__TrustZone__Group_3__2"
    // InternalMyDsl.g:1680:1: rule__TrustZone__Group_3__2 : rule__TrustZone__Group_3__2__Impl rule__TrustZone__Group_3__3 ;
    public final void rule__TrustZone__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1684:1: ( rule__TrustZone__Group_3__2__Impl rule__TrustZone__Group_3__3 )
            // InternalMyDsl.g:1685:2: rule__TrustZone__Group_3__2__Impl rule__TrustZone__Group_3__3
            {
            pushFollow(FOLLOW_8);
            rule__TrustZone__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3__2"


    // $ANTLR start "rule__TrustZone__Group_3__2__Impl"
    // InternalMyDsl.g:1692:1: rule__TrustZone__Group_3__2__Impl : ( ( rule__TrustZone__AttackerprofileAssignment_3_2 ) ) ;
    public final void rule__TrustZone__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1696:1: ( ( ( rule__TrustZone__AttackerprofileAssignment_3_2 ) ) )
            // InternalMyDsl.g:1697:1: ( ( rule__TrustZone__AttackerprofileAssignment_3_2 ) )
            {
            // InternalMyDsl.g:1697:1: ( ( rule__TrustZone__AttackerprofileAssignment_3_2 ) )
            // InternalMyDsl.g:1698:2: ( rule__TrustZone__AttackerprofileAssignment_3_2 )
            {
             before(grammarAccess.getTrustZoneAccess().getAttackerprofileAssignment_3_2()); 
            // InternalMyDsl.g:1699:2: ( rule__TrustZone__AttackerprofileAssignment_3_2 )
            // InternalMyDsl.g:1699:3: rule__TrustZone__AttackerprofileAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__AttackerprofileAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getTrustZoneAccess().getAttackerprofileAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3__2__Impl"


    // $ANTLR start "rule__TrustZone__Group_3__3"
    // InternalMyDsl.g:1707:1: rule__TrustZone__Group_3__3 : rule__TrustZone__Group_3__3__Impl ;
    public final void rule__TrustZone__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1711:1: ( rule__TrustZone__Group_3__3__Impl )
            // InternalMyDsl.g:1712:2: rule__TrustZone__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3__3"


    // $ANTLR start "rule__TrustZone__Group_3__3__Impl"
    // InternalMyDsl.g:1718:1: rule__TrustZone__Group_3__3__Impl : ( ( rule__TrustZone__Group_3_3__0 )* ) ;
    public final void rule__TrustZone__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1722:1: ( ( ( rule__TrustZone__Group_3_3__0 )* ) )
            // InternalMyDsl.g:1723:1: ( ( rule__TrustZone__Group_3_3__0 )* )
            {
            // InternalMyDsl.g:1723:1: ( ( rule__TrustZone__Group_3_3__0 )* )
            // InternalMyDsl.g:1724:2: ( rule__TrustZone__Group_3_3__0 )*
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_3_3()); 
            // InternalMyDsl.g:1725:2: ( rule__TrustZone__Group_3_3__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==43) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMyDsl.g:1725:3: rule__TrustZone__Group_3_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TrustZone__Group_3_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getTrustZoneAccess().getGroup_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3__3__Impl"


    // $ANTLR start "rule__TrustZone__Group_3_3__0"
    // InternalMyDsl.g:1734:1: rule__TrustZone__Group_3_3__0 : rule__TrustZone__Group_3_3__0__Impl rule__TrustZone__Group_3_3__1 ;
    public final void rule__TrustZone__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1738:1: ( rule__TrustZone__Group_3_3__0__Impl rule__TrustZone__Group_3_3__1 )
            // InternalMyDsl.g:1739:2: rule__TrustZone__Group_3_3__0__Impl rule__TrustZone__Group_3_3__1
            {
            pushFollow(FOLLOW_4);
            rule__TrustZone__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_3_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3_3__0"


    // $ANTLR start "rule__TrustZone__Group_3_3__0__Impl"
    // InternalMyDsl.g:1746:1: rule__TrustZone__Group_3_3__0__Impl : ( ',' ) ;
    public final void rule__TrustZone__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1750:1: ( ( ',' ) )
            // InternalMyDsl.g:1751:1: ( ',' )
            {
            // InternalMyDsl.g:1751:1: ( ',' )
            // InternalMyDsl.g:1752:2: ','
            {
             before(grammarAccess.getTrustZoneAccess().getCommaKeyword_3_3_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getTrustZoneAccess().getCommaKeyword_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3_3__0__Impl"


    // $ANTLR start "rule__TrustZone__Group_3_3__1"
    // InternalMyDsl.g:1761:1: rule__TrustZone__Group_3_3__1 : rule__TrustZone__Group_3_3__1__Impl ;
    public final void rule__TrustZone__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1765:1: ( rule__TrustZone__Group_3_3__1__Impl )
            // InternalMyDsl.g:1766:2: rule__TrustZone__Group_3_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_3_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3_3__1"


    // $ANTLR start "rule__TrustZone__Group_3_3__1__Impl"
    // InternalMyDsl.g:1772:1: rule__TrustZone__Group_3_3__1__Impl : ( ( rule__TrustZone__AttackerprofileAssignment_3_3_1 ) ) ;
    public final void rule__TrustZone__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1776:1: ( ( ( rule__TrustZone__AttackerprofileAssignment_3_3_1 ) ) )
            // InternalMyDsl.g:1777:1: ( ( rule__TrustZone__AttackerprofileAssignment_3_3_1 ) )
            {
            // InternalMyDsl.g:1777:1: ( ( rule__TrustZone__AttackerprofileAssignment_3_3_1 ) )
            // InternalMyDsl.g:1778:2: ( rule__TrustZone__AttackerprofileAssignment_3_3_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getAttackerprofileAssignment_3_3_1()); 
            // InternalMyDsl.g:1779:2: ( rule__TrustZone__AttackerprofileAssignment_3_3_1 )
            // InternalMyDsl.g:1779:3: rule__TrustZone__AttackerprofileAssignment_3_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__AttackerprofileAssignment_3_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTrustZoneAccess().getAttackerprofileAssignment_3_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_3_3__1__Impl"


    // $ANTLR start "rule__TrustZone__Group_4__0"
    // InternalMyDsl.g:1788:1: rule__TrustZone__Group_4__0 : rule__TrustZone__Group_4__0__Impl rule__TrustZone__Group_4__1 ;
    public final void rule__TrustZone__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1792:1: ( rule__TrustZone__Group_4__0__Impl rule__TrustZone__Group_4__1 )
            // InternalMyDsl.g:1793:2: rule__TrustZone__Group_4__0__Impl rule__TrustZone__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__TrustZone__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4__0"


    // $ANTLR start "rule__TrustZone__Group_4__0__Impl"
    // InternalMyDsl.g:1800:1: rule__TrustZone__Group_4__0__Impl : ( 'elements:' ) ;
    public final void rule__TrustZone__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1804:1: ( ( 'elements:' ) )
            // InternalMyDsl.g:1805:1: ( 'elements:' )
            {
            // InternalMyDsl.g:1805:1: ( 'elements:' )
            // InternalMyDsl.g:1806:2: 'elements:'
            {
             before(grammarAccess.getTrustZoneAccess().getElementsKeyword_4_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getTrustZoneAccess().getElementsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4__0__Impl"


    // $ANTLR start "rule__TrustZone__Group_4__1"
    // InternalMyDsl.g:1815:1: rule__TrustZone__Group_4__1 : rule__TrustZone__Group_4__1__Impl rule__TrustZone__Group_4__2 ;
    public final void rule__TrustZone__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1819:1: ( rule__TrustZone__Group_4__1__Impl rule__TrustZone__Group_4__2 )
            // InternalMyDsl.g:1820:2: rule__TrustZone__Group_4__1__Impl rule__TrustZone__Group_4__2
            {
            pushFollow(FOLLOW_8);
            rule__TrustZone__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4__1"


    // $ANTLR start "rule__TrustZone__Group_4__1__Impl"
    // InternalMyDsl.g:1827:1: rule__TrustZone__Group_4__1__Impl : ( ( rule__TrustZone__ElementsAssignment_4_1 ) ) ;
    public final void rule__TrustZone__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1831:1: ( ( ( rule__TrustZone__ElementsAssignment_4_1 ) ) )
            // InternalMyDsl.g:1832:1: ( ( rule__TrustZone__ElementsAssignment_4_1 ) )
            {
            // InternalMyDsl.g:1832:1: ( ( rule__TrustZone__ElementsAssignment_4_1 ) )
            // InternalMyDsl.g:1833:2: ( rule__TrustZone__ElementsAssignment_4_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getElementsAssignment_4_1()); 
            // InternalMyDsl.g:1834:2: ( rule__TrustZone__ElementsAssignment_4_1 )
            // InternalMyDsl.g:1834:3: rule__TrustZone__ElementsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__ElementsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTrustZoneAccess().getElementsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4__1__Impl"


    // $ANTLR start "rule__TrustZone__Group_4__2"
    // InternalMyDsl.g:1842:1: rule__TrustZone__Group_4__2 : rule__TrustZone__Group_4__2__Impl ;
    public final void rule__TrustZone__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1846:1: ( rule__TrustZone__Group_4__2__Impl )
            // InternalMyDsl.g:1847:2: rule__TrustZone__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4__2"


    // $ANTLR start "rule__TrustZone__Group_4__2__Impl"
    // InternalMyDsl.g:1853:1: rule__TrustZone__Group_4__2__Impl : ( ( rule__TrustZone__Group_4_2__0 )* ) ;
    public final void rule__TrustZone__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1857:1: ( ( ( rule__TrustZone__Group_4_2__0 )* ) )
            // InternalMyDsl.g:1858:1: ( ( rule__TrustZone__Group_4_2__0 )* )
            {
            // InternalMyDsl.g:1858:1: ( ( rule__TrustZone__Group_4_2__0 )* )
            // InternalMyDsl.g:1859:2: ( rule__TrustZone__Group_4_2__0 )*
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_4_2()); 
            // InternalMyDsl.g:1860:2: ( rule__TrustZone__Group_4_2__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==43) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalMyDsl.g:1860:3: rule__TrustZone__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TrustZone__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getTrustZoneAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4__2__Impl"


    // $ANTLR start "rule__TrustZone__Group_4_2__0"
    // InternalMyDsl.g:1869:1: rule__TrustZone__Group_4_2__0 : rule__TrustZone__Group_4_2__0__Impl rule__TrustZone__Group_4_2__1 ;
    public final void rule__TrustZone__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1873:1: ( rule__TrustZone__Group_4_2__0__Impl rule__TrustZone__Group_4_2__1 )
            // InternalMyDsl.g:1874:2: rule__TrustZone__Group_4_2__0__Impl rule__TrustZone__Group_4_2__1
            {
            pushFollow(FOLLOW_4);
            rule__TrustZone__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4_2__0"


    // $ANTLR start "rule__TrustZone__Group_4_2__0__Impl"
    // InternalMyDsl.g:1881:1: rule__TrustZone__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__TrustZone__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1885:1: ( ( ',' ) )
            // InternalMyDsl.g:1886:1: ( ',' )
            {
            // InternalMyDsl.g:1886:1: ( ',' )
            // InternalMyDsl.g:1887:2: ','
            {
             before(grammarAccess.getTrustZoneAccess().getCommaKeyword_4_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getTrustZoneAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4_2__0__Impl"


    // $ANTLR start "rule__TrustZone__Group_4_2__1"
    // InternalMyDsl.g:1896:1: rule__TrustZone__Group_4_2__1 : rule__TrustZone__Group_4_2__1__Impl ;
    public final void rule__TrustZone__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1900:1: ( rule__TrustZone__Group_4_2__1__Impl )
            // InternalMyDsl.g:1901:2: rule__TrustZone__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4_2__1"


    // $ANTLR start "rule__TrustZone__Group_4_2__1__Impl"
    // InternalMyDsl.g:1907:1: rule__TrustZone__Group_4_2__1__Impl : ( ( rule__TrustZone__ElementsAssignment_4_2_1 ) ) ;
    public final void rule__TrustZone__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1911:1: ( ( ( rule__TrustZone__ElementsAssignment_4_2_1 ) ) )
            // InternalMyDsl.g:1912:1: ( ( rule__TrustZone__ElementsAssignment_4_2_1 ) )
            {
            // InternalMyDsl.g:1912:1: ( ( rule__TrustZone__ElementsAssignment_4_2_1 ) )
            // InternalMyDsl.g:1913:2: ( rule__TrustZone__ElementsAssignment_4_2_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getElementsAssignment_4_2_1()); 
            // InternalMyDsl.g:1914:2: ( rule__TrustZone__ElementsAssignment_4_2_1 )
            // InternalMyDsl.g:1914:3: rule__TrustZone__ElementsAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__ElementsAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTrustZoneAccess().getElementsAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_4_2__1__Impl"


    // $ANTLR start "rule__TrustZone__Group_5__0"
    // InternalMyDsl.g:1923:1: rule__TrustZone__Group_5__0 : rule__TrustZone__Group_5__0__Impl rule__TrustZone__Group_5__1 ;
    public final void rule__TrustZone__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1927:1: ( rule__TrustZone__Group_5__0__Impl rule__TrustZone__Group_5__1 )
            // InternalMyDsl.g:1928:2: rule__TrustZone__Group_5__0__Impl rule__TrustZone__Group_5__1
            {
            pushFollow(FOLLOW_10);
            rule__TrustZone__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5__0"


    // $ANTLR start "rule__TrustZone__Group_5__0__Impl"
    // InternalMyDsl.g:1935:1: rule__TrustZone__Group_5__0__Impl : ( 'subzones:' ) ;
    public final void rule__TrustZone__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1939:1: ( ( 'subzones:' ) )
            // InternalMyDsl.g:1940:1: ( 'subzones:' )
            {
            // InternalMyDsl.g:1940:1: ( 'subzones:' )
            // InternalMyDsl.g:1941:2: 'subzones:'
            {
             before(grammarAccess.getTrustZoneAccess().getSubzonesKeyword_5_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getTrustZoneAccess().getSubzonesKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5__0__Impl"


    // $ANTLR start "rule__TrustZone__Group_5__1"
    // InternalMyDsl.g:1950:1: rule__TrustZone__Group_5__1 : rule__TrustZone__Group_5__1__Impl rule__TrustZone__Group_5__2 ;
    public final void rule__TrustZone__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1954:1: ( rule__TrustZone__Group_5__1__Impl rule__TrustZone__Group_5__2 )
            // InternalMyDsl.g:1955:2: rule__TrustZone__Group_5__1__Impl rule__TrustZone__Group_5__2
            {
            pushFollow(FOLLOW_8);
            rule__TrustZone__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5__1"


    // $ANTLR start "rule__TrustZone__Group_5__1__Impl"
    // InternalMyDsl.g:1962:1: rule__TrustZone__Group_5__1__Impl : ( ( rule__TrustZone__SubzonesAssignment_5_1 ) ) ;
    public final void rule__TrustZone__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1966:1: ( ( ( rule__TrustZone__SubzonesAssignment_5_1 ) ) )
            // InternalMyDsl.g:1967:1: ( ( rule__TrustZone__SubzonesAssignment_5_1 ) )
            {
            // InternalMyDsl.g:1967:1: ( ( rule__TrustZone__SubzonesAssignment_5_1 ) )
            // InternalMyDsl.g:1968:2: ( rule__TrustZone__SubzonesAssignment_5_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getSubzonesAssignment_5_1()); 
            // InternalMyDsl.g:1969:2: ( rule__TrustZone__SubzonesAssignment_5_1 )
            // InternalMyDsl.g:1969:3: rule__TrustZone__SubzonesAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__SubzonesAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getTrustZoneAccess().getSubzonesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5__1__Impl"


    // $ANTLR start "rule__TrustZone__Group_5__2"
    // InternalMyDsl.g:1977:1: rule__TrustZone__Group_5__2 : rule__TrustZone__Group_5__2__Impl ;
    public final void rule__TrustZone__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1981:1: ( rule__TrustZone__Group_5__2__Impl )
            // InternalMyDsl.g:1982:2: rule__TrustZone__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5__2"


    // $ANTLR start "rule__TrustZone__Group_5__2__Impl"
    // InternalMyDsl.g:1988:1: rule__TrustZone__Group_5__2__Impl : ( ( rule__TrustZone__Group_5_2__0 )* ) ;
    public final void rule__TrustZone__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1992:1: ( ( ( rule__TrustZone__Group_5_2__0 )* ) )
            // InternalMyDsl.g:1993:1: ( ( rule__TrustZone__Group_5_2__0 )* )
            {
            // InternalMyDsl.g:1993:1: ( ( rule__TrustZone__Group_5_2__0 )* )
            // InternalMyDsl.g:1994:2: ( rule__TrustZone__Group_5_2__0 )*
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_5_2()); 
            // InternalMyDsl.g:1995:2: ( rule__TrustZone__Group_5_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==43) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMyDsl.g:1995:3: rule__TrustZone__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TrustZone__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getTrustZoneAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5__2__Impl"


    // $ANTLR start "rule__TrustZone__Group_5_2__0"
    // InternalMyDsl.g:2004:1: rule__TrustZone__Group_5_2__0 : rule__TrustZone__Group_5_2__0__Impl rule__TrustZone__Group_5_2__1 ;
    public final void rule__TrustZone__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2008:1: ( rule__TrustZone__Group_5_2__0__Impl rule__TrustZone__Group_5_2__1 )
            // InternalMyDsl.g:2009:2: rule__TrustZone__Group_5_2__0__Impl rule__TrustZone__Group_5_2__1
            {
            pushFollow(FOLLOW_10);
            rule__TrustZone__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_5_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5_2__0"


    // $ANTLR start "rule__TrustZone__Group_5_2__0__Impl"
    // InternalMyDsl.g:2016:1: rule__TrustZone__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__TrustZone__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2020:1: ( ( ',' ) )
            // InternalMyDsl.g:2021:1: ( ',' )
            {
            // InternalMyDsl.g:2021:1: ( ',' )
            // InternalMyDsl.g:2022:2: ','
            {
             before(grammarAccess.getTrustZoneAccess().getCommaKeyword_5_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getTrustZoneAccess().getCommaKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5_2__0__Impl"


    // $ANTLR start "rule__TrustZone__Group_5_2__1"
    // InternalMyDsl.g:2031:1: rule__TrustZone__Group_5_2__1 : rule__TrustZone__Group_5_2__1__Impl ;
    public final void rule__TrustZone__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2035:1: ( rule__TrustZone__Group_5_2__1__Impl )
            // InternalMyDsl.g:2036:2: rule__TrustZone__Group_5_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__Group_5_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5_2__1"


    // $ANTLR start "rule__TrustZone__Group_5_2__1__Impl"
    // InternalMyDsl.g:2042:1: rule__TrustZone__Group_5_2__1__Impl : ( ( rule__TrustZone__SubzonesAssignment_5_2_1 ) ) ;
    public final void rule__TrustZone__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2046:1: ( ( ( rule__TrustZone__SubzonesAssignment_5_2_1 ) ) )
            // InternalMyDsl.g:2047:1: ( ( rule__TrustZone__SubzonesAssignment_5_2_1 ) )
            {
            // InternalMyDsl.g:2047:1: ( ( rule__TrustZone__SubzonesAssignment_5_2_1 ) )
            // InternalMyDsl.g:2048:2: ( rule__TrustZone__SubzonesAssignment_5_2_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getSubzonesAssignment_5_2_1()); 
            // InternalMyDsl.g:2049:2: ( rule__TrustZone__SubzonesAssignment_5_2_1 )
            // InternalMyDsl.g:2049:3: rule__TrustZone__SubzonesAssignment_5_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TrustZone__SubzonesAssignment_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTrustZoneAccess().getSubzonesAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__Group_5_2__1__Impl"


    // $ANTLR start "rule__AttackerProfile__Group__0"
    // InternalMyDsl.g:2058:1: rule__AttackerProfile__Group__0 : rule__AttackerProfile__Group__0__Impl rule__AttackerProfile__Group__1 ;
    public final void rule__AttackerProfile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2062:1: ( rule__AttackerProfile__Group__0__Impl rule__AttackerProfile__Group__1 )
            // InternalMyDsl.g:2063:2: rule__AttackerProfile__Group__0__Impl rule__AttackerProfile__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__AttackerProfile__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttackerProfile__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__0"


    // $ANTLR start "rule__AttackerProfile__Group__0__Impl"
    // InternalMyDsl.g:2070:1: rule__AttackerProfile__Group__0__Impl : ( () ) ;
    public final void rule__AttackerProfile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2074:1: ( ( () ) )
            // InternalMyDsl.g:2075:1: ( () )
            {
            // InternalMyDsl.g:2075:1: ( () )
            // InternalMyDsl.g:2076:2: ()
            {
             before(grammarAccess.getAttackerProfileAccess().getAttackerProfileAction_0()); 
            // InternalMyDsl.g:2077:2: ()
            // InternalMyDsl.g:2077:3: 
            {
            }

             after(grammarAccess.getAttackerProfileAccess().getAttackerProfileAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__0__Impl"


    // $ANTLR start "rule__AttackerProfile__Group__1"
    // InternalMyDsl.g:2085:1: rule__AttackerProfile__Group__1 : rule__AttackerProfile__Group__1__Impl rule__AttackerProfile__Group__2 ;
    public final void rule__AttackerProfile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2089:1: ( rule__AttackerProfile__Group__1__Impl rule__AttackerProfile__Group__2 )
            // InternalMyDsl.g:2090:2: rule__AttackerProfile__Group__1__Impl rule__AttackerProfile__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__AttackerProfile__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttackerProfile__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__1"


    // $ANTLR start "rule__AttackerProfile__Group__1__Impl"
    // InternalMyDsl.g:2097:1: rule__AttackerProfile__Group__1__Impl : ( ( rule__AttackerProfile__NameAssignment_1 ) ) ;
    public final void rule__AttackerProfile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2101:1: ( ( ( rule__AttackerProfile__NameAssignment_1 ) ) )
            // InternalMyDsl.g:2102:1: ( ( rule__AttackerProfile__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:2102:1: ( ( rule__AttackerProfile__NameAssignment_1 ) )
            // InternalMyDsl.g:2103:2: ( rule__AttackerProfile__NameAssignment_1 )
            {
             before(grammarAccess.getAttackerProfileAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:2104:2: ( rule__AttackerProfile__NameAssignment_1 )
            // InternalMyDsl.g:2104:3: rule__AttackerProfile__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AttackerProfile__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttackerProfileAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__1__Impl"


    // $ANTLR start "rule__AttackerProfile__Group__2"
    // InternalMyDsl.g:2112:1: rule__AttackerProfile__Group__2 : rule__AttackerProfile__Group__2__Impl rule__AttackerProfile__Group__3 ;
    public final void rule__AttackerProfile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2116:1: ( rule__AttackerProfile__Group__2__Impl rule__AttackerProfile__Group__3 )
            // InternalMyDsl.g:2117:2: rule__AttackerProfile__Group__2__Impl rule__AttackerProfile__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__AttackerProfile__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttackerProfile__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__2"


    // $ANTLR start "rule__AttackerProfile__Group__2__Impl"
    // InternalMyDsl.g:2124:1: rule__AttackerProfile__Group__2__Impl : ( '[' ) ;
    public final void rule__AttackerProfile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2128:1: ( ( '[' ) )
            // InternalMyDsl.g:2129:1: ( '[' )
            {
            // InternalMyDsl.g:2129:1: ( '[' )
            // InternalMyDsl.g:2130:2: '['
            {
             before(grammarAccess.getAttackerProfileAccess().getLeftSquareBracketKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getAttackerProfileAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__2__Impl"


    // $ANTLR start "rule__AttackerProfile__Group__3"
    // InternalMyDsl.g:2139:1: rule__AttackerProfile__Group__3 : rule__AttackerProfile__Group__3__Impl rule__AttackerProfile__Group__4 ;
    public final void rule__AttackerProfile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2143:1: ( rule__AttackerProfile__Group__3__Impl rule__AttackerProfile__Group__4 )
            // InternalMyDsl.g:2144:2: rule__AttackerProfile__Group__3__Impl rule__AttackerProfile__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__AttackerProfile__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttackerProfile__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__3"


    // $ANTLR start "rule__AttackerProfile__Group__3__Impl"
    // InternalMyDsl.g:2151:1: rule__AttackerProfile__Group__3__Impl : ( ( rule__AttackerProfile__Group_3__0 )? ) ;
    public final void rule__AttackerProfile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2155:1: ( ( ( rule__AttackerProfile__Group_3__0 )? ) )
            // InternalMyDsl.g:2156:1: ( ( rule__AttackerProfile__Group_3__0 )? )
            {
            // InternalMyDsl.g:2156:1: ( ( rule__AttackerProfile__Group_3__0 )? )
            // InternalMyDsl.g:2157:2: ( rule__AttackerProfile__Group_3__0 )?
            {
             before(grammarAccess.getAttackerProfileAccess().getGroup_3()); 
            // InternalMyDsl.g:2158:2: ( rule__AttackerProfile__Group_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==50) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:2158:3: rule__AttackerProfile__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttackerProfile__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttackerProfileAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__3__Impl"


    // $ANTLR start "rule__AttackerProfile__Group__4"
    // InternalMyDsl.g:2166:1: rule__AttackerProfile__Group__4 : rule__AttackerProfile__Group__4__Impl ;
    public final void rule__AttackerProfile__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2170:1: ( rule__AttackerProfile__Group__4__Impl )
            // InternalMyDsl.g:2171:2: rule__AttackerProfile__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttackerProfile__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__4"


    // $ANTLR start "rule__AttackerProfile__Group__4__Impl"
    // InternalMyDsl.g:2177:1: rule__AttackerProfile__Group__4__Impl : ( ']' ) ;
    public final void rule__AttackerProfile__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2181:1: ( ( ']' ) )
            // InternalMyDsl.g:2182:1: ( ']' )
            {
            // InternalMyDsl.g:2182:1: ( ']' )
            // InternalMyDsl.g:2183:2: ']'
            {
             before(grammarAccess.getAttackerProfileAccess().getRightSquareBracketKeyword_4()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getAttackerProfileAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group__4__Impl"


    // $ANTLR start "rule__AttackerProfile__Group_3__0"
    // InternalMyDsl.g:2193:1: rule__AttackerProfile__Group_3__0 : rule__AttackerProfile__Group_3__0__Impl rule__AttackerProfile__Group_3__1 ;
    public final void rule__AttackerProfile__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2197:1: ( rule__AttackerProfile__Group_3__0__Impl rule__AttackerProfile__Group_3__1 )
            // InternalMyDsl.g:2198:2: rule__AttackerProfile__Group_3__0__Impl rule__AttackerProfile__Group_3__1
            {
            pushFollow(FOLLOW_15);
            rule__AttackerProfile__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttackerProfile__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group_3__0"


    // $ANTLR start "rule__AttackerProfile__Group_3__0__Impl"
    // InternalMyDsl.g:2205:1: rule__AttackerProfile__Group_3__0__Impl : ( 'observation:' ) ;
    public final void rule__AttackerProfile__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2209:1: ( ( 'observation:' ) )
            // InternalMyDsl.g:2210:1: ( 'observation:' )
            {
            // InternalMyDsl.g:2210:1: ( 'observation:' )
            // InternalMyDsl.g:2211:2: 'observation:'
            {
             before(grammarAccess.getAttackerProfileAccess().getObservationKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getAttackerProfileAccess().getObservationKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group_3__0__Impl"


    // $ANTLR start "rule__AttackerProfile__Group_3__1"
    // InternalMyDsl.g:2220:1: rule__AttackerProfile__Group_3__1 : rule__AttackerProfile__Group_3__1__Impl ;
    public final void rule__AttackerProfile__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2224:1: ( rule__AttackerProfile__Group_3__1__Impl )
            // InternalMyDsl.g:2225:2: rule__AttackerProfile__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttackerProfile__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group_3__1"


    // $ANTLR start "rule__AttackerProfile__Group_3__1__Impl"
    // InternalMyDsl.g:2231:1: rule__AttackerProfile__Group_3__1__Impl : ( ( rule__AttackerProfile__ObservationAssignment_3_1 ) ) ;
    public final void rule__AttackerProfile__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2235:1: ( ( ( rule__AttackerProfile__ObservationAssignment_3_1 ) ) )
            // InternalMyDsl.g:2236:1: ( ( rule__AttackerProfile__ObservationAssignment_3_1 ) )
            {
            // InternalMyDsl.g:2236:1: ( ( rule__AttackerProfile__ObservationAssignment_3_1 ) )
            // InternalMyDsl.g:2237:2: ( rule__AttackerProfile__ObservationAssignment_3_1 )
            {
             before(grammarAccess.getAttackerProfileAccess().getObservationAssignment_3_1()); 
            // InternalMyDsl.g:2238:2: ( rule__AttackerProfile__ObservationAssignment_3_1 )
            // InternalMyDsl.g:2238:3: rule__AttackerProfile__ObservationAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__AttackerProfile__ObservationAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getAttackerProfileAccess().getObservationAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__Group_3__1__Impl"


    // $ANTLR start "rule__Asset__Group__0"
    // InternalMyDsl.g:2247:1: rule__Asset__Group__0 : rule__Asset__Group__0__Impl rule__Asset__Group__1 ;
    public final void rule__Asset__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2251:1: ( rule__Asset__Group__0__Impl rule__Asset__Group__1 )
            // InternalMyDsl.g:2252:2: rule__Asset__Group__0__Impl rule__Asset__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Asset__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__0"


    // $ANTLR start "rule__Asset__Group__0__Impl"
    // InternalMyDsl.g:2259:1: rule__Asset__Group__0__Impl : ( () ) ;
    public final void rule__Asset__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2263:1: ( ( () ) )
            // InternalMyDsl.g:2264:1: ( () )
            {
            // InternalMyDsl.g:2264:1: ( () )
            // InternalMyDsl.g:2265:2: ()
            {
             before(grammarAccess.getAssetAccess().getAssetAction_0()); 
            // InternalMyDsl.g:2266:2: ()
            // InternalMyDsl.g:2266:3: 
            {
            }

             after(grammarAccess.getAssetAccess().getAssetAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__0__Impl"


    // $ANTLR start "rule__Asset__Group__1"
    // InternalMyDsl.g:2274:1: rule__Asset__Group__1 : rule__Asset__Group__1__Impl rule__Asset__Group__2 ;
    public final void rule__Asset__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2278:1: ( rule__Asset__Group__1__Impl rule__Asset__Group__2 )
            // InternalMyDsl.g:2279:2: rule__Asset__Group__1__Impl rule__Asset__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Asset__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__1"


    // $ANTLR start "rule__Asset__Group__1__Impl"
    // InternalMyDsl.g:2286:1: rule__Asset__Group__1__Impl : ( 'Asset' ) ;
    public final void rule__Asset__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2290:1: ( ( 'Asset' ) )
            // InternalMyDsl.g:2291:1: ( 'Asset' )
            {
            // InternalMyDsl.g:2291:1: ( 'Asset' )
            // InternalMyDsl.g:2292:2: 'Asset'
            {
             before(grammarAccess.getAssetAccess().getAssetKeyword_1()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getAssetKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__1__Impl"


    // $ANTLR start "rule__Asset__Group__2"
    // InternalMyDsl.g:2301:1: rule__Asset__Group__2 : rule__Asset__Group__2__Impl rule__Asset__Group__3 ;
    public final void rule__Asset__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2305:1: ( rule__Asset__Group__2__Impl rule__Asset__Group__3 )
            // InternalMyDsl.g:2306:2: rule__Asset__Group__2__Impl rule__Asset__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__Asset__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__2"


    // $ANTLR start "rule__Asset__Group__2__Impl"
    // InternalMyDsl.g:2313:1: rule__Asset__Group__2__Impl : ( ( rule__Asset__NameAssignment_2 ) ) ;
    public final void rule__Asset__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2317:1: ( ( ( rule__Asset__NameAssignment_2 ) ) )
            // InternalMyDsl.g:2318:1: ( ( rule__Asset__NameAssignment_2 ) )
            {
            // InternalMyDsl.g:2318:1: ( ( rule__Asset__NameAssignment_2 ) )
            // InternalMyDsl.g:2319:2: ( rule__Asset__NameAssignment_2 )
            {
             before(grammarAccess.getAssetAccess().getNameAssignment_2()); 
            // InternalMyDsl.g:2320:2: ( rule__Asset__NameAssignment_2 )
            // InternalMyDsl.g:2320:3: rule__Asset__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Asset__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__2__Impl"


    // $ANTLR start "rule__Asset__Group__3"
    // InternalMyDsl.g:2328:1: rule__Asset__Group__3 : rule__Asset__Group__3__Impl rule__Asset__Group__4 ;
    public final void rule__Asset__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2332:1: ( rule__Asset__Group__3__Impl rule__Asset__Group__4 )
            // InternalMyDsl.g:2333:2: rule__Asset__Group__3__Impl rule__Asset__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__Asset__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__3"


    // $ANTLR start "rule__Asset__Group__3__Impl"
    // InternalMyDsl.g:2340:1: rule__Asset__Group__3__Impl : ( ( rule__Asset__Group_3__0 )? ) ;
    public final void rule__Asset__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2344:1: ( ( ( rule__Asset__Group_3__0 )? ) )
            // InternalMyDsl.g:2345:1: ( ( rule__Asset__Group_3__0 )? )
            {
            // InternalMyDsl.g:2345:1: ( ( rule__Asset__Group_3__0 )? )
            // InternalMyDsl.g:2346:2: ( rule__Asset__Group_3__0 )?
            {
             before(grammarAccess.getAssetAccess().getGroup_3()); 
            // InternalMyDsl.g:2347:2: ( rule__Asset__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==54) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:2347:3: rule__Asset__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Asset__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssetAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__3__Impl"


    // $ANTLR start "rule__Asset__Group__4"
    // InternalMyDsl.g:2355:1: rule__Asset__Group__4 : rule__Asset__Group__4__Impl rule__Asset__Group__5 ;
    public final void rule__Asset__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2359:1: ( rule__Asset__Group__4__Impl rule__Asset__Group__5 )
            // InternalMyDsl.g:2360:2: rule__Asset__Group__4__Impl rule__Asset__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__Asset__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__4"


    // $ANTLR start "rule__Asset__Group__4__Impl"
    // InternalMyDsl.g:2367:1: rule__Asset__Group__4__Impl : ( 'source:' ) ;
    public final void rule__Asset__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2371:1: ( ( 'source:' ) )
            // InternalMyDsl.g:2372:1: ( 'source:' )
            {
            // InternalMyDsl.g:2372:1: ( 'source:' )
            // InternalMyDsl.g:2373:2: 'source:'
            {
             before(grammarAccess.getAssetAccess().getSourceKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getSourceKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__4__Impl"


    // $ANTLR start "rule__Asset__Group__5"
    // InternalMyDsl.g:2382:1: rule__Asset__Group__5 : rule__Asset__Group__5__Impl rule__Asset__Group__6 ;
    public final void rule__Asset__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2386:1: ( rule__Asset__Group__5__Impl rule__Asset__Group__6 )
            // InternalMyDsl.g:2387:2: rule__Asset__Group__5__Impl rule__Asset__Group__6
            {
            pushFollow(FOLLOW_17);
            rule__Asset__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__5"


    // $ANTLR start "rule__Asset__Group__5__Impl"
    // InternalMyDsl.g:2394:1: rule__Asset__Group__5__Impl : ( ( rule__Asset__SourceAssignment_5 ) ) ;
    public final void rule__Asset__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2398:1: ( ( ( rule__Asset__SourceAssignment_5 ) ) )
            // InternalMyDsl.g:2399:1: ( ( rule__Asset__SourceAssignment_5 ) )
            {
            // InternalMyDsl.g:2399:1: ( ( rule__Asset__SourceAssignment_5 ) )
            // InternalMyDsl.g:2400:2: ( rule__Asset__SourceAssignment_5 )
            {
             before(grammarAccess.getAssetAccess().getSourceAssignment_5()); 
            // InternalMyDsl.g:2401:2: ( rule__Asset__SourceAssignment_5 )
            // InternalMyDsl.g:2401:3: rule__Asset__SourceAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Asset__SourceAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getSourceAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__5__Impl"


    // $ANTLR start "rule__Asset__Group__6"
    // InternalMyDsl.g:2409:1: rule__Asset__Group__6 : rule__Asset__Group__6__Impl rule__Asset__Group__7 ;
    public final void rule__Asset__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2413:1: ( rule__Asset__Group__6__Impl rule__Asset__Group__7 )
            // InternalMyDsl.g:2414:2: rule__Asset__Group__6__Impl rule__Asset__Group__7
            {
            pushFollow(FOLLOW_4);
            rule__Asset__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__6"


    // $ANTLR start "rule__Asset__Group__6__Impl"
    // InternalMyDsl.g:2421:1: rule__Asset__Group__6__Impl : ( 'targets:' ) ;
    public final void rule__Asset__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2425:1: ( ( 'targets:' ) )
            // InternalMyDsl.g:2426:1: ( 'targets:' )
            {
            // InternalMyDsl.g:2426:1: ( 'targets:' )
            // InternalMyDsl.g:2427:2: 'targets:'
            {
             before(grammarAccess.getAssetAccess().getTargetsKeyword_6()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getTargetsKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__6__Impl"


    // $ANTLR start "rule__Asset__Group__7"
    // InternalMyDsl.g:2436:1: rule__Asset__Group__7 : rule__Asset__Group__7__Impl rule__Asset__Group__8 ;
    public final void rule__Asset__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2440:1: ( rule__Asset__Group__7__Impl rule__Asset__Group__8 )
            // InternalMyDsl.g:2441:2: rule__Asset__Group__7__Impl rule__Asset__Group__8
            {
            pushFollow(FOLLOW_8);
            rule__Asset__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__7"


    // $ANTLR start "rule__Asset__Group__7__Impl"
    // InternalMyDsl.g:2448:1: rule__Asset__Group__7__Impl : ( ( rule__Asset__TargetsAssignment_7 ) ) ;
    public final void rule__Asset__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2452:1: ( ( ( rule__Asset__TargetsAssignment_7 ) ) )
            // InternalMyDsl.g:2453:1: ( ( rule__Asset__TargetsAssignment_7 ) )
            {
            // InternalMyDsl.g:2453:1: ( ( rule__Asset__TargetsAssignment_7 ) )
            // InternalMyDsl.g:2454:2: ( rule__Asset__TargetsAssignment_7 )
            {
             before(grammarAccess.getAssetAccess().getTargetsAssignment_7()); 
            // InternalMyDsl.g:2455:2: ( rule__Asset__TargetsAssignment_7 )
            // InternalMyDsl.g:2455:3: rule__Asset__TargetsAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Asset__TargetsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getTargetsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__7__Impl"


    // $ANTLR start "rule__Asset__Group__8"
    // InternalMyDsl.g:2463:1: rule__Asset__Group__8 : rule__Asset__Group__8__Impl ;
    public final void rule__Asset__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2467:1: ( rule__Asset__Group__8__Impl )
            // InternalMyDsl.g:2468:2: rule__Asset__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Asset__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__8"


    // $ANTLR start "rule__Asset__Group__8__Impl"
    // InternalMyDsl.g:2474:1: rule__Asset__Group__8__Impl : ( ( rule__Asset__Group_8__0 )* ) ;
    public final void rule__Asset__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2478:1: ( ( ( rule__Asset__Group_8__0 )* ) )
            // InternalMyDsl.g:2479:1: ( ( rule__Asset__Group_8__0 )* )
            {
            // InternalMyDsl.g:2479:1: ( ( rule__Asset__Group_8__0 )* )
            // InternalMyDsl.g:2480:2: ( rule__Asset__Group_8__0 )*
            {
             before(grammarAccess.getAssetAccess().getGroup_8()); 
            // InternalMyDsl.g:2481:2: ( rule__Asset__Group_8__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==43) ) {
                    int LA23_2 = input.LA(2);

                    if ( ((LA23_2>=RULE_STRING && LA23_2<=RULE_ID)) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // InternalMyDsl.g:2481:3: rule__Asset__Group_8__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Asset__Group_8__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getAssetAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__8__Impl"


    // $ANTLR start "rule__Asset__Group_3__0"
    // InternalMyDsl.g:2490:1: rule__Asset__Group_3__0 : rule__Asset__Group_3__0__Impl rule__Asset__Group_3__1 ;
    public final void rule__Asset__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2494:1: ( rule__Asset__Group_3__0__Impl rule__Asset__Group_3__1 )
            // InternalMyDsl.g:2495:2: rule__Asset__Group_3__0__Impl rule__Asset__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Asset__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3__0"


    // $ANTLR start "rule__Asset__Group_3__0__Impl"
    // InternalMyDsl.g:2502:1: rule__Asset__Group_3__0__Impl : ( 'values:' ) ;
    public final void rule__Asset__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2506:1: ( ( 'values:' ) )
            // InternalMyDsl.g:2507:1: ( 'values:' )
            {
            // InternalMyDsl.g:2507:1: ( 'values:' )
            // InternalMyDsl.g:2508:2: 'values:'
            {
             before(grammarAccess.getAssetAccess().getValuesKeyword_3_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getValuesKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3__0__Impl"


    // $ANTLR start "rule__Asset__Group_3__1"
    // InternalMyDsl.g:2517:1: rule__Asset__Group_3__1 : rule__Asset__Group_3__1__Impl rule__Asset__Group_3__2 ;
    public final void rule__Asset__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2521:1: ( rule__Asset__Group_3__1__Impl rule__Asset__Group_3__2 )
            // InternalMyDsl.g:2522:2: rule__Asset__Group_3__1__Impl rule__Asset__Group_3__2
            {
            pushFollow(FOLLOW_8);
            rule__Asset__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3__1"


    // $ANTLR start "rule__Asset__Group_3__1__Impl"
    // InternalMyDsl.g:2529:1: rule__Asset__Group_3__1__Impl : ( ( rule__Asset__ValueAssignment_3_1 ) ) ;
    public final void rule__Asset__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2533:1: ( ( ( rule__Asset__ValueAssignment_3_1 ) ) )
            // InternalMyDsl.g:2534:1: ( ( rule__Asset__ValueAssignment_3_1 ) )
            {
            // InternalMyDsl.g:2534:1: ( ( rule__Asset__ValueAssignment_3_1 ) )
            // InternalMyDsl.g:2535:2: ( rule__Asset__ValueAssignment_3_1 )
            {
             before(grammarAccess.getAssetAccess().getValueAssignment_3_1()); 
            // InternalMyDsl.g:2536:2: ( rule__Asset__ValueAssignment_3_1 )
            // InternalMyDsl.g:2536:3: rule__Asset__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Asset__ValueAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getValueAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3__1__Impl"


    // $ANTLR start "rule__Asset__Group_3__2"
    // InternalMyDsl.g:2544:1: rule__Asset__Group_3__2 : rule__Asset__Group_3__2__Impl ;
    public final void rule__Asset__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2548:1: ( rule__Asset__Group_3__2__Impl )
            // InternalMyDsl.g:2549:2: rule__Asset__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Asset__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3__2"


    // $ANTLR start "rule__Asset__Group_3__2__Impl"
    // InternalMyDsl.g:2555:1: rule__Asset__Group_3__2__Impl : ( ( rule__Asset__Group_3_2__0 )* ) ;
    public final void rule__Asset__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2559:1: ( ( ( rule__Asset__Group_3_2__0 )* ) )
            // InternalMyDsl.g:2560:1: ( ( rule__Asset__Group_3_2__0 )* )
            {
            // InternalMyDsl.g:2560:1: ( ( rule__Asset__Group_3_2__0 )* )
            // InternalMyDsl.g:2561:2: ( rule__Asset__Group_3_2__0 )*
            {
             before(grammarAccess.getAssetAccess().getGroup_3_2()); 
            // InternalMyDsl.g:2562:2: ( rule__Asset__Group_3_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==43) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalMyDsl.g:2562:3: rule__Asset__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Asset__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getAssetAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3__2__Impl"


    // $ANTLR start "rule__Asset__Group_3_2__0"
    // InternalMyDsl.g:2571:1: rule__Asset__Group_3_2__0 : rule__Asset__Group_3_2__0__Impl rule__Asset__Group_3_2__1 ;
    public final void rule__Asset__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2575:1: ( rule__Asset__Group_3_2__0__Impl rule__Asset__Group_3_2__1 )
            // InternalMyDsl.g:2576:2: rule__Asset__Group_3_2__0__Impl rule__Asset__Group_3_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Asset__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3_2__0"


    // $ANTLR start "rule__Asset__Group_3_2__0__Impl"
    // InternalMyDsl.g:2583:1: rule__Asset__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Asset__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2587:1: ( ( ',' ) )
            // InternalMyDsl.g:2588:1: ( ',' )
            {
            // InternalMyDsl.g:2588:1: ( ',' )
            // InternalMyDsl.g:2589:2: ','
            {
             before(grammarAccess.getAssetAccess().getCommaKeyword_3_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getCommaKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3_2__0__Impl"


    // $ANTLR start "rule__Asset__Group_3_2__1"
    // InternalMyDsl.g:2598:1: rule__Asset__Group_3_2__1 : rule__Asset__Group_3_2__1__Impl ;
    public final void rule__Asset__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2602:1: ( rule__Asset__Group_3_2__1__Impl )
            // InternalMyDsl.g:2603:2: rule__Asset__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Asset__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3_2__1"


    // $ANTLR start "rule__Asset__Group_3_2__1__Impl"
    // InternalMyDsl.g:2609:1: rule__Asset__Group_3_2__1__Impl : ( ( rule__Asset__ValueAssignment_3_2_1 ) ) ;
    public final void rule__Asset__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2613:1: ( ( ( rule__Asset__ValueAssignment_3_2_1 ) ) )
            // InternalMyDsl.g:2614:1: ( ( rule__Asset__ValueAssignment_3_2_1 ) )
            {
            // InternalMyDsl.g:2614:1: ( ( rule__Asset__ValueAssignment_3_2_1 ) )
            // InternalMyDsl.g:2615:2: ( rule__Asset__ValueAssignment_3_2_1 )
            {
             before(grammarAccess.getAssetAccess().getValueAssignment_3_2_1()); 
            // InternalMyDsl.g:2616:2: ( rule__Asset__ValueAssignment_3_2_1 )
            // InternalMyDsl.g:2616:3: rule__Asset__ValueAssignment_3_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Asset__ValueAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getValueAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_3_2__1__Impl"


    // $ANTLR start "rule__Asset__Group_8__0"
    // InternalMyDsl.g:2625:1: rule__Asset__Group_8__0 : rule__Asset__Group_8__0__Impl rule__Asset__Group_8__1 ;
    public final void rule__Asset__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2629:1: ( rule__Asset__Group_8__0__Impl rule__Asset__Group_8__1 )
            // InternalMyDsl.g:2630:2: rule__Asset__Group_8__0__Impl rule__Asset__Group_8__1
            {
            pushFollow(FOLLOW_4);
            rule__Asset__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_8__0"


    // $ANTLR start "rule__Asset__Group_8__0__Impl"
    // InternalMyDsl.g:2637:1: rule__Asset__Group_8__0__Impl : ( ',' ) ;
    public final void rule__Asset__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2641:1: ( ( ',' ) )
            // InternalMyDsl.g:2642:1: ( ',' )
            {
            // InternalMyDsl.g:2642:1: ( ',' )
            // InternalMyDsl.g:2643:2: ','
            {
             before(grammarAccess.getAssetAccess().getCommaKeyword_8_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getCommaKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_8__0__Impl"


    // $ANTLR start "rule__Asset__Group_8__1"
    // InternalMyDsl.g:2652:1: rule__Asset__Group_8__1 : rule__Asset__Group_8__1__Impl ;
    public final void rule__Asset__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2656:1: ( rule__Asset__Group_8__1__Impl )
            // InternalMyDsl.g:2657:2: rule__Asset__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Asset__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_8__1"


    // $ANTLR start "rule__Asset__Group_8__1__Impl"
    // InternalMyDsl.g:2663:1: rule__Asset__Group_8__1__Impl : ( ( rule__Asset__TargetsAssignment_8_1 ) ) ;
    public final void rule__Asset__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2667:1: ( ( ( rule__Asset__TargetsAssignment_8_1 ) ) )
            // InternalMyDsl.g:2668:1: ( ( rule__Asset__TargetsAssignment_8_1 ) )
            {
            // InternalMyDsl.g:2668:1: ( ( rule__Asset__TargetsAssignment_8_1 ) )
            // InternalMyDsl.g:2669:2: ( rule__Asset__TargetsAssignment_8_1 )
            {
             before(grammarAccess.getAssetAccess().getTargetsAssignment_8_1()); 
            // InternalMyDsl.g:2670:2: ( rule__Asset__TargetsAssignment_8_1 )
            // InternalMyDsl.g:2670:3: rule__Asset__TargetsAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Asset__TargetsAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getTargetsAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_8__1__Impl"


    // $ANTLR start "rule__Process__Group__0"
    // InternalMyDsl.g:2679:1: rule__Process__Group__0 : rule__Process__Group__0__Impl rule__Process__Group__1 ;
    public final void rule__Process__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2683:1: ( rule__Process__Group__0__Impl rule__Process__Group__1 )
            // InternalMyDsl.g:2684:2: rule__Process__Group__0__Impl rule__Process__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Process__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__0"


    // $ANTLR start "rule__Process__Group__0__Impl"
    // InternalMyDsl.g:2691:1: rule__Process__Group__0__Impl : ( () ) ;
    public final void rule__Process__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2695:1: ( ( () ) )
            // InternalMyDsl.g:2696:1: ( () )
            {
            // InternalMyDsl.g:2696:1: ( () )
            // InternalMyDsl.g:2697:2: ()
            {
             before(grammarAccess.getProcessAccess().getProcessAction_0()); 
            // InternalMyDsl.g:2698:2: ()
            // InternalMyDsl.g:2698:3: 
            {
            }

             after(grammarAccess.getProcessAccess().getProcessAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__0__Impl"


    // $ANTLR start "rule__Process__Group__1"
    // InternalMyDsl.g:2706:1: rule__Process__Group__1 : rule__Process__Group__1__Impl rule__Process__Group__2 ;
    public final void rule__Process__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2710:1: ( rule__Process__Group__1__Impl rule__Process__Group__2 )
            // InternalMyDsl.g:2711:2: rule__Process__Group__1__Impl rule__Process__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Process__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__1"


    // $ANTLR start "rule__Process__Group__1__Impl"
    // InternalMyDsl.g:2718:1: rule__Process__Group__1__Impl : ( 'Process' ) ;
    public final void rule__Process__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2722:1: ( ( 'Process' ) )
            // InternalMyDsl.g:2723:1: ( 'Process' )
            {
            // InternalMyDsl.g:2723:1: ( 'Process' )
            // InternalMyDsl.g:2724:2: 'Process'
            {
             before(grammarAccess.getProcessAccess().getProcessKeyword_1()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getProcessKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__1__Impl"


    // $ANTLR start "rule__Process__Group__2"
    // InternalMyDsl.g:2733:1: rule__Process__Group__2 : rule__Process__Group__2__Impl rule__Process__Group__3 ;
    public final void rule__Process__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2737:1: ( rule__Process__Group__2__Impl rule__Process__Group__3 )
            // InternalMyDsl.g:2738:2: rule__Process__Group__2__Impl rule__Process__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__2"


    // $ANTLR start "rule__Process__Group__2__Impl"
    // InternalMyDsl.g:2745:1: rule__Process__Group__2__Impl : ( ( rule__Process__NameAssignment_2 ) ) ;
    public final void rule__Process__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2749:1: ( ( ( rule__Process__NameAssignment_2 ) ) )
            // InternalMyDsl.g:2750:1: ( ( rule__Process__NameAssignment_2 ) )
            {
            // InternalMyDsl.g:2750:1: ( ( rule__Process__NameAssignment_2 ) )
            // InternalMyDsl.g:2751:2: ( rule__Process__NameAssignment_2 )
            {
             before(grammarAccess.getProcessAccess().getNameAssignment_2()); 
            // InternalMyDsl.g:2752:2: ( rule__Process__NameAssignment_2 )
            // InternalMyDsl.g:2752:3: rule__Process__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Process__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__2__Impl"


    // $ANTLR start "rule__Process__Group__3"
    // InternalMyDsl.g:2760:1: rule__Process__Group__3 : rule__Process__Group__3__Impl rule__Process__Group__4 ;
    public final void rule__Process__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2764:1: ( rule__Process__Group__3__Impl rule__Process__Group__4 )
            // InternalMyDsl.g:2765:2: rule__Process__Group__3__Impl rule__Process__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__Process__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__3"


    // $ANTLR start "rule__Process__Group__3__Impl"
    // InternalMyDsl.g:2772:1: rule__Process__Group__3__Impl : ( '[' ) ;
    public final void rule__Process__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2776:1: ( ( '[' ) )
            // InternalMyDsl.g:2777:1: ( '[' )
            {
            // InternalMyDsl.g:2777:1: ( '[' )
            // InternalMyDsl.g:2778:2: '['
            {
             before(grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__3__Impl"


    // $ANTLR start "rule__Process__Group__4"
    // InternalMyDsl.g:2787:1: rule__Process__Group__4 : rule__Process__Group__4__Impl rule__Process__Group__5 ;
    public final void rule__Process__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2791:1: ( rule__Process__Group__4__Impl rule__Process__Group__5 )
            // InternalMyDsl.g:2792:2: rule__Process__Group__4__Impl rule__Process__Group__5
            {
            pushFollow(FOLLOW_19);
            rule__Process__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__4"


    // $ANTLR start "rule__Process__Group__4__Impl"
    // InternalMyDsl.g:2799:1: rule__Process__Group__4__Impl : ( ( rule__Process__Group_4__0 )? ) ;
    public final void rule__Process__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2803:1: ( ( ( rule__Process__Group_4__0 )? ) )
            // InternalMyDsl.g:2804:1: ( ( rule__Process__Group_4__0 )? )
            {
            // InternalMyDsl.g:2804:1: ( ( rule__Process__Group_4__0 )? )
            // InternalMyDsl.g:2805:2: ( rule__Process__Group_4__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_4()); 
            // InternalMyDsl.g:2806:2: ( rule__Process__Group_4__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==56) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:2806:3: rule__Process__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Process__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProcessAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__4__Impl"


    // $ANTLR start "rule__Process__Group__5"
    // InternalMyDsl.g:2814:1: rule__Process__Group__5 : rule__Process__Group__5__Impl rule__Process__Group__6 ;
    public final void rule__Process__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2818:1: ( rule__Process__Group__5__Impl rule__Process__Group__6 )
            // InternalMyDsl.g:2819:2: rule__Process__Group__5__Impl rule__Process__Group__6
            {
            pushFollow(FOLLOW_19);
            rule__Process__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__5"


    // $ANTLR start "rule__Process__Group__5__Impl"
    // InternalMyDsl.g:2826:1: rule__Process__Group__5__Impl : ( ( rule__Process__Group_5__0 )? ) ;
    public final void rule__Process__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2830:1: ( ( ( rule__Process__Group_5__0 )? ) )
            // InternalMyDsl.g:2831:1: ( ( rule__Process__Group_5__0 )? )
            {
            // InternalMyDsl.g:2831:1: ( ( rule__Process__Group_5__0 )? )
            // InternalMyDsl.g:2832:2: ( rule__Process__Group_5__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_5()); 
            // InternalMyDsl.g:2833:2: ( rule__Process__Group_5__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==42) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:2833:3: rule__Process__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Process__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProcessAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__5__Impl"


    // $ANTLR start "rule__Process__Group__6"
    // InternalMyDsl.g:2841:1: rule__Process__Group__6 : rule__Process__Group__6__Impl rule__Process__Group__7 ;
    public final void rule__Process__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2845:1: ( rule__Process__Group__6__Impl rule__Process__Group__7 )
            // InternalMyDsl.g:2846:2: rule__Process__Group__6__Impl rule__Process__Group__7
            {
            pushFollow(FOLLOW_19);
            rule__Process__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__6"


    // $ANTLR start "rule__Process__Group__6__Impl"
    // InternalMyDsl.g:2853:1: rule__Process__Group__6__Impl : ( ( rule__Process__Group_6__0 )? ) ;
    public final void rule__Process__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2857:1: ( ( ( rule__Process__Group_6__0 )? ) )
            // InternalMyDsl.g:2858:1: ( ( rule__Process__Group_6__0 )? )
            {
            // InternalMyDsl.g:2858:1: ( ( rule__Process__Group_6__0 )? )
            // InternalMyDsl.g:2859:2: ( rule__Process__Group_6__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_6()); 
            // InternalMyDsl.g:2860:2: ( rule__Process__Group_6__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==57) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMyDsl.g:2860:3: rule__Process__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Process__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProcessAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__6__Impl"


    // $ANTLR start "rule__Process__Group__7"
    // InternalMyDsl.g:2868:1: rule__Process__Group__7 : rule__Process__Group__7__Impl rule__Process__Group__8 ;
    public final void rule__Process__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2872:1: ( rule__Process__Group__7__Impl rule__Process__Group__8 )
            // InternalMyDsl.g:2873:2: rule__Process__Group__7__Impl rule__Process__Group__8
            {
            pushFollow(FOLLOW_19);
            rule__Process__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__7"


    // $ANTLR start "rule__Process__Group__7__Impl"
    // InternalMyDsl.g:2880:1: rule__Process__Group__7__Impl : ( ( rule__Process__Group_7__0 )? ) ;
    public final void rule__Process__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2884:1: ( ( ( rule__Process__Group_7__0 )? ) )
            // InternalMyDsl.g:2885:1: ( ( rule__Process__Group_7__0 )? )
            {
            // InternalMyDsl.g:2885:1: ( ( rule__Process__Group_7__0 )? )
            // InternalMyDsl.g:2886:2: ( rule__Process__Group_7__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_7()); 
            // InternalMyDsl.g:2887:2: ( rule__Process__Group_7__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==58) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMyDsl.g:2887:3: rule__Process__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Process__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProcessAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__7__Impl"


    // $ANTLR start "rule__Process__Group__8"
    // InternalMyDsl.g:2895:1: rule__Process__Group__8 : rule__Process__Group__8__Impl rule__Process__Group__9 ;
    public final void rule__Process__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2899:1: ( rule__Process__Group__8__Impl rule__Process__Group__9 )
            // InternalMyDsl.g:2900:2: rule__Process__Group__8__Impl rule__Process__Group__9
            {
            pushFollow(FOLLOW_19);
            rule__Process__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__8"


    // $ANTLR start "rule__Process__Group__8__Impl"
    // InternalMyDsl.g:2907:1: rule__Process__Group__8__Impl : ( ( rule__Process__Group_8__0 )? ) ;
    public final void rule__Process__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2911:1: ( ( ( rule__Process__Group_8__0 )? ) )
            // InternalMyDsl.g:2912:1: ( ( rule__Process__Group_8__0 )? )
            {
            // InternalMyDsl.g:2912:1: ( ( rule__Process__Group_8__0 )? )
            // InternalMyDsl.g:2913:2: ( rule__Process__Group_8__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_8()); 
            // InternalMyDsl.g:2914:2: ( rule__Process__Group_8__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==60) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:2914:3: rule__Process__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Process__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProcessAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__8__Impl"


    // $ANTLR start "rule__Process__Group__9"
    // InternalMyDsl.g:2922:1: rule__Process__Group__9 : rule__Process__Group__9__Impl rule__Process__Group__10 ;
    public final void rule__Process__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2926:1: ( rule__Process__Group__9__Impl rule__Process__Group__10 )
            // InternalMyDsl.g:2927:2: rule__Process__Group__9__Impl rule__Process__Group__10
            {
            pushFollow(FOLLOW_19);
            rule__Process__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__9"


    // $ANTLR start "rule__Process__Group__9__Impl"
    // InternalMyDsl.g:2934:1: rule__Process__Group__9__Impl : ( ( rule__Process__Group_9__0 )? ) ;
    public final void rule__Process__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2938:1: ( ( ( rule__Process__Group_9__0 )? ) )
            // InternalMyDsl.g:2939:1: ( ( rule__Process__Group_9__0 )? )
            {
            // InternalMyDsl.g:2939:1: ( ( rule__Process__Group_9__0 )? )
            // InternalMyDsl.g:2940:2: ( rule__Process__Group_9__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_9()); 
            // InternalMyDsl.g:2941:2: ( rule__Process__Group_9__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==61) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMyDsl.g:2941:3: rule__Process__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Process__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProcessAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__9__Impl"


    // $ANTLR start "rule__Process__Group__10"
    // InternalMyDsl.g:2949:1: rule__Process__Group__10 : rule__Process__Group__10__Impl ;
    public final void rule__Process__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2953:1: ( rule__Process__Group__10__Impl )
            // InternalMyDsl.g:2954:2: rule__Process__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__10"


    // $ANTLR start "rule__Process__Group__10__Impl"
    // InternalMyDsl.g:2960:1: rule__Process__Group__10__Impl : ( ']' ) ;
    public final void rule__Process__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2964:1: ( ( ']' ) )
            // InternalMyDsl.g:2965:1: ( ']' )
            {
            // InternalMyDsl.g:2965:1: ( ']' )
            // InternalMyDsl.g:2966:2: ']'
            {
             before(grammarAccess.getProcessAccess().getRightSquareBracketKeyword_10()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getRightSquareBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group__10__Impl"


    // $ANTLR start "rule__Process__Group_4__0"
    // InternalMyDsl.g:2976:1: rule__Process__Group_4__0 : rule__Process__Group_4__0__Impl rule__Process__Group_4__1 ;
    public final void rule__Process__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2980:1: ( rule__Process__Group_4__0__Impl rule__Process__Group_4__1 )
            // InternalMyDsl.g:2981:2: rule__Process__Group_4__0__Impl rule__Process__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4__0"


    // $ANTLR start "rule__Process__Group_4__0__Impl"
    // InternalMyDsl.g:2988:1: rule__Process__Group_4__0__Impl : ( 'responsibilities:' ) ;
    public final void rule__Process__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2992:1: ( ( 'responsibilities:' ) )
            // InternalMyDsl.g:2993:1: ( 'responsibilities:' )
            {
            // InternalMyDsl.g:2993:1: ( 'responsibilities:' )
            // InternalMyDsl.g:2994:2: 'responsibilities:'
            {
             before(grammarAccess.getProcessAccess().getResponsibilitiesKeyword_4_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getResponsibilitiesKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4__0__Impl"


    // $ANTLR start "rule__Process__Group_4__1"
    // InternalMyDsl.g:3003:1: rule__Process__Group_4__1 : rule__Process__Group_4__1__Impl rule__Process__Group_4__2 ;
    public final void rule__Process__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3007:1: ( rule__Process__Group_4__1__Impl rule__Process__Group_4__2 )
            // InternalMyDsl.g:3008:2: rule__Process__Group_4__1__Impl rule__Process__Group_4__2
            {
            pushFollow(FOLLOW_8);
            rule__Process__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4__1"


    // $ANTLR start "rule__Process__Group_4__1__Impl"
    // InternalMyDsl.g:3015:1: rule__Process__Group_4__1__Impl : ( ( rule__Process__ResponsibilityAssignment_4_1 ) ) ;
    public final void rule__Process__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3019:1: ( ( ( rule__Process__ResponsibilityAssignment_4_1 ) ) )
            // InternalMyDsl.g:3020:1: ( ( rule__Process__ResponsibilityAssignment_4_1 ) )
            {
            // InternalMyDsl.g:3020:1: ( ( rule__Process__ResponsibilityAssignment_4_1 ) )
            // InternalMyDsl.g:3021:2: ( rule__Process__ResponsibilityAssignment_4_1 )
            {
             before(grammarAccess.getProcessAccess().getResponsibilityAssignment_4_1()); 
            // InternalMyDsl.g:3022:2: ( rule__Process__ResponsibilityAssignment_4_1 )
            // InternalMyDsl.g:3022:3: rule__Process__ResponsibilityAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__ResponsibilityAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getResponsibilityAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4__1__Impl"


    // $ANTLR start "rule__Process__Group_4__2"
    // InternalMyDsl.g:3030:1: rule__Process__Group_4__2 : rule__Process__Group_4__2__Impl ;
    public final void rule__Process__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3034:1: ( rule__Process__Group_4__2__Impl )
            // InternalMyDsl.g:3035:2: rule__Process__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4__2"


    // $ANTLR start "rule__Process__Group_4__2__Impl"
    // InternalMyDsl.g:3041:1: rule__Process__Group_4__2__Impl : ( ( rule__Process__Group_4_2__0 )* ) ;
    public final void rule__Process__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3045:1: ( ( ( rule__Process__Group_4_2__0 )* ) )
            // InternalMyDsl.g:3046:1: ( ( rule__Process__Group_4_2__0 )* )
            {
            // InternalMyDsl.g:3046:1: ( ( rule__Process__Group_4_2__0 )* )
            // InternalMyDsl.g:3047:2: ( rule__Process__Group_4_2__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_4_2()); 
            // InternalMyDsl.g:3048:2: ( rule__Process__Group_4_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==43) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMyDsl.g:3048:3: rule__Process__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4__2__Impl"


    // $ANTLR start "rule__Process__Group_4_2__0"
    // InternalMyDsl.g:3057:1: rule__Process__Group_4_2__0 : rule__Process__Group_4_2__0__Impl rule__Process__Group_4_2__1 ;
    public final void rule__Process__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3061:1: ( rule__Process__Group_4_2__0__Impl rule__Process__Group_4_2__1 )
            // InternalMyDsl.g:3062:2: rule__Process__Group_4_2__0__Impl rule__Process__Group_4_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4_2__0"


    // $ANTLR start "rule__Process__Group_4_2__0__Impl"
    // InternalMyDsl.g:3069:1: rule__Process__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3073:1: ( ( ',' ) )
            // InternalMyDsl.g:3074:1: ( ',' )
            {
            // InternalMyDsl.g:3074:1: ( ',' )
            // InternalMyDsl.g:3075:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_4_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4_2__0__Impl"


    // $ANTLR start "rule__Process__Group_4_2__1"
    // InternalMyDsl.g:3084:1: rule__Process__Group_4_2__1 : rule__Process__Group_4_2__1__Impl ;
    public final void rule__Process__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3088:1: ( rule__Process__Group_4_2__1__Impl )
            // InternalMyDsl.g:3089:2: rule__Process__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4_2__1"


    // $ANTLR start "rule__Process__Group_4_2__1__Impl"
    // InternalMyDsl.g:3095:1: rule__Process__Group_4_2__1__Impl : ( ( rule__Process__ResponsibilityAssignment_4_2_1 ) ) ;
    public final void rule__Process__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3099:1: ( ( ( rule__Process__ResponsibilityAssignment_4_2_1 ) ) )
            // InternalMyDsl.g:3100:1: ( ( rule__Process__ResponsibilityAssignment_4_2_1 ) )
            {
            // InternalMyDsl.g:3100:1: ( ( rule__Process__ResponsibilityAssignment_4_2_1 ) )
            // InternalMyDsl.g:3101:2: ( rule__Process__ResponsibilityAssignment_4_2_1 )
            {
             before(grammarAccess.getProcessAccess().getResponsibilityAssignment_4_2_1()); 
            // InternalMyDsl.g:3102:2: ( rule__Process__ResponsibilityAssignment_4_2_1 )
            // InternalMyDsl.g:3102:3: rule__Process__ResponsibilityAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__ResponsibilityAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getResponsibilityAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_4_2__1__Impl"


    // $ANTLR start "rule__Process__Group_5__0"
    // InternalMyDsl.g:3111:1: rule__Process__Group_5__0 : rule__Process__Group_5__0__Impl rule__Process__Group_5__1 ;
    public final void rule__Process__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3115:1: ( rule__Process__Group_5__0__Impl rule__Process__Group_5__1 )
            // InternalMyDsl.g:3116:2: rule__Process__Group_5__0__Impl rule__Process__Group_5__1
            {
            pushFollow(FOLLOW_4);
            rule__Process__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5__0"


    // $ANTLR start "rule__Process__Group_5__0__Impl"
    // InternalMyDsl.g:3123:1: rule__Process__Group_5__0__Impl : ( 'assets:' ) ;
    public final void rule__Process__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3127:1: ( ( 'assets:' ) )
            // InternalMyDsl.g:3128:1: ( 'assets:' )
            {
            // InternalMyDsl.g:3128:1: ( 'assets:' )
            // InternalMyDsl.g:3129:2: 'assets:'
            {
             before(grammarAccess.getProcessAccess().getAssetsKeyword_5_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getAssetsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5__0__Impl"


    // $ANTLR start "rule__Process__Group_5__1"
    // InternalMyDsl.g:3138:1: rule__Process__Group_5__1 : rule__Process__Group_5__1__Impl rule__Process__Group_5__2 ;
    public final void rule__Process__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3142:1: ( rule__Process__Group_5__1__Impl rule__Process__Group_5__2 )
            // InternalMyDsl.g:3143:2: rule__Process__Group_5__1__Impl rule__Process__Group_5__2
            {
            pushFollow(FOLLOW_8);
            rule__Process__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5__1"


    // $ANTLR start "rule__Process__Group_5__1__Impl"
    // InternalMyDsl.g:3150:1: rule__Process__Group_5__1__Impl : ( ( rule__Process__AssetsAssignment_5_1 ) ) ;
    public final void rule__Process__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3154:1: ( ( ( rule__Process__AssetsAssignment_5_1 ) ) )
            // InternalMyDsl.g:3155:1: ( ( rule__Process__AssetsAssignment_5_1 ) )
            {
            // InternalMyDsl.g:3155:1: ( ( rule__Process__AssetsAssignment_5_1 ) )
            // InternalMyDsl.g:3156:2: ( rule__Process__AssetsAssignment_5_1 )
            {
             before(grammarAccess.getProcessAccess().getAssetsAssignment_5_1()); 
            // InternalMyDsl.g:3157:2: ( rule__Process__AssetsAssignment_5_1 )
            // InternalMyDsl.g:3157:3: rule__Process__AssetsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__AssetsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getAssetsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5__1__Impl"


    // $ANTLR start "rule__Process__Group_5__2"
    // InternalMyDsl.g:3165:1: rule__Process__Group_5__2 : rule__Process__Group_5__2__Impl ;
    public final void rule__Process__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3169:1: ( rule__Process__Group_5__2__Impl )
            // InternalMyDsl.g:3170:2: rule__Process__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5__2"


    // $ANTLR start "rule__Process__Group_5__2__Impl"
    // InternalMyDsl.g:3176:1: rule__Process__Group_5__2__Impl : ( ( rule__Process__Group_5_2__0 )* ) ;
    public final void rule__Process__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3180:1: ( ( ( rule__Process__Group_5_2__0 )* ) )
            // InternalMyDsl.g:3181:1: ( ( rule__Process__Group_5_2__0 )* )
            {
            // InternalMyDsl.g:3181:1: ( ( rule__Process__Group_5_2__0 )* )
            // InternalMyDsl.g:3182:2: ( rule__Process__Group_5_2__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_5_2()); 
            // InternalMyDsl.g:3183:2: ( rule__Process__Group_5_2__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==43) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalMyDsl.g:3183:3: rule__Process__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5__2__Impl"


    // $ANTLR start "rule__Process__Group_5_2__0"
    // InternalMyDsl.g:3192:1: rule__Process__Group_5_2__0 : rule__Process__Group_5_2__0__Impl rule__Process__Group_5_2__1 ;
    public final void rule__Process__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3196:1: ( rule__Process__Group_5_2__0__Impl rule__Process__Group_5_2__1 )
            // InternalMyDsl.g:3197:2: rule__Process__Group_5_2__0__Impl rule__Process__Group_5_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Process__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_5_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5_2__0"


    // $ANTLR start "rule__Process__Group_5_2__0__Impl"
    // InternalMyDsl.g:3204:1: rule__Process__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3208:1: ( ( ',' ) )
            // InternalMyDsl.g:3209:1: ( ',' )
            {
            // InternalMyDsl.g:3209:1: ( ',' )
            // InternalMyDsl.g:3210:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_5_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getCommaKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5_2__0__Impl"


    // $ANTLR start "rule__Process__Group_5_2__1"
    // InternalMyDsl.g:3219:1: rule__Process__Group_5_2__1 : rule__Process__Group_5_2__1__Impl ;
    public final void rule__Process__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3223:1: ( rule__Process__Group_5_2__1__Impl )
            // InternalMyDsl.g:3224:2: rule__Process__Group_5_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_5_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5_2__1"


    // $ANTLR start "rule__Process__Group_5_2__1__Impl"
    // InternalMyDsl.g:3230:1: rule__Process__Group_5_2__1__Impl : ( ( rule__Process__AssetsAssignment_5_2_1 ) ) ;
    public final void rule__Process__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3234:1: ( ( ( rule__Process__AssetsAssignment_5_2_1 ) ) )
            // InternalMyDsl.g:3235:1: ( ( rule__Process__AssetsAssignment_5_2_1 ) )
            {
            // InternalMyDsl.g:3235:1: ( ( rule__Process__AssetsAssignment_5_2_1 ) )
            // InternalMyDsl.g:3236:2: ( rule__Process__AssetsAssignment_5_2_1 )
            {
             before(grammarAccess.getProcessAccess().getAssetsAssignment_5_2_1()); 
            // InternalMyDsl.g:3237:2: ( rule__Process__AssetsAssignment_5_2_1 )
            // InternalMyDsl.g:3237:3: rule__Process__AssetsAssignment_5_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__AssetsAssignment_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getAssetsAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_5_2__1__Impl"


    // $ANTLR start "rule__Process__Group_6__0"
    // InternalMyDsl.g:3246:1: rule__Process__Group_6__0 : rule__Process__Group_6__0__Impl rule__Process__Group_6__1 ;
    public final void rule__Process__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3250:1: ( rule__Process__Group_6__0__Impl rule__Process__Group_6__1 )
            // InternalMyDsl.g:3251:2: rule__Process__Group_6__0__Impl rule__Process__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6__0"


    // $ANTLR start "rule__Process__Group_6__0__Impl"
    // InternalMyDsl.g:3258:1: rule__Process__Group_6__0__Impl : ( 'assumption:' ) ;
    public final void rule__Process__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3262:1: ( ( 'assumption:' ) )
            // InternalMyDsl.g:3263:1: ( 'assumption:' )
            {
            // InternalMyDsl.g:3263:1: ( 'assumption:' )
            // InternalMyDsl.g:3264:2: 'assumption:'
            {
             before(grammarAccess.getProcessAccess().getAssumptionKeyword_6_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getAssumptionKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6__0__Impl"


    // $ANTLR start "rule__Process__Group_6__1"
    // InternalMyDsl.g:3273:1: rule__Process__Group_6__1 : rule__Process__Group_6__1__Impl rule__Process__Group_6__2 ;
    public final void rule__Process__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3277:1: ( rule__Process__Group_6__1__Impl rule__Process__Group_6__2 )
            // InternalMyDsl.g:3278:2: rule__Process__Group_6__1__Impl rule__Process__Group_6__2
            {
            pushFollow(FOLLOW_8);
            rule__Process__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6__1"


    // $ANTLR start "rule__Process__Group_6__1__Impl"
    // InternalMyDsl.g:3285:1: rule__Process__Group_6__1__Impl : ( ( rule__Process__AssumptionAssignment_6_1 ) ) ;
    public final void rule__Process__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3289:1: ( ( ( rule__Process__AssumptionAssignment_6_1 ) ) )
            // InternalMyDsl.g:3290:1: ( ( rule__Process__AssumptionAssignment_6_1 ) )
            {
            // InternalMyDsl.g:3290:1: ( ( rule__Process__AssumptionAssignment_6_1 ) )
            // InternalMyDsl.g:3291:2: ( rule__Process__AssumptionAssignment_6_1 )
            {
             before(grammarAccess.getProcessAccess().getAssumptionAssignment_6_1()); 
            // InternalMyDsl.g:3292:2: ( rule__Process__AssumptionAssignment_6_1 )
            // InternalMyDsl.g:3292:3: rule__Process__AssumptionAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__AssumptionAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getAssumptionAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6__1__Impl"


    // $ANTLR start "rule__Process__Group_6__2"
    // InternalMyDsl.g:3300:1: rule__Process__Group_6__2 : rule__Process__Group_6__2__Impl ;
    public final void rule__Process__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3304:1: ( rule__Process__Group_6__2__Impl )
            // InternalMyDsl.g:3305:2: rule__Process__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6__2"


    // $ANTLR start "rule__Process__Group_6__2__Impl"
    // InternalMyDsl.g:3311:1: rule__Process__Group_6__2__Impl : ( ( rule__Process__Group_6_2__0 )* ) ;
    public final void rule__Process__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3315:1: ( ( ( rule__Process__Group_6_2__0 )* ) )
            // InternalMyDsl.g:3316:1: ( ( rule__Process__Group_6_2__0 )* )
            {
            // InternalMyDsl.g:3316:1: ( ( rule__Process__Group_6_2__0 )* )
            // InternalMyDsl.g:3317:2: ( rule__Process__Group_6_2__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_6_2()); 
            // InternalMyDsl.g:3318:2: ( rule__Process__Group_6_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==43) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalMyDsl.g:3318:3: rule__Process__Group_6_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_6_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getGroup_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6__2__Impl"


    // $ANTLR start "rule__Process__Group_6_2__0"
    // InternalMyDsl.g:3327:1: rule__Process__Group_6_2__0 : rule__Process__Group_6_2__0__Impl rule__Process__Group_6_2__1 ;
    public final void rule__Process__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3331:1: ( rule__Process__Group_6_2__0__Impl rule__Process__Group_6_2__1 )
            // InternalMyDsl.g:3332:2: rule__Process__Group_6_2__0__Impl rule__Process__Group_6_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Process__Group_6_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_6_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6_2__0"


    // $ANTLR start "rule__Process__Group_6_2__0__Impl"
    // InternalMyDsl.g:3339:1: rule__Process__Group_6_2__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3343:1: ( ( ',' ) )
            // InternalMyDsl.g:3344:1: ( ',' )
            {
            // InternalMyDsl.g:3344:1: ( ',' )
            // InternalMyDsl.g:3345:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_6_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getCommaKeyword_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6_2__0__Impl"


    // $ANTLR start "rule__Process__Group_6_2__1"
    // InternalMyDsl.g:3354:1: rule__Process__Group_6_2__1 : rule__Process__Group_6_2__1__Impl ;
    public final void rule__Process__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3358:1: ( rule__Process__Group_6_2__1__Impl )
            // InternalMyDsl.g:3359:2: rule__Process__Group_6_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_6_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6_2__1"


    // $ANTLR start "rule__Process__Group_6_2__1__Impl"
    // InternalMyDsl.g:3365:1: rule__Process__Group_6_2__1__Impl : ( ( rule__Process__AssumptionAssignment_6_2_1 ) ) ;
    public final void rule__Process__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3369:1: ( ( ( rule__Process__AssumptionAssignment_6_2_1 ) ) )
            // InternalMyDsl.g:3370:1: ( ( rule__Process__AssumptionAssignment_6_2_1 ) )
            {
            // InternalMyDsl.g:3370:1: ( ( rule__Process__AssumptionAssignment_6_2_1 ) )
            // InternalMyDsl.g:3371:2: ( rule__Process__AssumptionAssignment_6_2_1 )
            {
             before(grammarAccess.getProcessAccess().getAssumptionAssignment_6_2_1()); 
            // InternalMyDsl.g:3372:2: ( rule__Process__AssumptionAssignment_6_2_1 )
            // InternalMyDsl.g:3372:3: rule__Process__AssumptionAssignment_6_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__AssumptionAssignment_6_2_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getAssumptionAssignment_6_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_6_2__1__Impl"


    // $ANTLR start "rule__Process__Group_7__0"
    // InternalMyDsl.g:3381:1: rule__Process__Group_7__0 : rule__Process__Group_7__0__Impl rule__Process__Group_7__1 ;
    public final void rule__Process__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3385:1: ( rule__Process__Group_7__0__Impl rule__Process__Group_7__1 )
            // InternalMyDsl.g:3386:2: rule__Process__Group_7__0__Impl rule__Process__Group_7__1
            {
            pushFollow(FOLLOW_20);
            rule__Process__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7__0"


    // $ANTLR start "rule__Process__Group_7__0__Impl"
    // InternalMyDsl.g:3393:1: rule__Process__Group_7__0__Impl : ( 'incoming' ) ;
    public final void rule__Process__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3397:1: ( ( 'incoming' ) )
            // InternalMyDsl.g:3398:1: ( 'incoming' )
            {
            // InternalMyDsl.g:3398:1: ( 'incoming' )
            // InternalMyDsl.g:3399:2: 'incoming'
            {
             before(grammarAccess.getProcessAccess().getIncomingKeyword_7_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getIncomingKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7__0__Impl"


    // $ANTLR start "rule__Process__Group_7__1"
    // InternalMyDsl.g:3408:1: rule__Process__Group_7__1 : rule__Process__Group_7__1__Impl rule__Process__Group_7__2 ;
    public final void rule__Process__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3412:1: ( rule__Process__Group_7__1__Impl rule__Process__Group_7__2 )
            // InternalMyDsl.g:3413:2: rule__Process__Group_7__1__Impl rule__Process__Group_7__2
            {
            pushFollow(FOLLOW_4);
            rule__Process__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7__1"


    // $ANTLR start "rule__Process__Group_7__1__Impl"
    // InternalMyDsl.g:3420:1: rule__Process__Group_7__1__Impl : ( 'flows:' ) ;
    public final void rule__Process__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3424:1: ( ( 'flows:' ) )
            // InternalMyDsl.g:3425:1: ( 'flows:' )
            {
            // InternalMyDsl.g:3425:1: ( 'flows:' )
            // InternalMyDsl.g:3426:2: 'flows:'
            {
             before(grammarAccess.getProcessAccess().getFlowsKeyword_7_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getFlowsKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7__1__Impl"


    // $ANTLR start "rule__Process__Group_7__2"
    // InternalMyDsl.g:3435:1: rule__Process__Group_7__2 : rule__Process__Group_7__2__Impl rule__Process__Group_7__3 ;
    public final void rule__Process__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3439:1: ( rule__Process__Group_7__2__Impl rule__Process__Group_7__3 )
            // InternalMyDsl.g:3440:2: rule__Process__Group_7__2__Impl rule__Process__Group_7__3
            {
            pushFollow(FOLLOW_8);
            rule__Process__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7__2"


    // $ANTLR start "rule__Process__Group_7__2__Impl"
    // InternalMyDsl.g:3447:1: rule__Process__Group_7__2__Impl : ( ( rule__Process__InflowsAssignment_7_2 ) ) ;
    public final void rule__Process__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3451:1: ( ( ( rule__Process__InflowsAssignment_7_2 ) ) )
            // InternalMyDsl.g:3452:1: ( ( rule__Process__InflowsAssignment_7_2 ) )
            {
            // InternalMyDsl.g:3452:1: ( ( rule__Process__InflowsAssignment_7_2 ) )
            // InternalMyDsl.g:3453:2: ( rule__Process__InflowsAssignment_7_2 )
            {
             before(grammarAccess.getProcessAccess().getInflowsAssignment_7_2()); 
            // InternalMyDsl.g:3454:2: ( rule__Process__InflowsAssignment_7_2 )
            // InternalMyDsl.g:3454:3: rule__Process__InflowsAssignment_7_2
            {
            pushFollow(FOLLOW_2);
            rule__Process__InflowsAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getInflowsAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7__2__Impl"


    // $ANTLR start "rule__Process__Group_7__3"
    // InternalMyDsl.g:3462:1: rule__Process__Group_7__3 : rule__Process__Group_7__3__Impl ;
    public final void rule__Process__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3466:1: ( rule__Process__Group_7__3__Impl )
            // InternalMyDsl.g:3467:2: rule__Process__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_7__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7__3"


    // $ANTLR start "rule__Process__Group_7__3__Impl"
    // InternalMyDsl.g:3473:1: rule__Process__Group_7__3__Impl : ( ( rule__Process__Group_7_3__0 )* ) ;
    public final void rule__Process__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3477:1: ( ( ( rule__Process__Group_7_3__0 )* ) )
            // InternalMyDsl.g:3478:1: ( ( rule__Process__Group_7_3__0 )* )
            {
            // InternalMyDsl.g:3478:1: ( ( rule__Process__Group_7_3__0 )* )
            // InternalMyDsl.g:3479:2: ( rule__Process__Group_7_3__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_7_3()); 
            // InternalMyDsl.g:3480:2: ( rule__Process__Group_7_3__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==43) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalMyDsl.g:3480:3: rule__Process__Group_7_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_7_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getGroup_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7__3__Impl"


    // $ANTLR start "rule__Process__Group_7_3__0"
    // InternalMyDsl.g:3489:1: rule__Process__Group_7_3__0 : rule__Process__Group_7_3__0__Impl rule__Process__Group_7_3__1 ;
    public final void rule__Process__Group_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3493:1: ( rule__Process__Group_7_3__0__Impl rule__Process__Group_7_3__1 )
            // InternalMyDsl.g:3494:2: rule__Process__Group_7_3__0__Impl rule__Process__Group_7_3__1
            {
            pushFollow(FOLLOW_4);
            rule__Process__Group_7_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_7_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7_3__0"


    // $ANTLR start "rule__Process__Group_7_3__0__Impl"
    // InternalMyDsl.g:3501:1: rule__Process__Group_7_3__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3505:1: ( ( ',' ) )
            // InternalMyDsl.g:3506:1: ( ',' )
            {
            // InternalMyDsl.g:3506:1: ( ',' )
            // InternalMyDsl.g:3507:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_7_3_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getCommaKeyword_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7_3__0__Impl"


    // $ANTLR start "rule__Process__Group_7_3__1"
    // InternalMyDsl.g:3516:1: rule__Process__Group_7_3__1 : rule__Process__Group_7_3__1__Impl ;
    public final void rule__Process__Group_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3520:1: ( rule__Process__Group_7_3__1__Impl )
            // InternalMyDsl.g:3521:2: rule__Process__Group_7_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_7_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7_3__1"


    // $ANTLR start "rule__Process__Group_7_3__1__Impl"
    // InternalMyDsl.g:3527:1: rule__Process__Group_7_3__1__Impl : ( ( rule__Process__InflowsAssignment_7_3_1 ) ) ;
    public final void rule__Process__Group_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3531:1: ( ( ( rule__Process__InflowsAssignment_7_3_1 ) ) )
            // InternalMyDsl.g:3532:1: ( ( rule__Process__InflowsAssignment_7_3_1 ) )
            {
            // InternalMyDsl.g:3532:1: ( ( rule__Process__InflowsAssignment_7_3_1 ) )
            // InternalMyDsl.g:3533:2: ( rule__Process__InflowsAssignment_7_3_1 )
            {
             before(grammarAccess.getProcessAccess().getInflowsAssignment_7_3_1()); 
            // InternalMyDsl.g:3534:2: ( rule__Process__InflowsAssignment_7_3_1 )
            // InternalMyDsl.g:3534:3: rule__Process__InflowsAssignment_7_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__InflowsAssignment_7_3_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getInflowsAssignment_7_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_7_3__1__Impl"


    // $ANTLR start "rule__Process__Group_8__0"
    // InternalMyDsl.g:3543:1: rule__Process__Group_8__0 : rule__Process__Group_8__0__Impl rule__Process__Group_8__1 ;
    public final void rule__Process__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3547:1: ( rule__Process__Group_8__0__Impl rule__Process__Group_8__1 )
            // InternalMyDsl.g:3548:2: rule__Process__Group_8__0__Impl rule__Process__Group_8__1
            {
            pushFollow(FOLLOW_20);
            rule__Process__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8__0"


    // $ANTLR start "rule__Process__Group_8__0__Impl"
    // InternalMyDsl.g:3555:1: rule__Process__Group_8__0__Impl : ( 'outgoing' ) ;
    public final void rule__Process__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3559:1: ( ( 'outgoing' ) )
            // InternalMyDsl.g:3560:1: ( 'outgoing' )
            {
            // InternalMyDsl.g:3560:1: ( 'outgoing' )
            // InternalMyDsl.g:3561:2: 'outgoing'
            {
             before(grammarAccess.getProcessAccess().getOutgoingKeyword_8_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getOutgoingKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8__0__Impl"


    // $ANTLR start "rule__Process__Group_8__1"
    // InternalMyDsl.g:3570:1: rule__Process__Group_8__1 : rule__Process__Group_8__1__Impl rule__Process__Group_8__2 ;
    public final void rule__Process__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3574:1: ( rule__Process__Group_8__1__Impl rule__Process__Group_8__2 )
            // InternalMyDsl.g:3575:2: rule__Process__Group_8__1__Impl rule__Process__Group_8__2
            {
            pushFollow(FOLLOW_4);
            rule__Process__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8__1"


    // $ANTLR start "rule__Process__Group_8__1__Impl"
    // InternalMyDsl.g:3582:1: rule__Process__Group_8__1__Impl : ( 'flows:' ) ;
    public final void rule__Process__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3586:1: ( ( 'flows:' ) )
            // InternalMyDsl.g:3587:1: ( 'flows:' )
            {
            // InternalMyDsl.g:3587:1: ( 'flows:' )
            // InternalMyDsl.g:3588:2: 'flows:'
            {
             before(grammarAccess.getProcessAccess().getFlowsKeyword_8_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getFlowsKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8__1__Impl"


    // $ANTLR start "rule__Process__Group_8__2"
    // InternalMyDsl.g:3597:1: rule__Process__Group_8__2 : rule__Process__Group_8__2__Impl rule__Process__Group_8__3 ;
    public final void rule__Process__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3601:1: ( rule__Process__Group_8__2__Impl rule__Process__Group_8__3 )
            // InternalMyDsl.g:3602:2: rule__Process__Group_8__2__Impl rule__Process__Group_8__3
            {
            pushFollow(FOLLOW_8);
            rule__Process__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8__2"


    // $ANTLR start "rule__Process__Group_8__2__Impl"
    // InternalMyDsl.g:3609:1: rule__Process__Group_8__2__Impl : ( ( rule__Process__OutflowsAssignment_8_2 ) ) ;
    public final void rule__Process__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3613:1: ( ( ( rule__Process__OutflowsAssignment_8_2 ) ) )
            // InternalMyDsl.g:3614:1: ( ( rule__Process__OutflowsAssignment_8_2 ) )
            {
            // InternalMyDsl.g:3614:1: ( ( rule__Process__OutflowsAssignment_8_2 ) )
            // InternalMyDsl.g:3615:2: ( rule__Process__OutflowsAssignment_8_2 )
            {
             before(grammarAccess.getProcessAccess().getOutflowsAssignment_8_2()); 
            // InternalMyDsl.g:3616:2: ( rule__Process__OutflowsAssignment_8_2 )
            // InternalMyDsl.g:3616:3: rule__Process__OutflowsAssignment_8_2
            {
            pushFollow(FOLLOW_2);
            rule__Process__OutflowsAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getOutflowsAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8__2__Impl"


    // $ANTLR start "rule__Process__Group_8__3"
    // InternalMyDsl.g:3624:1: rule__Process__Group_8__3 : rule__Process__Group_8__3__Impl ;
    public final void rule__Process__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3628:1: ( rule__Process__Group_8__3__Impl )
            // InternalMyDsl.g:3629:2: rule__Process__Group_8__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_8__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8__3"


    // $ANTLR start "rule__Process__Group_8__3__Impl"
    // InternalMyDsl.g:3635:1: rule__Process__Group_8__3__Impl : ( ( rule__Process__Group_8_3__0 )* ) ;
    public final void rule__Process__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3639:1: ( ( ( rule__Process__Group_8_3__0 )* ) )
            // InternalMyDsl.g:3640:1: ( ( rule__Process__Group_8_3__0 )* )
            {
            // InternalMyDsl.g:3640:1: ( ( rule__Process__Group_8_3__0 )* )
            // InternalMyDsl.g:3641:2: ( rule__Process__Group_8_3__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_8_3()); 
            // InternalMyDsl.g:3642:2: ( rule__Process__Group_8_3__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==43) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalMyDsl.g:3642:3: rule__Process__Group_8_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_8_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getProcessAccess().getGroup_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8__3__Impl"


    // $ANTLR start "rule__Process__Group_8_3__0"
    // InternalMyDsl.g:3651:1: rule__Process__Group_8_3__0 : rule__Process__Group_8_3__0__Impl rule__Process__Group_8_3__1 ;
    public final void rule__Process__Group_8_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3655:1: ( rule__Process__Group_8_3__0__Impl rule__Process__Group_8_3__1 )
            // InternalMyDsl.g:3656:2: rule__Process__Group_8_3__0__Impl rule__Process__Group_8_3__1
            {
            pushFollow(FOLLOW_4);
            rule__Process__Group_8_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_8_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8_3__0"


    // $ANTLR start "rule__Process__Group_8_3__0__Impl"
    // InternalMyDsl.g:3663:1: rule__Process__Group_8_3__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_8_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3667:1: ( ( ',' ) )
            // InternalMyDsl.g:3668:1: ( ',' )
            {
            // InternalMyDsl.g:3668:1: ( ',' )
            // InternalMyDsl.g:3669:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_8_3_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getCommaKeyword_8_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8_3__0__Impl"


    // $ANTLR start "rule__Process__Group_8_3__1"
    // InternalMyDsl.g:3678:1: rule__Process__Group_8_3__1 : rule__Process__Group_8_3__1__Impl ;
    public final void rule__Process__Group_8_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3682:1: ( rule__Process__Group_8_3__1__Impl )
            // InternalMyDsl.g:3683:2: rule__Process__Group_8_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_8_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8_3__1"


    // $ANTLR start "rule__Process__Group_8_3__1__Impl"
    // InternalMyDsl.g:3689:1: rule__Process__Group_8_3__1__Impl : ( ( rule__Process__OutflowsAssignment_8_3_1 ) ) ;
    public final void rule__Process__Group_8_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3693:1: ( ( ( rule__Process__OutflowsAssignment_8_3_1 ) ) )
            // InternalMyDsl.g:3694:1: ( ( rule__Process__OutflowsAssignment_8_3_1 ) )
            {
            // InternalMyDsl.g:3694:1: ( ( rule__Process__OutflowsAssignment_8_3_1 ) )
            // InternalMyDsl.g:3695:2: ( rule__Process__OutflowsAssignment_8_3_1 )
            {
             before(grammarAccess.getProcessAccess().getOutflowsAssignment_8_3_1()); 
            // InternalMyDsl.g:3696:2: ( rule__Process__OutflowsAssignment_8_3_1 )
            // InternalMyDsl.g:3696:3: rule__Process__OutflowsAssignment_8_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__OutflowsAssignment_8_3_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getOutflowsAssignment_8_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_8_3__1__Impl"


    // $ANTLR start "rule__Process__Group_9__0"
    // InternalMyDsl.g:3705:1: rule__Process__Group_9__0 : rule__Process__Group_9__0__Impl rule__Process__Group_9__1 ;
    public final void rule__Process__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3709:1: ( rule__Process__Group_9__0__Impl rule__Process__Group_9__1 )
            // InternalMyDsl.g:3710:2: rule__Process__Group_9__0__Impl rule__Process__Group_9__1
            {
            pushFollow(FOLLOW_21);
            rule__Process__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Process__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_9__0"


    // $ANTLR start "rule__Process__Group_9__0__Impl"
    // InternalMyDsl.g:3717:1: rule__Process__Group_9__0__Impl : ( 'attacker:' ) ;
    public final void rule__Process__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3721:1: ( ( 'attacker:' ) )
            // InternalMyDsl.g:3722:1: ( 'attacker:' )
            {
            // InternalMyDsl.g:3722:1: ( 'attacker:' )
            // InternalMyDsl.g:3723:2: 'attacker:'
            {
             before(grammarAccess.getProcessAccess().getAttackerKeyword_9_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getProcessAccess().getAttackerKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_9__0__Impl"


    // $ANTLR start "rule__Process__Group_9__1"
    // InternalMyDsl.g:3732:1: rule__Process__Group_9__1 : rule__Process__Group_9__1__Impl ;
    public final void rule__Process__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3736:1: ( rule__Process__Group_9__1__Impl )
            // InternalMyDsl.g:3737:2: rule__Process__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Process__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_9__1"


    // $ANTLR start "rule__Process__Group_9__1__Impl"
    // InternalMyDsl.g:3743:1: rule__Process__Group_9__1__Impl : ( ( rule__Process__AttackerAssignment_9_1 ) ) ;
    public final void rule__Process__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3747:1: ( ( ( rule__Process__AttackerAssignment_9_1 ) ) )
            // InternalMyDsl.g:3748:1: ( ( rule__Process__AttackerAssignment_9_1 ) )
            {
            // InternalMyDsl.g:3748:1: ( ( rule__Process__AttackerAssignment_9_1 ) )
            // InternalMyDsl.g:3749:2: ( rule__Process__AttackerAssignment_9_1 )
            {
             before(grammarAccess.getProcessAccess().getAttackerAssignment_9_1()); 
            // InternalMyDsl.g:3750:2: ( rule__Process__AttackerAssignment_9_1 )
            // InternalMyDsl.g:3750:3: rule__Process__AttackerAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__Process__AttackerAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessAccess().getAttackerAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__Group_9__1__Impl"


    // $ANTLR start "rule__Responsibility__Group__0"
    // InternalMyDsl.g:3759:1: rule__Responsibility__Group__0 : rule__Responsibility__Group__0__Impl rule__Responsibility__Group__1 ;
    public final void rule__Responsibility__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3763:1: ( rule__Responsibility__Group__0__Impl rule__Responsibility__Group__1 )
            // InternalMyDsl.g:3764:2: rule__Responsibility__Group__0__Impl rule__Responsibility__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Responsibility__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group__0"


    // $ANTLR start "rule__Responsibility__Group__0__Impl"
    // InternalMyDsl.g:3771:1: rule__Responsibility__Group__0__Impl : ( () ) ;
    public final void rule__Responsibility__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3775:1: ( ( () ) )
            // InternalMyDsl.g:3776:1: ( () )
            {
            // InternalMyDsl.g:3776:1: ( () )
            // InternalMyDsl.g:3777:2: ()
            {
             before(grammarAccess.getResponsibilityAccess().getResponsibilityAction_0()); 
            // InternalMyDsl.g:3778:2: ()
            // InternalMyDsl.g:3778:3: 
            {
            }

             after(grammarAccess.getResponsibilityAccess().getResponsibilityAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group__0__Impl"


    // $ANTLR start "rule__Responsibility__Group__1"
    // InternalMyDsl.g:3786:1: rule__Responsibility__Group__1 : rule__Responsibility__Group__1__Impl rule__Responsibility__Group__2 ;
    public final void rule__Responsibility__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3790:1: ( rule__Responsibility__Group__1__Impl rule__Responsibility__Group__2 )
            // InternalMyDsl.g:3791:2: rule__Responsibility__Group__1__Impl rule__Responsibility__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__Responsibility__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group__1"


    // $ANTLR start "rule__Responsibility__Group__1__Impl"
    // InternalMyDsl.g:3798:1: rule__Responsibility__Group__1__Impl : ( '[' ) ;
    public final void rule__Responsibility__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3802:1: ( ( '[' ) )
            // InternalMyDsl.g:3803:1: ( '[' )
            {
            // InternalMyDsl.g:3803:1: ( '[' )
            // InternalMyDsl.g:3804:2: '['
            {
             before(grammarAccess.getResponsibilityAccess().getLeftSquareBracketKeyword_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getResponsibilityAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group__1__Impl"


    // $ANTLR start "rule__Responsibility__Group__2"
    // InternalMyDsl.g:3813:1: rule__Responsibility__Group__2 : rule__Responsibility__Group__2__Impl rule__Responsibility__Group__3 ;
    public final void rule__Responsibility__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3817:1: ( rule__Responsibility__Group__2__Impl rule__Responsibility__Group__3 )
            // InternalMyDsl.g:3818:2: rule__Responsibility__Group__2__Impl rule__Responsibility__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__Responsibility__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group__2"


    // $ANTLR start "rule__Responsibility__Group__2__Impl"
    // InternalMyDsl.g:3825:1: rule__Responsibility__Group__2__Impl : ( ( rule__Responsibility__Group_2__0 )? ) ;
    public final void rule__Responsibility__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3829:1: ( ( ( rule__Responsibility__Group_2__0 )? ) )
            // InternalMyDsl.g:3830:1: ( ( rule__Responsibility__Group_2__0 )? )
            {
            // InternalMyDsl.g:3830:1: ( ( rule__Responsibility__Group_2__0 )? )
            // InternalMyDsl.g:3831:2: ( rule__Responsibility__Group_2__0 )?
            {
             before(grammarAccess.getResponsibilityAccess().getGroup_2()); 
            // InternalMyDsl.g:3832:2: ( rule__Responsibility__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_ID)||(LA36_0>=23 && LA36_0<=35)||LA36_0==43) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMyDsl.g:3832:3: rule__Responsibility__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Responsibility__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResponsibilityAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group__2__Impl"


    // $ANTLR start "rule__Responsibility__Group__3"
    // InternalMyDsl.g:3840:1: rule__Responsibility__Group__3 : rule__Responsibility__Group__3__Impl ;
    public final void rule__Responsibility__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3844:1: ( rule__Responsibility__Group__3__Impl )
            // InternalMyDsl.g:3845:2: rule__Responsibility__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Responsibility__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group__3"


    // $ANTLR start "rule__Responsibility__Group__3__Impl"
    // InternalMyDsl.g:3851:1: rule__Responsibility__Group__3__Impl : ( ']' ) ;
    public final void rule__Responsibility__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3855:1: ( ( ']' ) )
            // InternalMyDsl.g:3856:1: ( ']' )
            {
            // InternalMyDsl.g:3856:1: ( ']' )
            // InternalMyDsl.g:3857:2: ']'
            {
             before(grammarAccess.getResponsibilityAccess().getRightSquareBracketKeyword_3()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getResponsibilityAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group__3__Impl"


    // $ANTLR start "rule__Responsibility__Group_2__0"
    // InternalMyDsl.g:3867:1: rule__Responsibility__Group_2__0 : rule__Responsibility__Group_2__0__Impl rule__Responsibility__Group_2__1 ;
    public final void rule__Responsibility__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3871:1: ( rule__Responsibility__Group_2__0__Impl rule__Responsibility__Group_2__1 )
            // InternalMyDsl.g:3872:2: rule__Responsibility__Group_2__0__Impl rule__Responsibility__Group_2__1
            {
            pushFollow(FOLLOW_23);
            rule__Responsibility__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__0"


    // $ANTLR start "rule__Responsibility__Group_2__0__Impl"
    // InternalMyDsl.g:3879:1: rule__Responsibility__Group_2__0__Impl : ( ( rule__Responsibility__IncomeassetsAssignment_2_0 )? ) ;
    public final void rule__Responsibility__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3883:1: ( ( ( rule__Responsibility__IncomeassetsAssignment_2_0 )? ) )
            // InternalMyDsl.g:3884:1: ( ( rule__Responsibility__IncomeassetsAssignment_2_0 )? )
            {
            // InternalMyDsl.g:3884:1: ( ( rule__Responsibility__IncomeassetsAssignment_2_0 )? )
            // InternalMyDsl.g:3885:2: ( rule__Responsibility__IncomeassetsAssignment_2_0 )?
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssignment_2_0()); 
            // InternalMyDsl.g:3886:2: ( rule__Responsibility__IncomeassetsAssignment_2_0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_STRING && LA37_0<=RULE_ID)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalMyDsl.g:3886:3: rule__Responsibility__IncomeassetsAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Responsibility__IncomeassetsAssignment_2_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResponsibilityAccess().getIncomeassetsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__0__Impl"


    // $ANTLR start "rule__Responsibility__Group_2__1"
    // InternalMyDsl.g:3894:1: rule__Responsibility__Group_2__1 : rule__Responsibility__Group_2__1__Impl rule__Responsibility__Group_2__2 ;
    public final void rule__Responsibility__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3898:1: ( rule__Responsibility__Group_2__1__Impl rule__Responsibility__Group_2__2 )
            // InternalMyDsl.g:3899:2: rule__Responsibility__Group_2__1__Impl rule__Responsibility__Group_2__2
            {
            pushFollow(FOLLOW_23);
            rule__Responsibility__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__1"


    // $ANTLR start "rule__Responsibility__Group_2__1__Impl"
    // InternalMyDsl.g:3906:1: rule__Responsibility__Group_2__1__Impl : ( ( rule__Responsibility__Group_2_1__0 )* ) ;
    public final void rule__Responsibility__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3910:1: ( ( ( rule__Responsibility__Group_2_1__0 )* ) )
            // InternalMyDsl.g:3911:1: ( ( rule__Responsibility__Group_2_1__0 )* )
            {
            // InternalMyDsl.g:3911:1: ( ( rule__Responsibility__Group_2_1__0 )* )
            // InternalMyDsl.g:3912:2: ( rule__Responsibility__Group_2_1__0 )*
            {
             before(grammarAccess.getResponsibilityAccess().getGroup_2_1()); 
            // InternalMyDsl.g:3913:2: ( rule__Responsibility__Group_2_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==43) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalMyDsl.g:3913:3: rule__Responsibility__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Responsibility__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getResponsibilityAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__1__Impl"


    // $ANTLR start "rule__Responsibility__Group_2__2"
    // InternalMyDsl.g:3921:1: rule__Responsibility__Group_2__2 : rule__Responsibility__Group_2__2__Impl rule__Responsibility__Group_2__3 ;
    public final void rule__Responsibility__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3925:1: ( rule__Responsibility__Group_2__2__Impl rule__Responsibility__Group_2__3 )
            // InternalMyDsl.g:3926:2: rule__Responsibility__Group_2__2__Impl rule__Responsibility__Group_2__3
            {
            pushFollow(FOLLOW_24);
            rule__Responsibility__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__2"


    // $ANTLR start "rule__Responsibility__Group_2__2__Impl"
    // InternalMyDsl.g:3933:1: rule__Responsibility__Group_2__2__Impl : ( ( rule__Responsibility__ActionAssignment_2_2 ) ) ;
    public final void rule__Responsibility__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3937:1: ( ( ( rule__Responsibility__ActionAssignment_2_2 ) ) )
            // InternalMyDsl.g:3938:1: ( ( rule__Responsibility__ActionAssignment_2_2 ) )
            {
            // InternalMyDsl.g:3938:1: ( ( rule__Responsibility__ActionAssignment_2_2 ) )
            // InternalMyDsl.g:3939:2: ( rule__Responsibility__ActionAssignment_2_2 )
            {
             before(grammarAccess.getResponsibilityAccess().getActionAssignment_2_2()); 
            // InternalMyDsl.g:3940:2: ( rule__Responsibility__ActionAssignment_2_2 )
            // InternalMyDsl.g:3940:3: rule__Responsibility__ActionAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Responsibility__ActionAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getResponsibilityAccess().getActionAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__2__Impl"


    // $ANTLR start "rule__Responsibility__Group_2__3"
    // InternalMyDsl.g:3948:1: rule__Responsibility__Group_2__3 : rule__Responsibility__Group_2__3__Impl rule__Responsibility__Group_2__4 ;
    public final void rule__Responsibility__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3952:1: ( rule__Responsibility__Group_2__3__Impl rule__Responsibility__Group_2__4 )
            // InternalMyDsl.g:3953:2: rule__Responsibility__Group_2__3__Impl rule__Responsibility__Group_2__4
            {
            pushFollow(FOLLOW_25);
            rule__Responsibility__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__3"


    // $ANTLR start "rule__Responsibility__Group_2__3__Impl"
    // InternalMyDsl.g:3960:1: rule__Responsibility__Group_2__3__Impl : ( '::' ) ;
    public final void rule__Responsibility__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3964:1: ( ( '::' ) )
            // InternalMyDsl.g:3965:1: ( '::' )
            {
            // InternalMyDsl.g:3965:1: ( '::' )
            // InternalMyDsl.g:3966:2: '::'
            {
             before(grammarAccess.getResponsibilityAccess().getColonColonKeyword_2_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getResponsibilityAccess().getColonColonKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__3__Impl"


    // $ANTLR start "rule__Responsibility__Group_2__4"
    // InternalMyDsl.g:3975:1: rule__Responsibility__Group_2__4 : rule__Responsibility__Group_2__4__Impl rule__Responsibility__Group_2__5 ;
    public final void rule__Responsibility__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3979:1: ( rule__Responsibility__Group_2__4__Impl rule__Responsibility__Group_2__5 )
            // InternalMyDsl.g:3980:2: rule__Responsibility__Group_2__4__Impl rule__Responsibility__Group_2__5
            {
            pushFollow(FOLLOW_25);
            rule__Responsibility__Group_2__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__4"


    // $ANTLR start "rule__Responsibility__Group_2__4__Impl"
    // InternalMyDsl.g:3987:1: rule__Responsibility__Group_2__4__Impl : ( ( rule__Responsibility__OutcomeassetsAssignment_2_4 )? ) ;
    public final void rule__Responsibility__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3991:1: ( ( ( rule__Responsibility__OutcomeassetsAssignment_2_4 )? ) )
            // InternalMyDsl.g:3992:1: ( ( rule__Responsibility__OutcomeassetsAssignment_2_4 )? )
            {
            // InternalMyDsl.g:3992:1: ( ( rule__Responsibility__OutcomeassetsAssignment_2_4 )? )
            // InternalMyDsl.g:3993:2: ( rule__Responsibility__OutcomeassetsAssignment_2_4 )?
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssignment_2_4()); 
            // InternalMyDsl.g:3994:2: ( rule__Responsibility__OutcomeassetsAssignment_2_4 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalMyDsl.g:3994:3: rule__Responsibility__OutcomeassetsAssignment_2_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Responsibility__OutcomeassetsAssignment_2_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssignment_2_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__4__Impl"


    // $ANTLR start "rule__Responsibility__Group_2__5"
    // InternalMyDsl.g:4002:1: rule__Responsibility__Group_2__5 : rule__Responsibility__Group_2__5__Impl ;
    public final void rule__Responsibility__Group_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4006:1: ( rule__Responsibility__Group_2__5__Impl )
            // InternalMyDsl.g:4007:2: rule__Responsibility__Group_2__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__5"


    // $ANTLR start "rule__Responsibility__Group_2__5__Impl"
    // InternalMyDsl.g:4013:1: rule__Responsibility__Group_2__5__Impl : ( ( rule__Responsibility__Group_2_5__0 )* ) ;
    public final void rule__Responsibility__Group_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4017:1: ( ( ( rule__Responsibility__Group_2_5__0 )* ) )
            // InternalMyDsl.g:4018:1: ( ( rule__Responsibility__Group_2_5__0 )* )
            {
            // InternalMyDsl.g:4018:1: ( ( rule__Responsibility__Group_2_5__0 )* )
            // InternalMyDsl.g:4019:2: ( rule__Responsibility__Group_2_5__0 )*
            {
             before(grammarAccess.getResponsibilityAccess().getGroup_2_5()); 
            // InternalMyDsl.g:4020:2: ( rule__Responsibility__Group_2_5__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==43) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalMyDsl.g:4020:3: rule__Responsibility__Group_2_5__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Responsibility__Group_2_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getResponsibilityAccess().getGroup_2_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2__5__Impl"


    // $ANTLR start "rule__Responsibility__Group_2_1__0"
    // InternalMyDsl.g:4029:1: rule__Responsibility__Group_2_1__0 : rule__Responsibility__Group_2_1__0__Impl rule__Responsibility__Group_2_1__1 ;
    public final void rule__Responsibility__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4033:1: ( rule__Responsibility__Group_2_1__0__Impl rule__Responsibility__Group_2_1__1 )
            // InternalMyDsl.g:4034:2: rule__Responsibility__Group_2_1__0__Impl rule__Responsibility__Group_2_1__1
            {
            pushFollow(FOLLOW_4);
            rule__Responsibility__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2_1__0"


    // $ANTLR start "rule__Responsibility__Group_2_1__0__Impl"
    // InternalMyDsl.g:4041:1: rule__Responsibility__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__Responsibility__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4045:1: ( ( ',' ) )
            // InternalMyDsl.g:4046:1: ( ',' )
            {
            // InternalMyDsl.g:4046:1: ( ',' )
            // InternalMyDsl.g:4047:2: ','
            {
             before(grammarAccess.getResponsibilityAccess().getCommaKeyword_2_1_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getResponsibilityAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2_1__0__Impl"


    // $ANTLR start "rule__Responsibility__Group_2_1__1"
    // InternalMyDsl.g:4056:1: rule__Responsibility__Group_2_1__1 : rule__Responsibility__Group_2_1__1__Impl ;
    public final void rule__Responsibility__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4060:1: ( rule__Responsibility__Group_2_1__1__Impl )
            // InternalMyDsl.g:4061:2: rule__Responsibility__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2_1__1"


    // $ANTLR start "rule__Responsibility__Group_2_1__1__Impl"
    // InternalMyDsl.g:4067:1: rule__Responsibility__Group_2_1__1__Impl : ( ( rule__Responsibility__IncomeassetsAssignment_2_1_1 ) ) ;
    public final void rule__Responsibility__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4071:1: ( ( ( rule__Responsibility__IncomeassetsAssignment_2_1_1 ) ) )
            // InternalMyDsl.g:4072:1: ( ( rule__Responsibility__IncomeassetsAssignment_2_1_1 ) )
            {
            // InternalMyDsl.g:4072:1: ( ( rule__Responsibility__IncomeassetsAssignment_2_1_1 ) )
            // InternalMyDsl.g:4073:2: ( rule__Responsibility__IncomeassetsAssignment_2_1_1 )
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssignment_2_1_1()); 
            // InternalMyDsl.g:4074:2: ( rule__Responsibility__IncomeassetsAssignment_2_1_1 )
            // InternalMyDsl.g:4074:3: rule__Responsibility__IncomeassetsAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Responsibility__IncomeassetsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getResponsibilityAccess().getIncomeassetsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2_1__1__Impl"


    // $ANTLR start "rule__Responsibility__Group_2_5__0"
    // InternalMyDsl.g:4083:1: rule__Responsibility__Group_2_5__0 : rule__Responsibility__Group_2_5__0__Impl rule__Responsibility__Group_2_5__1 ;
    public final void rule__Responsibility__Group_2_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4087:1: ( rule__Responsibility__Group_2_5__0__Impl rule__Responsibility__Group_2_5__1 )
            // InternalMyDsl.g:4088:2: rule__Responsibility__Group_2_5__0__Impl rule__Responsibility__Group_2_5__1
            {
            pushFollow(FOLLOW_4);
            rule__Responsibility__Group_2_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2_5__0"


    // $ANTLR start "rule__Responsibility__Group_2_5__0__Impl"
    // InternalMyDsl.g:4095:1: rule__Responsibility__Group_2_5__0__Impl : ( ',' ) ;
    public final void rule__Responsibility__Group_2_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4099:1: ( ( ',' ) )
            // InternalMyDsl.g:4100:1: ( ',' )
            {
            // InternalMyDsl.g:4100:1: ( ',' )
            // InternalMyDsl.g:4101:2: ','
            {
             before(grammarAccess.getResponsibilityAccess().getCommaKeyword_2_5_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getResponsibilityAccess().getCommaKeyword_2_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2_5__0__Impl"


    // $ANTLR start "rule__Responsibility__Group_2_5__1"
    // InternalMyDsl.g:4110:1: rule__Responsibility__Group_2_5__1 : rule__Responsibility__Group_2_5__1__Impl ;
    public final void rule__Responsibility__Group_2_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4114:1: ( rule__Responsibility__Group_2_5__1__Impl )
            // InternalMyDsl.g:4115:2: rule__Responsibility__Group_2_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Responsibility__Group_2_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2_5__1"


    // $ANTLR start "rule__Responsibility__Group_2_5__1__Impl"
    // InternalMyDsl.g:4121:1: rule__Responsibility__Group_2_5__1__Impl : ( ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 ) ) ;
    public final void rule__Responsibility__Group_2_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4125:1: ( ( ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 ) ) )
            // InternalMyDsl.g:4126:1: ( ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 ) )
            {
            // InternalMyDsl.g:4126:1: ( ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 ) )
            // InternalMyDsl.g:4127:2: ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 )
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssignment_2_5_1()); 
            // InternalMyDsl.g:4128:2: ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 )
            // InternalMyDsl.g:4128:3: rule__Responsibility__OutcomeassetsAssignment_2_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Responsibility__OutcomeassetsAssignment_2_5_1();

            state._fsp--;


            }

             after(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssignment_2_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__Group_2_5__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__0"
    // InternalMyDsl.g:4137:1: rule__ExternalEntity__Group__0 : rule__ExternalEntity__Group__0__Impl rule__ExternalEntity__Group__1 ;
    public final void rule__ExternalEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4141:1: ( rule__ExternalEntity__Group__0__Impl rule__ExternalEntity__Group__1 )
            // InternalMyDsl.g:4142:2: rule__ExternalEntity__Group__0__Impl rule__ExternalEntity__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__ExternalEntity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__0"


    // $ANTLR start "rule__ExternalEntity__Group__0__Impl"
    // InternalMyDsl.g:4149:1: rule__ExternalEntity__Group__0__Impl : ( () ) ;
    public final void rule__ExternalEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4153:1: ( ( () ) )
            // InternalMyDsl.g:4154:1: ( () )
            {
            // InternalMyDsl.g:4154:1: ( () )
            // InternalMyDsl.g:4155:2: ()
            {
             before(grammarAccess.getExternalEntityAccess().getExternalEntityAction_0()); 
            // InternalMyDsl.g:4156:2: ()
            // InternalMyDsl.g:4156:3: 
            {
            }

             after(grammarAccess.getExternalEntityAccess().getExternalEntityAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__1"
    // InternalMyDsl.g:4164:1: rule__ExternalEntity__Group__1 : rule__ExternalEntity__Group__1__Impl rule__ExternalEntity__Group__2 ;
    public final void rule__ExternalEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4168:1: ( rule__ExternalEntity__Group__1__Impl rule__ExternalEntity__Group__2 )
            // InternalMyDsl.g:4169:2: rule__ExternalEntity__Group__1__Impl rule__ExternalEntity__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ExternalEntity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__1"


    // $ANTLR start "rule__ExternalEntity__Group__1__Impl"
    // InternalMyDsl.g:4176:1: rule__ExternalEntity__Group__1__Impl : ( 'ExternalEntity' ) ;
    public final void rule__ExternalEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4180:1: ( ( 'ExternalEntity' ) )
            // InternalMyDsl.g:4181:1: ( 'ExternalEntity' )
            {
            // InternalMyDsl.g:4181:1: ( 'ExternalEntity' )
            // InternalMyDsl.g:4182:2: 'ExternalEntity'
            {
             before(grammarAccess.getExternalEntityAccess().getExternalEntityKeyword_1()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getExternalEntityKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__2"
    // InternalMyDsl.g:4191:1: rule__ExternalEntity__Group__2 : rule__ExternalEntity__Group__2__Impl rule__ExternalEntity__Group__3 ;
    public final void rule__ExternalEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4195:1: ( rule__ExternalEntity__Group__2__Impl rule__ExternalEntity__Group__3 )
            // InternalMyDsl.g:4196:2: rule__ExternalEntity__Group__2__Impl rule__ExternalEntity__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__ExternalEntity__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__2"


    // $ANTLR start "rule__ExternalEntity__Group__2__Impl"
    // InternalMyDsl.g:4203:1: rule__ExternalEntity__Group__2__Impl : ( ( rule__ExternalEntity__NameAssignment_2 ) ) ;
    public final void rule__ExternalEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4207:1: ( ( ( rule__ExternalEntity__NameAssignment_2 ) ) )
            // InternalMyDsl.g:4208:1: ( ( rule__ExternalEntity__NameAssignment_2 ) )
            {
            // InternalMyDsl.g:4208:1: ( ( rule__ExternalEntity__NameAssignment_2 ) )
            // InternalMyDsl.g:4209:2: ( rule__ExternalEntity__NameAssignment_2 )
            {
             before(grammarAccess.getExternalEntityAccess().getNameAssignment_2()); 
            // InternalMyDsl.g:4210:2: ( rule__ExternalEntity__NameAssignment_2 )
            // InternalMyDsl.g:4210:3: rule__ExternalEntity__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__2__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__3"
    // InternalMyDsl.g:4218:1: rule__ExternalEntity__Group__3 : rule__ExternalEntity__Group__3__Impl rule__ExternalEntity__Group__4 ;
    public final void rule__ExternalEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4222:1: ( rule__ExternalEntity__Group__3__Impl rule__ExternalEntity__Group__4 )
            // InternalMyDsl.g:4223:2: rule__ExternalEntity__Group__3__Impl rule__ExternalEntity__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__ExternalEntity__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__3"


    // $ANTLR start "rule__ExternalEntity__Group__3__Impl"
    // InternalMyDsl.g:4230:1: rule__ExternalEntity__Group__3__Impl : ( '[' ) ;
    public final void rule__ExternalEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4234:1: ( ( '[' ) )
            // InternalMyDsl.g:4235:1: ( '[' )
            {
            // InternalMyDsl.g:4235:1: ( '[' )
            // InternalMyDsl.g:4236:2: '['
            {
             before(grammarAccess.getExternalEntityAccess().getLeftSquareBracketKeyword_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__3__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__4"
    // InternalMyDsl.g:4245:1: rule__ExternalEntity__Group__4 : rule__ExternalEntity__Group__4__Impl rule__ExternalEntity__Group__5 ;
    public final void rule__ExternalEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4249:1: ( rule__ExternalEntity__Group__4__Impl rule__ExternalEntity__Group__5 )
            // InternalMyDsl.g:4250:2: rule__ExternalEntity__Group__4__Impl rule__ExternalEntity__Group__5
            {
            pushFollow(FOLLOW_27);
            rule__ExternalEntity__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__4"


    // $ANTLR start "rule__ExternalEntity__Group__4__Impl"
    // InternalMyDsl.g:4257:1: rule__ExternalEntity__Group__4__Impl : ( ( rule__ExternalEntity__Group_4__0 )? ) ;
    public final void rule__ExternalEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4261:1: ( ( ( rule__ExternalEntity__Group_4__0 )? ) )
            // InternalMyDsl.g:4262:1: ( ( rule__ExternalEntity__Group_4__0 )? )
            {
            // InternalMyDsl.g:4262:1: ( ( rule__ExternalEntity__Group_4__0 )? )
            // InternalMyDsl.g:4263:2: ( rule__ExternalEntity__Group_4__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_4()); 
            // InternalMyDsl.g:4264:2: ( rule__ExternalEntity__Group_4__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==42) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalMyDsl.g:4264:3: rule__ExternalEntity__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExternalEntity__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExternalEntityAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__4__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__5"
    // InternalMyDsl.g:4272:1: rule__ExternalEntity__Group__5 : rule__ExternalEntity__Group__5__Impl rule__ExternalEntity__Group__6 ;
    public final void rule__ExternalEntity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4276:1: ( rule__ExternalEntity__Group__5__Impl rule__ExternalEntity__Group__6 )
            // InternalMyDsl.g:4277:2: rule__ExternalEntity__Group__5__Impl rule__ExternalEntity__Group__6
            {
            pushFollow(FOLLOW_27);
            rule__ExternalEntity__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__5"


    // $ANTLR start "rule__ExternalEntity__Group__5__Impl"
    // InternalMyDsl.g:4284:1: rule__ExternalEntity__Group__5__Impl : ( ( rule__ExternalEntity__Group_5__0 )? ) ;
    public final void rule__ExternalEntity__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4288:1: ( ( ( rule__ExternalEntity__Group_5__0 )? ) )
            // InternalMyDsl.g:4289:1: ( ( rule__ExternalEntity__Group_5__0 )? )
            {
            // InternalMyDsl.g:4289:1: ( ( rule__ExternalEntity__Group_5__0 )? )
            // InternalMyDsl.g:4290:2: ( rule__ExternalEntity__Group_5__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_5()); 
            // InternalMyDsl.g:4291:2: ( rule__ExternalEntity__Group_5__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==57) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMyDsl.g:4291:3: rule__ExternalEntity__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExternalEntity__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExternalEntityAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__5__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__6"
    // InternalMyDsl.g:4299:1: rule__ExternalEntity__Group__6 : rule__ExternalEntity__Group__6__Impl rule__ExternalEntity__Group__7 ;
    public final void rule__ExternalEntity__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4303:1: ( rule__ExternalEntity__Group__6__Impl rule__ExternalEntity__Group__7 )
            // InternalMyDsl.g:4304:2: rule__ExternalEntity__Group__6__Impl rule__ExternalEntity__Group__7
            {
            pushFollow(FOLLOW_27);
            rule__ExternalEntity__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__6"


    // $ANTLR start "rule__ExternalEntity__Group__6__Impl"
    // InternalMyDsl.g:4311:1: rule__ExternalEntity__Group__6__Impl : ( ( rule__ExternalEntity__Group_6__0 )? ) ;
    public final void rule__ExternalEntity__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4315:1: ( ( ( rule__ExternalEntity__Group_6__0 )? ) )
            // InternalMyDsl.g:4316:1: ( ( rule__ExternalEntity__Group_6__0 )? )
            {
            // InternalMyDsl.g:4316:1: ( ( rule__ExternalEntity__Group_6__0 )? )
            // InternalMyDsl.g:4317:2: ( rule__ExternalEntity__Group_6__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_6()); 
            // InternalMyDsl.g:4318:2: ( rule__ExternalEntity__Group_6__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==58) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalMyDsl.g:4318:3: rule__ExternalEntity__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExternalEntity__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExternalEntityAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__6__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__7"
    // InternalMyDsl.g:4326:1: rule__ExternalEntity__Group__7 : rule__ExternalEntity__Group__7__Impl rule__ExternalEntity__Group__8 ;
    public final void rule__ExternalEntity__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4330:1: ( rule__ExternalEntity__Group__7__Impl rule__ExternalEntity__Group__8 )
            // InternalMyDsl.g:4331:2: rule__ExternalEntity__Group__7__Impl rule__ExternalEntity__Group__8
            {
            pushFollow(FOLLOW_27);
            rule__ExternalEntity__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__7"


    // $ANTLR start "rule__ExternalEntity__Group__7__Impl"
    // InternalMyDsl.g:4338:1: rule__ExternalEntity__Group__7__Impl : ( ( rule__ExternalEntity__Group_7__0 )? ) ;
    public final void rule__ExternalEntity__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4342:1: ( ( ( rule__ExternalEntity__Group_7__0 )? ) )
            // InternalMyDsl.g:4343:1: ( ( rule__ExternalEntity__Group_7__0 )? )
            {
            // InternalMyDsl.g:4343:1: ( ( rule__ExternalEntity__Group_7__0 )? )
            // InternalMyDsl.g:4344:2: ( rule__ExternalEntity__Group_7__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_7()); 
            // InternalMyDsl.g:4345:2: ( rule__ExternalEntity__Group_7__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==60) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalMyDsl.g:4345:3: rule__ExternalEntity__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExternalEntity__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExternalEntityAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__7__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__8"
    // InternalMyDsl.g:4353:1: rule__ExternalEntity__Group__8 : rule__ExternalEntity__Group__8__Impl rule__ExternalEntity__Group__9 ;
    public final void rule__ExternalEntity__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4357:1: ( rule__ExternalEntity__Group__8__Impl rule__ExternalEntity__Group__9 )
            // InternalMyDsl.g:4358:2: rule__ExternalEntity__Group__8__Impl rule__ExternalEntity__Group__9
            {
            pushFollow(FOLLOW_27);
            rule__ExternalEntity__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__8"


    // $ANTLR start "rule__ExternalEntity__Group__8__Impl"
    // InternalMyDsl.g:4365:1: rule__ExternalEntity__Group__8__Impl : ( ( rule__ExternalEntity__Group_8__0 )? ) ;
    public final void rule__ExternalEntity__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4369:1: ( ( ( rule__ExternalEntity__Group_8__0 )? ) )
            // InternalMyDsl.g:4370:1: ( ( rule__ExternalEntity__Group_8__0 )? )
            {
            // InternalMyDsl.g:4370:1: ( ( rule__ExternalEntity__Group_8__0 )? )
            // InternalMyDsl.g:4371:2: ( rule__ExternalEntity__Group_8__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_8()); 
            // InternalMyDsl.g:4372:2: ( rule__ExternalEntity__Group_8__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==61) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalMyDsl.g:4372:3: rule__ExternalEntity__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExternalEntity__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExternalEntityAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__8__Impl"


    // $ANTLR start "rule__ExternalEntity__Group__9"
    // InternalMyDsl.g:4380:1: rule__ExternalEntity__Group__9 : rule__ExternalEntity__Group__9__Impl ;
    public final void rule__ExternalEntity__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4384:1: ( rule__ExternalEntity__Group__9__Impl )
            // InternalMyDsl.g:4385:2: rule__ExternalEntity__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__9"


    // $ANTLR start "rule__ExternalEntity__Group__9__Impl"
    // InternalMyDsl.g:4391:1: rule__ExternalEntity__Group__9__Impl : ( ']' ) ;
    public final void rule__ExternalEntity__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4395:1: ( ( ']' ) )
            // InternalMyDsl.g:4396:1: ( ']' )
            {
            // InternalMyDsl.g:4396:1: ( ']' )
            // InternalMyDsl.g:4397:2: ']'
            {
             before(grammarAccess.getExternalEntityAccess().getRightSquareBracketKeyword_9()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getRightSquareBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group__9__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_4__0"
    // InternalMyDsl.g:4407:1: rule__ExternalEntity__Group_4__0 : rule__ExternalEntity__Group_4__0__Impl rule__ExternalEntity__Group_4__1 ;
    public final void rule__ExternalEntity__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4411:1: ( rule__ExternalEntity__Group_4__0__Impl rule__ExternalEntity__Group_4__1 )
            // InternalMyDsl.g:4412:2: rule__ExternalEntity__Group_4__0__Impl rule__ExternalEntity__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__ExternalEntity__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4__0"


    // $ANTLR start "rule__ExternalEntity__Group_4__0__Impl"
    // InternalMyDsl.g:4419:1: rule__ExternalEntity__Group_4__0__Impl : ( 'assets:' ) ;
    public final void rule__ExternalEntity__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4423:1: ( ( 'assets:' ) )
            // InternalMyDsl.g:4424:1: ( 'assets:' )
            {
            // InternalMyDsl.g:4424:1: ( 'assets:' )
            // InternalMyDsl.g:4425:2: 'assets:'
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsKeyword_4_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getAssetsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_4__1"
    // InternalMyDsl.g:4434:1: rule__ExternalEntity__Group_4__1 : rule__ExternalEntity__Group_4__1__Impl rule__ExternalEntity__Group_4__2 ;
    public final void rule__ExternalEntity__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4438:1: ( rule__ExternalEntity__Group_4__1__Impl rule__ExternalEntity__Group_4__2 )
            // InternalMyDsl.g:4439:2: rule__ExternalEntity__Group_4__1__Impl rule__ExternalEntity__Group_4__2
            {
            pushFollow(FOLLOW_8);
            rule__ExternalEntity__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4__1"


    // $ANTLR start "rule__ExternalEntity__Group_4__1__Impl"
    // InternalMyDsl.g:4446:1: rule__ExternalEntity__Group_4__1__Impl : ( ( rule__ExternalEntity__AssetsAssignment_4_1 ) ) ;
    public final void rule__ExternalEntity__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4450:1: ( ( ( rule__ExternalEntity__AssetsAssignment_4_1 ) ) )
            // InternalMyDsl.g:4451:1: ( ( rule__ExternalEntity__AssetsAssignment_4_1 ) )
            {
            // InternalMyDsl.g:4451:1: ( ( rule__ExternalEntity__AssetsAssignment_4_1 ) )
            // InternalMyDsl.g:4452:2: ( rule__ExternalEntity__AssetsAssignment_4_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssignment_4_1()); 
            // InternalMyDsl.g:4453:2: ( rule__ExternalEntity__AssetsAssignment_4_1 )
            // InternalMyDsl.g:4453:3: rule__ExternalEntity__AssetsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__AssetsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getAssetsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_4__2"
    // InternalMyDsl.g:4461:1: rule__ExternalEntity__Group_4__2 : rule__ExternalEntity__Group_4__2__Impl ;
    public final void rule__ExternalEntity__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4465:1: ( rule__ExternalEntity__Group_4__2__Impl )
            // InternalMyDsl.g:4466:2: rule__ExternalEntity__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4__2"


    // $ANTLR start "rule__ExternalEntity__Group_4__2__Impl"
    // InternalMyDsl.g:4472:1: rule__ExternalEntity__Group_4__2__Impl : ( ( rule__ExternalEntity__Group_4_2__0 )* ) ;
    public final void rule__ExternalEntity__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4476:1: ( ( ( rule__ExternalEntity__Group_4_2__0 )* ) )
            // InternalMyDsl.g:4477:1: ( ( rule__ExternalEntity__Group_4_2__0 )* )
            {
            // InternalMyDsl.g:4477:1: ( ( rule__ExternalEntity__Group_4_2__0 )* )
            // InternalMyDsl.g:4478:2: ( rule__ExternalEntity__Group_4_2__0 )*
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_4_2()); 
            // InternalMyDsl.g:4479:2: ( rule__ExternalEntity__Group_4_2__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==43) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalMyDsl.g:4479:3: rule__ExternalEntity__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ExternalEntity__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getExternalEntityAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4__2__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_4_2__0"
    // InternalMyDsl.g:4488:1: rule__ExternalEntity__Group_4_2__0 : rule__ExternalEntity__Group_4_2__0__Impl rule__ExternalEntity__Group_4_2__1 ;
    public final void rule__ExternalEntity__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4492:1: ( rule__ExternalEntity__Group_4_2__0__Impl rule__ExternalEntity__Group_4_2__1 )
            // InternalMyDsl.g:4493:2: rule__ExternalEntity__Group_4_2__0__Impl rule__ExternalEntity__Group_4_2__1
            {
            pushFollow(FOLLOW_4);
            rule__ExternalEntity__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4_2__0"


    // $ANTLR start "rule__ExternalEntity__Group_4_2__0__Impl"
    // InternalMyDsl.g:4500:1: rule__ExternalEntity__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__ExternalEntity__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4504:1: ( ( ',' ) )
            // InternalMyDsl.g:4505:1: ( ',' )
            {
            // InternalMyDsl.g:4505:1: ( ',' )
            // InternalMyDsl.g:4506:2: ','
            {
             before(grammarAccess.getExternalEntityAccess().getCommaKeyword_4_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4_2__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_4_2__1"
    // InternalMyDsl.g:4515:1: rule__ExternalEntity__Group_4_2__1 : rule__ExternalEntity__Group_4_2__1__Impl ;
    public final void rule__ExternalEntity__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4519:1: ( rule__ExternalEntity__Group_4_2__1__Impl )
            // InternalMyDsl.g:4520:2: rule__ExternalEntity__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4_2__1"


    // $ANTLR start "rule__ExternalEntity__Group_4_2__1__Impl"
    // InternalMyDsl.g:4526:1: rule__ExternalEntity__Group_4_2__1__Impl : ( ( rule__ExternalEntity__AssetsAssignment_4_2_1 ) ) ;
    public final void rule__ExternalEntity__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4530:1: ( ( ( rule__ExternalEntity__AssetsAssignment_4_2_1 ) ) )
            // InternalMyDsl.g:4531:1: ( ( rule__ExternalEntity__AssetsAssignment_4_2_1 ) )
            {
            // InternalMyDsl.g:4531:1: ( ( rule__ExternalEntity__AssetsAssignment_4_2_1 ) )
            // InternalMyDsl.g:4532:2: ( rule__ExternalEntity__AssetsAssignment_4_2_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssignment_4_2_1()); 
            // InternalMyDsl.g:4533:2: ( rule__ExternalEntity__AssetsAssignment_4_2_1 )
            // InternalMyDsl.g:4533:3: rule__ExternalEntity__AssetsAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__AssetsAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getAssetsAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_4_2__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_5__0"
    // InternalMyDsl.g:4542:1: rule__ExternalEntity__Group_5__0 : rule__ExternalEntity__Group_5__0__Impl rule__ExternalEntity__Group_5__1 ;
    public final void rule__ExternalEntity__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4546:1: ( rule__ExternalEntity__Group_5__0__Impl rule__ExternalEntity__Group_5__1 )
            // InternalMyDsl.g:4547:2: rule__ExternalEntity__Group_5__0__Impl rule__ExternalEntity__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__ExternalEntity__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5__0"


    // $ANTLR start "rule__ExternalEntity__Group_5__0__Impl"
    // InternalMyDsl.g:4554:1: rule__ExternalEntity__Group_5__0__Impl : ( 'assumption:' ) ;
    public final void rule__ExternalEntity__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4558:1: ( ( 'assumption:' ) )
            // InternalMyDsl.g:4559:1: ( 'assumption:' )
            {
            // InternalMyDsl.g:4559:1: ( 'assumption:' )
            // InternalMyDsl.g:4560:2: 'assumption:'
            {
             before(grammarAccess.getExternalEntityAccess().getAssumptionKeyword_5_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getAssumptionKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_5__1"
    // InternalMyDsl.g:4569:1: rule__ExternalEntity__Group_5__1 : rule__ExternalEntity__Group_5__1__Impl rule__ExternalEntity__Group_5__2 ;
    public final void rule__ExternalEntity__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4573:1: ( rule__ExternalEntity__Group_5__1__Impl rule__ExternalEntity__Group_5__2 )
            // InternalMyDsl.g:4574:2: rule__ExternalEntity__Group_5__1__Impl rule__ExternalEntity__Group_5__2
            {
            pushFollow(FOLLOW_8);
            rule__ExternalEntity__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5__1"


    // $ANTLR start "rule__ExternalEntity__Group_5__1__Impl"
    // InternalMyDsl.g:4581:1: rule__ExternalEntity__Group_5__1__Impl : ( ( rule__ExternalEntity__AssumptionAssignment_5_1 ) ) ;
    public final void rule__ExternalEntity__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4585:1: ( ( ( rule__ExternalEntity__AssumptionAssignment_5_1 ) ) )
            // InternalMyDsl.g:4586:1: ( ( rule__ExternalEntity__AssumptionAssignment_5_1 ) )
            {
            // InternalMyDsl.g:4586:1: ( ( rule__ExternalEntity__AssumptionAssignment_5_1 ) )
            // InternalMyDsl.g:4587:2: ( rule__ExternalEntity__AssumptionAssignment_5_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAssumptionAssignment_5_1()); 
            // InternalMyDsl.g:4588:2: ( rule__ExternalEntity__AssumptionAssignment_5_1 )
            // InternalMyDsl.g:4588:3: rule__ExternalEntity__AssumptionAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__AssumptionAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getAssumptionAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_5__2"
    // InternalMyDsl.g:4596:1: rule__ExternalEntity__Group_5__2 : rule__ExternalEntity__Group_5__2__Impl ;
    public final void rule__ExternalEntity__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4600:1: ( rule__ExternalEntity__Group_5__2__Impl )
            // InternalMyDsl.g:4601:2: rule__ExternalEntity__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5__2"


    // $ANTLR start "rule__ExternalEntity__Group_5__2__Impl"
    // InternalMyDsl.g:4607:1: rule__ExternalEntity__Group_5__2__Impl : ( ( rule__ExternalEntity__Group_5_2__0 )* ) ;
    public final void rule__ExternalEntity__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4611:1: ( ( ( rule__ExternalEntity__Group_5_2__0 )* ) )
            // InternalMyDsl.g:4612:1: ( ( rule__ExternalEntity__Group_5_2__0 )* )
            {
            // InternalMyDsl.g:4612:1: ( ( rule__ExternalEntity__Group_5_2__0 )* )
            // InternalMyDsl.g:4613:2: ( rule__ExternalEntity__Group_5_2__0 )*
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_5_2()); 
            // InternalMyDsl.g:4614:2: ( rule__ExternalEntity__Group_5_2__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==43) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalMyDsl.g:4614:3: rule__ExternalEntity__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ExternalEntity__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getExternalEntityAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5__2__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_5_2__0"
    // InternalMyDsl.g:4623:1: rule__ExternalEntity__Group_5_2__0 : rule__ExternalEntity__Group_5_2__0__Impl rule__ExternalEntity__Group_5_2__1 ;
    public final void rule__ExternalEntity__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4627:1: ( rule__ExternalEntity__Group_5_2__0__Impl rule__ExternalEntity__Group_5_2__1 )
            // InternalMyDsl.g:4628:2: rule__ExternalEntity__Group_5_2__0__Impl rule__ExternalEntity__Group_5_2__1
            {
            pushFollow(FOLLOW_5);
            rule__ExternalEntity__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_5_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5_2__0"


    // $ANTLR start "rule__ExternalEntity__Group_5_2__0__Impl"
    // InternalMyDsl.g:4635:1: rule__ExternalEntity__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__ExternalEntity__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4639:1: ( ( ',' ) )
            // InternalMyDsl.g:4640:1: ( ',' )
            {
            // InternalMyDsl.g:4640:1: ( ',' )
            // InternalMyDsl.g:4641:2: ','
            {
             before(grammarAccess.getExternalEntityAccess().getCommaKeyword_5_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getCommaKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5_2__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_5_2__1"
    // InternalMyDsl.g:4650:1: rule__ExternalEntity__Group_5_2__1 : rule__ExternalEntity__Group_5_2__1__Impl ;
    public final void rule__ExternalEntity__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4654:1: ( rule__ExternalEntity__Group_5_2__1__Impl )
            // InternalMyDsl.g:4655:2: rule__ExternalEntity__Group_5_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_5_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5_2__1"


    // $ANTLR start "rule__ExternalEntity__Group_5_2__1__Impl"
    // InternalMyDsl.g:4661:1: rule__ExternalEntity__Group_5_2__1__Impl : ( ( rule__ExternalEntity__AssumptionAssignment_5_2_1 ) ) ;
    public final void rule__ExternalEntity__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4665:1: ( ( ( rule__ExternalEntity__AssumptionAssignment_5_2_1 ) ) )
            // InternalMyDsl.g:4666:1: ( ( rule__ExternalEntity__AssumptionAssignment_5_2_1 ) )
            {
            // InternalMyDsl.g:4666:1: ( ( rule__ExternalEntity__AssumptionAssignment_5_2_1 ) )
            // InternalMyDsl.g:4667:2: ( rule__ExternalEntity__AssumptionAssignment_5_2_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAssumptionAssignment_5_2_1()); 
            // InternalMyDsl.g:4668:2: ( rule__ExternalEntity__AssumptionAssignment_5_2_1 )
            // InternalMyDsl.g:4668:3: rule__ExternalEntity__AssumptionAssignment_5_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__AssumptionAssignment_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getAssumptionAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_5_2__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_6__0"
    // InternalMyDsl.g:4677:1: rule__ExternalEntity__Group_6__0 : rule__ExternalEntity__Group_6__0__Impl rule__ExternalEntity__Group_6__1 ;
    public final void rule__ExternalEntity__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4681:1: ( rule__ExternalEntity__Group_6__0__Impl rule__ExternalEntity__Group_6__1 )
            // InternalMyDsl.g:4682:2: rule__ExternalEntity__Group_6__0__Impl rule__ExternalEntity__Group_6__1
            {
            pushFollow(FOLLOW_20);
            rule__ExternalEntity__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6__0"


    // $ANTLR start "rule__ExternalEntity__Group_6__0__Impl"
    // InternalMyDsl.g:4689:1: rule__ExternalEntity__Group_6__0__Impl : ( 'incoming' ) ;
    public final void rule__ExternalEntity__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4693:1: ( ( 'incoming' ) )
            // InternalMyDsl.g:4694:1: ( 'incoming' )
            {
            // InternalMyDsl.g:4694:1: ( 'incoming' )
            // InternalMyDsl.g:4695:2: 'incoming'
            {
             before(grammarAccess.getExternalEntityAccess().getIncomingKeyword_6_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getIncomingKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_6__1"
    // InternalMyDsl.g:4704:1: rule__ExternalEntity__Group_6__1 : rule__ExternalEntity__Group_6__1__Impl rule__ExternalEntity__Group_6__2 ;
    public final void rule__ExternalEntity__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4708:1: ( rule__ExternalEntity__Group_6__1__Impl rule__ExternalEntity__Group_6__2 )
            // InternalMyDsl.g:4709:2: rule__ExternalEntity__Group_6__1__Impl rule__ExternalEntity__Group_6__2
            {
            pushFollow(FOLLOW_4);
            rule__ExternalEntity__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6__1"


    // $ANTLR start "rule__ExternalEntity__Group_6__1__Impl"
    // InternalMyDsl.g:4716:1: rule__ExternalEntity__Group_6__1__Impl : ( 'flows:' ) ;
    public final void rule__ExternalEntity__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4720:1: ( ( 'flows:' ) )
            // InternalMyDsl.g:4721:1: ( 'flows:' )
            {
            // InternalMyDsl.g:4721:1: ( 'flows:' )
            // InternalMyDsl.g:4722:2: 'flows:'
            {
             before(grammarAccess.getExternalEntityAccess().getFlowsKeyword_6_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getFlowsKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_6__2"
    // InternalMyDsl.g:4731:1: rule__ExternalEntity__Group_6__2 : rule__ExternalEntity__Group_6__2__Impl rule__ExternalEntity__Group_6__3 ;
    public final void rule__ExternalEntity__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4735:1: ( rule__ExternalEntity__Group_6__2__Impl rule__ExternalEntity__Group_6__3 )
            // InternalMyDsl.g:4736:2: rule__ExternalEntity__Group_6__2__Impl rule__ExternalEntity__Group_6__3
            {
            pushFollow(FOLLOW_8);
            rule__ExternalEntity__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6__2"


    // $ANTLR start "rule__ExternalEntity__Group_6__2__Impl"
    // InternalMyDsl.g:4743:1: rule__ExternalEntity__Group_6__2__Impl : ( ( rule__ExternalEntity__InflowsAssignment_6_2 ) ) ;
    public final void rule__ExternalEntity__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4747:1: ( ( ( rule__ExternalEntity__InflowsAssignment_6_2 ) ) )
            // InternalMyDsl.g:4748:1: ( ( rule__ExternalEntity__InflowsAssignment_6_2 ) )
            {
            // InternalMyDsl.g:4748:1: ( ( rule__ExternalEntity__InflowsAssignment_6_2 ) )
            // InternalMyDsl.g:4749:2: ( rule__ExternalEntity__InflowsAssignment_6_2 )
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsAssignment_6_2()); 
            // InternalMyDsl.g:4750:2: ( rule__ExternalEntity__InflowsAssignment_6_2 )
            // InternalMyDsl.g:4750:3: rule__ExternalEntity__InflowsAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__InflowsAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getInflowsAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6__2__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_6__3"
    // InternalMyDsl.g:4758:1: rule__ExternalEntity__Group_6__3 : rule__ExternalEntity__Group_6__3__Impl ;
    public final void rule__ExternalEntity__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4762:1: ( rule__ExternalEntity__Group_6__3__Impl )
            // InternalMyDsl.g:4763:2: rule__ExternalEntity__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_6__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6__3"


    // $ANTLR start "rule__ExternalEntity__Group_6__3__Impl"
    // InternalMyDsl.g:4769:1: rule__ExternalEntity__Group_6__3__Impl : ( ( rule__ExternalEntity__Group_6_3__0 )* ) ;
    public final void rule__ExternalEntity__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4773:1: ( ( ( rule__ExternalEntity__Group_6_3__0 )* ) )
            // InternalMyDsl.g:4774:1: ( ( rule__ExternalEntity__Group_6_3__0 )* )
            {
            // InternalMyDsl.g:4774:1: ( ( rule__ExternalEntity__Group_6_3__0 )* )
            // InternalMyDsl.g:4775:2: ( rule__ExternalEntity__Group_6_3__0 )*
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_6_3()); 
            // InternalMyDsl.g:4776:2: ( rule__ExternalEntity__Group_6_3__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==43) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalMyDsl.g:4776:3: rule__ExternalEntity__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ExternalEntity__Group_6_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getExternalEntityAccess().getGroup_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6__3__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_6_3__0"
    // InternalMyDsl.g:4785:1: rule__ExternalEntity__Group_6_3__0 : rule__ExternalEntity__Group_6_3__0__Impl rule__ExternalEntity__Group_6_3__1 ;
    public final void rule__ExternalEntity__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4789:1: ( rule__ExternalEntity__Group_6_3__0__Impl rule__ExternalEntity__Group_6_3__1 )
            // InternalMyDsl.g:4790:2: rule__ExternalEntity__Group_6_3__0__Impl rule__ExternalEntity__Group_6_3__1
            {
            pushFollow(FOLLOW_4);
            rule__ExternalEntity__Group_6_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_6_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6_3__0"


    // $ANTLR start "rule__ExternalEntity__Group_6_3__0__Impl"
    // InternalMyDsl.g:4797:1: rule__ExternalEntity__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__ExternalEntity__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4801:1: ( ( ',' ) )
            // InternalMyDsl.g:4802:1: ( ',' )
            {
            // InternalMyDsl.g:4802:1: ( ',' )
            // InternalMyDsl.g:4803:2: ','
            {
             before(grammarAccess.getExternalEntityAccess().getCommaKeyword_6_3_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getCommaKeyword_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6_3__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_6_3__1"
    // InternalMyDsl.g:4812:1: rule__ExternalEntity__Group_6_3__1 : rule__ExternalEntity__Group_6_3__1__Impl ;
    public final void rule__ExternalEntity__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4816:1: ( rule__ExternalEntity__Group_6_3__1__Impl )
            // InternalMyDsl.g:4817:2: rule__ExternalEntity__Group_6_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_6_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6_3__1"


    // $ANTLR start "rule__ExternalEntity__Group_6_3__1__Impl"
    // InternalMyDsl.g:4823:1: rule__ExternalEntity__Group_6_3__1__Impl : ( ( rule__ExternalEntity__InflowsAssignment_6_3_1 ) ) ;
    public final void rule__ExternalEntity__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4827:1: ( ( ( rule__ExternalEntity__InflowsAssignment_6_3_1 ) ) )
            // InternalMyDsl.g:4828:1: ( ( rule__ExternalEntity__InflowsAssignment_6_3_1 ) )
            {
            // InternalMyDsl.g:4828:1: ( ( rule__ExternalEntity__InflowsAssignment_6_3_1 ) )
            // InternalMyDsl.g:4829:2: ( rule__ExternalEntity__InflowsAssignment_6_3_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsAssignment_6_3_1()); 
            // InternalMyDsl.g:4830:2: ( rule__ExternalEntity__InflowsAssignment_6_3_1 )
            // InternalMyDsl.g:4830:3: rule__ExternalEntity__InflowsAssignment_6_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__InflowsAssignment_6_3_1();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getInflowsAssignment_6_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_6_3__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_7__0"
    // InternalMyDsl.g:4839:1: rule__ExternalEntity__Group_7__0 : rule__ExternalEntity__Group_7__0__Impl rule__ExternalEntity__Group_7__1 ;
    public final void rule__ExternalEntity__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4843:1: ( rule__ExternalEntity__Group_7__0__Impl rule__ExternalEntity__Group_7__1 )
            // InternalMyDsl.g:4844:2: rule__ExternalEntity__Group_7__0__Impl rule__ExternalEntity__Group_7__1
            {
            pushFollow(FOLLOW_20);
            rule__ExternalEntity__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7__0"


    // $ANTLR start "rule__ExternalEntity__Group_7__0__Impl"
    // InternalMyDsl.g:4851:1: rule__ExternalEntity__Group_7__0__Impl : ( 'outgoing' ) ;
    public final void rule__ExternalEntity__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4855:1: ( ( 'outgoing' ) )
            // InternalMyDsl.g:4856:1: ( 'outgoing' )
            {
            // InternalMyDsl.g:4856:1: ( 'outgoing' )
            // InternalMyDsl.g:4857:2: 'outgoing'
            {
             before(grammarAccess.getExternalEntityAccess().getOutgoingKeyword_7_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getOutgoingKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_7__1"
    // InternalMyDsl.g:4866:1: rule__ExternalEntity__Group_7__1 : rule__ExternalEntity__Group_7__1__Impl rule__ExternalEntity__Group_7__2 ;
    public final void rule__ExternalEntity__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4870:1: ( rule__ExternalEntity__Group_7__1__Impl rule__ExternalEntity__Group_7__2 )
            // InternalMyDsl.g:4871:2: rule__ExternalEntity__Group_7__1__Impl rule__ExternalEntity__Group_7__2
            {
            pushFollow(FOLLOW_4);
            rule__ExternalEntity__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7__1"


    // $ANTLR start "rule__ExternalEntity__Group_7__1__Impl"
    // InternalMyDsl.g:4878:1: rule__ExternalEntity__Group_7__1__Impl : ( 'flows:' ) ;
    public final void rule__ExternalEntity__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4882:1: ( ( 'flows:' ) )
            // InternalMyDsl.g:4883:1: ( 'flows:' )
            {
            // InternalMyDsl.g:4883:1: ( 'flows:' )
            // InternalMyDsl.g:4884:2: 'flows:'
            {
             before(grammarAccess.getExternalEntityAccess().getFlowsKeyword_7_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getFlowsKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_7__2"
    // InternalMyDsl.g:4893:1: rule__ExternalEntity__Group_7__2 : rule__ExternalEntity__Group_7__2__Impl rule__ExternalEntity__Group_7__3 ;
    public final void rule__ExternalEntity__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4897:1: ( rule__ExternalEntity__Group_7__2__Impl rule__ExternalEntity__Group_7__3 )
            // InternalMyDsl.g:4898:2: rule__ExternalEntity__Group_7__2__Impl rule__ExternalEntity__Group_7__3
            {
            pushFollow(FOLLOW_8);
            rule__ExternalEntity__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7__2"


    // $ANTLR start "rule__ExternalEntity__Group_7__2__Impl"
    // InternalMyDsl.g:4905:1: rule__ExternalEntity__Group_7__2__Impl : ( ( rule__ExternalEntity__OutflowsAssignment_7_2 ) ) ;
    public final void rule__ExternalEntity__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4909:1: ( ( ( rule__ExternalEntity__OutflowsAssignment_7_2 ) ) )
            // InternalMyDsl.g:4910:1: ( ( rule__ExternalEntity__OutflowsAssignment_7_2 ) )
            {
            // InternalMyDsl.g:4910:1: ( ( rule__ExternalEntity__OutflowsAssignment_7_2 ) )
            // InternalMyDsl.g:4911:2: ( rule__ExternalEntity__OutflowsAssignment_7_2 )
            {
             before(grammarAccess.getExternalEntityAccess().getOutflowsAssignment_7_2()); 
            // InternalMyDsl.g:4912:2: ( rule__ExternalEntity__OutflowsAssignment_7_2 )
            // InternalMyDsl.g:4912:3: rule__ExternalEntity__OutflowsAssignment_7_2
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__OutflowsAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getOutflowsAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7__2__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_7__3"
    // InternalMyDsl.g:4920:1: rule__ExternalEntity__Group_7__3 : rule__ExternalEntity__Group_7__3__Impl ;
    public final void rule__ExternalEntity__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4924:1: ( rule__ExternalEntity__Group_7__3__Impl )
            // InternalMyDsl.g:4925:2: rule__ExternalEntity__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_7__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7__3"


    // $ANTLR start "rule__ExternalEntity__Group_7__3__Impl"
    // InternalMyDsl.g:4931:1: rule__ExternalEntity__Group_7__3__Impl : ( ( rule__ExternalEntity__Group_7_3__0 )* ) ;
    public final void rule__ExternalEntity__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4935:1: ( ( ( rule__ExternalEntity__Group_7_3__0 )* ) )
            // InternalMyDsl.g:4936:1: ( ( rule__ExternalEntity__Group_7_3__0 )* )
            {
            // InternalMyDsl.g:4936:1: ( ( rule__ExternalEntity__Group_7_3__0 )* )
            // InternalMyDsl.g:4937:2: ( rule__ExternalEntity__Group_7_3__0 )*
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_7_3()); 
            // InternalMyDsl.g:4938:2: ( rule__ExternalEntity__Group_7_3__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==43) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalMyDsl.g:4938:3: rule__ExternalEntity__Group_7_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ExternalEntity__Group_7_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getExternalEntityAccess().getGroup_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7__3__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_7_3__0"
    // InternalMyDsl.g:4947:1: rule__ExternalEntity__Group_7_3__0 : rule__ExternalEntity__Group_7_3__0__Impl rule__ExternalEntity__Group_7_3__1 ;
    public final void rule__ExternalEntity__Group_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4951:1: ( rule__ExternalEntity__Group_7_3__0__Impl rule__ExternalEntity__Group_7_3__1 )
            // InternalMyDsl.g:4952:2: rule__ExternalEntity__Group_7_3__0__Impl rule__ExternalEntity__Group_7_3__1
            {
            pushFollow(FOLLOW_4);
            rule__ExternalEntity__Group_7_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_7_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7_3__0"


    // $ANTLR start "rule__ExternalEntity__Group_7_3__0__Impl"
    // InternalMyDsl.g:4959:1: rule__ExternalEntity__Group_7_3__0__Impl : ( ',' ) ;
    public final void rule__ExternalEntity__Group_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4963:1: ( ( ',' ) )
            // InternalMyDsl.g:4964:1: ( ',' )
            {
            // InternalMyDsl.g:4964:1: ( ',' )
            // InternalMyDsl.g:4965:2: ','
            {
             before(grammarAccess.getExternalEntityAccess().getCommaKeyword_7_3_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getCommaKeyword_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7_3__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_7_3__1"
    // InternalMyDsl.g:4974:1: rule__ExternalEntity__Group_7_3__1 : rule__ExternalEntity__Group_7_3__1__Impl ;
    public final void rule__ExternalEntity__Group_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4978:1: ( rule__ExternalEntity__Group_7_3__1__Impl )
            // InternalMyDsl.g:4979:2: rule__ExternalEntity__Group_7_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_7_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7_3__1"


    // $ANTLR start "rule__ExternalEntity__Group_7_3__1__Impl"
    // InternalMyDsl.g:4985:1: rule__ExternalEntity__Group_7_3__1__Impl : ( ( rule__ExternalEntity__OutflowsAssignment_7_3_1 ) ) ;
    public final void rule__ExternalEntity__Group_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4989:1: ( ( ( rule__ExternalEntity__OutflowsAssignment_7_3_1 ) ) )
            // InternalMyDsl.g:4990:1: ( ( rule__ExternalEntity__OutflowsAssignment_7_3_1 ) )
            {
            // InternalMyDsl.g:4990:1: ( ( rule__ExternalEntity__OutflowsAssignment_7_3_1 ) )
            // InternalMyDsl.g:4991:2: ( rule__ExternalEntity__OutflowsAssignment_7_3_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getOutflowsAssignment_7_3_1()); 
            // InternalMyDsl.g:4992:2: ( rule__ExternalEntity__OutflowsAssignment_7_3_1 )
            // InternalMyDsl.g:4992:3: rule__ExternalEntity__OutflowsAssignment_7_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__OutflowsAssignment_7_3_1();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getOutflowsAssignment_7_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_7_3__1__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_8__0"
    // InternalMyDsl.g:5001:1: rule__ExternalEntity__Group_8__0 : rule__ExternalEntity__Group_8__0__Impl rule__ExternalEntity__Group_8__1 ;
    public final void rule__ExternalEntity__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5005:1: ( rule__ExternalEntity__Group_8__0__Impl rule__ExternalEntity__Group_8__1 )
            // InternalMyDsl.g:5006:2: rule__ExternalEntity__Group_8__0__Impl rule__ExternalEntity__Group_8__1
            {
            pushFollow(FOLLOW_21);
            rule__ExternalEntity__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_8__0"


    // $ANTLR start "rule__ExternalEntity__Group_8__0__Impl"
    // InternalMyDsl.g:5013:1: rule__ExternalEntity__Group_8__0__Impl : ( 'attacker:' ) ;
    public final void rule__ExternalEntity__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5017:1: ( ( 'attacker:' ) )
            // InternalMyDsl.g:5018:1: ( 'attacker:' )
            {
            // InternalMyDsl.g:5018:1: ( 'attacker:' )
            // InternalMyDsl.g:5019:2: 'attacker:'
            {
             before(grammarAccess.getExternalEntityAccess().getAttackerKeyword_8_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getExternalEntityAccess().getAttackerKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_8__0__Impl"


    // $ANTLR start "rule__ExternalEntity__Group_8__1"
    // InternalMyDsl.g:5028:1: rule__ExternalEntity__Group_8__1 : rule__ExternalEntity__Group_8__1__Impl ;
    public final void rule__ExternalEntity__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5032:1: ( rule__ExternalEntity__Group_8__1__Impl )
            // InternalMyDsl.g:5033:2: rule__ExternalEntity__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_8__1"


    // $ANTLR start "rule__ExternalEntity__Group_8__1__Impl"
    // InternalMyDsl.g:5039:1: rule__ExternalEntity__Group_8__1__Impl : ( ( rule__ExternalEntity__AttackerAssignment_8_1 ) ) ;
    public final void rule__ExternalEntity__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5043:1: ( ( ( rule__ExternalEntity__AttackerAssignment_8_1 ) ) )
            // InternalMyDsl.g:5044:1: ( ( rule__ExternalEntity__AttackerAssignment_8_1 ) )
            {
            // InternalMyDsl.g:5044:1: ( ( rule__ExternalEntity__AttackerAssignment_8_1 ) )
            // InternalMyDsl.g:5045:2: ( rule__ExternalEntity__AttackerAssignment_8_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAttackerAssignment_8_1()); 
            // InternalMyDsl.g:5046:2: ( rule__ExternalEntity__AttackerAssignment_8_1 )
            // InternalMyDsl.g:5046:3: rule__ExternalEntity__AttackerAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__ExternalEntity__AttackerAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getExternalEntityAccess().getAttackerAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__Group_8__1__Impl"


    // $ANTLR start "rule__Flow__Group__0"
    // InternalMyDsl.g:5055:1: rule__Flow__Group__0 : rule__Flow__Group__0__Impl rule__Flow__Group__1 ;
    public final void rule__Flow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5059:1: ( rule__Flow__Group__0__Impl rule__Flow__Group__1 )
            // InternalMyDsl.g:5060:2: rule__Flow__Group__0__Impl rule__Flow__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Flow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__0"


    // $ANTLR start "rule__Flow__Group__0__Impl"
    // InternalMyDsl.g:5067:1: rule__Flow__Group__0__Impl : ( () ) ;
    public final void rule__Flow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5071:1: ( ( () ) )
            // InternalMyDsl.g:5072:1: ( () )
            {
            // InternalMyDsl.g:5072:1: ( () )
            // InternalMyDsl.g:5073:2: ()
            {
             before(grammarAccess.getFlowAccess().getFlowAction_0()); 
            // InternalMyDsl.g:5074:2: ()
            // InternalMyDsl.g:5074:3: 
            {
            }

             after(grammarAccess.getFlowAccess().getFlowAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__0__Impl"


    // $ANTLR start "rule__Flow__Group__1"
    // InternalMyDsl.g:5082:1: rule__Flow__Group__1 : rule__Flow__Group__1__Impl rule__Flow__Group__2 ;
    public final void rule__Flow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5086:1: ( rule__Flow__Group__1__Impl rule__Flow__Group__2 )
            // InternalMyDsl.g:5087:2: rule__Flow__Group__1__Impl rule__Flow__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Flow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__1"


    // $ANTLR start "rule__Flow__Group__1__Impl"
    // InternalMyDsl.g:5094:1: rule__Flow__Group__1__Impl : ( ( rule__Flow__NameAssignment_1 ) ) ;
    public final void rule__Flow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5098:1: ( ( ( rule__Flow__NameAssignment_1 ) ) )
            // InternalMyDsl.g:5099:1: ( ( rule__Flow__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:5099:1: ( ( rule__Flow__NameAssignment_1 ) )
            // InternalMyDsl.g:5100:2: ( rule__Flow__NameAssignment_1 )
            {
             before(grammarAccess.getFlowAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:5101:2: ( rule__Flow__NameAssignment_1 )
            // InternalMyDsl.g:5101:3: rule__Flow__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__1__Impl"


    // $ANTLR start "rule__Flow__Group__2"
    // InternalMyDsl.g:5109:1: rule__Flow__Group__2 : rule__Flow__Group__2__Impl rule__Flow__Group__3 ;
    public final void rule__Flow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5113:1: ( rule__Flow__Group__2__Impl rule__Flow__Group__3 )
            // InternalMyDsl.g:5114:2: rule__Flow__Group__2__Impl rule__Flow__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__Flow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__2"


    // $ANTLR start "rule__Flow__Group__2__Impl"
    // InternalMyDsl.g:5121:1: rule__Flow__Group__2__Impl : ( '[' ) ;
    public final void rule__Flow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5125:1: ( ( '[' ) )
            // InternalMyDsl.g:5126:1: ( '[' )
            {
            // InternalMyDsl.g:5126:1: ( '[' )
            // InternalMyDsl.g:5127:2: '['
            {
             before(grammarAccess.getFlowAccess().getLeftSquareBracketKeyword_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__2__Impl"


    // $ANTLR start "rule__Flow__Group__3"
    // InternalMyDsl.g:5136:1: rule__Flow__Group__3 : rule__Flow__Group__3__Impl rule__Flow__Group__4 ;
    public final void rule__Flow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5140:1: ( rule__Flow__Group__3__Impl rule__Flow__Group__4 )
            // InternalMyDsl.g:5141:2: rule__Flow__Group__3__Impl rule__Flow__Group__4
            {
            pushFollow(FOLLOW_28);
            rule__Flow__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__3"


    // $ANTLR start "rule__Flow__Group__3__Impl"
    // InternalMyDsl.g:5148:1: rule__Flow__Group__3__Impl : ( ( rule__Flow__Group_3__0 )? ) ;
    public final void rule__Flow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5152:1: ( ( ( rule__Flow__Group_3__0 )? ) )
            // InternalMyDsl.g:5153:1: ( ( rule__Flow__Group_3__0 )? )
            {
            // InternalMyDsl.g:5153:1: ( ( rule__Flow__Group_3__0 )? )
            // InternalMyDsl.g:5154:2: ( rule__Flow__Group_3__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_3()); 
            // InternalMyDsl.g:5155:2: ( rule__Flow__Group_3__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==64) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalMyDsl.g:5155:3: rule__Flow__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Flow__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__3__Impl"


    // $ANTLR start "rule__Flow__Group__4"
    // InternalMyDsl.g:5163:1: rule__Flow__Group__4 : rule__Flow__Group__4__Impl rule__Flow__Group__5 ;
    public final void rule__Flow__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5167:1: ( rule__Flow__Group__4__Impl rule__Flow__Group__5 )
            // InternalMyDsl.g:5168:2: rule__Flow__Group__4__Impl rule__Flow__Group__5
            {
            pushFollow(FOLLOW_28);
            rule__Flow__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__4"


    // $ANTLR start "rule__Flow__Group__4__Impl"
    // InternalMyDsl.g:5175:1: rule__Flow__Group__4__Impl : ( ( rule__Flow__Group_4__0 )? ) ;
    public final void rule__Flow__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5179:1: ( ( ( rule__Flow__Group_4__0 )? ) )
            // InternalMyDsl.g:5180:1: ( ( rule__Flow__Group_4__0 )? )
            {
            // InternalMyDsl.g:5180:1: ( ( rule__Flow__Group_4__0 )? )
            // InternalMyDsl.g:5181:2: ( rule__Flow__Group_4__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_4()); 
            // InternalMyDsl.g:5182:2: ( rule__Flow__Group_4__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==42) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalMyDsl.g:5182:3: rule__Flow__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Flow__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__4__Impl"


    // $ANTLR start "rule__Flow__Group__5"
    // InternalMyDsl.g:5190:1: rule__Flow__Group__5 : rule__Flow__Group__5__Impl rule__Flow__Group__6 ;
    public final void rule__Flow__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5194:1: ( rule__Flow__Group__5__Impl rule__Flow__Group__6 )
            // InternalMyDsl.g:5195:2: rule__Flow__Group__5__Impl rule__Flow__Group__6
            {
            pushFollow(FOLLOW_28);
            rule__Flow__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__5"


    // $ANTLR start "rule__Flow__Group__5__Impl"
    // InternalMyDsl.g:5202:1: rule__Flow__Group__5__Impl : ( ( rule__Flow__Group_5__0 )? ) ;
    public final void rule__Flow__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5206:1: ( ( ( rule__Flow__Group_5__0 )? ) )
            // InternalMyDsl.g:5207:1: ( ( rule__Flow__Group_5__0 )? )
            {
            // InternalMyDsl.g:5207:1: ( ( rule__Flow__Group_5__0 )? )
            // InternalMyDsl.g:5208:2: ( rule__Flow__Group_5__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_5()); 
            // InternalMyDsl.g:5209:2: ( rule__Flow__Group_5__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==52) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalMyDsl.g:5209:3: rule__Flow__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Flow__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__5__Impl"


    // $ANTLR start "rule__Flow__Group__6"
    // InternalMyDsl.g:5217:1: rule__Flow__Group__6 : rule__Flow__Group__6__Impl rule__Flow__Group__7 ;
    public final void rule__Flow__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5221:1: ( rule__Flow__Group__6__Impl rule__Flow__Group__7 )
            // InternalMyDsl.g:5222:2: rule__Flow__Group__6__Impl rule__Flow__Group__7
            {
            pushFollow(FOLLOW_28);
            rule__Flow__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__6"


    // $ANTLR start "rule__Flow__Group__6__Impl"
    // InternalMyDsl.g:5229:1: rule__Flow__Group__6__Impl : ( ( rule__Flow__Group_6__0 )? ) ;
    public final void rule__Flow__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5233:1: ( ( ( rule__Flow__Group_6__0 )? ) )
            // InternalMyDsl.g:5234:1: ( ( rule__Flow__Group_6__0 )? )
            {
            // InternalMyDsl.g:5234:1: ( ( rule__Flow__Group_6__0 )? )
            // InternalMyDsl.g:5235:2: ( rule__Flow__Group_6__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_6()); 
            // InternalMyDsl.g:5236:2: ( rule__Flow__Group_6__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==53) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalMyDsl.g:5236:3: rule__Flow__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Flow__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__6__Impl"


    // $ANTLR start "rule__Flow__Group__7"
    // InternalMyDsl.g:5244:1: rule__Flow__Group__7 : rule__Flow__Group__7__Impl rule__Flow__Group__8 ;
    public final void rule__Flow__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5248:1: ( rule__Flow__Group__7__Impl rule__Flow__Group__8 )
            // InternalMyDsl.g:5249:2: rule__Flow__Group__7__Impl rule__Flow__Group__8
            {
            pushFollow(FOLLOW_28);
            rule__Flow__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__7"


    // $ANTLR start "rule__Flow__Group__7__Impl"
    // InternalMyDsl.g:5256:1: rule__Flow__Group__7__Impl : ( ( rule__Flow__Group_7__0 )? ) ;
    public final void rule__Flow__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5260:1: ( ( ( rule__Flow__Group_7__0 )? ) )
            // InternalMyDsl.g:5261:1: ( ( rule__Flow__Group_7__0 )? )
            {
            // InternalMyDsl.g:5261:1: ( ( rule__Flow__Group_7__0 )? )
            // InternalMyDsl.g:5262:2: ( rule__Flow__Group_7__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_7()); 
            // InternalMyDsl.g:5263:2: ( rule__Flow__Group_7__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==65) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalMyDsl.g:5263:3: rule__Flow__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Flow__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__7__Impl"


    // $ANTLR start "rule__Flow__Group__8"
    // InternalMyDsl.g:5271:1: rule__Flow__Group__8 : rule__Flow__Group__8__Impl rule__Flow__Group__9 ;
    public final void rule__Flow__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5275:1: ( rule__Flow__Group__8__Impl rule__Flow__Group__9 )
            // InternalMyDsl.g:5276:2: rule__Flow__Group__8__Impl rule__Flow__Group__9
            {
            pushFollow(FOLLOW_28);
            rule__Flow__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__8"


    // $ANTLR start "rule__Flow__Group__8__Impl"
    // InternalMyDsl.g:5283:1: rule__Flow__Group__8__Impl : ( ( rule__Flow__Group_8__0 )? ) ;
    public final void rule__Flow__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5287:1: ( ( ( rule__Flow__Group_8__0 )? ) )
            // InternalMyDsl.g:5288:1: ( ( rule__Flow__Group_8__0 )? )
            {
            // InternalMyDsl.g:5288:1: ( ( rule__Flow__Group_8__0 )? )
            // InternalMyDsl.g:5289:2: ( rule__Flow__Group_8__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_8()); 
            // InternalMyDsl.g:5290:2: ( rule__Flow__Group_8__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==57) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalMyDsl.g:5290:3: rule__Flow__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Flow__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFlowAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__8__Impl"


    // $ANTLR start "rule__Flow__Group__9"
    // InternalMyDsl.g:5298:1: rule__Flow__Group__9 : rule__Flow__Group__9__Impl ;
    public final void rule__Flow__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5302:1: ( rule__Flow__Group__9__Impl )
            // InternalMyDsl.g:5303:2: rule__Flow__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__9"


    // $ANTLR start "rule__Flow__Group__9__Impl"
    // InternalMyDsl.g:5309:1: rule__Flow__Group__9__Impl : ( ']' ) ;
    public final void rule__Flow__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5313:1: ( ( ']' ) )
            // InternalMyDsl.g:5314:1: ( ']' )
            {
            // InternalMyDsl.g:5314:1: ( ']' )
            // InternalMyDsl.g:5315:2: ']'
            {
             before(grammarAccess.getFlowAccess().getRightSquareBracketKeyword_9()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getRightSquareBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group__9__Impl"


    // $ANTLR start "rule__Flow__Group_3__0"
    // InternalMyDsl.g:5325:1: rule__Flow__Group_3__0 : rule__Flow__Group_3__0__Impl rule__Flow__Group_3__1 ;
    public final void rule__Flow__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5329:1: ( rule__Flow__Group_3__0__Impl rule__Flow__Group_3__1 )
            // InternalMyDsl.g:5330:2: rule__Flow__Group_3__0__Impl rule__Flow__Group_3__1
            {
            pushFollow(FOLLOW_15);
            rule__Flow__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_3__0"


    // $ANTLR start "rule__Flow__Group_3__0__Impl"
    // InternalMyDsl.g:5337:1: rule__Flow__Group_3__0__Impl : ( 'num:' ) ;
    public final void rule__Flow__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5341:1: ( ( 'num:' ) )
            // InternalMyDsl.g:5342:1: ( 'num:' )
            {
            // InternalMyDsl.g:5342:1: ( 'num:' )
            // InternalMyDsl.g:5343:2: 'num:'
            {
             before(grammarAccess.getFlowAccess().getNumKeyword_3_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getNumKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_3__0__Impl"


    // $ANTLR start "rule__Flow__Group_3__1"
    // InternalMyDsl.g:5352:1: rule__Flow__Group_3__1 : rule__Flow__Group_3__1__Impl ;
    public final void rule__Flow__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5356:1: ( rule__Flow__Group_3__1__Impl )
            // InternalMyDsl.g:5357:2: rule__Flow__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_3__1"


    // $ANTLR start "rule__Flow__Group_3__1__Impl"
    // InternalMyDsl.g:5363:1: rule__Flow__Group_3__1__Impl : ( ( rule__Flow__NumberAssignment_3_1 ) ) ;
    public final void rule__Flow__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5367:1: ( ( ( rule__Flow__NumberAssignment_3_1 ) ) )
            // InternalMyDsl.g:5368:1: ( ( rule__Flow__NumberAssignment_3_1 ) )
            {
            // InternalMyDsl.g:5368:1: ( ( rule__Flow__NumberAssignment_3_1 ) )
            // InternalMyDsl.g:5369:2: ( rule__Flow__NumberAssignment_3_1 )
            {
             before(grammarAccess.getFlowAccess().getNumberAssignment_3_1()); 
            // InternalMyDsl.g:5370:2: ( rule__Flow__NumberAssignment_3_1 )
            // InternalMyDsl.g:5370:3: rule__Flow__NumberAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__NumberAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getNumberAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_3__1__Impl"


    // $ANTLR start "rule__Flow__Group_4__0"
    // InternalMyDsl.g:5379:1: rule__Flow__Group_4__0 : rule__Flow__Group_4__0__Impl rule__Flow__Group_4__1 ;
    public final void rule__Flow__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5383:1: ( rule__Flow__Group_4__0__Impl rule__Flow__Group_4__1 )
            // InternalMyDsl.g:5384:2: rule__Flow__Group_4__0__Impl rule__Flow__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__Flow__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4__0"


    // $ANTLR start "rule__Flow__Group_4__0__Impl"
    // InternalMyDsl.g:5391:1: rule__Flow__Group_4__0__Impl : ( 'assets:' ) ;
    public final void rule__Flow__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5395:1: ( ( 'assets:' ) )
            // InternalMyDsl.g:5396:1: ( 'assets:' )
            {
            // InternalMyDsl.g:5396:1: ( 'assets:' )
            // InternalMyDsl.g:5397:2: 'assets:'
            {
             before(grammarAccess.getFlowAccess().getAssetsKeyword_4_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getAssetsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4__0__Impl"


    // $ANTLR start "rule__Flow__Group_4__1"
    // InternalMyDsl.g:5406:1: rule__Flow__Group_4__1 : rule__Flow__Group_4__1__Impl rule__Flow__Group_4__2 ;
    public final void rule__Flow__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5410:1: ( rule__Flow__Group_4__1__Impl rule__Flow__Group_4__2 )
            // InternalMyDsl.g:5411:2: rule__Flow__Group_4__1__Impl rule__Flow__Group_4__2
            {
            pushFollow(FOLLOW_8);
            rule__Flow__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4__1"


    // $ANTLR start "rule__Flow__Group_4__1__Impl"
    // InternalMyDsl.g:5418:1: rule__Flow__Group_4__1__Impl : ( ( rule__Flow__AssetsAssignment_4_1 ) ) ;
    public final void rule__Flow__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5422:1: ( ( ( rule__Flow__AssetsAssignment_4_1 ) ) )
            // InternalMyDsl.g:5423:1: ( ( rule__Flow__AssetsAssignment_4_1 ) )
            {
            // InternalMyDsl.g:5423:1: ( ( rule__Flow__AssetsAssignment_4_1 ) )
            // InternalMyDsl.g:5424:2: ( rule__Flow__AssetsAssignment_4_1 )
            {
             before(grammarAccess.getFlowAccess().getAssetsAssignment_4_1()); 
            // InternalMyDsl.g:5425:2: ( rule__Flow__AssetsAssignment_4_1 )
            // InternalMyDsl.g:5425:3: rule__Flow__AssetsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__AssetsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getAssetsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4__1__Impl"


    // $ANTLR start "rule__Flow__Group_4__2"
    // InternalMyDsl.g:5433:1: rule__Flow__Group_4__2 : rule__Flow__Group_4__2__Impl ;
    public final void rule__Flow__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5437:1: ( rule__Flow__Group_4__2__Impl )
            // InternalMyDsl.g:5438:2: rule__Flow__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4__2"


    // $ANTLR start "rule__Flow__Group_4__2__Impl"
    // InternalMyDsl.g:5444:1: rule__Flow__Group_4__2__Impl : ( ( rule__Flow__Group_4_2__0 )* ) ;
    public final void rule__Flow__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5448:1: ( ( ( rule__Flow__Group_4_2__0 )* ) )
            // InternalMyDsl.g:5449:1: ( ( rule__Flow__Group_4_2__0 )* )
            {
            // InternalMyDsl.g:5449:1: ( ( rule__Flow__Group_4_2__0 )* )
            // InternalMyDsl.g:5450:2: ( rule__Flow__Group_4_2__0 )*
            {
             before(grammarAccess.getFlowAccess().getGroup_4_2()); 
            // InternalMyDsl.g:5451:2: ( rule__Flow__Group_4_2__0 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==43) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalMyDsl.g:5451:3: rule__Flow__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Flow__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

             after(grammarAccess.getFlowAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4__2__Impl"


    // $ANTLR start "rule__Flow__Group_4_2__0"
    // InternalMyDsl.g:5460:1: rule__Flow__Group_4_2__0 : rule__Flow__Group_4_2__0__Impl rule__Flow__Group_4_2__1 ;
    public final void rule__Flow__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5464:1: ( rule__Flow__Group_4_2__0__Impl rule__Flow__Group_4_2__1 )
            // InternalMyDsl.g:5465:2: rule__Flow__Group_4_2__0__Impl rule__Flow__Group_4_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Flow__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4_2__0"


    // $ANTLR start "rule__Flow__Group_4_2__0__Impl"
    // InternalMyDsl.g:5472:1: rule__Flow__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Flow__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5476:1: ( ( ',' ) )
            // InternalMyDsl.g:5477:1: ( ',' )
            {
            // InternalMyDsl.g:5477:1: ( ',' )
            // InternalMyDsl.g:5478:2: ','
            {
             before(grammarAccess.getFlowAccess().getCommaKeyword_4_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4_2__0__Impl"


    // $ANTLR start "rule__Flow__Group_4_2__1"
    // InternalMyDsl.g:5487:1: rule__Flow__Group_4_2__1 : rule__Flow__Group_4_2__1__Impl ;
    public final void rule__Flow__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5491:1: ( rule__Flow__Group_4_2__1__Impl )
            // InternalMyDsl.g:5492:2: rule__Flow__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4_2__1"


    // $ANTLR start "rule__Flow__Group_4_2__1__Impl"
    // InternalMyDsl.g:5498:1: rule__Flow__Group_4_2__1__Impl : ( ( rule__Flow__AssetsAssignment_4_2_1 ) ) ;
    public final void rule__Flow__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5502:1: ( ( ( rule__Flow__AssetsAssignment_4_2_1 ) ) )
            // InternalMyDsl.g:5503:1: ( ( rule__Flow__AssetsAssignment_4_2_1 ) )
            {
            // InternalMyDsl.g:5503:1: ( ( rule__Flow__AssetsAssignment_4_2_1 ) )
            // InternalMyDsl.g:5504:2: ( rule__Flow__AssetsAssignment_4_2_1 )
            {
             before(grammarAccess.getFlowAccess().getAssetsAssignment_4_2_1()); 
            // InternalMyDsl.g:5505:2: ( rule__Flow__AssetsAssignment_4_2_1 )
            // InternalMyDsl.g:5505:3: rule__Flow__AssetsAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__AssetsAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getAssetsAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_4_2__1__Impl"


    // $ANTLR start "rule__Flow__Group_5__0"
    // InternalMyDsl.g:5514:1: rule__Flow__Group_5__0 : rule__Flow__Group_5__0__Impl rule__Flow__Group_5__1 ;
    public final void rule__Flow__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5518:1: ( rule__Flow__Group_5__0__Impl rule__Flow__Group_5__1 )
            // InternalMyDsl.g:5519:2: rule__Flow__Group_5__0__Impl rule__Flow__Group_5__1
            {
            pushFollow(FOLLOW_4);
            rule__Flow__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_5__0"


    // $ANTLR start "rule__Flow__Group_5__0__Impl"
    // InternalMyDsl.g:5526:1: rule__Flow__Group_5__0__Impl : ( 'source:' ) ;
    public final void rule__Flow__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5530:1: ( ( 'source:' ) )
            // InternalMyDsl.g:5531:1: ( 'source:' )
            {
            // InternalMyDsl.g:5531:1: ( 'source:' )
            // InternalMyDsl.g:5532:2: 'source:'
            {
             before(grammarAccess.getFlowAccess().getSourceKeyword_5_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getSourceKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_5__0__Impl"


    // $ANTLR start "rule__Flow__Group_5__1"
    // InternalMyDsl.g:5541:1: rule__Flow__Group_5__1 : rule__Flow__Group_5__1__Impl ;
    public final void rule__Flow__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5545:1: ( rule__Flow__Group_5__1__Impl )
            // InternalMyDsl.g:5546:2: rule__Flow__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_5__1"


    // $ANTLR start "rule__Flow__Group_5__1__Impl"
    // InternalMyDsl.g:5552:1: rule__Flow__Group_5__1__Impl : ( ( rule__Flow__SourceAssignment_5_1 ) ) ;
    public final void rule__Flow__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5556:1: ( ( ( rule__Flow__SourceAssignment_5_1 ) ) )
            // InternalMyDsl.g:5557:1: ( ( rule__Flow__SourceAssignment_5_1 ) )
            {
            // InternalMyDsl.g:5557:1: ( ( rule__Flow__SourceAssignment_5_1 ) )
            // InternalMyDsl.g:5558:2: ( rule__Flow__SourceAssignment_5_1 )
            {
             before(grammarAccess.getFlowAccess().getSourceAssignment_5_1()); 
            // InternalMyDsl.g:5559:2: ( rule__Flow__SourceAssignment_5_1 )
            // InternalMyDsl.g:5559:3: rule__Flow__SourceAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__SourceAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getSourceAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_5__1__Impl"


    // $ANTLR start "rule__Flow__Group_6__0"
    // InternalMyDsl.g:5568:1: rule__Flow__Group_6__0 : rule__Flow__Group_6__0__Impl rule__Flow__Group_6__1 ;
    public final void rule__Flow__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5572:1: ( rule__Flow__Group_6__0__Impl rule__Flow__Group_6__1 )
            // InternalMyDsl.g:5573:2: rule__Flow__Group_6__0__Impl rule__Flow__Group_6__1
            {
            pushFollow(FOLLOW_4);
            rule__Flow__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6__0"


    // $ANTLR start "rule__Flow__Group_6__0__Impl"
    // InternalMyDsl.g:5580:1: rule__Flow__Group_6__0__Impl : ( 'targets:' ) ;
    public final void rule__Flow__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5584:1: ( ( 'targets:' ) )
            // InternalMyDsl.g:5585:1: ( 'targets:' )
            {
            // InternalMyDsl.g:5585:1: ( 'targets:' )
            // InternalMyDsl.g:5586:2: 'targets:'
            {
             before(grammarAccess.getFlowAccess().getTargetsKeyword_6_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getTargetsKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6__0__Impl"


    // $ANTLR start "rule__Flow__Group_6__1"
    // InternalMyDsl.g:5595:1: rule__Flow__Group_6__1 : rule__Flow__Group_6__1__Impl rule__Flow__Group_6__2 ;
    public final void rule__Flow__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5599:1: ( rule__Flow__Group_6__1__Impl rule__Flow__Group_6__2 )
            // InternalMyDsl.g:5600:2: rule__Flow__Group_6__1__Impl rule__Flow__Group_6__2
            {
            pushFollow(FOLLOW_8);
            rule__Flow__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6__1"


    // $ANTLR start "rule__Flow__Group_6__1__Impl"
    // InternalMyDsl.g:5607:1: rule__Flow__Group_6__1__Impl : ( ( rule__Flow__TargetAssignment_6_1 ) ) ;
    public final void rule__Flow__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5611:1: ( ( ( rule__Flow__TargetAssignment_6_1 ) ) )
            // InternalMyDsl.g:5612:1: ( ( rule__Flow__TargetAssignment_6_1 ) )
            {
            // InternalMyDsl.g:5612:1: ( ( rule__Flow__TargetAssignment_6_1 ) )
            // InternalMyDsl.g:5613:2: ( rule__Flow__TargetAssignment_6_1 )
            {
             before(grammarAccess.getFlowAccess().getTargetAssignment_6_1()); 
            // InternalMyDsl.g:5614:2: ( rule__Flow__TargetAssignment_6_1 )
            // InternalMyDsl.g:5614:3: rule__Flow__TargetAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__TargetAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getTargetAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6__1__Impl"


    // $ANTLR start "rule__Flow__Group_6__2"
    // InternalMyDsl.g:5622:1: rule__Flow__Group_6__2 : rule__Flow__Group_6__2__Impl ;
    public final void rule__Flow__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5626:1: ( rule__Flow__Group_6__2__Impl )
            // InternalMyDsl.g:5627:2: rule__Flow__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6__2"


    // $ANTLR start "rule__Flow__Group_6__2__Impl"
    // InternalMyDsl.g:5633:1: rule__Flow__Group_6__2__Impl : ( ( rule__Flow__Group_6_2__0 )* ) ;
    public final void rule__Flow__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5637:1: ( ( ( rule__Flow__Group_6_2__0 )* ) )
            // InternalMyDsl.g:5638:1: ( ( rule__Flow__Group_6_2__0 )* )
            {
            // InternalMyDsl.g:5638:1: ( ( rule__Flow__Group_6_2__0 )* )
            // InternalMyDsl.g:5639:2: ( rule__Flow__Group_6_2__0 )*
            {
             before(grammarAccess.getFlowAccess().getGroup_6_2()); 
            // InternalMyDsl.g:5640:2: ( rule__Flow__Group_6_2__0 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==43) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalMyDsl.g:5640:3: rule__Flow__Group_6_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Flow__Group_6_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getFlowAccess().getGroup_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6__2__Impl"


    // $ANTLR start "rule__Flow__Group_6_2__0"
    // InternalMyDsl.g:5649:1: rule__Flow__Group_6_2__0 : rule__Flow__Group_6_2__0__Impl rule__Flow__Group_6_2__1 ;
    public final void rule__Flow__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5653:1: ( rule__Flow__Group_6_2__0__Impl rule__Flow__Group_6_2__1 )
            // InternalMyDsl.g:5654:2: rule__Flow__Group_6_2__0__Impl rule__Flow__Group_6_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Flow__Group_6_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_6_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6_2__0"


    // $ANTLR start "rule__Flow__Group_6_2__0__Impl"
    // InternalMyDsl.g:5661:1: rule__Flow__Group_6_2__0__Impl : ( ',' ) ;
    public final void rule__Flow__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5665:1: ( ( ',' ) )
            // InternalMyDsl.g:5666:1: ( ',' )
            {
            // InternalMyDsl.g:5666:1: ( ',' )
            // InternalMyDsl.g:5667:2: ','
            {
             before(grammarAccess.getFlowAccess().getCommaKeyword_6_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getCommaKeyword_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6_2__0__Impl"


    // $ANTLR start "rule__Flow__Group_6_2__1"
    // InternalMyDsl.g:5676:1: rule__Flow__Group_6_2__1 : rule__Flow__Group_6_2__1__Impl ;
    public final void rule__Flow__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5680:1: ( rule__Flow__Group_6_2__1__Impl )
            // InternalMyDsl.g:5681:2: rule__Flow__Group_6_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group_6_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6_2__1"


    // $ANTLR start "rule__Flow__Group_6_2__1__Impl"
    // InternalMyDsl.g:5687:1: rule__Flow__Group_6_2__1__Impl : ( ( rule__Flow__TargetAssignment_6_2_1 ) ) ;
    public final void rule__Flow__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5691:1: ( ( ( rule__Flow__TargetAssignment_6_2_1 ) ) )
            // InternalMyDsl.g:5692:1: ( ( rule__Flow__TargetAssignment_6_2_1 ) )
            {
            // InternalMyDsl.g:5692:1: ( ( rule__Flow__TargetAssignment_6_2_1 ) )
            // InternalMyDsl.g:5693:2: ( rule__Flow__TargetAssignment_6_2_1 )
            {
             before(grammarAccess.getFlowAccess().getTargetAssignment_6_2_1()); 
            // InternalMyDsl.g:5694:2: ( rule__Flow__TargetAssignment_6_2_1 )
            // InternalMyDsl.g:5694:3: rule__Flow__TargetAssignment_6_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__TargetAssignment_6_2_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getTargetAssignment_6_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_6_2__1__Impl"


    // $ANTLR start "rule__Flow__Group_7__0"
    // InternalMyDsl.g:5703:1: rule__Flow__Group_7__0 : rule__Flow__Group_7__0__Impl rule__Flow__Group_7__1 ;
    public final void rule__Flow__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5707:1: ( rule__Flow__Group_7__0__Impl rule__Flow__Group_7__1 )
            // InternalMyDsl.g:5708:2: rule__Flow__Group_7__0__Impl rule__Flow__Group_7__1
            {
            pushFollow(FOLLOW_29);
            rule__Flow__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_7__0"


    // $ANTLR start "rule__Flow__Group_7__0__Impl"
    // InternalMyDsl.g:5715:1: rule__Flow__Group_7__0__Impl : ( 'channel' ) ;
    public final void rule__Flow__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5719:1: ( ( 'channel' ) )
            // InternalMyDsl.g:5720:1: ( 'channel' )
            {
            // InternalMyDsl.g:5720:1: ( 'channel' )
            // InternalMyDsl.g:5721:2: 'channel'
            {
             before(grammarAccess.getFlowAccess().getChannelKeyword_7_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getChannelKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_7__0__Impl"


    // $ANTLR start "rule__Flow__Group_7__1"
    // InternalMyDsl.g:5730:1: rule__Flow__Group_7__1 : rule__Flow__Group_7__1__Impl ;
    public final void rule__Flow__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5734:1: ( rule__Flow__Group_7__1__Impl )
            // InternalMyDsl.g:5735:2: rule__Flow__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_7__1"


    // $ANTLR start "rule__Flow__Group_7__1__Impl"
    // InternalMyDsl.g:5741:1: rule__Flow__Group_7__1__Impl : ( ( rule__Flow__ChannelAssignment_7_1 ) ) ;
    public final void rule__Flow__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5745:1: ( ( ( rule__Flow__ChannelAssignment_7_1 ) ) )
            // InternalMyDsl.g:5746:1: ( ( rule__Flow__ChannelAssignment_7_1 ) )
            {
            // InternalMyDsl.g:5746:1: ( ( rule__Flow__ChannelAssignment_7_1 ) )
            // InternalMyDsl.g:5747:2: ( rule__Flow__ChannelAssignment_7_1 )
            {
             before(grammarAccess.getFlowAccess().getChannelAssignment_7_1()); 
            // InternalMyDsl.g:5748:2: ( rule__Flow__ChannelAssignment_7_1 )
            // InternalMyDsl.g:5748:3: rule__Flow__ChannelAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__ChannelAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getChannelAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_7__1__Impl"


    // $ANTLR start "rule__Flow__Group_8__0"
    // InternalMyDsl.g:5757:1: rule__Flow__Group_8__0 : rule__Flow__Group_8__0__Impl rule__Flow__Group_8__1 ;
    public final void rule__Flow__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5761:1: ( rule__Flow__Group_8__0__Impl rule__Flow__Group_8__1 )
            // InternalMyDsl.g:5762:2: rule__Flow__Group_8__0__Impl rule__Flow__Group_8__1
            {
            pushFollow(FOLLOW_5);
            rule__Flow__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8__0"


    // $ANTLR start "rule__Flow__Group_8__0__Impl"
    // InternalMyDsl.g:5769:1: rule__Flow__Group_8__0__Impl : ( 'assumption:' ) ;
    public final void rule__Flow__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5773:1: ( ( 'assumption:' ) )
            // InternalMyDsl.g:5774:1: ( 'assumption:' )
            {
            // InternalMyDsl.g:5774:1: ( 'assumption:' )
            // InternalMyDsl.g:5775:2: 'assumption:'
            {
             before(grammarAccess.getFlowAccess().getAssumptionKeyword_8_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getAssumptionKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8__0__Impl"


    // $ANTLR start "rule__Flow__Group_8__1"
    // InternalMyDsl.g:5784:1: rule__Flow__Group_8__1 : rule__Flow__Group_8__1__Impl rule__Flow__Group_8__2 ;
    public final void rule__Flow__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5788:1: ( rule__Flow__Group_8__1__Impl rule__Flow__Group_8__2 )
            // InternalMyDsl.g:5789:2: rule__Flow__Group_8__1__Impl rule__Flow__Group_8__2
            {
            pushFollow(FOLLOW_8);
            rule__Flow__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8__1"


    // $ANTLR start "rule__Flow__Group_8__1__Impl"
    // InternalMyDsl.g:5796:1: rule__Flow__Group_8__1__Impl : ( ( rule__Flow__AssumptionAssignment_8_1 ) ) ;
    public final void rule__Flow__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5800:1: ( ( ( rule__Flow__AssumptionAssignment_8_1 ) ) )
            // InternalMyDsl.g:5801:1: ( ( rule__Flow__AssumptionAssignment_8_1 ) )
            {
            // InternalMyDsl.g:5801:1: ( ( rule__Flow__AssumptionAssignment_8_1 ) )
            // InternalMyDsl.g:5802:2: ( rule__Flow__AssumptionAssignment_8_1 )
            {
             before(grammarAccess.getFlowAccess().getAssumptionAssignment_8_1()); 
            // InternalMyDsl.g:5803:2: ( rule__Flow__AssumptionAssignment_8_1 )
            // InternalMyDsl.g:5803:3: rule__Flow__AssumptionAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__AssumptionAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getAssumptionAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8__1__Impl"


    // $ANTLR start "rule__Flow__Group_8__2"
    // InternalMyDsl.g:5811:1: rule__Flow__Group_8__2 : rule__Flow__Group_8__2__Impl ;
    public final void rule__Flow__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5815:1: ( rule__Flow__Group_8__2__Impl )
            // InternalMyDsl.g:5816:2: rule__Flow__Group_8__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group_8__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8__2"


    // $ANTLR start "rule__Flow__Group_8__2__Impl"
    // InternalMyDsl.g:5822:1: rule__Flow__Group_8__2__Impl : ( ( rule__Flow__Group_8_2__0 )* ) ;
    public final void rule__Flow__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5826:1: ( ( ( rule__Flow__Group_8_2__0 )* ) )
            // InternalMyDsl.g:5827:1: ( ( rule__Flow__Group_8_2__0 )* )
            {
            // InternalMyDsl.g:5827:1: ( ( rule__Flow__Group_8_2__0 )* )
            // InternalMyDsl.g:5828:2: ( rule__Flow__Group_8_2__0 )*
            {
             before(grammarAccess.getFlowAccess().getGroup_8_2()); 
            // InternalMyDsl.g:5829:2: ( rule__Flow__Group_8_2__0 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==43) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalMyDsl.g:5829:3: rule__Flow__Group_8_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Flow__Group_8_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

             after(grammarAccess.getFlowAccess().getGroup_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8__2__Impl"


    // $ANTLR start "rule__Flow__Group_8_2__0"
    // InternalMyDsl.g:5838:1: rule__Flow__Group_8_2__0 : rule__Flow__Group_8_2__0__Impl rule__Flow__Group_8_2__1 ;
    public final void rule__Flow__Group_8_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5842:1: ( rule__Flow__Group_8_2__0__Impl rule__Flow__Group_8_2__1 )
            // InternalMyDsl.g:5843:2: rule__Flow__Group_8_2__0__Impl rule__Flow__Group_8_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Flow__Group_8_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Flow__Group_8_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8_2__0"


    // $ANTLR start "rule__Flow__Group_8_2__0__Impl"
    // InternalMyDsl.g:5850:1: rule__Flow__Group_8_2__0__Impl : ( ',' ) ;
    public final void rule__Flow__Group_8_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5854:1: ( ( ',' ) )
            // InternalMyDsl.g:5855:1: ( ',' )
            {
            // InternalMyDsl.g:5855:1: ( ',' )
            // InternalMyDsl.g:5856:2: ','
            {
             before(grammarAccess.getFlowAccess().getCommaKeyword_8_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getFlowAccess().getCommaKeyword_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8_2__0__Impl"


    // $ANTLR start "rule__Flow__Group_8_2__1"
    // InternalMyDsl.g:5865:1: rule__Flow__Group_8_2__1 : rule__Flow__Group_8_2__1__Impl ;
    public final void rule__Flow__Group_8_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5869:1: ( rule__Flow__Group_8_2__1__Impl )
            // InternalMyDsl.g:5870:2: rule__Flow__Group_8_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Flow__Group_8_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8_2__1"


    // $ANTLR start "rule__Flow__Group_8_2__1__Impl"
    // InternalMyDsl.g:5876:1: rule__Flow__Group_8_2__1__Impl : ( ( rule__Flow__AssumptionAssignment_8_2_1 ) ) ;
    public final void rule__Flow__Group_8_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5880:1: ( ( ( rule__Flow__AssumptionAssignment_8_2_1 ) ) )
            // InternalMyDsl.g:5881:1: ( ( rule__Flow__AssumptionAssignment_8_2_1 ) )
            {
            // InternalMyDsl.g:5881:1: ( ( rule__Flow__AssumptionAssignment_8_2_1 ) )
            // InternalMyDsl.g:5882:2: ( rule__Flow__AssumptionAssignment_8_2_1 )
            {
             before(grammarAccess.getFlowAccess().getAssumptionAssignment_8_2_1()); 
            // InternalMyDsl.g:5883:2: ( rule__Flow__AssumptionAssignment_8_2_1 )
            // InternalMyDsl.g:5883:3: rule__Flow__AssumptionAssignment_8_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Flow__AssumptionAssignment_8_2_1();

            state._fsp--;


            }

             after(grammarAccess.getFlowAccess().getAssumptionAssignment_8_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__Group_8_2__1__Impl"


    // $ANTLR start "rule__DataStore__Group__0"
    // InternalMyDsl.g:5892:1: rule__DataStore__Group__0 : rule__DataStore__Group__0__Impl rule__DataStore__Group__1 ;
    public final void rule__DataStore__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5896:1: ( rule__DataStore__Group__0__Impl rule__DataStore__Group__1 )
            // InternalMyDsl.g:5897:2: rule__DataStore__Group__0__Impl rule__DataStore__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__DataStore__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__0"


    // $ANTLR start "rule__DataStore__Group__0__Impl"
    // InternalMyDsl.g:5904:1: rule__DataStore__Group__0__Impl : ( () ) ;
    public final void rule__DataStore__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5908:1: ( ( () ) )
            // InternalMyDsl.g:5909:1: ( () )
            {
            // InternalMyDsl.g:5909:1: ( () )
            // InternalMyDsl.g:5910:2: ()
            {
             before(grammarAccess.getDataStoreAccess().getDataStoreAction_0()); 
            // InternalMyDsl.g:5911:2: ()
            // InternalMyDsl.g:5911:3: 
            {
            }

             after(grammarAccess.getDataStoreAccess().getDataStoreAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__0__Impl"


    // $ANTLR start "rule__DataStore__Group__1"
    // InternalMyDsl.g:5919:1: rule__DataStore__Group__1 : rule__DataStore__Group__1__Impl rule__DataStore__Group__2 ;
    public final void rule__DataStore__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5923:1: ( rule__DataStore__Group__1__Impl rule__DataStore__Group__2 )
            // InternalMyDsl.g:5924:2: rule__DataStore__Group__1__Impl rule__DataStore__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__DataStore__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__1"


    // $ANTLR start "rule__DataStore__Group__1__Impl"
    // InternalMyDsl.g:5931:1: rule__DataStore__Group__1__Impl : ( 'DataStore' ) ;
    public final void rule__DataStore__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5935:1: ( ( 'DataStore' ) )
            // InternalMyDsl.g:5936:1: ( 'DataStore' )
            {
            // InternalMyDsl.g:5936:1: ( 'DataStore' )
            // InternalMyDsl.g:5937:2: 'DataStore'
            {
             before(grammarAccess.getDataStoreAccess().getDataStoreKeyword_1()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getDataStoreKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__1__Impl"


    // $ANTLR start "rule__DataStore__Group__2"
    // InternalMyDsl.g:5946:1: rule__DataStore__Group__2 : rule__DataStore__Group__2__Impl rule__DataStore__Group__3 ;
    public final void rule__DataStore__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5950:1: ( rule__DataStore__Group__2__Impl rule__DataStore__Group__3 )
            // InternalMyDsl.g:5951:2: rule__DataStore__Group__2__Impl rule__DataStore__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__DataStore__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__2"


    // $ANTLR start "rule__DataStore__Group__2__Impl"
    // InternalMyDsl.g:5958:1: rule__DataStore__Group__2__Impl : ( ( rule__DataStore__NameAssignment_2 ) ) ;
    public final void rule__DataStore__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5962:1: ( ( ( rule__DataStore__NameAssignment_2 ) ) )
            // InternalMyDsl.g:5963:1: ( ( rule__DataStore__NameAssignment_2 ) )
            {
            // InternalMyDsl.g:5963:1: ( ( rule__DataStore__NameAssignment_2 ) )
            // InternalMyDsl.g:5964:2: ( rule__DataStore__NameAssignment_2 )
            {
             before(grammarAccess.getDataStoreAccess().getNameAssignment_2()); 
            // InternalMyDsl.g:5965:2: ( rule__DataStore__NameAssignment_2 )
            // InternalMyDsl.g:5965:3: rule__DataStore__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__2__Impl"


    // $ANTLR start "rule__DataStore__Group__3"
    // InternalMyDsl.g:5973:1: rule__DataStore__Group__3 : rule__DataStore__Group__3__Impl rule__DataStore__Group__4 ;
    public final void rule__DataStore__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5977:1: ( rule__DataStore__Group__3__Impl rule__DataStore__Group__4 )
            // InternalMyDsl.g:5978:2: rule__DataStore__Group__3__Impl rule__DataStore__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__DataStore__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__3"


    // $ANTLR start "rule__DataStore__Group__3__Impl"
    // InternalMyDsl.g:5985:1: rule__DataStore__Group__3__Impl : ( '[' ) ;
    public final void rule__DataStore__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5989:1: ( ( '[' ) )
            // InternalMyDsl.g:5990:1: ( '[' )
            {
            // InternalMyDsl.g:5990:1: ( '[' )
            // InternalMyDsl.g:5991:2: '['
            {
             before(grammarAccess.getDataStoreAccess().getLeftSquareBracketKeyword_3()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__3__Impl"


    // $ANTLR start "rule__DataStore__Group__4"
    // InternalMyDsl.g:6000:1: rule__DataStore__Group__4 : rule__DataStore__Group__4__Impl rule__DataStore__Group__5 ;
    public final void rule__DataStore__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6004:1: ( rule__DataStore__Group__4__Impl rule__DataStore__Group__5 )
            // InternalMyDsl.g:6005:2: rule__DataStore__Group__4__Impl rule__DataStore__Group__5
            {
            pushFollow(FOLLOW_27);
            rule__DataStore__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__4"


    // $ANTLR start "rule__DataStore__Group__4__Impl"
    // InternalMyDsl.g:6012:1: rule__DataStore__Group__4__Impl : ( ( rule__DataStore__Group_4__0 )? ) ;
    public final void rule__DataStore__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6016:1: ( ( ( rule__DataStore__Group_4__0 )? ) )
            // InternalMyDsl.g:6017:1: ( ( rule__DataStore__Group_4__0 )? )
            {
            // InternalMyDsl.g:6017:1: ( ( rule__DataStore__Group_4__0 )? )
            // InternalMyDsl.g:6018:2: ( rule__DataStore__Group_4__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_4()); 
            // InternalMyDsl.g:6019:2: ( rule__DataStore__Group_4__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==42) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalMyDsl.g:6019:3: rule__DataStore__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStore__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStoreAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__4__Impl"


    // $ANTLR start "rule__DataStore__Group__5"
    // InternalMyDsl.g:6027:1: rule__DataStore__Group__5 : rule__DataStore__Group__5__Impl rule__DataStore__Group__6 ;
    public final void rule__DataStore__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6031:1: ( rule__DataStore__Group__5__Impl rule__DataStore__Group__6 )
            // InternalMyDsl.g:6032:2: rule__DataStore__Group__5__Impl rule__DataStore__Group__6
            {
            pushFollow(FOLLOW_27);
            rule__DataStore__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__5"


    // $ANTLR start "rule__DataStore__Group__5__Impl"
    // InternalMyDsl.g:6039:1: rule__DataStore__Group__5__Impl : ( ( rule__DataStore__Group_5__0 )? ) ;
    public final void rule__DataStore__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6043:1: ( ( ( rule__DataStore__Group_5__0 )? ) )
            // InternalMyDsl.g:6044:1: ( ( rule__DataStore__Group_5__0 )? )
            {
            // InternalMyDsl.g:6044:1: ( ( rule__DataStore__Group_5__0 )? )
            // InternalMyDsl.g:6045:2: ( rule__DataStore__Group_5__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_5()); 
            // InternalMyDsl.g:6046:2: ( rule__DataStore__Group_5__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==57) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalMyDsl.g:6046:3: rule__DataStore__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStore__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStoreAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__5__Impl"


    // $ANTLR start "rule__DataStore__Group__6"
    // InternalMyDsl.g:6054:1: rule__DataStore__Group__6 : rule__DataStore__Group__6__Impl rule__DataStore__Group__7 ;
    public final void rule__DataStore__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6058:1: ( rule__DataStore__Group__6__Impl rule__DataStore__Group__7 )
            // InternalMyDsl.g:6059:2: rule__DataStore__Group__6__Impl rule__DataStore__Group__7
            {
            pushFollow(FOLLOW_27);
            rule__DataStore__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__6"


    // $ANTLR start "rule__DataStore__Group__6__Impl"
    // InternalMyDsl.g:6066:1: rule__DataStore__Group__6__Impl : ( ( rule__DataStore__Group_6__0 )? ) ;
    public final void rule__DataStore__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6070:1: ( ( ( rule__DataStore__Group_6__0 )? ) )
            // InternalMyDsl.g:6071:1: ( ( rule__DataStore__Group_6__0 )? )
            {
            // InternalMyDsl.g:6071:1: ( ( rule__DataStore__Group_6__0 )? )
            // InternalMyDsl.g:6072:2: ( rule__DataStore__Group_6__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_6()); 
            // InternalMyDsl.g:6073:2: ( rule__DataStore__Group_6__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==58) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalMyDsl.g:6073:3: rule__DataStore__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStore__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStoreAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__6__Impl"


    // $ANTLR start "rule__DataStore__Group__7"
    // InternalMyDsl.g:6081:1: rule__DataStore__Group__7 : rule__DataStore__Group__7__Impl rule__DataStore__Group__8 ;
    public final void rule__DataStore__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6085:1: ( rule__DataStore__Group__7__Impl rule__DataStore__Group__8 )
            // InternalMyDsl.g:6086:2: rule__DataStore__Group__7__Impl rule__DataStore__Group__8
            {
            pushFollow(FOLLOW_27);
            rule__DataStore__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__7"


    // $ANTLR start "rule__DataStore__Group__7__Impl"
    // InternalMyDsl.g:6093:1: rule__DataStore__Group__7__Impl : ( ( rule__DataStore__Group_7__0 )? ) ;
    public final void rule__DataStore__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6097:1: ( ( ( rule__DataStore__Group_7__0 )? ) )
            // InternalMyDsl.g:6098:1: ( ( rule__DataStore__Group_7__0 )? )
            {
            // InternalMyDsl.g:6098:1: ( ( rule__DataStore__Group_7__0 )? )
            // InternalMyDsl.g:6099:2: ( rule__DataStore__Group_7__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_7()); 
            // InternalMyDsl.g:6100:2: ( rule__DataStore__Group_7__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==60) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalMyDsl.g:6100:3: rule__DataStore__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStore__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStoreAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__7__Impl"


    // $ANTLR start "rule__DataStore__Group__8"
    // InternalMyDsl.g:6108:1: rule__DataStore__Group__8 : rule__DataStore__Group__8__Impl rule__DataStore__Group__9 ;
    public final void rule__DataStore__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6112:1: ( rule__DataStore__Group__8__Impl rule__DataStore__Group__9 )
            // InternalMyDsl.g:6113:2: rule__DataStore__Group__8__Impl rule__DataStore__Group__9
            {
            pushFollow(FOLLOW_27);
            rule__DataStore__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__8"


    // $ANTLR start "rule__DataStore__Group__8__Impl"
    // InternalMyDsl.g:6120:1: rule__DataStore__Group__8__Impl : ( ( rule__DataStore__Group_8__0 )? ) ;
    public final void rule__DataStore__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6124:1: ( ( ( rule__DataStore__Group_8__0 )? ) )
            // InternalMyDsl.g:6125:1: ( ( rule__DataStore__Group_8__0 )? )
            {
            // InternalMyDsl.g:6125:1: ( ( rule__DataStore__Group_8__0 )? )
            // InternalMyDsl.g:6126:2: ( rule__DataStore__Group_8__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_8()); 
            // InternalMyDsl.g:6127:2: ( rule__DataStore__Group_8__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==61) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalMyDsl.g:6127:3: rule__DataStore__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataStore__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataStoreAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__8__Impl"


    // $ANTLR start "rule__DataStore__Group__9"
    // InternalMyDsl.g:6135:1: rule__DataStore__Group__9 : rule__DataStore__Group__9__Impl ;
    public final void rule__DataStore__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6139:1: ( rule__DataStore__Group__9__Impl )
            // InternalMyDsl.g:6140:2: rule__DataStore__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__9"


    // $ANTLR start "rule__DataStore__Group__9__Impl"
    // InternalMyDsl.g:6146:1: rule__DataStore__Group__9__Impl : ( ']' ) ;
    public final void rule__DataStore__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6150:1: ( ( ']' ) )
            // InternalMyDsl.g:6151:1: ( ']' )
            {
            // InternalMyDsl.g:6151:1: ( ']' )
            // InternalMyDsl.g:6152:2: ']'
            {
             before(grammarAccess.getDataStoreAccess().getRightSquareBracketKeyword_9()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getRightSquareBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group__9__Impl"


    // $ANTLR start "rule__DataStore__Group_4__0"
    // InternalMyDsl.g:6162:1: rule__DataStore__Group_4__0 : rule__DataStore__Group_4__0__Impl rule__DataStore__Group_4__1 ;
    public final void rule__DataStore__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6166:1: ( rule__DataStore__Group_4__0__Impl rule__DataStore__Group_4__1 )
            // InternalMyDsl.g:6167:2: rule__DataStore__Group_4__0__Impl rule__DataStore__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__DataStore__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4__0"


    // $ANTLR start "rule__DataStore__Group_4__0__Impl"
    // InternalMyDsl.g:6174:1: rule__DataStore__Group_4__0__Impl : ( 'assets:' ) ;
    public final void rule__DataStore__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6178:1: ( ( 'assets:' ) )
            // InternalMyDsl.g:6179:1: ( 'assets:' )
            {
            // InternalMyDsl.g:6179:1: ( 'assets:' )
            // InternalMyDsl.g:6180:2: 'assets:'
            {
             before(grammarAccess.getDataStoreAccess().getAssetsKeyword_4_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getAssetsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4__0__Impl"


    // $ANTLR start "rule__DataStore__Group_4__1"
    // InternalMyDsl.g:6189:1: rule__DataStore__Group_4__1 : rule__DataStore__Group_4__1__Impl rule__DataStore__Group_4__2 ;
    public final void rule__DataStore__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6193:1: ( rule__DataStore__Group_4__1__Impl rule__DataStore__Group_4__2 )
            // InternalMyDsl.g:6194:2: rule__DataStore__Group_4__1__Impl rule__DataStore__Group_4__2
            {
            pushFollow(FOLLOW_8);
            rule__DataStore__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4__1"


    // $ANTLR start "rule__DataStore__Group_4__1__Impl"
    // InternalMyDsl.g:6201:1: rule__DataStore__Group_4__1__Impl : ( ( rule__DataStore__AssetsAssignment_4_1 ) ) ;
    public final void rule__DataStore__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6205:1: ( ( ( rule__DataStore__AssetsAssignment_4_1 ) ) )
            // InternalMyDsl.g:6206:1: ( ( rule__DataStore__AssetsAssignment_4_1 ) )
            {
            // InternalMyDsl.g:6206:1: ( ( rule__DataStore__AssetsAssignment_4_1 ) )
            // InternalMyDsl.g:6207:2: ( rule__DataStore__AssetsAssignment_4_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssignment_4_1()); 
            // InternalMyDsl.g:6208:2: ( rule__DataStore__AssetsAssignment_4_1 )
            // InternalMyDsl.g:6208:3: rule__DataStore__AssetsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__AssetsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getAssetsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4__1__Impl"


    // $ANTLR start "rule__DataStore__Group_4__2"
    // InternalMyDsl.g:6216:1: rule__DataStore__Group_4__2 : rule__DataStore__Group_4__2__Impl ;
    public final void rule__DataStore__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6220:1: ( rule__DataStore__Group_4__2__Impl )
            // InternalMyDsl.g:6221:2: rule__DataStore__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4__2"


    // $ANTLR start "rule__DataStore__Group_4__2__Impl"
    // InternalMyDsl.g:6227:1: rule__DataStore__Group_4__2__Impl : ( ( rule__DataStore__Group_4_2__0 )* ) ;
    public final void rule__DataStore__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6231:1: ( ( ( rule__DataStore__Group_4_2__0 )* ) )
            // InternalMyDsl.g:6232:1: ( ( rule__DataStore__Group_4_2__0 )* )
            {
            // InternalMyDsl.g:6232:1: ( ( rule__DataStore__Group_4_2__0 )* )
            // InternalMyDsl.g:6233:2: ( rule__DataStore__Group_4_2__0 )*
            {
             before(grammarAccess.getDataStoreAccess().getGroup_4_2()); 
            // InternalMyDsl.g:6234:2: ( rule__DataStore__Group_4_2__0 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==43) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalMyDsl.g:6234:3: rule__DataStore__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataStore__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

             after(grammarAccess.getDataStoreAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4__2__Impl"


    // $ANTLR start "rule__DataStore__Group_4_2__0"
    // InternalMyDsl.g:6243:1: rule__DataStore__Group_4_2__0 : rule__DataStore__Group_4_2__0__Impl rule__DataStore__Group_4_2__1 ;
    public final void rule__DataStore__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6247:1: ( rule__DataStore__Group_4_2__0__Impl rule__DataStore__Group_4_2__1 )
            // InternalMyDsl.g:6248:2: rule__DataStore__Group_4_2__0__Impl rule__DataStore__Group_4_2__1
            {
            pushFollow(FOLLOW_4);
            rule__DataStore__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4_2__0"


    // $ANTLR start "rule__DataStore__Group_4_2__0__Impl"
    // InternalMyDsl.g:6255:1: rule__DataStore__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__DataStore__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6259:1: ( ( ',' ) )
            // InternalMyDsl.g:6260:1: ( ',' )
            {
            // InternalMyDsl.g:6260:1: ( ',' )
            // InternalMyDsl.g:6261:2: ','
            {
             before(grammarAccess.getDataStoreAccess().getCommaKeyword_4_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4_2__0__Impl"


    // $ANTLR start "rule__DataStore__Group_4_2__1"
    // InternalMyDsl.g:6270:1: rule__DataStore__Group_4_2__1 : rule__DataStore__Group_4_2__1__Impl ;
    public final void rule__DataStore__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6274:1: ( rule__DataStore__Group_4_2__1__Impl )
            // InternalMyDsl.g:6275:2: rule__DataStore__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4_2__1"


    // $ANTLR start "rule__DataStore__Group_4_2__1__Impl"
    // InternalMyDsl.g:6281:1: rule__DataStore__Group_4_2__1__Impl : ( ( rule__DataStore__AssetsAssignment_4_2_1 ) ) ;
    public final void rule__DataStore__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6285:1: ( ( ( rule__DataStore__AssetsAssignment_4_2_1 ) ) )
            // InternalMyDsl.g:6286:1: ( ( rule__DataStore__AssetsAssignment_4_2_1 ) )
            {
            // InternalMyDsl.g:6286:1: ( ( rule__DataStore__AssetsAssignment_4_2_1 ) )
            // InternalMyDsl.g:6287:2: ( rule__DataStore__AssetsAssignment_4_2_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssignment_4_2_1()); 
            // InternalMyDsl.g:6288:2: ( rule__DataStore__AssetsAssignment_4_2_1 )
            // InternalMyDsl.g:6288:3: rule__DataStore__AssetsAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__AssetsAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getAssetsAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_4_2__1__Impl"


    // $ANTLR start "rule__DataStore__Group_5__0"
    // InternalMyDsl.g:6297:1: rule__DataStore__Group_5__0 : rule__DataStore__Group_5__0__Impl rule__DataStore__Group_5__1 ;
    public final void rule__DataStore__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6301:1: ( rule__DataStore__Group_5__0__Impl rule__DataStore__Group_5__1 )
            // InternalMyDsl.g:6302:2: rule__DataStore__Group_5__0__Impl rule__DataStore__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__DataStore__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5__0"


    // $ANTLR start "rule__DataStore__Group_5__0__Impl"
    // InternalMyDsl.g:6309:1: rule__DataStore__Group_5__0__Impl : ( 'assumption:' ) ;
    public final void rule__DataStore__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6313:1: ( ( 'assumption:' ) )
            // InternalMyDsl.g:6314:1: ( 'assumption:' )
            {
            // InternalMyDsl.g:6314:1: ( 'assumption:' )
            // InternalMyDsl.g:6315:2: 'assumption:'
            {
             before(grammarAccess.getDataStoreAccess().getAssumptionKeyword_5_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getAssumptionKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5__0__Impl"


    // $ANTLR start "rule__DataStore__Group_5__1"
    // InternalMyDsl.g:6324:1: rule__DataStore__Group_5__1 : rule__DataStore__Group_5__1__Impl rule__DataStore__Group_5__2 ;
    public final void rule__DataStore__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6328:1: ( rule__DataStore__Group_5__1__Impl rule__DataStore__Group_5__2 )
            // InternalMyDsl.g:6329:2: rule__DataStore__Group_5__1__Impl rule__DataStore__Group_5__2
            {
            pushFollow(FOLLOW_8);
            rule__DataStore__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5__1"


    // $ANTLR start "rule__DataStore__Group_5__1__Impl"
    // InternalMyDsl.g:6336:1: rule__DataStore__Group_5__1__Impl : ( ( rule__DataStore__AssumptionAssignment_5_1 ) ) ;
    public final void rule__DataStore__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6340:1: ( ( ( rule__DataStore__AssumptionAssignment_5_1 ) ) )
            // InternalMyDsl.g:6341:1: ( ( rule__DataStore__AssumptionAssignment_5_1 ) )
            {
            // InternalMyDsl.g:6341:1: ( ( rule__DataStore__AssumptionAssignment_5_1 ) )
            // InternalMyDsl.g:6342:2: ( rule__DataStore__AssumptionAssignment_5_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAssumptionAssignment_5_1()); 
            // InternalMyDsl.g:6343:2: ( rule__DataStore__AssumptionAssignment_5_1 )
            // InternalMyDsl.g:6343:3: rule__DataStore__AssumptionAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__AssumptionAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getAssumptionAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5__1__Impl"


    // $ANTLR start "rule__DataStore__Group_5__2"
    // InternalMyDsl.g:6351:1: rule__DataStore__Group_5__2 : rule__DataStore__Group_5__2__Impl ;
    public final void rule__DataStore__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6355:1: ( rule__DataStore__Group_5__2__Impl )
            // InternalMyDsl.g:6356:2: rule__DataStore__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5__2"


    // $ANTLR start "rule__DataStore__Group_5__2__Impl"
    // InternalMyDsl.g:6362:1: rule__DataStore__Group_5__2__Impl : ( ( rule__DataStore__Group_5_2__0 )* ) ;
    public final void rule__DataStore__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6366:1: ( ( ( rule__DataStore__Group_5_2__0 )* ) )
            // InternalMyDsl.g:6367:1: ( ( rule__DataStore__Group_5_2__0 )* )
            {
            // InternalMyDsl.g:6367:1: ( ( rule__DataStore__Group_5_2__0 )* )
            // InternalMyDsl.g:6368:2: ( rule__DataStore__Group_5_2__0 )*
            {
             before(grammarAccess.getDataStoreAccess().getGroup_5_2()); 
            // InternalMyDsl.g:6369:2: ( rule__DataStore__Group_5_2__0 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==43) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalMyDsl.g:6369:3: rule__DataStore__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataStore__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

             after(grammarAccess.getDataStoreAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5__2__Impl"


    // $ANTLR start "rule__DataStore__Group_5_2__0"
    // InternalMyDsl.g:6378:1: rule__DataStore__Group_5_2__0 : rule__DataStore__Group_5_2__0__Impl rule__DataStore__Group_5_2__1 ;
    public final void rule__DataStore__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6382:1: ( rule__DataStore__Group_5_2__0__Impl rule__DataStore__Group_5_2__1 )
            // InternalMyDsl.g:6383:2: rule__DataStore__Group_5_2__0__Impl rule__DataStore__Group_5_2__1
            {
            pushFollow(FOLLOW_5);
            rule__DataStore__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_5_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5_2__0"


    // $ANTLR start "rule__DataStore__Group_5_2__0__Impl"
    // InternalMyDsl.g:6390:1: rule__DataStore__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__DataStore__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6394:1: ( ( ',' ) )
            // InternalMyDsl.g:6395:1: ( ',' )
            {
            // InternalMyDsl.g:6395:1: ( ',' )
            // InternalMyDsl.g:6396:2: ','
            {
             before(grammarAccess.getDataStoreAccess().getCommaKeyword_5_2_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getCommaKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5_2__0__Impl"


    // $ANTLR start "rule__DataStore__Group_5_2__1"
    // InternalMyDsl.g:6405:1: rule__DataStore__Group_5_2__1 : rule__DataStore__Group_5_2__1__Impl ;
    public final void rule__DataStore__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6409:1: ( rule__DataStore__Group_5_2__1__Impl )
            // InternalMyDsl.g:6410:2: rule__DataStore__Group_5_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group_5_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5_2__1"


    // $ANTLR start "rule__DataStore__Group_5_2__1__Impl"
    // InternalMyDsl.g:6416:1: rule__DataStore__Group_5_2__1__Impl : ( ( rule__DataStore__AssumptionAssignment_5_2_1 ) ) ;
    public final void rule__DataStore__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6420:1: ( ( ( rule__DataStore__AssumptionAssignment_5_2_1 ) ) )
            // InternalMyDsl.g:6421:1: ( ( rule__DataStore__AssumptionAssignment_5_2_1 ) )
            {
            // InternalMyDsl.g:6421:1: ( ( rule__DataStore__AssumptionAssignment_5_2_1 ) )
            // InternalMyDsl.g:6422:2: ( rule__DataStore__AssumptionAssignment_5_2_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAssumptionAssignment_5_2_1()); 
            // InternalMyDsl.g:6423:2: ( rule__DataStore__AssumptionAssignment_5_2_1 )
            // InternalMyDsl.g:6423:3: rule__DataStore__AssumptionAssignment_5_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__AssumptionAssignment_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getAssumptionAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_5_2__1__Impl"


    // $ANTLR start "rule__DataStore__Group_6__0"
    // InternalMyDsl.g:6432:1: rule__DataStore__Group_6__0 : rule__DataStore__Group_6__0__Impl rule__DataStore__Group_6__1 ;
    public final void rule__DataStore__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6436:1: ( rule__DataStore__Group_6__0__Impl rule__DataStore__Group_6__1 )
            // InternalMyDsl.g:6437:2: rule__DataStore__Group_6__0__Impl rule__DataStore__Group_6__1
            {
            pushFollow(FOLLOW_20);
            rule__DataStore__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6__0"


    // $ANTLR start "rule__DataStore__Group_6__0__Impl"
    // InternalMyDsl.g:6444:1: rule__DataStore__Group_6__0__Impl : ( 'incoming' ) ;
    public final void rule__DataStore__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6448:1: ( ( 'incoming' ) )
            // InternalMyDsl.g:6449:1: ( 'incoming' )
            {
            // InternalMyDsl.g:6449:1: ( 'incoming' )
            // InternalMyDsl.g:6450:2: 'incoming'
            {
             before(grammarAccess.getDataStoreAccess().getIncomingKeyword_6_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getIncomingKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6__0__Impl"


    // $ANTLR start "rule__DataStore__Group_6__1"
    // InternalMyDsl.g:6459:1: rule__DataStore__Group_6__1 : rule__DataStore__Group_6__1__Impl rule__DataStore__Group_6__2 ;
    public final void rule__DataStore__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6463:1: ( rule__DataStore__Group_6__1__Impl rule__DataStore__Group_6__2 )
            // InternalMyDsl.g:6464:2: rule__DataStore__Group_6__1__Impl rule__DataStore__Group_6__2
            {
            pushFollow(FOLLOW_4);
            rule__DataStore__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6__1"


    // $ANTLR start "rule__DataStore__Group_6__1__Impl"
    // InternalMyDsl.g:6471:1: rule__DataStore__Group_6__1__Impl : ( 'flows:' ) ;
    public final void rule__DataStore__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6475:1: ( ( 'flows:' ) )
            // InternalMyDsl.g:6476:1: ( 'flows:' )
            {
            // InternalMyDsl.g:6476:1: ( 'flows:' )
            // InternalMyDsl.g:6477:2: 'flows:'
            {
             before(grammarAccess.getDataStoreAccess().getFlowsKeyword_6_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getFlowsKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6__1__Impl"


    // $ANTLR start "rule__DataStore__Group_6__2"
    // InternalMyDsl.g:6486:1: rule__DataStore__Group_6__2 : rule__DataStore__Group_6__2__Impl rule__DataStore__Group_6__3 ;
    public final void rule__DataStore__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6490:1: ( rule__DataStore__Group_6__2__Impl rule__DataStore__Group_6__3 )
            // InternalMyDsl.g:6491:2: rule__DataStore__Group_6__2__Impl rule__DataStore__Group_6__3
            {
            pushFollow(FOLLOW_8);
            rule__DataStore__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6__2"


    // $ANTLR start "rule__DataStore__Group_6__2__Impl"
    // InternalMyDsl.g:6498:1: rule__DataStore__Group_6__2__Impl : ( ( rule__DataStore__InflowsAssignment_6_2 ) ) ;
    public final void rule__DataStore__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6502:1: ( ( ( rule__DataStore__InflowsAssignment_6_2 ) ) )
            // InternalMyDsl.g:6503:1: ( ( rule__DataStore__InflowsAssignment_6_2 ) )
            {
            // InternalMyDsl.g:6503:1: ( ( rule__DataStore__InflowsAssignment_6_2 ) )
            // InternalMyDsl.g:6504:2: ( rule__DataStore__InflowsAssignment_6_2 )
            {
             before(grammarAccess.getDataStoreAccess().getInflowsAssignment_6_2()); 
            // InternalMyDsl.g:6505:2: ( rule__DataStore__InflowsAssignment_6_2 )
            // InternalMyDsl.g:6505:3: rule__DataStore__InflowsAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__InflowsAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getInflowsAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6__2__Impl"


    // $ANTLR start "rule__DataStore__Group_6__3"
    // InternalMyDsl.g:6513:1: rule__DataStore__Group_6__3 : rule__DataStore__Group_6__3__Impl ;
    public final void rule__DataStore__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6517:1: ( rule__DataStore__Group_6__3__Impl )
            // InternalMyDsl.g:6518:2: rule__DataStore__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group_6__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6__3"


    // $ANTLR start "rule__DataStore__Group_6__3__Impl"
    // InternalMyDsl.g:6524:1: rule__DataStore__Group_6__3__Impl : ( ( rule__DataStore__Group_6_3__0 )* ) ;
    public final void rule__DataStore__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6528:1: ( ( ( rule__DataStore__Group_6_3__0 )* ) )
            // InternalMyDsl.g:6529:1: ( ( rule__DataStore__Group_6_3__0 )* )
            {
            // InternalMyDsl.g:6529:1: ( ( rule__DataStore__Group_6_3__0 )* )
            // InternalMyDsl.g:6530:2: ( rule__DataStore__Group_6_3__0 )*
            {
             before(grammarAccess.getDataStoreAccess().getGroup_6_3()); 
            // InternalMyDsl.g:6531:2: ( rule__DataStore__Group_6_3__0 )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==43) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalMyDsl.g:6531:3: rule__DataStore__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataStore__Group_6_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

             after(grammarAccess.getDataStoreAccess().getGroup_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6__3__Impl"


    // $ANTLR start "rule__DataStore__Group_6_3__0"
    // InternalMyDsl.g:6540:1: rule__DataStore__Group_6_3__0 : rule__DataStore__Group_6_3__0__Impl rule__DataStore__Group_6_3__1 ;
    public final void rule__DataStore__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6544:1: ( rule__DataStore__Group_6_3__0__Impl rule__DataStore__Group_6_3__1 )
            // InternalMyDsl.g:6545:2: rule__DataStore__Group_6_3__0__Impl rule__DataStore__Group_6_3__1
            {
            pushFollow(FOLLOW_4);
            rule__DataStore__Group_6_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_6_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6_3__0"


    // $ANTLR start "rule__DataStore__Group_6_3__0__Impl"
    // InternalMyDsl.g:6552:1: rule__DataStore__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__DataStore__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6556:1: ( ( ',' ) )
            // InternalMyDsl.g:6557:1: ( ',' )
            {
            // InternalMyDsl.g:6557:1: ( ',' )
            // InternalMyDsl.g:6558:2: ','
            {
             before(grammarAccess.getDataStoreAccess().getCommaKeyword_6_3_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getCommaKeyword_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6_3__0__Impl"


    // $ANTLR start "rule__DataStore__Group_6_3__1"
    // InternalMyDsl.g:6567:1: rule__DataStore__Group_6_3__1 : rule__DataStore__Group_6_3__1__Impl ;
    public final void rule__DataStore__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6571:1: ( rule__DataStore__Group_6_3__1__Impl )
            // InternalMyDsl.g:6572:2: rule__DataStore__Group_6_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group_6_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6_3__1"


    // $ANTLR start "rule__DataStore__Group_6_3__1__Impl"
    // InternalMyDsl.g:6578:1: rule__DataStore__Group_6_3__1__Impl : ( ( rule__DataStore__InflowsAssignment_6_3_1 ) ) ;
    public final void rule__DataStore__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6582:1: ( ( ( rule__DataStore__InflowsAssignment_6_3_1 ) ) )
            // InternalMyDsl.g:6583:1: ( ( rule__DataStore__InflowsAssignment_6_3_1 ) )
            {
            // InternalMyDsl.g:6583:1: ( ( rule__DataStore__InflowsAssignment_6_3_1 ) )
            // InternalMyDsl.g:6584:2: ( rule__DataStore__InflowsAssignment_6_3_1 )
            {
             before(grammarAccess.getDataStoreAccess().getInflowsAssignment_6_3_1()); 
            // InternalMyDsl.g:6585:2: ( rule__DataStore__InflowsAssignment_6_3_1 )
            // InternalMyDsl.g:6585:3: rule__DataStore__InflowsAssignment_6_3_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__InflowsAssignment_6_3_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getInflowsAssignment_6_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_6_3__1__Impl"


    // $ANTLR start "rule__DataStore__Group_7__0"
    // InternalMyDsl.g:6594:1: rule__DataStore__Group_7__0 : rule__DataStore__Group_7__0__Impl rule__DataStore__Group_7__1 ;
    public final void rule__DataStore__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6598:1: ( rule__DataStore__Group_7__0__Impl rule__DataStore__Group_7__1 )
            // InternalMyDsl.g:6599:2: rule__DataStore__Group_7__0__Impl rule__DataStore__Group_7__1
            {
            pushFollow(FOLLOW_20);
            rule__DataStore__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7__0"


    // $ANTLR start "rule__DataStore__Group_7__0__Impl"
    // InternalMyDsl.g:6606:1: rule__DataStore__Group_7__0__Impl : ( 'outgoing' ) ;
    public final void rule__DataStore__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6610:1: ( ( 'outgoing' ) )
            // InternalMyDsl.g:6611:1: ( 'outgoing' )
            {
            // InternalMyDsl.g:6611:1: ( 'outgoing' )
            // InternalMyDsl.g:6612:2: 'outgoing'
            {
             before(grammarAccess.getDataStoreAccess().getOutgoingKeyword_7_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getOutgoingKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7__0__Impl"


    // $ANTLR start "rule__DataStore__Group_7__1"
    // InternalMyDsl.g:6621:1: rule__DataStore__Group_7__1 : rule__DataStore__Group_7__1__Impl rule__DataStore__Group_7__2 ;
    public final void rule__DataStore__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6625:1: ( rule__DataStore__Group_7__1__Impl rule__DataStore__Group_7__2 )
            // InternalMyDsl.g:6626:2: rule__DataStore__Group_7__1__Impl rule__DataStore__Group_7__2
            {
            pushFollow(FOLLOW_4);
            rule__DataStore__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7__1"


    // $ANTLR start "rule__DataStore__Group_7__1__Impl"
    // InternalMyDsl.g:6633:1: rule__DataStore__Group_7__1__Impl : ( 'flows:' ) ;
    public final void rule__DataStore__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6637:1: ( ( 'flows:' ) )
            // InternalMyDsl.g:6638:1: ( 'flows:' )
            {
            // InternalMyDsl.g:6638:1: ( 'flows:' )
            // InternalMyDsl.g:6639:2: 'flows:'
            {
             before(grammarAccess.getDataStoreAccess().getFlowsKeyword_7_1()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getFlowsKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7__1__Impl"


    // $ANTLR start "rule__DataStore__Group_7__2"
    // InternalMyDsl.g:6648:1: rule__DataStore__Group_7__2 : rule__DataStore__Group_7__2__Impl rule__DataStore__Group_7__3 ;
    public final void rule__DataStore__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6652:1: ( rule__DataStore__Group_7__2__Impl rule__DataStore__Group_7__3 )
            // InternalMyDsl.g:6653:2: rule__DataStore__Group_7__2__Impl rule__DataStore__Group_7__3
            {
            pushFollow(FOLLOW_8);
            rule__DataStore__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7__2"


    // $ANTLR start "rule__DataStore__Group_7__2__Impl"
    // InternalMyDsl.g:6660:1: rule__DataStore__Group_7__2__Impl : ( ( rule__DataStore__OutflowsAssignment_7_2 ) ) ;
    public final void rule__DataStore__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6664:1: ( ( ( rule__DataStore__OutflowsAssignment_7_2 ) ) )
            // InternalMyDsl.g:6665:1: ( ( rule__DataStore__OutflowsAssignment_7_2 ) )
            {
            // InternalMyDsl.g:6665:1: ( ( rule__DataStore__OutflowsAssignment_7_2 ) )
            // InternalMyDsl.g:6666:2: ( rule__DataStore__OutflowsAssignment_7_2 )
            {
             before(grammarAccess.getDataStoreAccess().getOutflowsAssignment_7_2()); 
            // InternalMyDsl.g:6667:2: ( rule__DataStore__OutflowsAssignment_7_2 )
            // InternalMyDsl.g:6667:3: rule__DataStore__OutflowsAssignment_7_2
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__OutflowsAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getOutflowsAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7__2__Impl"


    // $ANTLR start "rule__DataStore__Group_7__3"
    // InternalMyDsl.g:6675:1: rule__DataStore__Group_7__3 : rule__DataStore__Group_7__3__Impl ;
    public final void rule__DataStore__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6679:1: ( rule__DataStore__Group_7__3__Impl )
            // InternalMyDsl.g:6680:2: rule__DataStore__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group_7__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7__3"


    // $ANTLR start "rule__DataStore__Group_7__3__Impl"
    // InternalMyDsl.g:6686:1: rule__DataStore__Group_7__3__Impl : ( ( rule__DataStore__Group_7_3__0 )* ) ;
    public final void rule__DataStore__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6690:1: ( ( ( rule__DataStore__Group_7_3__0 )* ) )
            // InternalMyDsl.g:6691:1: ( ( rule__DataStore__Group_7_3__0 )* )
            {
            // InternalMyDsl.g:6691:1: ( ( rule__DataStore__Group_7_3__0 )* )
            // InternalMyDsl.g:6692:2: ( rule__DataStore__Group_7_3__0 )*
            {
             before(grammarAccess.getDataStoreAccess().getGroup_7_3()); 
            // InternalMyDsl.g:6693:2: ( rule__DataStore__Group_7_3__0 )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==43) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalMyDsl.g:6693:3: rule__DataStore__Group_7_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataStore__Group_7_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

             after(grammarAccess.getDataStoreAccess().getGroup_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7__3__Impl"


    // $ANTLR start "rule__DataStore__Group_7_3__0"
    // InternalMyDsl.g:6702:1: rule__DataStore__Group_7_3__0 : rule__DataStore__Group_7_3__0__Impl rule__DataStore__Group_7_3__1 ;
    public final void rule__DataStore__Group_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6706:1: ( rule__DataStore__Group_7_3__0__Impl rule__DataStore__Group_7_3__1 )
            // InternalMyDsl.g:6707:2: rule__DataStore__Group_7_3__0__Impl rule__DataStore__Group_7_3__1
            {
            pushFollow(FOLLOW_4);
            rule__DataStore__Group_7_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_7_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7_3__0"


    // $ANTLR start "rule__DataStore__Group_7_3__0__Impl"
    // InternalMyDsl.g:6714:1: rule__DataStore__Group_7_3__0__Impl : ( ',' ) ;
    public final void rule__DataStore__Group_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6718:1: ( ( ',' ) )
            // InternalMyDsl.g:6719:1: ( ',' )
            {
            // InternalMyDsl.g:6719:1: ( ',' )
            // InternalMyDsl.g:6720:2: ','
            {
             before(grammarAccess.getDataStoreAccess().getCommaKeyword_7_3_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getCommaKeyword_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7_3__0__Impl"


    // $ANTLR start "rule__DataStore__Group_7_3__1"
    // InternalMyDsl.g:6729:1: rule__DataStore__Group_7_3__1 : rule__DataStore__Group_7_3__1__Impl ;
    public final void rule__DataStore__Group_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6733:1: ( rule__DataStore__Group_7_3__1__Impl )
            // InternalMyDsl.g:6734:2: rule__DataStore__Group_7_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group_7_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7_3__1"


    // $ANTLR start "rule__DataStore__Group_7_3__1__Impl"
    // InternalMyDsl.g:6740:1: rule__DataStore__Group_7_3__1__Impl : ( ( rule__DataStore__OutflowsAssignment_7_3_1 ) ) ;
    public final void rule__DataStore__Group_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6744:1: ( ( ( rule__DataStore__OutflowsAssignment_7_3_1 ) ) )
            // InternalMyDsl.g:6745:1: ( ( rule__DataStore__OutflowsAssignment_7_3_1 ) )
            {
            // InternalMyDsl.g:6745:1: ( ( rule__DataStore__OutflowsAssignment_7_3_1 ) )
            // InternalMyDsl.g:6746:2: ( rule__DataStore__OutflowsAssignment_7_3_1 )
            {
             before(grammarAccess.getDataStoreAccess().getOutflowsAssignment_7_3_1()); 
            // InternalMyDsl.g:6747:2: ( rule__DataStore__OutflowsAssignment_7_3_1 )
            // InternalMyDsl.g:6747:3: rule__DataStore__OutflowsAssignment_7_3_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__OutflowsAssignment_7_3_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getOutflowsAssignment_7_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_7_3__1__Impl"


    // $ANTLR start "rule__DataStore__Group_8__0"
    // InternalMyDsl.g:6756:1: rule__DataStore__Group_8__0 : rule__DataStore__Group_8__0__Impl rule__DataStore__Group_8__1 ;
    public final void rule__DataStore__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6760:1: ( rule__DataStore__Group_8__0__Impl rule__DataStore__Group_8__1 )
            // InternalMyDsl.g:6761:2: rule__DataStore__Group_8__0__Impl rule__DataStore__Group_8__1
            {
            pushFollow(FOLLOW_21);
            rule__DataStore__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataStore__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_8__0"


    // $ANTLR start "rule__DataStore__Group_8__0__Impl"
    // InternalMyDsl.g:6768:1: rule__DataStore__Group_8__0__Impl : ( 'attacker:' ) ;
    public final void rule__DataStore__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6772:1: ( ( 'attacker:' ) )
            // InternalMyDsl.g:6773:1: ( 'attacker:' )
            {
            // InternalMyDsl.g:6773:1: ( 'attacker:' )
            // InternalMyDsl.g:6774:2: 'attacker:'
            {
             before(grammarAccess.getDataStoreAccess().getAttackerKeyword_8_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getDataStoreAccess().getAttackerKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_8__0__Impl"


    // $ANTLR start "rule__DataStore__Group_8__1"
    // InternalMyDsl.g:6783:1: rule__DataStore__Group_8__1 : rule__DataStore__Group_8__1__Impl ;
    public final void rule__DataStore__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6787:1: ( rule__DataStore__Group_8__1__Impl )
            // InternalMyDsl.g:6788:2: rule__DataStore__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_8__1"


    // $ANTLR start "rule__DataStore__Group_8__1__Impl"
    // InternalMyDsl.g:6794:1: rule__DataStore__Group_8__1__Impl : ( ( rule__DataStore__AttackerAssignment_8_1 ) ) ;
    public final void rule__DataStore__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6798:1: ( ( ( rule__DataStore__AttackerAssignment_8_1 ) ) )
            // InternalMyDsl.g:6799:1: ( ( rule__DataStore__AttackerAssignment_8_1 ) )
            {
            // InternalMyDsl.g:6799:1: ( ( rule__DataStore__AttackerAssignment_8_1 ) )
            // InternalMyDsl.g:6800:2: ( rule__DataStore__AttackerAssignment_8_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAttackerAssignment_8_1()); 
            // InternalMyDsl.g:6801:2: ( rule__DataStore__AttackerAssignment_8_1 )
            // InternalMyDsl.g:6801:3: rule__DataStore__AttackerAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__DataStore__AttackerAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getDataStoreAccess().getAttackerAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__Group_8__1__Impl"


    // $ANTLR start "rule__Value__Group__0"
    // InternalMyDsl.g:6810:1: rule__Value__Group__0 : rule__Value__Group__0__Impl rule__Value__Group__1 ;
    public final void rule__Value__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6814:1: ( rule__Value__Group__0__Impl rule__Value__Group__1 )
            // InternalMyDsl.g:6815:2: rule__Value__Group__0__Impl rule__Value__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Value__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__0"


    // $ANTLR start "rule__Value__Group__0__Impl"
    // InternalMyDsl.g:6822:1: rule__Value__Group__0__Impl : ( () ) ;
    public final void rule__Value__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6826:1: ( ( () ) )
            // InternalMyDsl.g:6827:1: ( () )
            {
            // InternalMyDsl.g:6827:1: ( () )
            // InternalMyDsl.g:6828:2: ()
            {
             before(grammarAccess.getValueAccess().getValueAction_0()); 
            // InternalMyDsl.g:6829:2: ()
            // InternalMyDsl.g:6829:3: 
            {
            }

             after(grammarAccess.getValueAccess().getValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__0__Impl"


    // $ANTLR start "rule__Value__Group__1"
    // InternalMyDsl.g:6837:1: rule__Value__Group__1 : rule__Value__Group__1__Impl rule__Value__Group__2 ;
    public final void rule__Value__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6841:1: ( rule__Value__Group__1__Impl rule__Value__Group__2 )
            // InternalMyDsl.g:6842:2: rule__Value__Group__1__Impl rule__Value__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__Value__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__1"


    // $ANTLR start "rule__Value__Group__1__Impl"
    // InternalMyDsl.g:6849:1: rule__Value__Group__1__Impl : ( '[' ) ;
    public final void rule__Value__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6853:1: ( ( '[' ) )
            // InternalMyDsl.g:6854:1: ( '[' )
            {
            // InternalMyDsl.g:6854:1: ( '[' )
            // InternalMyDsl.g:6855:2: '['
            {
             before(grammarAccess.getValueAccess().getLeftSquareBracketKeyword_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__1__Impl"


    // $ANTLR start "rule__Value__Group__2"
    // InternalMyDsl.g:6864:1: rule__Value__Group__2 : rule__Value__Group__2__Impl rule__Value__Group__3 ;
    public final void rule__Value__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6868:1: ( rule__Value__Group__2__Impl rule__Value__Group__3 )
            // InternalMyDsl.g:6869:2: rule__Value__Group__2__Impl rule__Value__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__Value__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__2"


    // $ANTLR start "rule__Value__Group__2__Impl"
    // InternalMyDsl.g:6876:1: rule__Value__Group__2__Impl : ( ( rule__Value__PriorityAssignment_2 )? ) ;
    public final void rule__Value__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6880:1: ( ( ( rule__Value__PriorityAssignment_2 )? ) )
            // InternalMyDsl.g:6881:1: ( ( rule__Value__PriorityAssignment_2 )? )
            {
            // InternalMyDsl.g:6881:1: ( ( rule__Value__PriorityAssignment_2 )? )
            // InternalMyDsl.g:6882:2: ( rule__Value__PriorityAssignment_2 )?
            {
             before(grammarAccess.getValueAccess().getPriorityAssignment_2()); 
            // InternalMyDsl.g:6883:2: ( rule__Value__PriorityAssignment_2 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=13 && LA68_0<=15)) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalMyDsl.g:6883:3: rule__Value__PriorityAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__PriorityAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValueAccess().getPriorityAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__2__Impl"


    // $ANTLR start "rule__Value__Group__3"
    // InternalMyDsl.g:6891:1: rule__Value__Group__3 : rule__Value__Group__3__Impl rule__Value__Group__4 ;
    public final void rule__Value__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6895:1: ( rule__Value__Group__3__Impl rule__Value__Group__4 )
            // InternalMyDsl.g:6896:2: rule__Value__Group__3__Impl rule__Value__Group__4
            {
            pushFollow(FOLLOW_31);
            rule__Value__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__3"


    // $ANTLR start "rule__Value__Group__3__Impl"
    // InternalMyDsl.g:6903:1: rule__Value__Group__3__Impl : ( ( rule__Value__ObjectiveAssignment_3 )? ) ;
    public final void rule__Value__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6907:1: ( ( ( rule__Value__ObjectiveAssignment_3 )? ) )
            // InternalMyDsl.g:6908:1: ( ( rule__Value__ObjectiveAssignment_3 )? )
            {
            // InternalMyDsl.g:6908:1: ( ( rule__Value__ObjectiveAssignment_3 )? )
            // InternalMyDsl.g:6909:2: ( rule__Value__ObjectiveAssignment_3 )?
            {
             before(grammarAccess.getValueAccess().getObjectiveAssignment_3()); 
            // InternalMyDsl.g:6910:2: ( rule__Value__ObjectiveAssignment_3 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=16 && LA69_0<=19)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalMyDsl.g:6910:3: rule__Value__ObjectiveAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__ObjectiveAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValueAccess().getObjectiveAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__3__Impl"


    // $ANTLR start "rule__Value__Group__4"
    // InternalMyDsl.g:6918:1: rule__Value__Group__4 : rule__Value__Group__4__Impl ;
    public final void rule__Value__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6922:1: ( rule__Value__Group__4__Impl )
            // InternalMyDsl.g:6923:2: rule__Value__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Value__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__4"


    // $ANTLR start "rule__Value__Group__4__Impl"
    // InternalMyDsl.g:6929:1: rule__Value__Group__4__Impl : ( ']' ) ;
    public final void rule__Value__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6933:1: ( ( ']' ) )
            // InternalMyDsl.g:6934:1: ( ']' )
            {
            // InternalMyDsl.g:6934:1: ( ']' )
            // InternalMyDsl.g:6935:2: ']'
            {
             before(grammarAccess.getValueAccess().getRightSquareBracketKeyword_4()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group__4__Impl"


    // $ANTLR start "rule__Assumption__Group__0"
    // InternalMyDsl.g:6945:1: rule__Assumption__Group__0 : rule__Assumption__Group__0__Impl rule__Assumption__Group__1 ;
    public final void rule__Assumption__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6949:1: ( rule__Assumption__Group__0__Impl rule__Assumption__Group__1 )
            // InternalMyDsl.g:6950:2: rule__Assumption__Group__0__Impl rule__Assumption__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Assumption__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assumption__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__0"


    // $ANTLR start "rule__Assumption__Group__0__Impl"
    // InternalMyDsl.g:6957:1: rule__Assumption__Group__0__Impl : ( () ) ;
    public final void rule__Assumption__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6961:1: ( ( () ) )
            // InternalMyDsl.g:6962:1: ( () )
            {
            // InternalMyDsl.g:6962:1: ( () )
            // InternalMyDsl.g:6963:2: ()
            {
             before(grammarAccess.getAssumptionAccess().getAssumptionAction_0()); 
            // InternalMyDsl.g:6964:2: ()
            // InternalMyDsl.g:6964:3: 
            {
            }

             after(grammarAccess.getAssumptionAccess().getAssumptionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__0__Impl"


    // $ANTLR start "rule__Assumption__Group__1"
    // InternalMyDsl.g:6972:1: rule__Assumption__Group__1 : rule__Assumption__Group__1__Impl rule__Assumption__Group__2 ;
    public final void rule__Assumption__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6976:1: ( rule__Assumption__Group__1__Impl rule__Assumption__Group__2 )
            // InternalMyDsl.g:6977:2: rule__Assumption__Group__1__Impl rule__Assumption__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__Assumption__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assumption__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__1"


    // $ANTLR start "rule__Assumption__Group__1__Impl"
    // InternalMyDsl.g:6984:1: rule__Assumption__Group__1__Impl : ( '[' ) ;
    public final void rule__Assumption__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6988:1: ( ( '[' ) )
            // InternalMyDsl.g:6989:1: ( '[' )
            {
            // InternalMyDsl.g:6989:1: ( '[' )
            // InternalMyDsl.g:6990:2: '['
            {
             before(grammarAccess.getAssumptionAccess().getLeftSquareBracketKeyword_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getAssumptionAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__1__Impl"


    // $ANTLR start "rule__Assumption__Group__2"
    // InternalMyDsl.g:6999:1: rule__Assumption__Group__2 : rule__Assumption__Group__2__Impl rule__Assumption__Group__3 ;
    public final void rule__Assumption__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7003:1: ( rule__Assumption__Group__2__Impl rule__Assumption__Group__3 )
            // InternalMyDsl.g:7004:2: rule__Assumption__Group__2__Impl rule__Assumption__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__Assumption__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assumption__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__2"


    // $ANTLR start "rule__Assumption__Group__2__Impl"
    // InternalMyDsl.g:7011:1: rule__Assumption__Group__2__Impl : ( ( rule__Assumption__Group_2__0 )? ) ;
    public final void rule__Assumption__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7015:1: ( ( ( rule__Assumption__Group_2__0 )? ) )
            // InternalMyDsl.g:7016:1: ( ( rule__Assumption__Group_2__0 )? )
            {
            // InternalMyDsl.g:7016:1: ( ( rule__Assumption__Group_2__0 )? )
            // InternalMyDsl.g:7017:2: ( rule__Assumption__Group_2__0 )?
            {
             before(grammarAccess.getAssumptionAccess().getGroup_2()); 
            // InternalMyDsl.g:7018:2: ( rule__Assumption__Group_2__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=16 && LA70_0<=19)) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalMyDsl.g:7018:3: rule__Assumption__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Assumption__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssumptionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__2__Impl"


    // $ANTLR start "rule__Assumption__Group__3"
    // InternalMyDsl.g:7026:1: rule__Assumption__Group__3 : rule__Assumption__Group__3__Impl rule__Assumption__Group__4 ;
    public final void rule__Assumption__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7030:1: ( rule__Assumption__Group__3__Impl rule__Assumption__Group__4 )
            // InternalMyDsl.g:7031:2: rule__Assumption__Group__3__Impl rule__Assumption__Group__4
            {
            pushFollow(FOLLOW_32);
            rule__Assumption__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assumption__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__3"


    // $ANTLR start "rule__Assumption__Group__3__Impl"
    // InternalMyDsl.g:7038:1: rule__Assumption__Group__3__Impl : ( ( rule__Assumption__Group_3__0 )? ) ;
    public final void rule__Assumption__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7042:1: ( ( ( rule__Assumption__Group_3__0 )? ) )
            // InternalMyDsl.g:7043:1: ( ( rule__Assumption__Group_3__0 )? )
            {
            // InternalMyDsl.g:7043:1: ( ( rule__Assumption__Group_3__0 )? )
            // InternalMyDsl.g:7044:2: ( rule__Assumption__Group_3__0 )?
            {
             before(grammarAccess.getAssumptionAccess().getGroup_3()); 
            // InternalMyDsl.g:7045:2: ( rule__Assumption__Group_3__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==67) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalMyDsl.g:7045:3: rule__Assumption__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Assumption__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssumptionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__3__Impl"


    // $ANTLR start "rule__Assumption__Group__4"
    // InternalMyDsl.g:7053:1: rule__Assumption__Group__4 : rule__Assumption__Group__4__Impl ;
    public final void rule__Assumption__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7057:1: ( rule__Assumption__Group__4__Impl )
            // InternalMyDsl.g:7058:2: rule__Assumption__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Assumption__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__4"


    // $ANTLR start "rule__Assumption__Group__4__Impl"
    // InternalMyDsl.g:7064:1: rule__Assumption__Group__4__Impl : ( ']' ) ;
    public final void rule__Assumption__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7068:1: ( ( ']' ) )
            // InternalMyDsl.g:7069:1: ( ']' )
            {
            // InternalMyDsl.g:7069:1: ( ']' )
            // InternalMyDsl.g:7070:2: ']'
            {
             before(grammarAccess.getAssumptionAccess().getRightSquareBracketKeyword_4()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getAssumptionAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group__4__Impl"


    // $ANTLR start "rule__Assumption__Group_2__0"
    // InternalMyDsl.g:7080:1: rule__Assumption__Group_2__0 : rule__Assumption__Group_2__0__Impl rule__Assumption__Group_2__1 ;
    public final void rule__Assumption__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7084:1: ( rule__Assumption__Group_2__0__Impl rule__Assumption__Group_2__1 )
            // InternalMyDsl.g:7085:2: rule__Assumption__Group_2__0__Impl rule__Assumption__Group_2__1
            {
            pushFollow(FOLLOW_8);
            rule__Assumption__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assumption__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_2__0"


    // $ANTLR start "rule__Assumption__Group_2__0__Impl"
    // InternalMyDsl.g:7092:1: rule__Assumption__Group_2__0__Impl : ( ( rule__Assumption__ObjectiveAssignment_2_0 ) ) ;
    public final void rule__Assumption__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7096:1: ( ( ( rule__Assumption__ObjectiveAssignment_2_0 ) ) )
            // InternalMyDsl.g:7097:1: ( ( rule__Assumption__ObjectiveAssignment_2_0 ) )
            {
            // InternalMyDsl.g:7097:1: ( ( rule__Assumption__ObjectiveAssignment_2_0 ) )
            // InternalMyDsl.g:7098:2: ( rule__Assumption__ObjectiveAssignment_2_0 )
            {
             before(grammarAccess.getAssumptionAccess().getObjectiveAssignment_2_0()); 
            // InternalMyDsl.g:7099:2: ( rule__Assumption__ObjectiveAssignment_2_0 )
            // InternalMyDsl.g:7099:3: rule__Assumption__ObjectiveAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Assumption__ObjectiveAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getAssumptionAccess().getObjectiveAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_2__0__Impl"


    // $ANTLR start "rule__Assumption__Group_2__1"
    // InternalMyDsl.g:7107:1: rule__Assumption__Group_2__1 : rule__Assumption__Group_2__1__Impl ;
    public final void rule__Assumption__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7111:1: ( rule__Assumption__Group_2__1__Impl )
            // InternalMyDsl.g:7112:2: rule__Assumption__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Assumption__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_2__1"


    // $ANTLR start "rule__Assumption__Group_2__1__Impl"
    // InternalMyDsl.g:7118:1: rule__Assumption__Group_2__1__Impl : ( ( rule__Assumption__Group_2_1__0 )* ) ;
    public final void rule__Assumption__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7122:1: ( ( ( rule__Assumption__Group_2_1__0 )* ) )
            // InternalMyDsl.g:7123:1: ( ( rule__Assumption__Group_2_1__0 )* )
            {
            // InternalMyDsl.g:7123:1: ( ( rule__Assumption__Group_2_1__0 )* )
            // InternalMyDsl.g:7124:2: ( rule__Assumption__Group_2_1__0 )*
            {
             before(grammarAccess.getAssumptionAccess().getGroup_2_1()); 
            // InternalMyDsl.g:7125:2: ( rule__Assumption__Group_2_1__0 )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==43) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalMyDsl.g:7125:3: rule__Assumption__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Assumption__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

             after(grammarAccess.getAssumptionAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_2__1__Impl"


    // $ANTLR start "rule__Assumption__Group_2_1__0"
    // InternalMyDsl.g:7134:1: rule__Assumption__Group_2_1__0 : rule__Assumption__Group_2_1__0__Impl rule__Assumption__Group_2_1__1 ;
    public final void rule__Assumption__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7138:1: ( rule__Assumption__Group_2_1__0__Impl rule__Assumption__Group_2_1__1 )
            // InternalMyDsl.g:7139:2: rule__Assumption__Group_2_1__0__Impl rule__Assumption__Group_2_1__1
            {
            pushFollow(FOLLOW_33);
            rule__Assumption__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assumption__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_2_1__0"


    // $ANTLR start "rule__Assumption__Group_2_1__0__Impl"
    // InternalMyDsl.g:7146:1: rule__Assumption__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__Assumption__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7150:1: ( ( ',' ) )
            // InternalMyDsl.g:7151:1: ( ',' )
            {
            // InternalMyDsl.g:7151:1: ( ',' )
            // InternalMyDsl.g:7152:2: ','
            {
             before(grammarAccess.getAssumptionAccess().getCommaKeyword_2_1_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getAssumptionAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_2_1__0__Impl"


    // $ANTLR start "rule__Assumption__Group_2_1__1"
    // InternalMyDsl.g:7161:1: rule__Assumption__Group_2_1__1 : rule__Assumption__Group_2_1__1__Impl ;
    public final void rule__Assumption__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7165:1: ( rule__Assumption__Group_2_1__1__Impl )
            // InternalMyDsl.g:7166:2: rule__Assumption__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Assumption__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_2_1__1"


    // $ANTLR start "rule__Assumption__Group_2_1__1__Impl"
    // InternalMyDsl.g:7172:1: rule__Assumption__Group_2_1__1__Impl : ( ( rule__Assumption__ObjectiveAssignment_2_1_1 ) ) ;
    public final void rule__Assumption__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7176:1: ( ( ( rule__Assumption__ObjectiveAssignment_2_1_1 ) ) )
            // InternalMyDsl.g:7177:1: ( ( rule__Assumption__ObjectiveAssignment_2_1_1 ) )
            {
            // InternalMyDsl.g:7177:1: ( ( rule__Assumption__ObjectiveAssignment_2_1_1 ) )
            // InternalMyDsl.g:7178:2: ( rule__Assumption__ObjectiveAssignment_2_1_1 )
            {
             before(grammarAccess.getAssumptionAccess().getObjectiveAssignment_2_1_1()); 
            // InternalMyDsl.g:7179:2: ( rule__Assumption__ObjectiveAssignment_2_1_1 )
            // InternalMyDsl.g:7179:3: rule__Assumption__ObjectiveAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Assumption__ObjectiveAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAssumptionAccess().getObjectiveAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_2_1__1__Impl"


    // $ANTLR start "rule__Assumption__Group_3__0"
    // InternalMyDsl.g:7188:1: rule__Assumption__Group_3__0 : rule__Assumption__Group_3__0__Impl rule__Assumption__Group_3__1 ;
    public final void rule__Assumption__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7192:1: ( rule__Assumption__Group_3__0__Impl rule__Assumption__Group_3__1 )
            // InternalMyDsl.g:7193:2: rule__Assumption__Group_3__0__Impl rule__Assumption__Group_3__1
            {
            pushFollow(FOLLOW_34);
            rule__Assumption__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assumption__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_3__0"


    // $ANTLR start "rule__Assumption__Group_3__0__Impl"
    // InternalMyDsl.g:7200:1: rule__Assumption__Group_3__0__Impl : ( 'layer:' ) ;
    public final void rule__Assumption__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7204:1: ( ( 'layer:' ) )
            // InternalMyDsl.g:7205:1: ( 'layer:' )
            {
            // InternalMyDsl.g:7205:1: ( 'layer:' )
            // InternalMyDsl.g:7206:2: 'layer:'
            {
             before(grammarAccess.getAssumptionAccess().getLayerKeyword_3_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getAssumptionAccess().getLayerKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_3__0__Impl"


    // $ANTLR start "rule__Assumption__Group_3__1"
    // InternalMyDsl.g:7215:1: rule__Assumption__Group_3__1 : rule__Assumption__Group_3__1__Impl ;
    public final void rule__Assumption__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7219:1: ( rule__Assumption__Group_3__1__Impl )
            // InternalMyDsl.g:7220:2: rule__Assumption__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Assumption__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_3__1"


    // $ANTLR start "rule__Assumption__Group_3__1__Impl"
    // InternalMyDsl.g:7226:1: rule__Assumption__Group_3__1__Impl : ( ( rule__Assumption__LayerAssignment_3_1 ) ) ;
    public final void rule__Assumption__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7230:1: ( ( ( rule__Assumption__LayerAssignment_3_1 ) ) )
            // InternalMyDsl.g:7231:1: ( ( rule__Assumption__LayerAssignment_3_1 ) )
            {
            // InternalMyDsl.g:7231:1: ( ( rule__Assumption__LayerAssignment_3_1 ) )
            // InternalMyDsl.g:7232:2: ( rule__Assumption__LayerAssignment_3_1 )
            {
             before(grammarAccess.getAssumptionAccess().getLayerAssignment_3_1()); 
            // InternalMyDsl.g:7233:2: ( rule__Assumption__LayerAssignment_3_1 )
            // InternalMyDsl.g:7233:3: rule__Assumption__LayerAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Assumption__LayerAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getAssumptionAccess().getLayerAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__Group_3__1__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalMyDsl.g:7242:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7246:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalMyDsl.g:7247:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EInt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // InternalMyDsl.g:7254:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7258:1: ( ( ( '-' )? ) )
            // InternalMyDsl.g:7259:1: ( ( '-' )? )
            {
            // InternalMyDsl.g:7259:1: ( ( '-' )? )
            // InternalMyDsl.g:7260:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalMyDsl.g:7261:2: ( '-' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==68) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalMyDsl.g:7261:3: '-'
                    {
                    match(input,68,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // InternalMyDsl.g:7269:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7273:1: ( rule__EInt__Group__1__Impl )
            // InternalMyDsl.g:7274:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // InternalMyDsl.g:7280:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7284:1: ( ( RULE_INT ) )
            // InternalMyDsl.g:7285:1: ( RULE_INT )
            {
            // InternalMyDsl.g:7285:1: ( RULE_INT )
            // InternalMyDsl.g:7286:2: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__EDFD__NameAssignment_2"
    // InternalMyDsl.g:7296:1: rule__EDFD__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__EDFD__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7300:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7301:2: ( ruleEString )
            {
            // InternalMyDsl.g:7301:2: ( ruleEString )
            // InternalMyDsl.g:7302:3: ruleEString
            {
             before(grammarAccess.getEDFDAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEDFDAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__NameAssignment_2"


    // $ANTLR start "rule__EDFD__AssetAssignment_4_1"
    // InternalMyDsl.g:7311:1: rule__EDFD__AssetAssignment_4_1 : ( ruleAsset ) ;
    public final void rule__EDFD__AssetAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7315:1: ( ( ruleAsset ) )
            // InternalMyDsl.g:7316:2: ( ruleAsset )
            {
            // InternalMyDsl.g:7316:2: ( ruleAsset )
            // InternalMyDsl.g:7317:3: ruleAsset
            {
             before(grammarAccess.getEDFDAccess().getAssetAssetParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAsset();

            state._fsp--;

             after(grammarAccess.getEDFDAccess().getAssetAssetParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__AssetAssignment_4_1"


    // $ANTLR start "rule__EDFD__AssetAssignment_4_2_1"
    // InternalMyDsl.g:7326:1: rule__EDFD__AssetAssignment_4_2_1 : ( ruleAsset ) ;
    public final void rule__EDFD__AssetAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7330:1: ( ( ruleAsset ) )
            // InternalMyDsl.g:7331:2: ( ruleAsset )
            {
            // InternalMyDsl.g:7331:2: ( ruleAsset )
            // InternalMyDsl.g:7332:3: ruleAsset
            {
             before(grammarAccess.getEDFDAccess().getAssetAssetParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAsset();

            state._fsp--;

             after(grammarAccess.getEDFDAccess().getAssetAssetParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__AssetAssignment_4_2_1"


    // $ANTLR start "rule__EDFD__ElementsAssignment_5_1"
    // InternalMyDsl.g:7341:1: rule__EDFD__ElementsAssignment_5_1 : ( ruleElement ) ;
    public final void rule__EDFD__ElementsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7345:1: ( ( ruleElement ) )
            // InternalMyDsl.g:7346:2: ( ruleElement )
            {
            // InternalMyDsl.g:7346:2: ( ruleElement )
            // InternalMyDsl.g:7347:3: ruleElement
            {
             before(grammarAccess.getEDFDAccess().getElementsElementParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getEDFDAccess().getElementsElementParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__ElementsAssignment_5_1"


    // $ANTLR start "rule__EDFD__ElementsAssignment_5_2_1"
    // InternalMyDsl.g:7356:1: rule__EDFD__ElementsAssignment_5_2_1 : ( ruleElement ) ;
    public final void rule__EDFD__ElementsAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7360:1: ( ( ruleElement ) )
            // InternalMyDsl.g:7361:2: ( ruleElement )
            {
            // InternalMyDsl.g:7361:2: ( ruleElement )
            // InternalMyDsl.g:7362:3: ruleElement
            {
             before(grammarAccess.getEDFDAccess().getElementsElementParserRuleCall_5_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getEDFDAccess().getElementsElementParserRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__ElementsAssignment_5_2_1"


    // $ANTLR start "rule__EDFD__TrustzonesAssignment_6_2"
    // InternalMyDsl.g:7371:1: rule__EDFD__TrustzonesAssignment_6_2 : ( ruleTrustZone ) ;
    public final void rule__EDFD__TrustzonesAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7375:1: ( ( ruleTrustZone ) )
            // InternalMyDsl.g:7376:2: ( ruleTrustZone )
            {
            // InternalMyDsl.g:7376:2: ( ruleTrustZone )
            // InternalMyDsl.g:7377:3: ruleTrustZone
            {
             before(grammarAccess.getEDFDAccess().getTrustzonesTrustZoneParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTrustZone();

            state._fsp--;

             after(grammarAccess.getEDFDAccess().getTrustzonesTrustZoneParserRuleCall_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__TrustzonesAssignment_6_2"


    // $ANTLR start "rule__EDFD__TrustzonesAssignment_6_3_1"
    // InternalMyDsl.g:7386:1: rule__EDFD__TrustzonesAssignment_6_3_1 : ( ruleTrustZone ) ;
    public final void rule__EDFD__TrustzonesAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7390:1: ( ( ruleTrustZone ) )
            // InternalMyDsl.g:7391:2: ( ruleTrustZone )
            {
            // InternalMyDsl.g:7391:2: ( ruleTrustZone )
            // InternalMyDsl.g:7392:3: ruleTrustZone
            {
             before(grammarAccess.getEDFDAccess().getTrustzonesTrustZoneParserRuleCall_6_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTrustZone();

            state._fsp--;

             after(grammarAccess.getEDFDAccess().getTrustzonesTrustZoneParserRuleCall_6_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDFD__TrustzonesAssignment_6_3_1"


    // $ANTLR start "rule__TrustZone__NameAssignment_1"
    // InternalMyDsl.g:7401:1: rule__TrustZone__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__TrustZone__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7405:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7406:2: ( ruleEString )
            {
            // InternalMyDsl.g:7406:2: ( ruleEString )
            // InternalMyDsl.g:7407:3: ruleEString
            {
             before(grammarAccess.getTrustZoneAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTrustZoneAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__NameAssignment_1"


    // $ANTLR start "rule__TrustZone__AttackerprofileAssignment_3_2"
    // InternalMyDsl.g:7416:1: rule__TrustZone__AttackerprofileAssignment_3_2 : ( ruleAttackerProfile ) ;
    public final void rule__TrustZone__AttackerprofileAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7420:1: ( ( ruleAttackerProfile ) )
            // InternalMyDsl.g:7421:2: ( ruleAttackerProfile )
            {
            // InternalMyDsl.g:7421:2: ( ruleAttackerProfile )
            // InternalMyDsl.g:7422:3: ruleAttackerProfile
            {
             before(grammarAccess.getTrustZoneAccess().getAttackerprofileAttackerProfileParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttackerProfile();

            state._fsp--;

             after(grammarAccess.getTrustZoneAccess().getAttackerprofileAttackerProfileParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__AttackerprofileAssignment_3_2"


    // $ANTLR start "rule__TrustZone__AttackerprofileAssignment_3_3_1"
    // InternalMyDsl.g:7431:1: rule__TrustZone__AttackerprofileAssignment_3_3_1 : ( ruleAttackerProfile ) ;
    public final void rule__TrustZone__AttackerprofileAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7435:1: ( ( ruleAttackerProfile ) )
            // InternalMyDsl.g:7436:2: ( ruleAttackerProfile )
            {
            // InternalMyDsl.g:7436:2: ( ruleAttackerProfile )
            // InternalMyDsl.g:7437:3: ruleAttackerProfile
            {
             before(grammarAccess.getTrustZoneAccess().getAttackerprofileAttackerProfileParserRuleCall_3_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttackerProfile();

            state._fsp--;

             after(grammarAccess.getTrustZoneAccess().getAttackerprofileAttackerProfileParserRuleCall_3_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__AttackerprofileAssignment_3_3_1"


    // $ANTLR start "rule__TrustZone__ElementsAssignment_4_1"
    // InternalMyDsl.g:7446:1: rule__TrustZone__ElementsAssignment_4_1 : ( ( ruleEString ) ) ;
    public final void rule__TrustZone__ElementsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7450:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7451:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7451:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7452:3: ( ruleEString )
            {
             before(grammarAccess.getTrustZoneAccess().getElementsElementCrossReference_4_1_0()); 
            // InternalMyDsl.g:7453:3: ( ruleEString )
            // InternalMyDsl.g:7454:4: ruleEString
            {
             before(grammarAccess.getTrustZoneAccess().getElementsElementEStringParserRuleCall_4_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTrustZoneAccess().getElementsElementEStringParserRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getTrustZoneAccess().getElementsElementCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__ElementsAssignment_4_1"


    // $ANTLR start "rule__TrustZone__ElementsAssignment_4_2_1"
    // InternalMyDsl.g:7465:1: rule__TrustZone__ElementsAssignment_4_2_1 : ( ( ruleEString ) ) ;
    public final void rule__TrustZone__ElementsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7469:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7470:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7470:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7471:3: ( ruleEString )
            {
             before(grammarAccess.getTrustZoneAccess().getElementsElementCrossReference_4_2_1_0()); 
            // InternalMyDsl.g:7472:3: ( ruleEString )
            // InternalMyDsl.g:7473:4: ruleEString
            {
             before(grammarAccess.getTrustZoneAccess().getElementsElementEStringParserRuleCall_4_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTrustZoneAccess().getElementsElementEStringParserRuleCall_4_2_1_0_1()); 

            }

             after(grammarAccess.getTrustZoneAccess().getElementsElementCrossReference_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__ElementsAssignment_4_2_1"


    // $ANTLR start "rule__TrustZone__SubzonesAssignment_5_1"
    // InternalMyDsl.g:7484:1: rule__TrustZone__SubzonesAssignment_5_1 : ( ruleTrustZone ) ;
    public final void rule__TrustZone__SubzonesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7488:1: ( ( ruleTrustZone ) )
            // InternalMyDsl.g:7489:2: ( ruleTrustZone )
            {
            // InternalMyDsl.g:7489:2: ( ruleTrustZone )
            // InternalMyDsl.g:7490:3: ruleTrustZone
            {
             before(grammarAccess.getTrustZoneAccess().getSubzonesTrustZoneParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTrustZone();

            state._fsp--;

             after(grammarAccess.getTrustZoneAccess().getSubzonesTrustZoneParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__SubzonesAssignment_5_1"


    // $ANTLR start "rule__TrustZone__SubzonesAssignment_5_2_1"
    // InternalMyDsl.g:7499:1: rule__TrustZone__SubzonesAssignment_5_2_1 : ( ruleTrustZone ) ;
    public final void rule__TrustZone__SubzonesAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7503:1: ( ( ruleTrustZone ) )
            // InternalMyDsl.g:7504:2: ( ruleTrustZone )
            {
            // InternalMyDsl.g:7504:2: ( ruleTrustZone )
            // InternalMyDsl.g:7505:3: ruleTrustZone
            {
             before(grammarAccess.getTrustZoneAccess().getSubzonesTrustZoneParserRuleCall_5_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTrustZone();

            state._fsp--;

             after(grammarAccess.getTrustZoneAccess().getSubzonesTrustZoneParserRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrustZone__SubzonesAssignment_5_2_1"


    // $ANTLR start "rule__AttackerProfile__NameAssignment_1"
    // InternalMyDsl.g:7514:1: rule__AttackerProfile__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__AttackerProfile__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7518:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7519:2: ( ruleEString )
            {
            // InternalMyDsl.g:7519:2: ( ruleEString )
            // InternalMyDsl.g:7520:3: ruleEString
            {
             before(grammarAccess.getAttackerProfileAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAttackerProfileAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__NameAssignment_1"


    // $ANTLR start "rule__AttackerProfile__ObservationAssignment_3_1"
    // InternalMyDsl.g:7529:1: rule__AttackerProfile__ObservationAssignment_3_1 : ( ruleEInt ) ;
    public final void rule__AttackerProfile__ObservationAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7533:1: ( ( ruleEInt ) )
            // InternalMyDsl.g:7534:2: ( ruleEInt )
            {
            // InternalMyDsl.g:7534:2: ( ruleEInt )
            // InternalMyDsl.g:7535:3: ruleEInt
            {
             before(grammarAccess.getAttackerProfileAccess().getObservationEIntParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getAttackerProfileAccess().getObservationEIntParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttackerProfile__ObservationAssignment_3_1"


    // $ANTLR start "rule__Asset__NameAssignment_2"
    // InternalMyDsl.g:7544:1: rule__Asset__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Asset__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7548:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7549:2: ( ruleEString )
            {
            // InternalMyDsl.g:7549:2: ( ruleEString )
            // InternalMyDsl.g:7550:3: ruleEString
            {
             before(grammarAccess.getAssetAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__NameAssignment_2"


    // $ANTLR start "rule__Asset__ValueAssignment_3_1"
    // InternalMyDsl.g:7559:1: rule__Asset__ValueAssignment_3_1 : ( ruleValue ) ;
    public final void rule__Asset__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7563:1: ( ( ruleValue ) )
            // InternalMyDsl.g:7564:2: ( ruleValue )
            {
            // InternalMyDsl.g:7564:2: ( ruleValue )
            // InternalMyDsl.g:7565:3: ruleValue
            {
             before(grammarAccess.getAssetAccess().getValueValueParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getValueValueParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__ValueAssignment_3_1"


    // $ANTLR start "rule__Asset__ValueAssignment_3_2_1"
    // InternalMyDsl.g:7574:1: rule__Asset__ValueAssignment_3_2_1 : ( ruleValue ) ;
    public final void rule__Asset__ValueAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7578:1: ( ( ruleValue ) )
            // InternalMyDsl.g:7579:2: ( ruleValue )
            {
            // InternalMyDsl.g:7579:2: ( ruleValue )
            // InternalMyDsl.g:7580:3: ruleValue
            {
             before(grammarAccess.getAssetAccess().getValueValueParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getValueValueParserRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__ValueAssignment_3_2_1"


    // $ANTLR start "rule__Asset__SourceAssignment_5"
    // InternalMyDsl.g:7589:1: rule__Asset__SourceAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Asset__SourceAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7593:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7594:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7594:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7595:3: ( ruleEString )
            {
             before(grammarAccess.getAssetAccess().getSourceElementCrossReference_5_0()); 
            // InternalMyDsl.g:7596:3: ( ruleEString )
            // InternalMyDsl.g:7597:4: ruleEString
            {
             before(grammarAccess.getAssetAccess().getSourceElementEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getSourceElementEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getAssetAccess().getSourceElementCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__SourceAssignment_5"


    // $ANTLR start "rule__Asset__TargetsAssignment_7"
    // InternalMyDsl.g:7608:1: rule__Asset__TargetsAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__Asset__TargetsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7612:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7613:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7613:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7614:3: ( ruleEString )
            {
             before(grammarAccess.getAssetAccess().getTargetsElementCrossReference_7_0()); 
            // InternalMyDsl.g:7615:3: ( ruleEString )
            // InternalMyDsl.g:7616:4: ruleEString
            {
             before(grammarAccess.getAssetAccess().getTargetsElementEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getTargetsElementEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getAssetAccess().getTargetsElementCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__TargetsAssignment_7"


    // $ANTLR start "rule__Asset__TargetsAssignment_8_1"
    // InternalMyDsl.g:7627:1: rule__Asset__TargetsAssignment_8_1 : ( ( ruleEString ) ) ;
    public final void rule__Asset__TargetsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7631:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7632:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7632:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7633:3: ( ruleEString )
            {
             before(grammarAccess.getAssetAccess().getTargetsElementCrossReference_8_1_0()); 
            // InternalMyDsl.g:7634:3: ( ruleEString )
            // InternalMyDsl.g:7635:4: ruleEString
            {
             before(grammarAccess.getAssetAccess().getTargetsElementEStringParserRuleCall_8_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getTargetsElementEStringParserRuleCall_8_1_0_1()); 

            }

             after(grammarAccess.getAssetAccess().getTargetsElementCrossReference_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__TargetsAssignment_8_1"


    // $ANTLR start "rule__Process__NameAssignment_2"
    // InternalMyDsl.g:7646:1: rule__Process__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Process__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7650:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7651:2: ( ruleEString )
            {
            // InternalMyDsl.g:7651:2: ( ruleEString )
            // InternalMyDsl.g:7652:3: ruleEString
            {
             before(grammarAccess.getProcessAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__NameAssignment_2"


    // $ANTLR start "rule__Process__ResponsibilityAssignment_4_1"
    // InternalMyDsl.g:7661:1: rule__Process__ResponsibilityAssignment_4_1 : ( ruleResponsibility ) ;
    public final void rule__Process__ResponsibilityAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7665:1: ( ( ruleResponsibility ) )
            // InternalMyDsl.g:7666:2: ( ruleResponsibility )
            {
            // InternalMyDsl.g:7666:2: ( ruleResponsibility )
            // InternalMyDsl.g:7667:3: ruleResponsibility
            {
             before(grammarAccess.getProcessAccess().getResponsibilityResponsibilityParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleResponsibility();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getResponsibilityResponsibilityParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__ResponsibilityAssignment_4_1"


    // $ANTLR start "rule__Process__ResponsibilityAssignment_4_2_1"
    // InternalMyDsl.g:7676:1: rule__Process__ResponsibilityAssignment_4_2_1 : ( ruleResponsibility ) ;
    public final void rule__Process__ResponsibilityAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7680:1: ( ( ruleResponsibility ) )
            // InternalMyDsl.g:7681:2: ( ruleResponsibility )
            {
            // InternalMyDsl.g:7681:2: ( ruleResponsibility )
            // InternalMyDsl.g:7682:3: ruleResponsibility
            {
             before(grammarAccess.getProcessAccess().getResponsibilityResponsibilityParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleResponsibility();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getResponsibilityResponsibilityParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__ResponsibilityAssignment_4_2_1"


    // $ANTLR start "rule__Process__AssetsAssignment_5_1"
    // InternalMyDsl.g:7691:1: rule__Process__AssetsAssignment_5_1 : ( ( ruleEString ) ) ;
    public final void rule__Process__AssetsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7695:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7696:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7696:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7697:3: ( ruleEString )
            {
             before(grammarAccess.getProcessAccess().getAssetsAssetCrossReference_5_1_0()); 
            // InternalMyDsl.g:7698:3: ( ruleEString )
            // InternalMyDsl.g:7699:4: ruleEString
            {
             before(grammarAccess.getProcessAccess().getAssetsAssetEStringParserRuleCall_5_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getAssetsAssetEStringParserRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getProcessAccess().getAssetsAssetCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__AssetsAssignment_5_1"


    // $ANTLR start "rule__Process__AssetsAssignment_5_2_1"
    // InternalMyDsl.g:7710:1: rule__Process__AssetsAssignment_5_2_1 : ( ( ruleEString ) ) ;
    public final void rule__Process__AssetsAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7714:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7715:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7715:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7716:3: ( ruleEString )
            {
             before(grammarAccess.getProcessAccess().getAssetsAssetCrossReference_5_2_1_0()); 
            // InternalMyDsl.g:7717:3: ( ruleEString )
            // InternalMyDsl.g:7718:4: ruleEString
            {
             before(grammarAccess.getProcessAccess().getAssetsAssetEStringParserRuleCall_5_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getAssetsAssetEStringParserRuleCall_5_2_1_0_1()); 

            }

             after(grammarAccess.getProcessAccess().getAssetsAssetCrossReference_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__AssetsAssignment_5_2_1"


    // $ANTLR start "rule__Process__AssumptionAssignment_6_1"
    // InternalMyDsl.g:7729:1: rule__Process__AssumptionAssignment_6_1 : ( ruleAssumption ) ;
    public final void rule__Process__AssumptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7733:1: ( ( ruleAssumption ) )
            // InternalMyDsl.g:7734:2: ( ruleAssumption )
            {
            // InternalMyDsl.g:7734:2: ( ruleAssumption )
            // InternalMyDsl.g:7735:3: ruleAssumption
            {
             before(grammarAccess.getProcessAccess().getAssumptionAssumptionParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssumption();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getAssumptionAssumptionParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__AssumptionAssignment_6_1"


    // $ANTLR start "rule__Process__AssumptionAssignment_6_2_1"
    // InternalMyDsl.g:7744:1: rule__Process__AssumptionAssignment_6_2_1 : ( ruleAssumption ) ;
    public final void rule__Process__AssumptionAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7748:1: ( ( ruleAssumption ) )
            // InternalMyDsl.g:7749:2: ( ruleAssumption )
            {
            // InternalMyDsl.g:7749:2: ( ruleAssumption )
            // InternalMyDsl.g:7750:3: ruleAssumption
            {
             before(grammarAccess.getProcessAccess().getAssumptionAssumptionParserRuleCall_6_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssumption();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getAssumptionAssumptionParserRuleCall_6_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__AssumptionAssignment_6_2_1"


    // $ANTLR start "rule__Process__InflowsAssignment_7_2"
    // InternalMyDsl.g:7759:1: rule__Process__InflowsAssignment_7_2 : ( ( ruleEString ) ) ;
    public final void rule__Process__InflowsAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7763:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7764:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7764:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7765:3: ( ruleEString )
            {
             before(grammarAccess.getProcessAccess().getInflowsFlowCrossReference_7_2_0()); 
            // InternalMyDsl.g:7766:3: ( ruleEString )
            // InternalMyDsl.g:7767:4: ruleEString
            {
             before(grammarAccess.getProcessAccess().getInflowsFlowEStringParserRuleCall_7_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getInflowsFlowEStringParserRuleCall_7_2_0_1()); 

            }

             after(grammarAccess.getProcessAccess().getInflowsFlowCrossReference_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__InflowsAssignment_7_2"


    // $ANTLR start "rule__Process__InflowsAssignment_7_3_1"
    // InternalMyDsl.g:7778:1: rule__Process__InflowsAssignment_7_3_1 : ( ( ruleEString ) ) ;
    public final void rule__Process__InflowsAssignment_7_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7782:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7783:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7783:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7784:3: ( ruleEString )
            {
             before(grammarAccess.getProcessAccess().getInflowsFlowCrossReference_7_3_1_0()); 
            // InternalMyDsl.g:7785:3: ( ruleEString )
            // InternalMyDsl.g:7786:4: ruleEString
            {
             before(grammarAccess.getProcessAccess().getInflowsFlowEStringParserRuleCall_7_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getInflowsFlowEStringParserRuleCall_7_3_1_0_1()); 

            }

             after(grammarAccess.getProcessAccess().getInflowsFlowCrossReference_7_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__InflowsAssignment_7_3_1"


    // $ANTLR start "rule__Process__OutflowsAssignment_8_2"
    // InternalMyDsl.g:7797:1: rule__Process__OutflowsAssignment_8_2 : ( ruleFlow ) ;
    public final void rule__Process__OutflowsAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7801:1: ( ( ruleFlow ) )
            // InternalMyDsl.g:7802:2: ( ruleFlow )
            {
            // InternalMyDsl.g:7802:2: ( ruleFlow )
            // InternalMyDsl.g:7803:3: ruleFlow
            {
             before(grammarAccess.getProcessAccess().getOutflowsFlowParserRuleCall_8_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFlow();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getOutflowsFlowParserRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__OutflowsAssignment_8_2"


    // $ANTLR start "rule__Process__OutflowsAssignment_8_3_1"
    // InternalMyDsl.g:7812:1: rule__Process__OutflowsAssignment_8_3_1 : ( ruleFlow ) ;
    public final void rule__Process__OutflowsAssignment_8_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7816:1: ( ( ruleFlow ) )
            // InternalMyDsl.g:7817:2: ( ruleFlow )
            {
            // InternalMyDsl.g:7817:2: ( ruleFlow )
            // InternalMyDsl.g:7818:3: ruleFlow
            {
             before(grammarAccess.getProcessAccess().getOutflowsFlowParserRuleCall_8_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFlow();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getOutflowsFlowParserRuleCall_8_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__OutflowsAssignment_8_3_1"


    // $ANTLR start "rule__Process__AttackerAssignment_9_1"
    // InternalMyDsl.g:7827:1: rule__Process__AttackerAssignment_9_1 : ( ruleEBoolean ) ;
    public final void rule__Process__AttackerAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7831:1: ( ( ruleEBoolean ) )
            // InternalMyDsl.g:7832:2: ( ruleEBoolean )
            {
            // InternalMyDsl.g:7832:2: ( ruleEBoolean )
            // InternalMyDsl.g:7833:3: ruleEBoolean
            {
             before(grammarAccess.getProcessAccess().getAttackerEBooleanParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getProcessAccess().getAttackerEBooleanParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Process__AttackerAssignment_9_1"


    // $ANTLR start "rule__Responsibility__IncomeassetsAssignment_2_0"
    // InternalMyDsl.g:7842:1: rule__Responsibility__IncomeassetsAssignment_2_0 : ( ( ruleEString ) ) ;
    public final void rule__Responsibility__IncomeassetsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7846:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7847:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7847:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7848:3: ( ruleEString )
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetCrossReference_2_0_0()); 
            // InternalMyDsl.g:7849:3: ( ruleEString )
            // InternalMyDsl.g:7850:4: ruleEString
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetEStringParserRuleCall_2_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetEStringParserRuleCall_2_0_0_1()); 

            }

             after(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetCrossReference_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__IncomeassetsAssignment_2_0"


    // $ANTLR start "rule__Responsibility__IncomeassetsAssignment_2_1_1"
    // InternalMyDsl.g:7861:1: rule__Responsibility__IncomeassetsAssignment_2_1_1 : ( ( ruleEString ) ) ;
    public final void rule__Responsibility__IncomeassetsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7865:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7866:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7866:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7867:3: ( ruleEString )
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetCrossReference_2_1_1_0()); 
            // InternalMyDsl.g:7868:3: ( ruleEString )
            // InternalMyDsl.g:7869:4: ruleEString
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetEStringParserRuleCall_2_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetEStringParserRuleCall_2_1_1_0_1()); 

            }

             after(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetCrossReference_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__IncomeassetsAssignment_2_1_1"


    // $ANTLR start "rule__Responsibility__ActionAssignment_2_2"
    // InternalMyDsl.g:7880:1: rule__Responsibility__ActionAssignment_2_2 : ( ruleResponsibilityType ) ;
    public final void rule__Responsibility__ActionAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7884:1: ( ( ruleResponsibilityType ) )
            // InternalMyDsl.g:7885:2: ( ruleResponsibilityType )
            {
            // InternalMyDsl.g:7885:2: ( ruleResponsibilityType )
            // InternalMyDsl.g:7886:3: ruleResponsibilityType
            {
             before(grammarAccess.getResponsibilityAccess().getActionResponsibilityTypeEnumRuleCall_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleResponsibilityType();

            state._fsp--;

             after(grammarAccess.getResponsibilityAccess().getActionResponsibilityTypeEnumRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__ActionAssignment_2_2"


    // $ANTLR start "rule__Responsibility__OutcomeassetsAssignment_2_4"
    // InternalMyDsl.g:7895:1: rule__Responsibility__OutcomeassetsAssignment_2_4 : ( ( ruleEString ) ) ;
    public final void rule__Responsibility__OutcomeassetsAssignment_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7899:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7900:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7900:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7901:3: ( ruleEString )
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetCrossReference_2_4_0()); 
            // InternalMyDsl.g:7902:3: ( ruleEString )
            // InternalMyDsl.g:7903:4: ruleEString
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetEStringParserRuleCall_2_4_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetEStringParserRuleCall_2_4_0_1()); 

            }

             after(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetCrossReference_2_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__OutcomeassetsAssignment_2_4"


    // $ANTLR start "rule__Responsibility__OutcomeassetsAssignment_2_5_1"
    // InternalMyDsl.g:7914:1: rule__Responsibility__OutcomeassetsAssignment_2_5_1 : ( ( ruleEString ) ) ;
    public final void rule__Responsibility__OutcomeassetsAssignment_2_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7918:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7919:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7919:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7920:3: ( ruleEString )
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetCrossReference_2_5_1_0()); 
            // InternalMyDsl.g:7921:3: ( ruleEString )
            // InternalMyDsl.g:7922:4: ruleEString
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetEStringParserRuleCall_2_5_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetEStringParserRuleCall_2_5_1_0_1()); 

            }

             after(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetCrossReference_2_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Responsibility__OutcomeassetsAssignment_2_5_1"


    // $ANTLR start "rule__ExternalEntity__NameAssignment_2"
    // InternalMyDsl.g:7933:1: rule__ExternalEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__ExternalEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7937:1: ( ( ruleEString ) )
            // InternalMyDsl.g:7938:2: ( ruleEString )
            {
            // InternalMyDsl.g:7938:2: ( ruleEString )
            // InternalMyDsl.g:7939:3: ruleEString
            {
             before(grammarAccess.getExternalEntityAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__NameAssignment_2"


    // $ANTLR start "rule__ExternalEntity__AssetsAssignment_4_1"
    // InternalMyDsl.g:7948:1: rule__ExternalEntity__AssetsAssignment_4_1 : ( ( ruleEString ) ) ;
    public final void rule__ExternalEntity__AssetsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7952:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7953:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7953:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7954:3: ( ruleEString )
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssetCrossReference_4_1_0()); 
            // InternalMyDsl.g:7955:3: ( ruleEString )
            // InternalMyDsl.g:7956:4: ruleEString
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssetEStringParserRuleCall_4_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getAssetsAssetEStringParserRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getExternalEntityAccess().getAssetsAssetCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__AssetsAssignment_4_1"


    // $ANTLR start "rule__ExternalEntity__AssetsAssignment_4_2_1"
    // InternalMyDsl.g:7967:1: rule__ExternalEntity__AssetsAssignment_4_2_1 : ( ( ruleEString ) ) ;
    public final void rule__ExternalEntity__AssetsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7971:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:7972:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:7972:2: ( ( ruleEString ) )
            // InternalMyDsl.g:7973:3: ( ruleEString )
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssetCrossReference_4_2_1_0()); 
            // InternalMyDsl.g:7974:3: ( ruleEString )
            // InternalMyDsl.g:7975:4: ruleEString
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssetEStringParserRuleCall_4_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getAssetsAssetEStringParserRuleCall_4_2_1_0_1()); 

            }

             after(grammarAccess.getExternalEntityAccess().getAssetsAssetCrossReference_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__AssetsAssignment_4_2_1"


    // $ANTLR start "rule__ExternalEntity__AssumptionAssignment_5_1"
    // InternalMyDsl.g:7986:1: rule__ExternalEntity__AssumptionAssignment_5_1 : ( ruleAssumption ) ;
    public final void rule__ExternalEntity__AssumptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7990:1: ( ( ruleAssumption ) )
            // InternalMyDsl.g:7991:2: ( ruleAssumption )
            {
            // InternalMyDsl.g:7991:2: ( ruleAssumption )
            // InternalMyDsl.g:7992:3: ruleAssumption
            {
             before(grammarAccess.getExternalEntityAccess().getAssumptionAssumptionParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssumption();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getAssumptionAssumptionParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__AssumptionAssignment_5_1"


    // $ANTLR start "rule__ExternalEntity__AssumptionAssignment_5_2_1"
    // InternalMyDsl.g:8001:1: rule__ExternalEntity__AssumptionAssignment_5_2_1 : ( ruleAssumption ) ;
    public final void rule__ExternalEntity__AssumptionAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8005:1: ( ( ruleAssumption ) )
            // InternalMyDsl.g:8006:2: ( ruleAssumption )
            {
            // InternalMyDsl.g:8006:2: ( ruleAssumption )
            // InternalMyDsl.g:8007:3: ruleAssumption
            {
             before(grammarAccess.getExternalEntityAccess().getAssumptionAssumptionParserRuleCall_5_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssumption();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getAssumptionAssumptionParserRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__AssumptionAssignment_5_2_1"


    // $ANTLR start "rule__ExternalEntity__InflowsAssignment_6_2"
    // InternalMyDsl.g:8016:1: rule__ExternalEntity__InflowsAssignment_6_2 : ( ( ruleEString ) ) ;
    public final void rule__ExternalEntity__InflowsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8020:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8021:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8021:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8022:3: ( ruleEString )
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsFlowCrossReference_6_2_0()); 
            // InternalMyDsl.g:8023:3: ( ruleEString )
            // InternalMyDsl.g:8024:4: ruleEString
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsFlowEStringParserRuleCall_6_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getInflowsFlowEStringParserRuleCall_6_2_0_1()); 

            }

             after(grammarAccess.getExternalEntityAccess().getInflowsFlowCrossReference_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__InflowsAssignment_6_2"


    // $ANTLR start "rule__ExternalEntity__InflowsAssignment_6_3_1"
    // InternalMyDsl.g:8035:1: rule__ExternalEntity__InflowsAssignment_6_3_1 : ( ( ruleEString ) ) ;
    public final void rule__ExternalEntity__InflowsAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8039:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8040:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8040:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8041:3: ( ruleEString )
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsFlowCrossReference_6_3_1_0()); 
            // InternalMyDsl.g:8042:3: ( ruleEString )
            // InternalMyDsl.g:8043:4: ruleEString
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsFlowEStringParserRuleCall_6_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getInflowsFlowEStringParserRuleCall_6_3_1_0_1()); 

            }

             after(grammarAccess.getExternalEntityAccess().getInflowsFlowCrossReference_6_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__InflowsAssignment_6_3_1"


    // $ANTLR start "rule__ExternalEntity__OutflowsAssignment_7_2"
    // InternalMyDsl.g:8054:1: rule__ExternalEntity__OutflowsAssignment_7_2 : ( ruleFlow ) ;
    public final void rule__ExternalEntity__OutflowsAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8058:1: ( ( ruleFlow ) )
            // InternalMyDsl.g:8059:2: ( ruleFlow )
            {
            // InternalMyDsl.g:8059:2: ( ruleFlow )
            // InternalMyDsl.g:8060:3: ruleFlow
            {
             before(grammarAccess.getExternalEntityAccess().getOutflowsFlowParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFlow();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getOutflowsFlowParserRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__OutflowsAssignment_7_2"


    // $ANTLR start "rule__ExternalEntity__OutflowsAssignment_7_3_1"
    // InternalMyDsl.g:8069:1: rule__ExternalEntity__OutflowsAssignment_7_3_1 : ( ruleFlow ) ;
    public final void rule__ExternalEntity__OutflowsAssignment_7_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8073:1: ( ( ruleFlow ) )
            // InternalMyDsl.g:8074:2: ( ruleFlow )
            {
            // InternalMyDsl.g:8074:2: ( ruleFlow )
            // InternalMyDsl.g:8075:3: ruleFlow
            {
             before(grammarAccess.getExternalEntityAccess().getOutflowsFlowParserRuleCall_7_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFlow();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getOutflowsFlowParserRuleCall_7_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__OutflowsAssignment_7_3_1"


    // $ANTLR start "rule__ExternalEntity__AttackerAssignment_8_1"
    // InternalMyDsl.g:8084:1: rule__ExternalEntity__AttackerAssignment_8_1 : ( ruleEBoolean ) ;
    public final void rule__ExternalEntity__AttackerAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8088:1: ( ( ruleEBoolean ) )
            // InternalMyDsl.g:8089:2: ( ruleEBoolean )
            {
            // InternalMyDsl.g:8089:2: ( ruleEBoolean )
            // InternalMyDsl.g:8090:3: ruleEBoolean
            {
             before(grammarAccess.getExternalEntityAccess().getAttackerEBooleanParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getExternalEntityAccess().getAttackerEBooleanParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExternalEntity__AttackerAssignment_8_1"


    // $ANTLR start "rule__Flow__NameAssignment_1"
    // InternalMyDsl.g:8099:1: rule__Flow__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Flow__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8103:1: ( ( ruleEString ) )
            // InternalMyDsl.g:8104:2: ( ruleEString )
            {
            // InternalMyDsl.g:8104:2: ( ruleEString )
            // InternalMyDsl.g:8105:3: ruleEString
            {
             before(grammarAccess.getFlowAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__NameAssignment_1"


    // $ANTLR start "rule__Flow__NumberAssignment_3_1"
    // InternalMyDsl.g:8114:1: rule__Flow__NumberAssignment_3_1 : ( ruleEInt ) ;
    public final void rule__Flow__NumberAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8118:1: ( ( ruleEInt ) )
            // InternalMyDsl.g:8119:2: ( ruleEInt )
            {
            // InternalMyDsl.g:8119:2: ( ruleEInt )
            // InternalMyDsl.g:8120:3: ruleEInt
            {
             before(grammarAccess.getFlowAccess().getNumberEIntParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getNumberEIntParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__NumberAssignment_3_1"


    // $ANTLR start "rule__Flow__AssetsAssignment_4_1"
    // InternalMyDsl.g:8129:1: rule__Flow__AssetsAssignment_4_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__AssetsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8133:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8134:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8134:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8135:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getAssetsAssetCrossReference_4_1_0()); 
            // InternalMyDsl.g:8136:3: ( ruleEString )
            // InternalMyDsl.g:8137:4: ruleEString
            {
             before(grammarAccess.getFlowAccess().getAssetsAssetEStringParserRuleCall_4_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getAssetsAssetEStringParserRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getFlowAccess().getAssetsAssetCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__AssetsAssignment_4_1"


    // $ANTLR start "rule__Flow__AssetsAssignment_4_2_1"
    // InternalMyDsl.g:8148:1: rule__Flow__AssetsAssignment_4_2_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__AssetsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8152:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8153:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8153:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8154:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getAssetsAssetCrossReference_4_2_1_0()); 
            // InternalMyDsl.g:8155:3: ( ruleEString )
            // InternalMyDsl.g:8156:4: ruleEString
            {
             before(grammarAccess.getFlowAccess().getAssetsAssetEStringParserRuleCall_4_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getAssetsAssetEStringParserRuleCall_4_2_1_0_1()); 

            }

             after(grammarAccess.getFlowAccess().getAssetsAssetCrossReference_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__AssetsAssignment_4_2_1"


    // $ANTLR start "rule__Flow__SourceAssignment_5_1"
    // InternalMyDsl.g:8167:1: rule__Flow__SourceAssignment_5_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__SourceAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8171:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8172:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8172:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8173:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getSourceElementCrossReference_5_1_0()); 
            // InternalMyDsl.g:8174:3: ( ruleEString )
            // InternalMyDsl.g:8175:4: ruleEString
            {
             before(grammarAccess.getFlowAccess().getSourceElementEStringParserRuleCall_5_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getSourceElementEStringParserRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getFlowAccess().getSourceElementCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__SourceAssignment_5_1"


    // $ANTLR start "rule__Flow__TargetAssignment_6_1"
    // InternalMyDsl.g:8186:1: rule__Flow__TargetAssignment_6_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__TargetAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8190:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8191:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8191:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8192:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getTargetElementCrossReference_6_1_0()); 
            // InternalMyDsl.g:8193:3: ( ruleEString )
            // InternalMyDsl.g:8194:4: ruleEString
            {
             before(grammarAccess.getFlowAccess().getTargetElementEStringParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getTargetElementEStringParserRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getFlowAccess().getTargetElementCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__TargetAssignment_6_1"


    // $ANTLR start "rule__Flow__TargetAssignment_6_2_1"
    // InternalMyDsl.g:8205:1: rule__Flow__TargetAssignment_6_2_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__TargetAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8209:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8210:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8210:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8211:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getTargetElementCrossReference_6_2_1_0()); 
            // InternalMyDsl.g:8212:3: ( ruleEString )
            // InternalMyDsl.g:8213:4: ruleEString
            {
             before(grammarAccess.getFlowAccess().getTargetElementEStringParserRuleCall_6_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getTargetElementEStringParserRuleCall_6_2_1_0_1()); 

            }

             after(grammarAccess.getFlowAccess().getTargetElementCrossReference_6_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__TargetAssignment_6_2_1"


    // $ANTLR start "rule__Flow__ChannelAssignment_7_1"
    // InternalMyDsl.g:8224:1: rule__Flow__ChannelAssignment_7_1 : ( ruleChannel ) ;
    public final void rule__Flow__ChannelAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8228:1: ( ( ruleChannel ) )
            // InternalMyDsl.g:8229:2: ( ruleChannel )
            {
            // InternalMyDsl.g:8229:2: ( ruleChannel )
            // InternalMyDsl.g:8230:3: ruleChannel
            {
             before(grammarAccess.getFlowAccess().getChannelChannelEnumRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleChannel();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getChannelChannelEnumRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__ChannelAssignment_7_1"


    // $ANTLR start "rule__Flow__AssumptionAssignment_8_1"
    // InternalMyDsl.g:8239:1: rule__Flow__AssumptionAssignment_8_1 : ( ruleAssumption ) ;
    public final void rule__Flow__AssumptionAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8243:1: ( ( ruleAssumption ) )
            // InternalMyDsl.g:8244:2: ( ruleAssumption )
            {
            // InternalMyDsl.g:8244:2: ( ruleAssumption )
            // InternalMyDsl.g:8245:3: ruleAssumption
            {
             before(grammarAccess.getFlowAccess().getAssumptionAssumptionParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssumption();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getAssumptionAssumptionParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__AssumptionAssignment_8_1"


    // $ANTLR start "rule__Flow__AssumptionAssignment_8_2_1"
    // InternalMyDsl.g:8254:1: rule__Flow__AssumptionAssignment_8_2_1 : ( ruleAssumption ) ;
    public final void rule__Flow__AssumptionAssignment_8_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8258:1: ( ( ruleAssumption ) )
            // InternalMyDsl.g:8259:2: ( ruleAssumption )
            {
            // InternalMyDsl.g:8259:2: ( ruleAssumption )
            // InternalMyDsl.g:8260:3: ruleAssumption
            {
             before(grammarAccess.getFlowAccess().getAssumptionAssumptionParserRuleCall_8_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssumption();

            state._fsp--;

             after(grammarAccess.getFlowAccess().getAssumptionAssumptionParserRuleCall_8_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Flow__AssumptionAssignment_8_2_1"


    // $ANTLR start "rule__DataStore__NameAssignment_2"
    // InternalMyDsl.g:8269:1: rule__DataStore__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__DataStore__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8273:1: ( ( ruleEString ) )
            // InternalMyDsl.g:8274:2: ( ruleEString )
            {
            // InternalMyDsl.g:8274:2: ( ruleEString )
            // InternalMyDsl.g:8275:3: ruleEString
            {
             before(grammarAccess.getDataStoreAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__NameAssignment_2"


    // $ANTLR start "rule__DataStore__AssetsAssignment_4_1"
    // InternalMyDsl.g:8284:1: rule__DataStore__AssetsAssignment_4_1 : ( ( ruleEString ) ) ;
    public final void rule__DataStore__AssetsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8288:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8289:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8289:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8290:3: ( ruleEString )
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssetCrossReference_4_1_0()); 
            // InternalMyDsl.g:8291:3: ( ruleEString )
            // InternalMyDsl.g:8292:4: ruleEString
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssetEStringParserRuleCall_4_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getAssetsAssetEStringParserRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getDataStoreAccess().getAssetsAssetCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__AssetsAssignment_4_1"


    // $ANTLR start "rule__DataStore__AssetsAssignment_4_2_1"
    // InternalMyDsl.g:8303:1: rule__DataStore__AssetsAssignment_4_2_1 : ( ( ruleEString ) ) ;
    public final void rule__DataStore__AssetsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8307:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8308:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8308:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8309:3: ( ruleEString )
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssetCrossReference_4_2_1_0()); 
            // InternalMyDsl.g:8310:3: ( ruleEString )
            // InternalMyDsl.g:8311:4: ruleEString
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssetEStringParserRuleCall_4_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getAssetsAssetEStringParserRuleCall_4_2_1_0_1()); 

            }

             after(grammarAccess.getDataStoreAccess().getAssetsAssetCrossReference_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__AssetsAssignment_4_2_1"


    // $ANTLR start "rule__DataStore__AssumptionAssignment_5_1"
    // InternalMyDsl.g:8322:1: rule__DataStore__AssumptionAssignment_5_1 : ( ruleAssumption ) ;
    public final void rule__DataStore__AssumptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8326:1: ( ( ruleAssumption ) )
            // InternalMyDsl.g:8327:2: ( ruleAssumption )
            {
            // InternalMyDsl.g:8327:2: ( ruleAssumption )
            // InternalMyDsl.g:8328:3: ruleAssumption
            {
             before(grammarAccess.getDataStoreAccess().getAssumptionAssumptionParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssumption();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getAssumptionAssumptionParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__AssumptionAssignment_5_1"


    // $ANTLR start "rule__DataStore__AssumptionAssignment_5_2_1"
    // InternalMyDsl.g:8337:1: rule__DataStore__AssumptionAssignment_5_2_1 : ( ruleAssumption ) ;
    public final void rule__DataStore__AssumptionAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8341:1: ( ( ruleAssumption ) )
            // InternalMyDsl.g:8342:2: ( ruleAssumption )
            {
            // InternalMyDsl.g:8342:2: ( ruleAssumption )
            // InternalMyDsl.g:8343:3: ruleAssumption
            {
             before(grammarAccess.getDataStoreAccess().getAssumptionAssumptionParserRuleCall_5_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssumption();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getAssumptionAssumptionParserRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__AssumptionAssignment_5_2_1"


    // $ANTLR start "rule__DataStore__InflowsAssignment_6_2"
    // InternalMyDsl.g:8352:1: rule__DataStore__InflowsAssignment_6_2 : ( ( ruleEString ) ) ;
    public final void rule__DataStore__InflowsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8356:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8357:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8357:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8358:3: ( ruleEString )
            {
             before(grammarAccess.getDataStoreAccess().getInflowsFlowCrossReference_6_2_0()); 
            // InternalMyDsl.g:8359:3: ( ruleEString )
            // InternalMyDsl.g:8360:4: ruleEString
            {
             before(grammarAccess.getDataStoreAccess().getInflowsFlowEStringParserRuleCall_6_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getInflowsFlowEStringParserRuleCall_6_2_0_1()); 

            }

             after(grammarAccess.getDataStoreAccess().getInflowsFlowCrossReference_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__InflowsAssignment_6_2"


    // $ANTLR start "rule__DataStore__InflowsAssignment_6_3_1"
    // InternalMyDsl.g:8371:1: rule__DataStore__InflowsAssignment_6_3_1 : ( ( ruleEString ) ) ;
    public final void rule__DataStore__InflowsAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8375:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:8376:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:8376:2: ( ( ruleEString ) )
            // InternalMyDsl.g:8377:3: ( ruleEString )
            {
             before(grammarAccess.getDataStoreAccess().getInflowsFlowCrossReference_6_3_1_0()); 
            // InternalMyDsl.g:8378:3: ( ruleEString )
            // InternalMyDsl.g:8379:4: ruleEString
            {
             before(grammarAccess.getDataStoreAccess().getInflowsFlowEStringParserRuleCall_6_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getInflowsFlowEStringParserRuleCall_6_3_1_0_1()); 

            }

             after(grammarAccess.getDataStoreAccess().getInflowsFlowCrossReference_6_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__InflowsAssignment_6_3_1"


    // $ANTLR start "rule__DataStore__OutflowsAssignment_7_2"
    // InternalMyDsl.g:8390:1: rule__DataStore__OutflowsAssignment_7_2 : ( ruleFlow ) ;
    public final void rule__DataStore__OutflowsAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8394:1: ( ( ruleFlow ) )
            // InternalMyDsl.g:8395:2: ( ruleFlow )
            {
            // InternalMyDsl.g:8395:2: ( ruleFlow )
            // InternalMyDsl.g:8396:3: ruleFlow
            {
             before(grammarAccess.getDataStoreAccess().getOutflowsFlowParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFlow();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getOutflowsFlowParserRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__OutflowsAssignment_7_2"


    // $ANTLR start "rule__DataStore__OutflowsAssignment_7_3_1"
    // InternalMyDsl.g:8405:1: rule__DataStore__OutflowsAssignment_7_3_1 : ( ruleFlow ) ;
    public final void rule__DataStore__OutflowsAssignment_7_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8409:1: ( ( ruleFlow ) )
            // InternalMyDsl.g:8410:2: ( ruleFlow )
            {
            // InternalMyDsl.g:8410:2: ( ruleFlow )
            // InternalMyDsl.g:8411:3: ruleFlow
            {
             before(grammarAccess.getDataStoreAccess().getOutflowsFlowParserRuleCall_7_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFlow();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getOutflowsFlowParserRuleCall_7_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__OutflowsAssignment_7_3_1"


    // $ANTLR start "rule__DataStore__AttackerAssignment_8_1"
    // InternalMyDsl.g:8420:1: rule__DataStore__AttackerAssignment_8_1 : ( ruleEBoolean ) ;
    public final void rule__DataStore__AttackerAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8424:1: ( ( ruleEBoolean ) )
            // InternalMyDsl.g:8425:2: ( ruleEBoolean )
            {
            // InternalMyDsl.g:8425:2: ( ruleEBoolean )
            // InternalMyDsl.g:8426:3: ruleEBoolean
            {
             before(grammarAccess.getDataStoreAccess().getAttackerEBooleanParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getDataStoreAccess().getAttackerEBooleanParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataStore__AttackerAssignment_8_1"


    // $ANTLR start "rule__Value__PriorityAssignment_2"
    // InternalMyDsl.g:8435:1: rule__Value__PriorityAssignment_2 : ( rulePriority ) ;
    public final void rule__Value__PriorityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8439:1: ( ( rulePriority ) )
            // InternalMyDsl.g:8440:2: ( rulePriority )
            {
            // InternalMyDsl.g:8440:2: ( rulePriority )
            // InternalMyDsl.g:8441:3: rulePriority
            {
             before(grammarAccess.getValueAccess().getPriorityPriorityEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulePriority();

            state._fsp--;

             after(grammarAccess.getValueAccess().getPriorityPriorityEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__PriorityAssignment_2"


    // $ANTLR start "rule__Value__ObjectiveAssignment_3"
    // InternalMyDsl.g:8450:1: rule__Value__ObjectiveAssignment_3 : ( ruleObjective ) ;
    public final void rule__Value__ObjectiveAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8454:1: ( ( ruleObjective ) )
            // InternalMyDsl.g:8455:2: ( ruleObjective )
            {
            // InternalMyDsl.g:8455:2: ( ruleObjective )
            // InternalMyDsl.g:8456:3: ruleObjective
            {
             before(grammarAccess.getValueAccess().getObjectiveObjectiveEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleObjective();

            state._fsp--;

             after(grammarAccess.getValueAccess().getObjectiveObjectiveEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ObjectiveAssignment_3"


    // $ANTLR start "rule__Assumption__ObjectiveAssignment_2_0"
    // InternalMyDsl.g:8465:1: rule__Assumption__ObjectiveAssignment_2_0 : ( ruleObjective ) ;
    public final void rule__Assumption__ObjectiveAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8469:1: ( ( ruleObjective ) )
            // InternalMyDsl.g:8470:2: ( ruleObjective )
            {
            // InternalMyDsl.g:8470:2: ( ruleObjective )
            // InternalMyDsl.g:8471:3: ruleObjective
            {
             before(grammarAccess.getAssumptionAccess().getObjectiveObjectiveEnumRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleObjective();

            state._fsp--;

             after(grammarAccess.getAssumptionAccess().getObjectiveObjectiveEnumRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__ObjectiveAssignment_2_0"


    // $ANTLR start "rule__Assumption__ObjectiveAssignment_2_1_1"
    // InternalMyDsl.g:8480:1: rule__Assumption__ObjectiveAssignment_2_1_1 : ( ruleObjective ) ;
    public final void rule__Assumption__ObjectiveAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8484:1: ( ( ruleObjective ) )
            // InternalMyDsl.g:8485:2: ( ruleObjective )
            {
            // InternalMyDsl.g:8485:2: ( ruleObjective )
            // InternalMyDsl.g:8486:3: ruleObjective
            {
             before(grammarAccess.getAssumptionAccess().getObjectiveObjectiveEnumRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleObjective();

            state._fsp--;

             after(grammarAccess.getAssumptionAccess().getObjectiveObjectiveEnumRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__ObjectiveAssignment_2_1_1"


    // $ANTLR start "rule__Assumption__LayerAssignment_3_1"
    // InternalMyDsl.g:8495:1: rule__Assumption__LayerAssignment_3_1 : ( ruleLayer ) ;
    public final void rule__Assumption__LayerAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8499:1: ( ( ruleLayer ) )
            // InternalMyDsl.g:8500:2: ( ruleLayer )
            {
            // InternalMyDsl.g:8500:2: ( ruleLayer )
            // InternalMyDsl.g:8501:3: ruleLayer
            {
             before(grammarAccess.getAssumptionAccess().getLayerLayerEnumRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLayer();

            state._fsp--;

             after(grammarAccess.getAssumptionAccess().getLayerLayerEnumRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assumption__LayerAssignment_3_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000360000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x8080000000000030L,0x0000000000000004L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0002920000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0004020000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x3700060000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000A0FFF800030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080FFF800030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000080000000030L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x3600060000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0230060000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00000200000FE000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000200000F0000L,0x0000000000000008L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000000000F0000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000700000L});

}