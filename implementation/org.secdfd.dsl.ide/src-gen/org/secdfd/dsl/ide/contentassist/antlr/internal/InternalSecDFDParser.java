package org.secdfd.dsl.ide.contentassist.antlr.internal;

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
import org.secdfd.dsl.services.SecDFDGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSecDFDParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'H'", "'M'", "'L'", "'I'", "'C'", "'Av'", "'Ac'", "'Transport'", "'Architectural'", "'Application'", "'Store'", "'Comparator'", "'Discarder'", "'Joiner'", "'Copier'", "'Splitter'", "'Forward'", "'EncryptOrHash'", "'Decrypt'", "'Authenticator'", "'Authoriser'", "'Verifier'", "'User'", "'VLAN'", "'ETH'", "'WiFi'", "'String'", "'Number'", "'Object'", "'Vector'", "'EDFD'", "'['", "']'", "'assets:'", "','", "'elements:'", "'attack'", "'zones:'", "'attacker'", "'profiles:'", "'subzones:'", "'observation:'", "'Asset'", "'type:'", "'source:'", "'targets:'", "'values:'", "'Process'", "'responsibilities:'", "'assumption:'", "'incoming'", "'flows:'", "'outgoing'", "'attacker:'", "'::'", "'ExternalEntity'", "'num:'", "'channel'", "'DataStore'", "'layer:'", "'-'"
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
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
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


        public InternalSecDFDParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSecDFDParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSecDFDParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSecDFD.g"; }


    	private SecDFDGrammarAccess grammarAccess;

    	public void setGrammarAccess(SecDFDGrammarAccess grammarAccess) {
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
    // InternalSecDFD.g:53:1: entryRuleEDFD : ruleEDFD EOF ;
    public final void entryRuleEDFD() throws RecognitionException {
        try {
            // InternalSecDFD.g:54:1: ( ruleEDFD EOF )
            // InternalSecDFD.g:55:1: ruleEDFD EOF
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
    // InternalSecDFD.g:62:1: ruleEDFD : ( ( rule__EDFD__Group__0 ) ) ;
    public final void ruleEDFD() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:66:2: ( ( ( rule__EDFD__Group__0 ) ) )
            // InternalSecDFD.g:67:2: ( ( rule__EDFD__Group__0 ) )
            {
            // InternalSecDFD.g:67:2: ( ( rule__EDFD__Group__0 ) )
            // InternalSecDFD.g:68:3: ( rule__EDFD__Group__0 )
            {
             before(grammarAccess.getEDFDAccess().getGroup()); 
            // InternalSecDFD.g:69:3: ( rule__EDFD__Group__0 )
            // InternalSecDFD.g:69:4: rule__EDFD__Group__0
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
    // InternalSecDFD.g:78:1: entryRuleTrustZone : ruleTrustZone EOF ;
    public final void entryRuleTrustZone() throws RecognitionException {
        try {
            // InternalSecDFD.g:79:1: ( ruleTrustZone EOF )
            // InternalSecDFD.g:80:1: ruleTrustZone EOF
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
    // InternalSecDFD.g:87:1: ruleTrustZone : ( ( rule__TrustZone__Group__0 ) ) ;
    public final void ruleTrustZone() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:91:2: ( ( ( rule__TrustZone__Group__0 ) ) )
            // InternalSecDFD.g:92:2: ( ( rule__TrustZone__Group__0 ) )
            {
            // InternalSecDFD.g:92:2: ( ( rule__TrustZone__Group__0 ) )
            // InternalSecDFD.g:93:3: ( rule__TrustZone__Group__0 )
            {
             before(grammarAccess.getTrustZoneAccess().getGroup()); 
            // InternalSecDFD.g:94:3: ( rule__TrustZone__Group__0 )
            // InternalSecDFD.g:94:4: rule__TrustZone__Group__0
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
    // InternalSecDFD.g:103:1: entryRuleAttackerProfile : ruleAttackerProfile EOF ;
    public final void entryRuleAttackerProfile() throws RecognitionException {
        try {
            // InternalSecDFD.g:104:1: ( ruleAttackerProfile EOF )
            // InternalSecDFD.g:105:1: ruleAttackerProfile EOF
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
    // InternalSecDFD.g:112:1: ruleAttackerProfile : ( ( rule__AttackerProfile__Group__0 ) ) ;
    public final void ruleAttackerProfile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:116:2: ( ( ( rule__AttackerProfile__Group__0 ) ) )
            // InternalSecDFD.g:117:2: ( ( rule__AttackerProfile__Group__0 ) )
            {
            // InternalSecDFD.g:117:2: ( ( rule__AttackerProfile__Group__0 ) )
            // InternalSecDFD.g:118:3: ( rule__AttackerProfile__Group__0 )
            {
             before(grammarAccess.getAttackerProfileAccess().getGroup()); 
            // InternalSecDFD.g:119:3: ( rule__AttackerProfile__Group__0 )
            // InternalSecDFD.g:119:4: rule__AttackerProfile__Group__0
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
    // InternalSecDFD.g:128:1: entryRuleAsset : ruleAsset EOF ;
    public final void entryRuleAsset() throws RecognitionException {
        try {
            // InternalSecDFD.g:129:1: ( ruleAsset EOF )
            // InternalSecDFD.g:130:1: ruleAsset EOF
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
    // InternalSecDFD.g:137:1: ruleAsset : ( ( rule__Asset__Group__0 ) ) ;
    public final void ruleAsset() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:141:2: ( ( ( rule__Asset__Group__0 ) ) )
            // InternalSecDFD.g:142:2: ( ( rule__Asset__Group__0 ) )
            {
            // InternalSecDFD.g:142:2: ( ( rule__Asset__Group__0 ) )
            // InternalSecDFD.g:143:3: ( rule__Asset__Group__0 )
            {
             before(grammarAccess.getAssetAccess().getGroup()); 
            // InternalSecDFD.g:144:3: ( rule__Asset__Group__0 )
            // InternalSecDFD.g:144:4: rule__Asset__Group__0
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
    // InternalSecDFD.g:153:1: entryRuleProcess : ruleProcess EOF ;
    public final void entryRuleProcess() throws RecognitionException {
        try {
            // InternalSecDFD.g:154:1: ( ruleProcess EOF )
            // InternalSecDFD.g:155:1: ruleProcess EOF
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
    // InternalSecDFD.g:162:1: ruleProcess : ( ( rule__Process__Group__0 ) ) ;
    public final void ruleProcess() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:166:2: ( ( ( rule__Process__Group__0 ) ) )
            // InternalSecDFD.g:167:2: ( ( rule__Process__Group__0 ) )
            {
            // InternalSecDFD.g:167:2: ( ( rule__Process__Group__0 ) )
            // InternalSecDFD.g:168:3: ( rule__Process__Group__0 )
            {
             before(grammarAccess.getProcessAccess().getGroup()); 
            // InternalSecDFD.g:169:3: ( rule__Process__Group__0 )
            // InternalSecDFD.g:169:4: rule__Process__Group__0
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
    // InternalSecDFD.g:178:1: entryRuleResponsibility : ruleResponsibility EOF ;
    public final void entryRuleResponsibility() throws RecognitionException {
        try {
            // InternalSecDFD.g:179:1: ( ruleResponsibility EOF )
            // InternalSecDFD.g:180:1: ruleResponsibility EOF
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
    // InternalSecDFD.g:187:1: ruleResponsibility : ( ( rule__Responsibility__Group__0 ) ) ;
    public final void ruleResponsibility() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:191:2: ( ( ( rule__Responsibility__Group__0 ) ) )
            // InternalSecDFD.g:192:2: ( ( rule__Responsibility__Group__0 ) )
            {
            // InternalSecDFD.g:192:2: ( ( rule__Responsibility__Group__0 ) )
            // InternalSecDFD.g:193:3: ( rule__Responsibility__Group__0 )
            {
             before(grammarAccess.getResponsibilityAccess().getGroup()); 
            // InternalSecDFD.g:194:3: ( rule__Responsibility__Group__0 )
            // InternalSecDFD.g:194:4: rule__Responsibility__Group__0
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
    // InternalSecDFD.g:203:1: entryRuleExternalEntity : ruleExternalEntity EOF ;
    public final void entryRuleExternalEntity() throws RecognitionException {
        try {
            // InternalSecDFD.g:204:1: ( ruleExternalEntity EOF )
            // InternalSecDFD.g:205:1: ruleExternalEntity EOF
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
    // InternalSecDFD.g:212:1: ruleExternalEntity : ( ( rule__ExternalEntity__Group__0 ) ) ;
    public final void ruleExternalEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:216:2: ( ( ( rule__ExternalEntity__Group__0 ) ) )
            // InternalSecDFD.g:217:2: ( ( rule__ExternalEntity__Group__0 ) )
            {
            // InternalSecDFD.g:217:2: ( ( rule__ExternalEntity__Group__0 ) )
            // InternalSecDFD.g:218:3: ( rule__ExternalEntity__Group__0 )
            {
             before(grammarAccess.getExternalEntityAccess().getGroup()); 
            // InternalSecDFD.g:219:3: ( rule__ExternalEntity__Group__0 )
            // InternalSecDFD.g:219:4: rule__ExternalEntity__Group__0
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
    // InternalSecDFD.g:228:1: entryRuleFlow : ruleFlow EOF ;
    public final void entryRuleFlow() throws RecognitionException {
        try {
            // InternalSecDFD.g:229:1: ( ruleFlow EOF )
            // InternalSecDFD.g:230:1: ruleFlow EOF
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
    // InternalSecDFD.g:237:1: ruleFlow : ( ( rule__Flow__Group__0 ) ) ;
    public final void ruleFlow() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:241:2: ( ( ( rule__Flow__Group__0 ) ) )
            // InternalSecDFD.g:242:2: ( ( rule__Flow__Group__0 ) )
            {
            // InternalSecDFD.g:242:2: ( ( rule__Flow__Group__0 ) )
            // InternalSecDFD.g:243:3: ( rule__Flow__Group__0 )
            {
             before(grammarAccess.getFlowAccess().getGroup()); 
            // InternalSecDFD.g:244:3: ( rule__Flow__Group__0 )
            // InternalSecDFD.g:244:4: rule__Flow__Group__0
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
    // InternalSecDFD.g:253:1: entryRuleDataStore : ruleDataStore EOF ;
    public final void entryRuleDataStore() throws RecognitionException {
        try {
            // InternalSecDFD.g:254:1: ( ruleDataStore EOF )
            // InternalSecDFD.g:255:1: ruleDataStore EOF
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
    // InternalSecDFD.g:262:1: ruleDataStore : ( ( rule__DataStore__Group__0 ) ) ;
    public final void ruleDataStore() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:266:2: ( ( ( rule__DataStore__Group__0 ) ) )
            // InternalSecDFD.g:267:2: ( ( rule__DataStore__Group__0 ) )
            {
            // InternalSecDFD.g:267:2: ( ( rule__DataStore__Group__0 ) )
            // InternalSecDFD.g:268:3: ( rule__DataStore__Group__0 )
            {
             before(grammarAccess.getDataStoreAccess().getGroup()); 
            // InternalSecDFD.g:269:3: ( rule__DataStore__Group__0 )
            // InternalSecDFD.g:269:4: rule__DataStore__Group__0
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
    // InternalSecDFD.g:278:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // InternalSecDFD.g:279:1: ( ruleValue EOF )
            // InternalSecDFD.g:280:1: ruleValue EOF
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
    // InternalSecDFD.g:287:1: ruleValue : ( ( rule__Value__Group__0 ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:291:2: ( ( ( rule__Value__Group__0 ) ) )
            // InternalSecDFD.g:292:2: ( ( rule__Value__Group__0 ) )
            {
            // InternalSecDFD.g:292:2: ( ( rule__Value__Group__0 ) )
            // InternalSecDFD.g:293:3: ( rule__Value__Group__0 )
            {
             before(grammarAccess.getValueAccess().getGroup()); 
            // InternalSecDFD.g:294:3: ( rule__Value__Group__0 )
            // InternalSecDFD.g:294:4: rule__Value__Group__0
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
    // InternalSecDFD.g:303:1: entryRuleAssumption : ruleAssumption EOF ;
    public final void entryRuleAssumption() throws RecognitionException {
        try {
            // InternalSecDFD.g:304:1: ( ruleAssumption EOF )
            // InternalSecDFD.g:305:1: ruleAssumption EOF
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
    // InternalSecDFD.g:312:1: ruleAssumption : ( ( rule__Assumption__Group__0 ) ) ;
    public final void ruleAssumption() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:316:2: ( ( ( rule__Assumption__Group__0 ) ) )
            // InternalSecDFD.g:317:2: ( ( rule__Assumption__Group__0 ) )
            {
            // InternalSecDFD.g:317:2: ( ( rule__Assumption__Group__0 ) )
            // InternalSecDFD.g:318:3: ( rule__Assumption__Group__0 )
            {
             before(grammarAccess.getAssumptionAccess().getGroup()); 
            // InternalSecDFD.g:319:3: ( rule__Assumption__Group__0 )
            // InternalSecDFD.g:319:4: rule__Assumption__Group__0
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
    // InternalSecDFD.g:328:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalSecDFD.g:329:1: ( ruleElement EOF )
            // InternalSecDFD.g:330:1: ruleElement EOF
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
    // InternalSecDFD.g:337:1: ruleElement : ( ( rule__Element__Alternatives ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:341:2: ( ( ( rule__Element__Alternatives ) ) )
            // InternalSecDFD.g:342:2: ( ( rule__Element__Alternatives ) )
            {
            // InternalSecDFD.g:342:2: ( ( rule__Element__Alternatives ) )
            // InternalSecDFD.g:343:3: ( rule__Element__Alternatives )
            {
             before(grammarAccess.getElementAccess().getAlternatives()); 
            // InternalSecDFD.g:344:3: ( rule__Element__Alternatives )
            // InternalSecDFD.g:344:4: rule__Element__Alternatives
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
    // InternalSecDFD.g:353:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalSecDFD.g:354:1: ( ruleEString EOF )
            // InternalSecDFD.g:355:1: ruleEString EOF
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
    // InternalSecDFD.g:362:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:366:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalSecDFD.g:367:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalSecDFD.g:367:2: ( ( rule__EString__Alternatives ) )
            // InternalSecDFD.g:368:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalSecDFD.g:369:3: ( rule__EString__Alternatives )
            // InternalSecDFD.g:369:4: rule__EString__Alternatives
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
    // InternalSecDFD.g:378:1: entryRuleEBoolean : ruleEBoolean EOF ;
    public final void entryRuleEBoolean() throws RecognitionException {
        try {
            // InternalSecDFD.g:379:1: ( ruleEBoolean EOF )
            // InternalSecDFD.g:380:1: ruleEBoolean EOF
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
    // InternalSecDFD.g:387:1: ruleEBoolean : ( ( rule__EBoolean__Alternatives ) ) ;
    public final void ruleEBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:391:2: ( ( ( rule__EBoolean__Alternatives ) ) )
            // InternalSecDFD.g:392:2: ( ( rule__EBoolean__Alternatives ) )
            {
            // InternalSecDFD.g:392:2: ( ( rule__EBoolean__Alternatives ) )
            // InternalSecDFD.g:393:3: ( rule__EBoolean__Alternatives )
            {
             before(grammarAccess.getEBooleanAccess().getAlternatives()); 
            // InternalSecDFD.g:394:3: ( rule__EBoolean__Alternatives )
            // InternalSecDFD.g:394:4: rule__EBoolean__Alternatives
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
    // InternalSecDFD.g:403:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalSecDFD.g:404:1: ( ruleEInt EOF )
            // InternalSecDFD.g:405:1: ruleEInt EOF
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
    // InternalSecDFD.g:412:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:416:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalSecDFD.g:417:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalSecDFD.g:417:2: ( ( rule__EInt__Group__0 ) )
            // InternalSecDFD.g:418:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalSecDFD.g:419:3: ( rule__EInt__Group__0 )
            // InternalSecDFD.g:419:4: rule__EInt__Group__0
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
    // InternalSecDFD.g:428:1: rulePriority : ( ( rule__Priority__Alternatives ) ) ;
    public final void rulePriority() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:432:1: ( ( ( rule__Priority__Alternatives ) ) )
            // InternalSecDFD.g:433:2: ( ( rule__Priority__Alternatives ) )
            {
            // InternalSecDFD.g:433:2: ( ( rule__Priority__Alternatives ) )
            // InternalSecDFD.g:434:3: ( rule__Priority__Alternatives )
            {
             before(grammarAccess.getPriorityAccess().getAlternatives()); 
            // InternalSecDFD.g:435:3: ( rule__Priority__Alternatives )
            // InternalSecDFD.g:435:4: rule__Priority__Alternatives
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
    // InternalSecDFD.g:444:1: ruleObjective : ( ( rule__Objective__Alternatives ) ) ;
    public final void ruleObjective() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:448:1: ( ( ( rule__Objective__Alternatives ) ) )
            // InternalSecDFD.g:449:2: ( ( rule__Objective__Alternatives ) )
            {
            // InternalSecDFD.g:449:2: ( ( rule__Objective__Alternatives ) )
            // InternalSecDFD.g:450:3: ( rule__Objective__Alternatives )
            {
             before(grammarAccess.getObjectiveAccess().getAlternatives()); 
            // InternalSecDFD.g:451:3: ( rule__Objective__Alternatives )
            // InternalSecDFD.g:451:4: rule__Objective__Alternatives
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
    // InternalSecDFD.g:460:1: ruleLayer : ( ( rule__Layer__Alternatives ) ) ;
    public final void ruleLayer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:464:1: ( ( ( rule__Layer__Alternatives ) ) )
            // InternalSecDFD.g:465:2: ( ( rule__Layer__Alternatives ) )
            {
            // InternalSecDFD.g:465:2: ( ( rule__Layer__Alternatives ) )
            // InternalSecDFD.g:466:3: ( rule__Layer__Alternatives )
            {
             before(grammarAccess.getLayerAccess().getAlternatives()); 
            // InternalSecDFD.g:467:3: ( rule__Layer__Alternatives )
            // InternalSecDFD.g:467:4: rule__Layer__Alternatives
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
    // InternalSecDFD.g:476:1: ruleResponsibilityType : ( ( rule__ResponsibilityType__Alternatives ) ) ;
    public final void ruleResponsibilityType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:480:1: ( ( ( rule__ResponsibilityType__Alternatives ) ) )
            // InternalSecDFD.g:481:2: ( ( rule__ResponsibilityType__Alternatives ) )
            {
            // InternalSecDFD.g:481:2: ( ( rule__ResponsibilityType__Alternatives ) )
            // InternalSecDFD.g:482:3: ( rule__ResponsibilityType__Alternatives )
            {
             before(grammarAccess.getResponsibilityTypeAccess().getAlternatives()); 
            // InternalSecDFD.g:483:3: ( rule__ResponsibilityType__Alternatives )
            // InternalSecDFD.g:483:4: rule__ResponsibilityType__Alternatives
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
    // InternalSecDFD.g:492:1: ruleChannel : ( ( rule__Channel__Alternatives ) ) ;
    public final void ruleChannel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:496:1: ( ( ( rule__Channel__Alternatives ) ) )
            // InternalSecDFD.g:497:2: ( ( rule__Channel__Alternatives ) )
            {
            // InternalSecDFD.g:497:2: ( ( rule__Channel__Alternatives ) )
            // InternalSecDFD.g:498:3: ( rule__Channel__Alternatives )
            {
             before(grammarAccess.getChannelAccess().getAlternatives()); 
            // InternalSecDFD.g:499:3: ( rule__Channel__Alternatives )
            // InternalSecDFD.g:499:4: rule__Channel__Alternatives
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


    // $ANTLR start "ruleAssetType"
    // InternalSecDFD.g:508:1: ruleAssetType : ( ( rule__AssetType__Alternatives ) ) ;
    public final void ruleAssetType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:512:1: ( ( ( rule__AssetType__Alternatives ) ) )
            // InternalSecDFD.g:513:2: ( ( rule__AssetType__Alternatives ) )
            {
            // InternalSecDFD.g:513:2: ( ( rule__AssetType__Alternatives ) )
            // InternalSecDFD.g:514:3: ( rule__AssetType__Alternatives )
            {
             before(grammarAccess.getAssetTypeAccess().getAlternatives()); 
            // InternalSecDFD.g:515:3: ( rule__AssetType__Alternatives )
            // InternalSecDFD.g:515:4: rule__AssetType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AssetType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAssetTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssetType"


    // $ANTLR start "rule__Element__Alternatives"
    // InternalSecDFD.g:523:1: rule__Element__Alternatives : ( ( ruleProcess ) | ( ruleExternalEntity ) | ( ruleFlow ) | ( ruleDataStore ) | ( ruleTrustZone ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:527:1: ( ( ruleProcess ) | ( ruleExternalEntity ) | ( ruleFlow ) | ( ruleDataStore ) | ( ruleTrustZone ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt1=1;
                }
                break;
            case 68:
                {
                alt1=2;
                }
                break;
            case RULE_STRING:
                {
                int LA1_3 = input.LA(2);

                if ( (LA1_3==44) ) {
                    int LA1_6 = input.LA(3);

                    if ( (LA1_6==48||LA1_6==51||LA1_6==53) ) {
                        alt1=5;
                    }
                    else if ( ((LA1_6>=45 && LA1_6<=46)||(LA1_6>=57 && LA1_6<=58)||LA1_6==62||(LA1_6>=69 && LA1_6<=70)) ) {
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

                if ( (LA1_4==44) ) {
                    int LA1_6 = input.LA(3);

                    if ( (LA1_6==48||LA1_6==51||LA1_6==53) ) {
                        alt1=5;
                    }
                    else if ( ((LA1_6>=45 && LA1_6<=46)||(LA1_6>=57 && LA1_6<=58)||LA1_6==62||(LA1_6>=69 && LA1_6<=70)) ) {
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
            case 71:
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
                    // InternalSecDFD.g:528:2: ( ruleProcess )
                    {
                    // InternalSecDFD.g:528:2: ( ruleProcess )
                    // InternalSecDFD.g:529:3: ruleProcess
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
                    // InternalSecDFD.g:534:2: ( ruleExternalEntity )
                    {
                    // InternalSecDFD.g:534:2: ( ruleExternalEntity )
                    // InternalSecDFD.g:535:3: ruleExternalEntity
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
                    // InternalSecDFD.g:540:2: ( ruleFlow )
                    {
                    // InternalSecDFD.g:540:2: ( ruleFlow )
                    // InternalSecDFD.g:541:3: ruleFlow
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
                    // InternalSecDFD.g:546:2: ( ruleDataStore )
                    {
                    // InternalSecDFD.g:546:2: ( ruleDataStore )
                    // InternalSecDFD.g:547:3: ruleDataStore
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
                    // InternalSecDFD.g:552:2: ( ruleTrustZone )
                    {
                    // InternalSecDFD.g:552:2: ( ruleTrustZone )
                    // InternalSecDFD.g:553:3: ruleTrustZone
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
    // InternalSecDFD.g:562:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:566:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalSecDFD.g:567:2: ( RULE_STRING )
                    {
                    // InternalSecDFD.g:567:2: ( RULE_STRING )
                    // InternalSecDFD.g:568:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecDFD.g:573:2: ( RULE_ID )
                    {
                    // InternalSecDFD.g:573:2: ( RULE_ID )
                    // InternalSecDFD.g:574:3: RULE_ID
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
    // InternalSecDFD.g:583:1: rule__EBoolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__EBoolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:587:1: ( ( 'true' ) | ( 'false' ) )
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
                    // InternalSecDFD.g:588:2: ( 'true' )
                    {
                    // InternalSecDFD.g:588:2: ( 'true' )
                    // InternalSecDFD.g:589:3: 'true'
                    {
                     before(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecDFD.g:594:2: ( 'false' )
                    {
                    // InternalSecDFD.g:594:2: ( 'false' )
                    // InternalSecDFD.g:595:3: 'false'
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
    // InternalSecDFD.g:604:1: rule__Priority__Alternatives : ( ( ( 'H' ) ) | ( ( 'M' ) ) | ( ( 'L' ) ) );
    public final void rule__Priority__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:608:1: ( ( ( 'H' ) ) | ( ( 'M' ) ) | ( ( 'L' ) ) )
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
                    // InternalSecDFD.g:609:2: ( ( 'H' ) )
                    {
                    // InternalSecDFD.g:609:2: ( ( 'H' ) )
                    // InternalSecDFD.g:610:3: ( 'H' )
                    {
                     before(grammarAccess.getPriorityAccess().getHEnumLiteralDeclaration_0()); 
                    // InternalSecDFD.g:611:3: ( 'H' )
                    // InternalSecDFD.g:611:4: 'H'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getPriorityAccess().getHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecDFD.g:615:2: ( ( 'M' ) )
                    {
                    // InternalSecDFD.g:615:2: ( ( 'M' ) )
                    // InternalSecDFD.g:616:3: ( 'M' )
                    {
                     before(grammarAccess.getPriorityAccess().getMEnumLiteralDeclaration_1()); 
                    // InternalSecDFD.g:617:3: ( 'M' )
                    // InternalSecDFD.g:617:4: 'M'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getPriorityAccess().getMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSecDFD.g:621:2: ( ( 'L' ) )
                    {
                    // InternalSecDFD.g:621:2: ( ( 'L' ) )
                    // InternalSecDFD.g:622:3: ( 'L' )
                    {
                     before(grammarAccess.getPriorityAccess().getLEnumLiteralDeclaration_2()); 
                    // InternalSecDFD.g:623:3: ( 'L' )
                    // InternalSecDFD.g:623:4: 'L'
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
    // InternalSecDFD.g:631:1: rule__Objective__Alternatives : ( ( ( 'I' ) ) | ( ( 'C' ) ) | ( ( 'Av' ) ) | ( ( 'Ac' ) ) );
    public final void rule__Objective__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:635:1: ( ( ( 'I' ) ) | ( ( 'C' ) ) | ( ( 'Av' ) ) | ( ( 'Ac' ) ) )
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
                    // InternalSecDFD.g:636:2: ( ( 'I' ) )
                    {
                    // InternalSecDFD.g:636:2: ( ( 'I' ) )
                    // InternalSecDFD.g:637:3: ( 'I' )
                    {
                     before(grammarAccess.getObjectiveAccess().getIntegrityEnumLiteralDeclaration_0()); 
                    // InternalSecDFD.g:638:3: ( 'I' )
                    // InternalSecDFD.g:638:4: 'I'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getIntegrityEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecDFD.g:642:2: ( ( 'C' ) )
                    {
                    // InternalSecDFD.g:642:2: ( ( 'C' ) )
                    // InternalSecDFD.g:643:3: ( 'C' )
                    {
                     before(grammarAccess.getObjectiveAccess().getConfidentialityEnumLiteralDeclaration_1()); 
                    // InternalSecDFD.g:644:3: ( 'C' )
                    // InternalSecDFD.g:644:4: 'C'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getConfidentialityEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSecDFD.g:648:2: ( ( 'Av' ) )
                    {
                    // InternalSecDFD.g:648:2: ( ( 'Av' ) )
                    // InternalSecDFD.g:649:3: ( 'Av' )
                    {
                     before(grammarAccess.getObjectiveAccess().getAvailabilityEnumLiteralDeclaration_2()); 
                    // InternalSecDFD.g:650:3: ( 'Av' )
                    // InternalSecDFD.g:650:4: 'Av'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getObjectiveAccess().getAvailabilityEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSecDFD.g:654:2: ( ( 'Ac' ) )
                    {
                    // InternalSecDFD.g:654:2: ( ( 'Ac' ) )
                    // InternalSecDFD.g:655:3: ( 'Ac' )
                    {
                     before(grammarAccess.getObjectiveAccess().getAccountabilityEnumLiteralDeclaration_3()); 
                    // InternalSecDFD.g:656:3: ( 'Ac' )
                    // InternalSecDFD.g:656:4: 'Ac'
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
    // InternalSecDFD.g:664:1: rule__Layer__Alternatives : ( ( ( 'Transport' ) ) | ( ( 'Architectural' ) ) | ( ( 'Application' ) ) );
    public final void rule__Layer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:668:1: ( ( ( 'Transport' ) ) | ( ( 'Architectural' ) ) | ( ( 'Application' ) ) )
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
                    // InternalSecDFD.g:669:2: ( ( 'Transport' ) )
                    {
                    // InternalSecDFD.g:669:2: ( ( 'Transport' ) )
                    // InternalSecDFD.g:670:3: ( 'Transport' )
                    {
                     before(grammarAccess.getLayerAccess().getTransportEnumLiteralDeclaration_0()); 
                    // InternalSecDFD.g:671:3: ( 'Transport' )
                    // InternalSecDFD.g:671:4: 'Transport'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLayerAccess().getTransportEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecDFD.g:675:2: ( ( 'Architectural' ) )
                    {
                    // InternalSecDFD.g:675:2: ( ( 'Architectural' ) )
                    // InternalSecDFD.g:676:3: ( 'Architectural' )
                    {
                     before(grammarAccess.getLayerAccess().getArchitecturalEnumLiteralDeclaration_1()); 
                    // InternalSecDFD.g:677:3: ( 'Architectural' )
                    // InternalSecDFD.g:677:4: 'Architectural'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLayerAccess().getArchitecturalEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSecDFD.g:681:2: ( ( 'Application' ) )
                    {
                    // InternalSecDFD.g:681:2: ( ( 'Application' ) )
                    // InternalSecDFD.g:682:3: ( 'Application' )
                    {
                     before(grammarAccess.getLayerAccess().getApplicationEnumLiteralDeclaration_2()); 
                    // InternalSecDFD.g:683:3: ( 'Application' )
                    // InternalSecDFD.g:683:4: 'Application'
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
    // InternalSecDFD.g:691:1: rule__ResponsibilityType__Alternatives : ( ( ( 'Store' ) ) | ( ( 'Comparator' ) ) | ( ( 'Discarder' ) ) | ( ( 'Joiner' ) ) | ( ( 'Copier' ) ) | ( ( 'Splitter' ) ) | ( ( 'Forward' ) ) | ( ( 'EncryptOrHash' ) ) | ( ( 'Decrypt' ) ) | ( ( 'Authenticator' ) ) | ( ( 'Authoriser' ) ) | ( ( 'Verifier' ) ) | ( ( 'User' ) ) );
    public final void rule__ResponsibilityType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:695:1: ( ( ( 'Store' ) ) | ( ( 'Comparator' ) ) | ( ( 'Discarder' ) ) | ( ( 'Joiner' ) ) | ( ( 'Copier' ) ) | ( ( 'Splitter' ) ) | ( ( 'Forward' ) ) | ( ( 'EncryptOrHash' ) ) | ( ( 'Decrypt' ) ) | ( ( 'Authenticator' ) ) | ( ( 'Authoriser' ) ) | ( ( 'Verifier' ) ) | ( ( 'User' ) ) )
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
                    // InternalSecDFD.g:696:2: ( ( 'Store' ) )
                    {
                    // InternalSecDFD.g:696:2: ( ( 'Store' ) )
                    // InternalSecDFD.g:697:3: ( 'Store' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getStoreEnumLiteralDeclaration_0()); 
                    // InternalSecDFD.g:698:3: ( 'Store' )
                    // InternalSecDFD.g:698:4: 'Store'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getStoreEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecDFD.g:702:2: ( ( 'Comparator' ) )
                    {
                    // InternalSecDFD.g:702:2: ( ( 'Comparator' ) )
                    // InternalSecDFD.g:703:3: ( 'Comparator' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getComparatorEnumLiteralDeclaration_1()); 
                    // InternalSecDFD.g:704:3: ( 'Comparator' )
                    // InternalSecDFD.g:704:4: 'Comparator'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getComparatorEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSecDFD.g:708:2: ( ( 'Discarder' ) )
                    {
                    // InternalSecDFD.g:708:2: ( ( 'Discarder' ) )
                    // InternalSecDFD.g:709:3: ( 'Discarder' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getDiscarderEnumLiteralDeclaration_2()); 
                    // InternalSecDFD.g:710:3: ( 'Discarder' )
                    // InternalSecDFD.g:710:4: 'Discarder'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getDiscarderEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSecDFD.g:714:2: ( ( 'Joiner' ) )
                    {
                    // InternalSecDFD.g:714:2: ( ( 'Joiner' ) )
                    // InternalSecDFD.g:715:3: ( 'Joiner' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getJoinerEnumLiteralDeclaration_3()); 
                    // InternalSecDFD.g:716:3: ( 'Joiner' )
                    // InternalSecDFD.g:716:4: 'Joiner'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getJoinerEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSecDFD.g:720:2: ( ( 'Copier' ) )
                    {
                    // InternalSecDFD.g:720:2: ( ( 'Copier' ) )
                    // InternalSecDFD.g:721:3: ( 'Copier' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getCopierEnumLiteralDeclaration_4()); 
                    // InternalSecDFD.g:722:3: ( 'Copier' )
                    // InternalSecDFD.g:722:4: 'Copier'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getCopierEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSecDFD.g:726:2: ( ( 'Splitter' ) )
                    {
                    // InternalSecDFD.g:726:2: ( ( 'Splitter' ) )
                    // InternalSecDFD.g:727:3: ( 'Splitter' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getSplitterEnumLiteralDeclaration_5()); 
                    // InternalSecDFD.g:728:3: ( 'Splitter' )
                    // InternalSecDFD.g:728:4: 'Splitter'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getSplitterEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSecDFD.g:732:2: ( ( 'Forward' ) )
                    {
                    // InternalSecDFD.g:732:2: ( ( 'Forward' ) )
                    // InternalSecDFD.g:733:3: ( 'Forward' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getForwardEnumLiteralDeclaration_6()); 
                    // InternalSecDFD.g:734:3: ( 'Forward' )
                    // InternalSecDFD.g:734:4: 'Forward'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getForwardEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSecDFD.g:738:2: ( ( 'EncryptOrHash' ) )
                    {
                    // InternalSecDFD.g:738:2: ( ( 'EncryptOrHash' ) )
                    // InternalSecDFD.g:739:3: ( 'EncryptOrHash' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getEncryptOrHashEnumLiteralDeclaration_7()); 
                    // InternalSecDFD.g:740:3: ( 'EncryptOrHash' )
                    // InternalSecDFD.g:740:4: 'EncryptOrHash'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getEncryptOrHashEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalSecDFD.g:744:2: ( ( 'Decrypt' ) )
                    {
                    // InternalSecDFD.g:744:2: ( ( 'Decrypt' ) )
                    // InternalSecDFD.g:745:3: ( 'Decrypt' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getDecryptEnumLiteralDeclaration_8()); 
                    // InternalSecDFD.g:746:3: ( 'Decrypt' )
                    // InternalSecDFD.g:746:4: 'Decrypt'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getDecryptEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalSecDFD.g:750:2: ( ( 'Authenticator' ) )
                    {
                    // InternalSecDFD.g:750:2: ( ( 'Authenticator' ) )
                    // InternalSecDFD.g:751:3: ( 'Authenticator' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getAuthenticatorEnumLiteralDeclaration_9()); 
                    // InternalSecDFD.g:752:3: ( 'Authenticator' )
                    // InternalSecDFD.g:752:4: 'Authenticator'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getAuthenticatorEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalSecDFD.g:756:2: ( ( 'Authoriser' ) )
                    {
                    // InternalSecDFD.g:756:2: ( ( 'Authoriser' ) )
                    // InternalSecDFD.g:757:3: ( 'Authoriser' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getAuthoriserEnumLiteralDeclaration_10()); 
                    // InternalSecDFD.g:758:3: ( 'Authoriser' )
                    // InternalSecDFD.g:758:4: 'Authoriser'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getAuthoriserEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalSecDFD.g:762:2: ( ( 'Verifier' ) )
                    {
                    // InternalSecDFD.g:762:2: ( ( 'Verifier' ) )
                    // InternalSecDFD.g:763:3: ( 'Verifier' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getVerifierEnumLiteralDeclaration_11()); 
                    // InternalSecDFD.g:764:3: ( 'Verifier' )
                    // InternalSecDFD.g:764:4: 'Verifier'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getResponsibilityTypeAccess().getVerifierEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalSecDFD.g:768:2: ( ( 'User' ) )
                    {
                    // InternalSecDFD.g:768:2: ( ( 'User' ) )
                    // InternalSecDFD.g:769:3: ( 'User' )
                    {
                     before(grammarAccess.getResponsibilityTypeAccess().getUserEnumLiteralDeclaration_12()); 
                    // InternalSecDFD.g:770:3: ( 'User' )
                    // InternalSecDFD.g:770:4: 'User'
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
    // InternalSecDFD.g:778:1: rule__Channel__Alternatives : ( ( ( 'VLAN' ) ) | ( ( 'ETH' ) ) | ( ( 'WiFi' ) ) );
    public final void rule__Channel__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:782:1: ( ( ( 'VLAN' ) ) | ( ( 'ETH' ) ) | ( ( 'WiFi' ) ) )
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
                    // InternalSecDFD.g:783:2: ( ( 'VLAN' ) )
                    {
                    // InternalSecDFD.g:783:2: ( ( 'VLAN' ) )
                    // InternalSecDFD.g:784:3: ( 'VLAN' )
                    {
                     before(grammarAccess.getChannelAccess().getVLANEnumLiteralDeclaration_0()); 
                    // InternalSecDFD.g:785:3: ( 'VLAN' )
                    // InternalSecDFD.g:785:4: 'VLAN'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getChannelAccess().getVLANEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecDFD.g:789:2: ( ( 'ETH' ) )
                    {
                    // InternalSecDFD.g:789:2: ( ( 'ETH' ) )
                    // InternalSecDFD.g:790:3: ( 'ETH' )
                    {
                     before(grammarAccess.getChannelAccess().getETHEnumLiteralDeclaration_1()); 
                    // InternalSecDFD.g:791:3: ( 'ETH' )
                    // InternalSecDFD.g:791:4: 'ETH'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getChannelAccess().getETHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSecDFD.g:795:2: ( ( 'WiFi' ) )
                    {
                    // InternalSecDFD.g:795:2: ( ( 'WiFi' ) )
                    // InternalSecDFD.g:796:3: ( 'WiFi' )
                    {
                     before(grammarAccess.getChannelAccess().getWiFiEnumLiteralDeclaration_2()); 
                    // InternalSecDFD.g:797:3: ( 'WiFi' )
                    // InternalSecDFD.g:797:4: 'WiFi'
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


    // $ANTLR start "rule__AssetType__Alternatives"
    // InternalSecDFD.g:805:1: rule__AssetType__Alternatives : ( ( ( 'String' ) ) | ( ( 'Number' ) ) | ( ( 'Object' ) ) | ( ( 'Vector' ) ) );
    public final void rule__AssetType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:809:1: ( ( ( 'String' ) ) | ( ( 'Number' ) ) | ( ( 'Object' ) ) | ( ( 'Vector' ) ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt9=1;
                }
                break;
            case 40:
                {
                alt9=2;
                }
                break;
            case 41:
                {
                alt9=3;
                }
                break;
            case 42:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalSecDFD.g:810:2: ( ( 'String' ) )
                    {
                    // InternalSecDFD.g:810:2: ( ( 'String' ) )
                    // InternalSecDFD.g:811:3: ( 'String' )
                    {
                     before(grammarAccess.getAssetTypeAccess().getStringEnumLiteralDeclaration_0()); 
                    // InternalSecDFD.g:812:3: ( 'String' )
                    // InternalSecDFD.g:812:4: 'String'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getAssetTypeAccess().getStringEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSecDFD.g:816:2: ( ( 'Number' ) )
                    {
                    // InternalSecDFD.g:816:2: ( ( 'Number' ) )
                    // InternalSecDFD.g:817:3: ( 'Number' )
                    {
                     before(grammarAccess.getAssetTypeAccess().getNumberEnumLiteralDeclaration_1()); 
                    // InternalSecDFD.g:818:3: ( 'Number' )
                    // InternalSecDFD.g:818:4: 'Number'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getAssetTypeAccess().getNumberEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSecDFD.g:822:2: ( ( 'Object' ) )
                    {
                    // InternalSecDFD.g:822:2: ( ( 'Object' ) )
                    // InternalSecDFD.g:823:3: ( 'Object' )
                    {
                     before(grammarAccess.getAssetTypeAccess().getObjectEnumLiteralDeclaration_2()); 
                    // InternalSecDFD.g:824:3: ( 'Object' )
                    // InternalSecDFD.g:824:4: 'Object'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getAssetTypeAccess().getObjectEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSecDFD.g:828:2: ( ( 'Vector' ) )
                    {
                    // InternalSecDFD.g:828:2: ( ( 'Vector' ) )
                    // InternalSecDFD.g:829:3: ( 'Vector' )
                    {
                     before(grammarAccess.getAssetTypeAccess().getVectorEnumLiteralDeclaration_3()); 
                    // InternalSecDFD.g:830:3: ( 'Vector' )
                    // InternalSecDFD.g:830:4: 'Vector'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getAssetTypeAccess().getVectorEnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__AssetType__Alternatives"


    // $ANTLR start "rule__EDFD__Group__0"
    // InternalSecDFD.g:838:1: rule__EDFD__Group__0 : rule__EDFD__Group__0__Impl rule__EDFD__Group__1 ;
    public final void rule__EDFD__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:842:1: ( rule__EDFD__Group__0__Impl rule__EDFD__Group__1 )
            // InternalSecDFD.g:843:2: rule__EDFD__Group__0__Impl rule__EDFD__Group__1
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
    // InternalSecDFD.g:850:1: rule__EDFD__Group__0__Impl : ( () ) ;
    public final void rule__EDFD__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:854:1: ( ( () ) )
            // InternalSecDFD.g:855:1: ( () )
            {
            // InternalSecDFD.g:855:1: ( () )
            // InternalSecDFD.g:856:2: ()
            {
             before(grammarAccess.getEDFDAccess().getEDFDAction_0()); 
            // InternalSecDFD.g:857:2: ()
            // InternalSecDFD.g:857:3: 
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
    // InternalSecDFD.g:865:1: rule__EDFD__Group__1 : rule__EDFD__Group__1__Impl rule__EDFD__Group__2 ;
    public final void rule__EDFD__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:869:1: ( rule__EDFD__Group__1__Impl rule__EDFD__Group__2 )
            // InternalSecDFD.g:870:2: rule__EDFD__Group__1__Impl rule__EDFD__Group__2
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
    // InternalSecDFD.g:877:1: rule__EDFD__Group__1__Impl : ( 'EDFD' ) ;
    public final void rule__EDFD__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:881:1: ( ( 'EDFD' ) )
            // InternalSecDFD.g:882:1: ( 'EDFD' )
            {
            // InternalSecDFD.g:882:1: ( 'EDFD' )
            // InternalSecDFD.g:883:2: 'EDFD'
            {
             before(grammarAccess.getEDFDAccess().getEDFDKeyword_1()); 
            match(input,43,FOLLOW_2); 
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
    // InternalSecDFD.g:892:1: rule__EDFD__Group__2 : rule__EDFD__Group__2__Impl rule__EDFD__Group__3 ;
    public final void rule__EDFD__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:896:1: ( rule__EDFD__Group__2__Impl rule__EDFD__Group__3 )
            // InternalSecDFD.g:897:2: rule__EDFD__Group__2__Impl rule__EDFD__Group__3
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
    // InternalSecDFD.g:904:1: rule__EDFD__Group__2__Impl : ( ( rule__EDFD__NameAssignment_2 ) ) ;
    public final void rule__EDFD__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:908:1: ( ( ( rule__EDFD__NameAssignment_2 ) ) )
            // InternalSecDFD.g:909:1: ( ( rule__EDFD__NameAssignment_2 ) )
            {
            // InternalSecDFD.g:909:1: ( ( rule__EDFD__NameAssignment_2 ) )
            // InternalSecDFD.g:910:2: ( rule__EDFD__NameAssignment_2 )
            {
             before(grammarAccess.getEDFDAccess().getNameAssignment_2()); 
            // InternalSecDFD.g:911:2: ( rule__EDFD__NameAssignment_2 )
            // InternalSecDFD.g:911:3: rule__EDFD__NameAssignment_2
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
    // InternalSecDFD.g:919:1: rule__EDFD__Group__3 : rule__EDFD__Group__3__Impl rule__EDFD__Group__4 ;
    public final void rule__EDFD__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:923:1: ( rule__EDFD__Group__3__Impl rule__EDFD__Group__4 )
            // InternalSecDFD.g:924:2: rule__EDFD__Group__3__Impl rule__EDFD__Group__4
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
    // InternalSecDFD.g:931:1: rule__EDFD__Group__3__Impl : ( '[' ) ;
    public final void rule__EDFD__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:935:1: ( ( '[' ) )
            // InternalSecDFD.g:936:1: ( '[' )
            {
            // InternalSecDFD.g:936:1: ( '[' )
            // InternalSecDFD.g:937:2: '['
            {
             before(grammarAccess.getEDFDAccess().getLeftSquareBracketKeyword_3()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:946:1: rule__EDFD__Group__4 : rule__EDFD__Group__4__Impl rule__EDFD__Group__5 ;
    public final void rule__EDFD__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:950:1: ( rule__EDFD__Group__4__Impl rule__EDFD__Group__5 )
            // InternalSecDFD.g:951:2: rule__EDFD__Group__4__Impl rule__EDFD__Group__5
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
    // InternalSecDFD.g:958:1: rule__EDFD__Group__4__Impl : ( ( rule__EDFD__Group_4__0 )? ) ;
    public final void rule__EDFD__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:962:1: ( ( ( rule__EDFD__Group_4__0 )? ) )
            // InternalSecDFD.g:963:1: ( ( rule__EDFD__Group_4__0 )? )
            {
            // InternalSecDFD.g:963:1: ( ( rule__EDFD__Group_4__0 )? )
            // InternalSecDFD.g:964:2: ( rule__EDFD__Group_4__0 )?
            {
             before(grammarAccess.getEDFDAccess().getGroup_4()); 
            // InternalSecDFD.g:965:2: ( rule__EDFD__Group_4__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==46) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSecDFD.g:965:3: rule__EDFD__Group_4__0
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
    // InternalSecDFD.g:973:1: rule__EDFD__Group__5 : rule__EDFD__Group__5__Impl rule__EDFD__Group__6 ;
    public final void rule__EDFD__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:977:1: ( rule__EDFD__Group__5__Impl rule__EDFD__Group__6 )
            // InternalSecDFD.g:978:2: rule__EDFD__Group__5__Impl rule__EDFD__Group__6
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
    // InternalSecDFD.g:985:1: rule__EDFD__Group__5__Impl : ( ( rule__EDFD__Group_5__0 )? ) ;
    public final void rule__EDFD__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:989:1: ( ( ( rule__EDFD__Group_5__0 )? ) )
            // InternalSecDFD.g:990:1: ( ( rule__EDFD__Group_5__0 )? )
            {
            // InternalSecDFD.g:990:1: ( ( rule__EDFD__Group_5__0 )? )
            // InternalSecDFD.g:991:2: ( rule__EDFD__Group_5__0 )?
            {
             before(grammarAccess.getEDFDAccess().getGroup_5()); 
            // InternalSecDFD.g:992:2: ( rule__EDFD__Group_5__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==48) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSecDFD.g:992:3: rule__EDFD__Group_5__0
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
    // InternalSecDFD.g:1000:1: rule__EDFD__Group__6 : rule__EDFD__Group__6__Impl rule__EDFD__Group__7 ;
    public final void rule__EDFD__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1004:1: ( rule__EDFD__Group__6__Impl rule__EDFD__Group__7 )
            // InternalSecDFD.g:1005:2: rule__EDFD__Group__6__Impl rule__EDFD__Group__7
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
    // InternalSecDFD.g:1012:1: rule__EDFD__Group__6__Impl : ( ( rule__EDFD__Group_6__0 )? ) ;
    public final void rule__EDFD__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1016:1: ( ( ( rule__EDFD__Group_6__0 )? ) )
            // InternalSecDFD.g:1017:1: ( ( rule__EDFD__Group_6__0 )? )
            {
            // InternalSecDFD.g:1017:1: ( ( rule__EDFD__Group_6__0 )? )
            // InternalSecDFD.g:1018:2: ( rule__EDFD__Group_6__0 )?
            {
             before(grammarAccess.getEDFDAccess().getGroup_6()); 
            // InternalSecDFD.g:1019:2: ( rule__EDFD__Group_6__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==49) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSecDFD.g:1019:3: rule__EDFD__Group_6__0
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
    // InternalSecDFD.g:1027:1: rule__EDFD__Group__7 : rule__EDFD__Group__7__Impl ;
    public final void rule__EDFD__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1031:1: ( rule__EDFD__Group__7__Impl )
            // InternalSecDFD.g:1032:2: rule__EDFD__Group__7__Impl
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
    // InternalSecDFD.g:1038:1: rule__EDFD__Group__7__Impl : ( ']' ) ;
    public final void rule__EDFD__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1042:1: ( ( ']' ) )
            // InternalSecDFD.g:1043:1: ( ']' )
            {
            // InternalSecDFD.g:1043:1: ( ']' )
            // InternalSecDFD.g:1044:2: ']'
            {
             before(grammarAccess.getEDFDAccess().getRightSquareBracketKeyword_7()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:1054:1: rule__EDFD__Group_4__0 : rule__EDFD__Group_4__0__Impl rule__EDFD__Group_4__1 ;
    public final void rule__EDFD__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1058:1: ( rule__EDFD__Group_4__0__Impl rule__EDFD__Group_4__1 )
            // InternalSecDFD.g:1059:2: rule__EDFD__Group_4__0__Impl rule__EDFD__Group_4__1
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
    // InternalSecDFD.g:1066:1: rule__EDFD__Group_4__0__Impl : ( 'assets:' ) ;
    public final void rule__EDFD__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1070:1: ( ( 'assets:' ) )
            // InternalSecDFD.g:1071:1: ( 'assets:' )
            {
            // InternalSecDFD.g:1071:1: ( 'assets:' )
            // InternalSecDFD.g:1072:2: 'assets:'
            {
             before(grammarAccess.getEDFDAccess().getAssetsKeyword_4_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalSecDFD.g:1081:1: rule__EDFD__Group_4__1 : rule__EDFD__Group_4__1__Impl rule__EDFD__Group_4__2 ;
    public final void rule__EDFD__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1085:1: ( rule__EDFD__Group_4__1__Impl rule__EDFD__Group_4__2 )
            // InternalSecDFD.g:1086:2: rule__EDFD__Group_4__1__Impl rule__EDFD__Group_4__2
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
    // InternalSecDFD.g:1093:1: rule__EDFD__Group_4__1__Impl : ( ( rule__EDFD__AssetAssignment_4_1 ) ) ;
    public final void rule__EDFD__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1097:1: ( ( ( rule__EDFD__AssetAssignment_4_1 ) ) )
            // InternalSecDFD.g:1098:1: ( ( rule__EDFD__AssetAssignment_4_1 ) )
            {
            // InternalSecDFD.g:1098:1: ( ( rule__EDFD__AssetAssignment_4_1 ) )
            // InternalSecDFD.g:1099:2: ( rule__EDFD__AssetAssignment_4_1 )
            {
             before(grammarAccess.getEDFDAccess().getAssetAssignment_4_1()); 
            // InternalSecDFD.g:1100:2: ( rule__EDFD__AssetAssignment_4_1 )
            // InternalSecDFD.g:1100:3: rule__EDFD__AssetAssignment_4_1
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
    // InternalSecDFD.g:1108:1: rule__EDFD__Group_4__2 : rule__EDFD__Group_4__2__Impl ;
    public final void rule__EDFD__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1112:1: ( rule__EDFD__Group_4__2__Impl )
            // InternalSecDFD.g:1113:2: rule__EDFD__Group_4__2__Impl
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
    // InternalSecDFD.g:1119:1: rule__EDFD__Group_4__2__Impl : ( ( rule__EDFD__Group_4_2__0 )* ) ;
    public final void rule__EDFD__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1123:1: ( ( ( rule__EDFD__Group_4_2__0 )* ) )
            // InternalSecDFD.g:1124:1: ( ( rule__EDFD__Group_4_2__0 )* )
            {
            // InternalSecDFD.g:1124:1: ( ( rule__EDFD__Group_4_2__0 )* )
            // InternalSecDFD.g:1125:2: ( rule__EDFD__Group_4_2__0 )*
            {
             before(grammarAccess.getEDFDAccess().getGroup_4_2()); 
            // InternalSecDFD.g:1126:2: ( rule__EDFD__Group_4_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==47) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSecDFD.g:1126:3: rule__EDFD__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__EDFD__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalSecDFD.g:1135:1: rule__EDFD__Group_4_2__0 : rule__EDFD__Group_4_2__0__Impl rule__EDFD__Group_4_2__1 ;
    public final void rule__EDFD__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1139:1: ( rule__EDFD__Group_4_2__0__Impl rule__EDFD__Group_4_2__1 )
            // InternalSecDFD.g:1140:2: rule__EDFD__Group_4_2__0__Impl rule__EDFD__Group_4_2__1
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
    // InternalSecDFD.g:1147:1: rule__EDFD__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__EDFD__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1151:1: ( ( ',' ) )
            // InternalSecDFD.g:1152:1: ( ',' )
            {
            // InternalSecDFD.g:1152:1: ( ',' )
            // InternalSecDFD.g:1153:2: ','
            {
             before(grammarAccess.getEDFDAccess().getCommaKeyword_4_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:1162:1: rule__EDFD__Group_4_2__1 : rule__EDFD__Group_4_2__1__Impl ;
    public final void rule__EDFD__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1166:1: ( rule__EDFD__Group_4_2__1__Impl )
            // InternalSecDFD.g:1167:2: rule__EDFD__Group_4_2__1__Impl
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
    // InternalSecDFD.g:1173:1: rule__EDFD__Group_4_2__1__Impl : ( ( rule__EDFD__AssetAssignment_4_2_1 ) ) ;
    public final void rule__EDFD__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1177:1: ( ( ( rule__EDFD__AssetAssignment_4_2_1 ) ) )
            // InternalSecDFD.g:1178:1: ( ( rule__EDFD__AssetAssignment_4_2_1 ) )
            {
            // InternalSecDFD.g:1178:1: ( ( rule__EDFD__AssetAssignment_4_2_1 ) )
            // InternalSecDFD.g:1179:2: ( rule__EDFD__AssetAssignment_4_2_1 )
            {
             before(grammarAccess.getEDFDAccess().getAssetAssignment_4_2_1()); 
            // InternalSecDFD.g:1180:2: ( rule__EDFD__AssetAssignment_4_2_1 )
            // InternalSecDFD.g:1180:3: rule__EDFD__AssetAssignment_4_2_1
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
    // InternalSecDFD.g:1189:1: rule__EDFD__Group_5__0 : rule__EDFD__Group_5__0__Impl rule__EDFD__Group_5__1 ;
    public final void rule__EDFD__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1193:1: ( rule__EDFD__Group_5__0__Impl rule__EDFD__Group_5__1 )
            // InternalSecDFD.g:1194:2: rule__EDFD__Group_5__0__Impl rule__EDFD__Group_5__1
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
    // InternalSecDFD.g:1201:1: rule__EDFD__Group_5__0__Impl : ( 'elements:' ) ;
    public final void rule__EDFD__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1205:1: ( ( 'elements:' ) )
            // InternalSecDFD.g:1206:1: ( 'elements:' )
            {
            // InternalSecDFD.g:1206:1: ( 'elements:' )
            // InternalSecDFD.g:1207:2: 'elements:'
            {
             before(grammarAccess.getEDFDAccess().getElementsKeyword_5_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalSecDFD.g:1216:1: rule__EDFD__Group_5__1 : rule__EDFD__Group_5__1__Impl rule__EDFD__Group_5__2 ;
    public final void rule__EDFD__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1220:1: ( rule__EDFD__Group_5__1__Impl rule__EDFD__Group_5__2 )
            // InternalSecDFD.g:1221:2: rule__EDFD__Group_5__1__Impl rule__EDFD__Group_5__2
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
    // InternalSecDFD.g:1228:1: rule__EDFD__Group_5__1__Impl : ( ( rule__EDFD__ElementsAssignment_5_1 ) ) ;
    public final void rule__EDFD__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1232:1: ( ( ( rule__EDFD__ElementsAssignment_5_1 ) ) )
            // InternalSecDFD.g:1233:1: ( ( rule__EDFD__ElementsAssignment_5_1 ) )
            {
            // InternalSecDFD.g:1233:1: ( ( rule__EDFD__ElementsAssignment_5_1 ) )
            // InternalSecDFD.g:1234:2: ( rule__EDFD__ElementsAssignment_5_1 )
            {
             before(grammarAccess.getEDFDAccess().getElementsAssignment_5_1()); 
            // InternalSecDFD.g:1235:2: ( rule__EDFD__ElementsAssignment_5_1 )
            // InternalSecDFD.g:1235:3: rule__EDFD__ElementsAssignment_5_1
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
    // InternalSecDFD.g:1243:1: rule__EDFD__Group_5__2 : rule__EDFD__Group_5__2__Impl ;
    public final void rule__EDFD__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1247:1: ( rule__EDFD__Group_5__2__Impl )
            // InternalSecDFD.g:1248:2: rule__EDFD__Group_5__2__Impl
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
    // InternalSecDFD.g:1254:1: rule__EDFD__Group_5__2__Impl : ( ( rule__EDFD__Group_5_2__0 )* ) ;
    public final void rule__EDFD__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1258:1: ( ( ( rule__EDFD__Group_5_2__0 )* ) )
            // InternalSecDFD.g:1259:1: ( ( rule__EDFD__Group_5_2__0 )* )
            {
            // InternalSecDFD.g:1259:1: ( ( rule__EDFD__Group_5_2__0 )* )
            // InternalSecDFD.g:1260:2: ( rule__EDFD__Group_5_2__0 )*
            {
             before(grammarAccess.getEDFDAccess().getGroup_5_2()); 
            // InternalSecDFD.g:1261:2: ( rule__EDFD__Group_5_2__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==47) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSecDFD.g:1261:3: rule__EDFD__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__EDFD__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalSecDFD.g:1270:1: rule__EDFD__Group_5_2__0 : rule__EDFD__Group_5_2__0__Impl rule__EDFD__Group_5_2__1 ;
    public final void rule__EDFD__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1274:1: ( rule__EDFD__Group_5_2__0__Impl rule__EDFD__Group_5_2__1 )
            // InternalSecDFD.g:1275:2: rule__EDFD__Group_5_2__0__Impl rule__EDFD__Group_5_2__1
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
    // InternalSecDFD.g:1282:1: rule__EDFD__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__EDFD__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1286:1: ( ( ',' ) )
            // InternalSecDFD.g:1287:1: ( ',' )
            {
            // InternalSecDFD.g:1287:1: ( ',' )
            // InternalSecDFD.g:1288:2: ','
            {
             before(grammarAccess.getEDFDAccess().getCommaKeyword_5_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:1297:1: rule__EDFD__Group_5_2__1 : rule__EDFD__Group_5_2__1__Impl ;
    public final void rule__EDFD__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1301:1: ( rule__EDFD__Group_5_2__1__Impl )
            // InternalSecDFD.g:1302:2: rule__EDFD__Group_5_2__1__Impl
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
    // InternalSecDFD.g:1308:1: rule__EDFD__Group_5_2__1__Impl : ( ( rule__EDFD__ElementsAssignment_5_2_1 ) ) ;
    public final void rule__EDFD__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1312:1: ( ( ( rule__EDFD__ElementsAssignment_5_2_1 ) ) )
            // InternalSecDFD.g:1313:1: ( ( rule__EDFD__ElementsAssignment_5_2_1 ) )
            {
            // InternalSecDFD.g:1313:1: ( ( rule__EDFD__ElementsAssignment_5_2_1 ) )
            // InternalSecDFD.g:1314:2: ( rule__EDFD__ElementsAssignment_5_2_1 )
            {
             before(grammarAccess.getEDFDAccess().getElementsAssignment_5_2_1()); 
            // InternalSecDFD.g:1315:2: ( rule__EDFD__ElementsAssignment_5_2_1 )
            // InternalSecDFD.g:1315:3: rule__EDFD__ElementsAssignment_5_2_1
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
    // InternalSecDFD.g:1324:1: rule__EDFD__Group_6__0 : rule__EDFD__Group_6__0__Impl rule__EDFD__Group_6__1 ;
    public final void rule__EDFD__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1328:1: ( rule__EDFD__Group_6__0__Impl rule__EDFD__Group_6__1 )
            // InternalSecDFD.g:1329:2: rule__EDFD__Group_6__0__Impl rule__EDFD__Group_6__1
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
    // InternalSecDFD.g:1336:1: rule__EDFD__Group_6__0__Impl : ( 'attack' ) ;
    public final void rule__EDFD__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1340:1: ( ( 'attack' ) )
            // InternalSecDFD.g:1341:1: ( 'attack' )
            {
            // InternalSecDFD.g:1341:1: ( 'attack' )
            // InternalSecDFD.g:1342:2: 'attack'
            {
             before(grammarAccess.getEDFDAccess().getAttackKeyword_6_0()); 
            match(input,49,FOLLOW_2); 
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
    // InternalSecDFD.g:1351:1: rule__EDFD__Group_6__1 : rule__EDFD__Group_6__1__Impl rule__EDFD__Group_6__2 ;
    public final void rule__EDFD__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1355:1: ( rule__EDFD__Group_6__1__Impl rule__EDFD__Group_6__2 )
            // InternalSecDFD.g:1356:2: rule__EDFD__Group_6__1__Impl rule__EDFD__Group_6__2
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
    // InternalSecDFD.g:1363:1: rule__EDFD__Group_6__1__Impl : ( 'zones:' ) ;
    public final void rule__EDFD__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1367:1: ( ( 'zones:' ) )
            // InternalSecDFD.g:1368:1: ( 'zones:' )
            {
            // InternalSecDFD.g:1368:1: ( 'zones:' )
            // InternalSecDFD.g:1369:2: 'zones:'
            {
             before(grammarAccess.getEDFDAccess().getZonesKeyword_6_1()); 
            match(input,50,FOLLOW_2); 
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
    // InternalSecDFD.g:1378:1: rule__EDFD__Group_6__2 : rule__EDFD__Group_6__2__Impl rule__EDFD__Group_6__3 ;
    public final void rule__EDFD__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1382:1: ( rule__EDFD__Group_6__2__Impl rule__EDFD__Group_6__3 )
            // InternalSecDFD.g:1383:2: rule__EDFD__Group_6__2__Impl rule__EDFD__Group_6__3
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
    // InternalSecDFD.g:1390:1: rule__EDFD__Group_6__2__Impl : ( ( rule__EDFD__TrustzonesAssignment_6_2 ) ) ;
    public final void rule__EDFD__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1394:1: ( ( ( rule__EDFD__TrustzonesAssignment_6_2 ) ) )
            // InternalSecDFD.g:1395:1: ( ( rule__EDFD__TrustzonesAssignment_6_2 ) )
            {
            // InternalSecDFD.g:1395:1: ( ( rule__EDFD__TrustzonesAssignment_6_2 ) )
            // InternalSecDFD.g:1396:2: ( rule__EDFD__TrustzonesAssignment_6_2 )
            {
             before(grammarAccess.getEDFDAccess().getTrustzonesAssignment_6_2()); 
            // InternalSecDFD.g:1397:2: ( rule__EDFD__TrustzonesAssignment_6_2 )
            // InternalSecDFD.g:1397:3: rule__EDFD__TrustzonesAssignment_6_2
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
    // InternalSecDFD.g:1405:1: rule__EDFD__Group_6__3 : rule__EDFD__Group_6__3__Impl ;
    public final void rule__EDFD__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1409:1: ( rule__EDFD__Group_6__3__Impl )
            // InternalSecDFD.g:1410:2: rule__EDFD__Group_6__3__Impl
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
    // InternalSecDFD.g:1416:1: rule__EDFD__Group_6__3__Impl : ( ( rule__EDFD__Group_6_3__0 )* ) ;
    public final void rule__EDFD__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1420:1: ( ( ( rule__EDFD__Group_6_3__0 )* ) )
            // InternalSecDFD.g:1421:1: ( ( rule__EDFD__Group_6_3__0 )* )
            {
            // InternalSecDFD.g:1421:1: ( ( rule__EDFD__Group_6_3__0 )* )
            // InternalSecDFD.g:1422:2: ( rule__EDFD__Group_6_3__0 )*
            {
             before(grammarAccess.getEDFDAccess().getGroup_6_3()); 
            // InternalSecDFD.g:1423:2: ( rule__EDFD__Group_6_3__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==47) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSecDFD.g:1423:3: rule__EDFD__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__EDFD__Group_6_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalSecDFD.g:1432:1: rule__EDFD__Group_6_3__0 : rule__EDFD__Group_6_3__0__Impl rule__EDFD__Group_6_3__1 ;
    public final void rule__EDFD__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1436:1: ( rule__EDFD__Group_6_3__0__Impl rule__EDFD__Group_6_3__1 )
            // InternalSecDFD.g:1437:2: rule__EDFD__Group_6_3__0__Impl rule__EDFD__Group_6_3__1
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
    // InternalSecDFD.g:1444:1: rule__EDFD__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__EDFD__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1448:1: ( ( ',' ) )
            // InternalSecDFD.g:1449:1: ( ',' )
            {
            // InternalSecDFD.g:1449:1: ( ',' )
            // InternalSecDFD.g:1450:2: ','
            {
             before(grammarAccess.getEDFDAccess().getCommaKeyword_6_3_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:1459:1: rule__EDFD__Group_6_3__1 : rule__EDFD__Group_6_3__1__Impl ;
    public final void rule__EDFD__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1463:1: ( rule__EDFD__Group_6_3__1__Impl )
            // InternalSecDFD.g:1464:2: rule__EDFD__Group_6_3__1__Impl
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
    // InternalSecDFD.g:1470:1: rule__EDFD__Group_6_3__1__Impl : ( ( rule__EDFD__TrustzonesAssignment_6_3_1 ) ) ;
    public final void rule__EDFD__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1474:1: ( ( ( rule__EDFD__TrustzonesAssignment_6_3_1 ) ) )
            // InternalSecDFD.g:1475:1: ( ( rule__EDFD__TrustzonesAssignment_6_3_1 ) )
            {
            // InternalSecDFD.g:1475:1: ( ( rule__EDFD__TrustzonesAssignment_6_3_1 ) )
            // InternalSecDFD.g:1476:2: ( rule__EDFD__TrustzonesAssignment_6_3_1 )
            {
             before(grammarAccess.getEDFDAccess().getTrustzonesAssignment_6_3_1()); 
            // InternalSecDFD.g:1477:2: ( rule__EDFD__TrustzonesAssignment_6_3_1 )
            // InternalSecDFD.g:1477:3: rule__EDFD__TrustzonesAssignment_6_3_1
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
    // InternalSecDFD.g:1486:1: rule__TrustZone__Group__0 : rule__TrustZone__Group__0__Impl rule__TrustZone__Group__1 ;
    public final void rule__TrustZone__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1490:1: ( rule__TrustZone__Group__0__Impl rule__TrustZone__Group__1 )
            // InternalSecDFD.g:1491:2: rule__TrustZone__Group__0__Impl rule__TrustZone__Group__1
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
    // InternalSecDFD.g:1498:1: rule__TrustZone__Group__0__Impl : ( () ) ;
    public final void rule__TrustZone__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1502:1: ( ( () ) )
            // InternalSecDFD.g:1503:1: ( () )
            {
            // InternalSecDFD.g:1503:1: ( () )
            // InternalSecDFD.g:1504:2: ()
            {
             before(grammarAccess.getTrustZoneAccess().getTrustZoneAction_0()); 
            // InternalSecDFD.g:1505:2: ()
            // InternalSecDFD.g:1505:3: 
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
    // InternalSecDFD.g:1513:1: rule__TrustZone__Group__1 : rule__TrustZone__Group__1__Impl rule__TrustZone__Group__2 ;
    public final void rule__TrustZone__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1517:1: ( rule__TrustZone__Group__1__Impl rule__TrustZone__Group__2 )
            // InternalSecDFD.g:1518:2: rule__TrustZone__Group__1__Impl rule__TrustZone__Group__2
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
    // InternalSecDFD.g:1525:1: rule__TrustZone__Group__1__Impl : ( ( rule__TrustZone__NameAssignment_1 ) ) ;
    public final void rule__TrustZone__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1529:1: ( ( ( rule__TrustZone__NameAssignment_1 ) ) )
            // InternalSecDFD.g:1530:1: ( ( rule__TrustZone__NameAssignment_1 ) )
            {
            // InternalSecDFD.g:1530:1: ( ( rule__TrustZone__NameAssignment_1 ) )
            // InternalSecDFD.g:1531:2: ( rule__TrustZone__NameAssignment_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getNameAssignment_1()); 
            // InternalSecDFD.g:1532:2: ( rule__TrustZone__NameAssignment_1 )
            // InternalSecDFD.g:1532:3: rule__TrustZone__NameAssignment_1
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
    // InternalSecDFD.g:1540:1: rule__TrustZone__Group__2 : rule__TrustZone__Group__2__Impl rule__TrustZone__Group__3 ;
    public final void rule__TrustZone__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1544:1: ( rule__TrustZone__Group__2__Impl rule__TrustZone__Group__3 )
            // InternalSecDFD.g:1545:2: rule__TrustZone__Group__2__Impl rule__TrustZone__Group__3
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
    // InternalSecDFD.g:1552:1: rule__TrustZone__Group__2__Impl : ( '[' ) ;
    public final void rule__TrustZone__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1556:1: ( ( '[' ) )
            // InternalSecDFD.g:1557:1: ( '[' )
            {
            // InternalSecDFD.g:1557:1: ( '[' )
            // InternalSecDFD.g:1558:2: '['
            {
             before(grammarAccess.getTrustZoneAccess().getLeftSquareBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:1567:1: rule__TrustZone__Group__3 : rule__TrustZone__Group__3__Impl rule__TrustZone__Group__4 ;
    public final void rule__TrustZone__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1571:1: ( rule__TrustZone__Group__3__Impl rule__TrustZone__Group__4 )
            // InternalSecDFD.g:1572:2: rule__TrustZone__Group__3__Impl rule__TrustZone__Group__4
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
    // InternalSecDFD.g:1579:1: rule__TrustZone__Group__3__Impl : ( ( rule__TrustZone__Group_3__0 )? ) ;
    public final void rule__TrustZone__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1583:1: ( ( ( rule__TrustZone__Group_3__0 )? ) )
            // InternalSecDFD.g:1584:1: ( ( rule__TrustZone__Group_3__0 )? )
            {
            // InternalSecDFD.g:1584:1: ( ( rule__TrustZone__Group_3__0 )? )
            // InternalSecDFD.g:1585:2: ( rule__TrustZone__Group_3__0 )?
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_3()); 
            // InternalSecDFD.g:1586:2: ( rule__TrustZone__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==51) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSecDFD.g:1586:3: rule__TrustZone__Group_3__0
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
    // InternalSecDFD.g:1594:1: rule__TrustZone__Group__4 : rule__TrustZone__Group__4__Impl rule__TrustZone__Group__5 ;
    public final void rule__TrustZone__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1598:1: ( rule__TrustZone__Group__4__Impl rule__TrustZone__Group__5 )
            // InternalSecDFD.g:1599:2: rule__TrustZone__Group__4__Impl rule__TrustZone__Group__5
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
    // InternalSecDFD.g:1606:1: rule__TrustZone__Group__4__Impl : ( ( rule__TrustZone__Group_4__0 )? ) ;
    public final void rule__TrustZone__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1610:1: ( ( ( rule__TrustZone__Group_4__0 )? ) )
            // InternalSecDFD.g:1611:1: ( ( rule__TrustZone__Group_4__0 )? )
            {
            // InternalSecDFD.g:1611:1: ( ( rule__TrustZone__Group_4__0 )? )
            // InternalSecDFD.g:1612:2: ( rule__TrustZone__Group_4__0 )?
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_4()); 
            // InternalSecDFD.g:1613:2: ( rule__TrustZone__Group_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==48) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSecDFD.g:1613:3: rule__TrustZone__Group_4__0
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
    // InternalSecDFD.g:1621:1: rule__TrustZone__Group__5 : rule__TrustZone__Group__5__Impl rule__TrustZone__Group__6 ;
    public final void rule__TrustZone__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1625:1: ( rule__TrustZone__Group__5__Impl rule__TrustZone__Group__6 )
            // InternalSecDFD.g:1626:2: rule__TrustZone__Group__5__Impl rule__TrustZone__Group__6
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
    // InternalSecDFD.g:1633:1: rule__TrustZone__Group__5__Impl : ( ( rule__TrustZone__Group_5__0 )? ) ;
    public final void rule__TrustZone__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1637:1: ( ( ( rule__TrustZone__Group_5__0 )? ) )
            // InternalSecDFD.g:1638:1: ( ( rule__TrustZone__Group_5__0 )? )
            {
            // InternalSecDFD.g:1638:1: ( ( rule__TrustZone__Group_5__0 )? )
            // InternalSecDFD.g:1639:2: ( rule__TrustZone__Group_5__0 )?
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_5()); 
            // InternalSecDFD.g:1640:2: ( rule__TrustZone__Group_5__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==53) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalSecDFD.g:1640:3: rule__TrustZone__Group_5__0
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
    // InternalSecDFD.g:1648:1: rule__TrustZone__Group__6 : rule__TrustZone__Group__6__Impl ;
    public final void rule__TrustZone__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1652:1: ( rule__TrustZone__Group__6__Impl )
            // InternalSecDFD.g:1653:2: rule__TrustZone__Group__6__Impl
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
    // InternalSecDFD.g:1659:1: rule__TrustZone__Group__6__Impl : ( ']' ) ;
    public final void rule__TrustZone__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1663:1: ( ( ']' ) )
            // InternalSecDFD.g:1664:1: ( ']' )
            {
            // InternalSecDFD.g:1664:1: ( ']' )
            // InternalSecDFD.g:1665:2: ']'
            {
             before(grammarAccess.getTrustZoneAccess().getRightSquareBracketKeyword_6()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:1675:1: rule__TrustZone__Group_3__0 : rule__TrustZone__Group_3__0__Impl rule__TrustZone__Group_3__1 ;
    public final void rule__TrustZone__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1679:1: ( rule__TrustZone__Group_3__0__Impl rule__TrustZone__Group_3__1 )
            // InternalSecDFD.g:1680:2: rule__TrustZone__Group_3__0__Impl rule__TrustZone__Group_3__1
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
    // InternalSecDFD.g:1687:1: rule__TrustZone__Group_3__0__Impl : ( 'attacker' ) ;
    public final void rule__TrustZone__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1691:1: ( ( 'attacker' ) )
            // InternalSecDFD.g:1692:1: ( 'attacker' )
            {
            // InternalSecDFD.g:1692:1: ( 'attacker' )
            // InternalSecDFD.g:1693:2: 'attacker'
            {
             before(grammarAccess.getTrustZoneAccess().getAttackerKeyword_3_0()); 
            match(input,51,FOLLOW_2); 
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
    // InternalSecDFD.g:1702:1: rule__TrustZone__Group_3__1 : rule__TrustZone__Group_3__1__Impl rule__TrustZone__Group_3__2 ;
    public final void rule__TrustZone__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1706:1: ( rule__TrustZone__Group_3__1__Impl rule__TrustZone__Group_3__2 )
            // InternalSecDFD.g:1707:2: rule__TrustZone__Group_3__1__Impl rule__TrustZone__Group_3__2
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
    // InternalSecDFD.g:1714:1: rule__TrustZone__Group_3__1__Impl : ( 'profiles:' ) ;
    public final void rule__TrustZone__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1718:1: ( ( 'profiles:' ) )
            // InternalSecDFD.g:1719:1: ( 'profiles:' )
            {
            // InternalSecDFD.g:1719:1: ( 'profiles:' )
            // InternalSecDFD.g:1720:2: 'profiles:'
            {
             before(grammarAccess.getTrustZoneAccess().getProfilesKeyword_3_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalSecDFD.g:1729:1: rule__TrustZone__Group_3__2 : rule__TrustZone__Group_3__2__Impl rule__TrustZone__Group_3__3 ;
    public final void rule__TrustZone__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1733:1: ( rule__TrustZone__Group_3__2__Impl rule__TrustZone__Group_3__3 )
            // InternalSecDFD.g:1734:2: rule__TrustZone__Group_3__2__Impl rule__TrustZone__Group_3__3
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
    // InternalSecDFD.g:1741:1: rule__TrustZone__Group_3__2__Impl : ( ( rule__TrustZone__AttackerprofileAssignment_3_2 ) ) ;
    public final void rule__TrustZone__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1745:1: ( ( ( rule__TrustZone__AttackerprofileAssignment_3_2 ) ) )
            // InternalSecDFD.g:1746:1: ( ( rule__TrustZone__AttackerprofileAssignment_3_2 ) )
            {
            // InternalSecDFD.g:1746:1: ( ( rule__TrustZone__AttackerprofileAssignment_3_2 ) )
            // InternalSecDFD.g:1747:2: ( rule__TrustZone__AttackerprofileAssignment_3_2 )
            {
             before(grammarAccess.getTrustZoneAccess().getAttackerprofileAssignment_3_2()); 
            // InternalSecDFD.g:1748:2: ( rule__TrustZone__AttackerprofileAssignment_3_2 )
            // InternalSecDFD.g:1748:3: rule__TrustZone__AttackerprofileAssignment_3_2
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
    // InternalSecDFD.g:1756:1: rule__TrustZone__Group_3__3 : rule__TrustZone__Group_3__3__Impl ;
    public final void rule__TrustZone__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1760:1: ( rule__TrustZone__Group_3__3__Impl )
            // InternalSecDFD.g:1761:2: rule__TrustZone__Group_3__3__Impl
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
    // InternalSecDFD.g:1767:1: rule__TrustZone__Group_3__3__Impl : ( ( rule__TrustZone__Group_3_3__0 )* ) ;
    public final void rule__TrustZone__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1771:1: ( ( ( rule__TrustZone__Group_3_3__0 )* ) )
            // InternalSecDFD.g:1772:1: ( ( rule__TrustZone__Group_3_3__0 )* )
            {
            // InternalSecDFD.g:1772:1: ( ( rule__TrustZone__Group_3_3__0 )* )
            // InternalSecDFD.g:1773:2: ( rule__TrustZone__Group_3_3__0 )*
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_3_3()); 
            // InternalSecDFD.g:1774:2: ( rule__TrustZone__Group_3_3__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==47) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSecDFD.g:1774:3: rule__TrustZone__Group_3_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TrustZone__Group_3_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalSecDFD.g:1783:1: rule__TrustZone__Group_3_3__0 : rule__TrustZone__Group_3_3__0__Impl rule__TrustZone__Group_3_3__1 ;
    public final void rule__TrustZone__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1787:1: ( rule__TrustZone__Group_3_3__0__Impl rule__TrustZone__Group_3_3__1 )
            // InternalSecDFD.g:1788:2: rule__TrustZone__Group_3_3__0__Impl rule__TrustZone__Group_3_3__1
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
    // InternalSecDFD.g:1795:1: rule__TrustZone__Group_3_3__0__Impl : ( ',' ) ;
    public final void rule__TrustZone__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1799:1: ( ( ',' ) )
            // InternalSecDFD.g:1800:1: ( ',' )
            {
            // InternalSecDFD.g:1800:1: ( ',' )
            // InternalSecDFD.g:1801:2: ','
            {
             before(grammarAccess.getTrustZoneAccess().getCommaKeyword_3_3_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:1810:1: rule__TrustZone__Group_3_3__1 : rule__TrustZone__Group_3_3__1__Impl ;
    public final void rule__TrustZone__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1814:1: ( rule__TrustZone__Group_3_3__1__Impl )
            // InternalSecDFD.g:1815:2: rule__TrustZone__Group_3_3__1__Impl
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
    // InternalSecDFD.g:1821:1: rule__TrustZone__Group_3_3__1__Impl : ( ( rule__TrustZone__AttackerprofileAssignment_3_3_1 ) ) ;
    public final void rule__TrustZone__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1825:1: ( ( ( rule__TrustZone__AttackerprofileAssignment_3_3_1 ) ) )
            // InternalSecDFD.g:1826:1: ( ( rule__TrustZone__AttackerprofileAssignment_3_3_1 ) )
            {
            // InternalSecDFD.g:1826:1: ( ( rule__TrustZone__AttackerprofileAssignment_3_3_1 ) )
            // InternalSecDFD.g:1827:2: ( rule__TrustZone__AttackerprofileAssignment_3_3_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getAttackerprofileAssignment_3_3_1()); 
            // InternalSecDFD.g:1828:2: ( rule__TrustZone__AttackerprofileAssignment_3_3_1 )
            // InternalSecDFD.g:1828:3: rule__TrustZone__AttackerprofileAssignment_3_3_1
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
    // InternalSecDFD.g:1837:1: rule__TrustZone__Group_4__0 : rule__TrustZone__Group_4__0__Impl rule__TrustZone__Group_4__1 ;
    public final void rule__TrustZone__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1841:1: ( rule__TrustZone__Group_4__0__Impl rule__TrustZone__Group_4__1 )
            // InternalSecDFD.g:1842:2: rule__TrustZone__Group_4__0__Impl rule__TrustZone__Group_4__1
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
    // InternalSecDFD.g:1849:1: rule__TrustZone__Group_4__0__Impl : ( 'elements:' ) ;
    public final void rule__TrustZone__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1853:1: ( ( 'elements:' ) )
            // InternalSecDFD.g:1854:1: ( 'elements:' )
            {
            // InternalSecDFD.g:1854:1: ( 'elements:' )
            // InternalSecDFD.g:1855:2: 'elements:'
            {
             before(grammarAccess.getTrustZoneAccess().getElementsKeyword_4_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalSecDFD.g:1864:1: rule__TrustZone__Group_4__1 : rule__TrustZone__Group_4__1__Impl rule__TrustZone__Group_4__2 ;
    public final void rule__TrustZone__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1868:1: ( rule__TrustZone__Group_4__1__Impl rule__TrustZone__Group_4__2 )
            // InternalSecDFD.g:1869:2: rule__TrustZone__Group_4__1__Impl rule__TrustZone__Group_4__2
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
    // InternalSecDFD.g:1876:1: rule__TrustZone__Group_4__1__Impl : ( ( rule__TrustZone__ElementsAssignment_4_1 ) ) ;
    public final void rule__TrustZone__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1880:1: ( ( ( rule__TrustZone__ElementsAssignment_4_1 ) ) )
            // InternalSecDFD.g:1881:1: ( ( rule__TrustZone__ElementsAssignment_4_1 ) )
            {
            // InternalSecDFD.g:1881:1: ( ( rule__TrustZone__ElementsAssignment_4_1 ) )
            // InternalSecDFD.g:1882:2: ( rule__TrustZone__ElementsAssignment_4_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getElementsAssignment_4_1()); 
            // InternalSecDFD.g:1883:2: ( rule__TrustZone__ElementsAssignment_4_1 )
            // InternalSecDFD.g:1883:3: rule__TrustZone__ElementsAssignment_4_1
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
    // InternalSecDFD.g:1891:1: rule__TrustZone__Group_4__2 : rule__TrustZone__Group_4__2__Impl ;
    public final void rule__TrustZone__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1895:1: ( rule__TrustZone__Group_4__2__Impl )
            // InternalSecDFD.g:1896:2: rule__TrustZone__Group_4__2__Impl
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
    // InternalSecDFD.g:1902:1: rule__TrustZone__Group_4__2__Impl : ( ( rule__TrustZone__Group_4_2__0 )* ) ;
    public final void rule__TrustZone__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1906:1: ( ( ( rule__TrustZone__Group_4_2__0 )* ) )
            // InternalSecDFD.g:1907:1: ( ( rule__TrustZone__Group_4_2__0 )* )
            {
            // InternalSecDFD.g:1907:1: ( ( rule__TrustZone__Group_4_2__0 )* )
            // InternalSecDFD.g:1908:2: ( rule__TrustZone__Group_4_2__0 )*
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_4_2()); 
            // InternalSecDFD.g:1909:2: ( rule__TrustZone__Group_4_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==47) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSecDFD.g:1909:3: rule__TrustZone__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TrustZone__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalSecDFD.g:1918:1: rule__TrustZone__Group_4_2__0 : rule__TrustZone__Group_4_2__0__Impl rule__TrustZone__Group_4_2__1 ;
    public final void rule__TrustZone__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1922:1: ( rule__TrustZone__Group_4_2__0__Impl rule__TrustZone__Group_4_2__1 )
            // InternalSecDFD.g:1923:2: rule__TrustZone__Group_4_2__0__Impl rule__TrustZone__Group_4_2__1
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
    // InternalSecDFD.g:1930:1: rule__TrustZone__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__TrustZone__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1934:1: ( ( ',' ) )
            // InternalSecDFD.g:1935:1: ( ',' )
            {
            // InternalSecDFD.g:1935:1: ( ',' )
            // InternalSecDFD.g:1936:2: ','
            {
             before(grammarAccess.getTrustZoneAccess().getCommaKeyword_4_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:1945:1: rule__TrustZone__Group_4_2__1 : rule__TrustZone__Group_4_2__1__Impl ;
    public final void rule__TrustZone__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1949:1: ( rule__TrustZone__Group_4_2__1__Impl )
            // InternalSecDFD.g:1950:2: rule__TrustZone__Group_4_2__1__Impl
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
    // InternalSecDFD.g:1956:1: rule__TrustZone__Group_4_2__1__Impl : ( ( rule__TrustZone__ElementsAssignment_4_2_1 ) ) ;
    public final void rule__TrustZone__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1960:1: ( ( ( rule__TrustZone__ElementsAssignment_4_2_1 ) ) )
            // InternalSecDFD.g:1961:1: ( ( rule__TrustZone__ElementsAssignment_4_2_1 ) )
            {
            // InternalSecDFD.g:1961:1: ( ( rule__TrustZone__ElementsAssignment_4_2_1 ) )
            // InternalSecDFD.g:1962:2: ( rule__TrustZone__ElementsAssignment_4_2_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getElementsAssignment_4_2_1()); 
            // InternalSecDFD.g:1963:2: ( rule__TrustZone__ElementsAssignment_4_2_1 )
            // InternalSecDFD.g:1963:3: rule__TrustZone__ElementsAssignment_4_2_1
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
    // InternalSecDFD.g:1972:1: rule__TrustZone__Group_5__0 : rule__TrustZone__Group_5__0__Impl rule__TrustZone__Group_5__1 ;
    public final void rule__TrustZone__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1976:1: ( rule__TrustZone__Group_5__0__Impl rule__TrustZone__Group_5__1 )
            // InternalSecDFD.g:1977:2: rule__TrustZone__Group_5__0__Impl rule__TrustZone__Group_5__1
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
    // InternalSecDFD.g:1984:1: rule__TrustZone__Group_5__0__Impl : ( 'subzones:' ) ;
    public final void rule__TrustZone__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:1988:1: ( ( 'subzones:' ) )
            // InternalSecDFD.g:1989:1: ( 'subzones:' )
            {
            // InternalSecDFD.g:1989:1: ( 'subzones:' )
            // InternalSecDFD.g:1990:2: 'subzones:'
            {
             before(grammarAccess.getTrustZoneAccess().getSubzonesKeyword_5_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalSecDFD.g:1999:1: rule__TrustZone__Group_5__1 : rule__TrustZone__Group_5__1__Impl rule__TrustZone__Group_5__2 ;
    public final void rule__TrustZone__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2003:1: ( rule__TrustZone__Group_5__1__Impl rule__TrustZone__Group_5__2 )
            // InternalSecDFD.g:2004:2: rule__TrustZone__Group_5__1__Impl rule__TrustZone__Group_5__2
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
    // InternalSecDFD.g:2011:1: rule__TrustZone__Group_5__1__Impl : ( ( rule__TrustZone__SubzonesAssignment_5_1 ) ) ;
    public final void rule__TrustZone__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2015:1: ( ( ( rule__TrustZone__SubzonesAssignment_5_1 ) ) )
            // InternalSecDFD.g:2016:1: ( ( rule__TrustZone__SubzonesAssignment_5_1 ) )
            {
            // InternalSecDFD.g:2016:1: ( ( rule__TrustZone__SubzonesAssignment_5_1 ) )
            // InternalSecDFD.g:2017:2: ( rule__TrustZone__SubzonesAssignment_5_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getSubzonesAssignment_5_1()); 
            // InternalSecDFD.g:2018:2: ( rule__TrustZone__SubzonesAssignment_5_1 )
            // InternalSecDFD.g:2018:3: rule__TrustZone__SubzonesAssignment_5_1
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
    // InternalSecDFD.g:2026:1: rule__TrustZone__Group_5__2 : rule__TrustZone__Group_5__2__Impl ;
    public final void rule__TrustZone__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2030:1: ( rule__TrustZone__Group_5__2__Impl )
            // InternalSecDFD.g:2031:2: rule__TrustZone__Group_5__2__Impl
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
    // InternalSecDFD.g:2037:1: rule__TrustZone__Group_5__2__Impl : ( ( rule__TrustZone__Group_5_2__0 )* ) ;
    public final void rule__TrustZone__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2041:1: ( ( ( rule__TrustZone__Group_5_2__0 )* ) )
            // InternalSecDFD.g:2042:1: ( ( rule__TrustZone__Group_5_2__0 )* )
            {
            // InternalSecDFD.g:2042:1: ( ( rule__TrustZone__Group_5_2__0 )* )
            // InternalSecDFD.g:2043:2: ( rule__TrustZone__Group_5_2__0 )*
            {
             before(grammarAccess.getTrustZoneAccess().getGroup_5_2()); 
            // InternalSecDFD.g:2044:2: ( rule__TrustZone__Group_5_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==47) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalSecDFD.g:2044:3: rule__TrustZone__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TrustZone__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalSecDFD.g:2053:1: rule__TrustZone__Group_5_2__0 : rule__TrustZone__Group_5_2__0__Impl rule__TrustZone__Group_5_2__1 ;
    public final void rule__TrustZone__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2057:1: ( rule__TrustZone__Group_5_2__0__Impl rule__TrustZone__Group_5_2__1 )
            // InternalSecDFD.g:2058:2: rule__TrustZone__Group_5_2__0__Impl rule__TrustZone__Group_5_2__1
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
    // InternalSecDFD.g:2065:1: rule__TrustZone__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__TrustZone__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2069:1: ( ( ',' ) )
            // InternalSecDFD.g:2070:1: ( ',' )
            {
            // InternalSecDFD.g:2070:1: ( ',' )
            // InternalSecDFD.g:2071:2: ','
            {
             before(grammarAccess.getTrustZoneAccess().getCommaKeyword_5_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:2080:1: rule__TrustZone__Group_5_2__1 : rule__TrustZone__Group_5_2__1__Impl ;
    public final void rule__TrustZone__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2084:1: ( rule__TrustZone__Group_5_2__1__Impl )
            // InternalSecDFD.g:2085:2: rule__TrustZone__Group_5_2__1__Impl
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
    // InternalSecDFD.g:2091:1: rule__TrustZone__Group_5_2__1__Impl : ( ( rule__TrustZone__SubzonesAssignment_5_2_1 ) ) ;
    public final void rule__TrustZone__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2095:1: ( ( ( rule__TrustZone__SubzonesAssignment_5_2_1 ) ) )
            // InternalSecDFD.g:2096:1: ( ( rule__TrustZone__SubzonesAssignment_5_2_1 ) )
            {
            // InternalSecDFD.g:2096:1: ( ( rule__TrustZone__SubzonesAssignment_5_2_1 ) )
            // InternalSecDFD.g:2097:2: ( rule__TrustZone__SubzonesAssignment_5_2_1 )
            {
             before(grammarAccess.getTrustZoneAccess().getSubzonesAssignment_5_2_1()); 
            // InternalSecDFD.g:2098:2: ( rule__TrustZone__SubzonesAssignment_5_2_1 )
            // InternalSecDFD.g:2098:3: rule__TrustZone__SubzonesAssignment_5_2_1
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
    // InternalSecDFD.g:2107:1: rule__AttackerProfile__Group__0 : rule__AttackerProfile__Group__0__Impl rule__AttackerProfile__Group__1 ;
    public final void rule__AttackerProfile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2111:1: ( rule__AttackerProfile__Group__0__Impl rule__AttackerProfile__Group__1 )
            // InternalSecDFD.g:2112:2: rule__AttackerProfile__Group__0__Impl rule__AttackerProfile__Group__1
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
    // InternalSecDFD.g:2119:1: rule__AttackerProfile__Group__0__Impl : ( () ) ;
    public final void rule__AttackerProfile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2123:1: ( ( () ) )
            // InternalSecDFD.g:2124:1: ( () )
            {
            // InternalSecDFD.g:2124:1: ( () )
            // InternalSecDFD.g:2125:2: ()
            {
             before(grammarAccess.getAttackerProfileAccess().getAttackerProfileAction_0()); 
            // InternalSecDFD.g:2126:2: ()
            // InternalSecDFD.g:2126:3: 
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
    // InternalSecDFD.g:2134:1: rule__AttackerProfile__Group__1 : rule__AttackerProfile__Group__1__Impl rule__AttackerProfile__Group__2 ;
    public final void rule__AttackerProfile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2138:1: ( rule__AttackerProfile__Group__1__Impl rule__AttackerProfile__Group__2 )
            // InternalSecDFD.g:2139:2: rule__AttackerProfile__Group__1__Impl rule__AttackerProfile__Group__2
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
    // InternalSecDFD.g:2146:1: rule__AttackerProfile__Group__1__Impl : ( ( rule__AttackerProfile__NameAssignment_1 ) ) ;
    public final void rule__AttackerProfile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2150:1: ( ( ( rule__AttackerProfile__NameAssignment_1 ) ) )
            // InternalSecDFD.g:2151:1: ( ( rule__AttackerProfile__NameAssignment_1 ) )
            {
            // InternalSecDFD.g:2151:1: ( ( rule__AttackerProfile__NameAssignment_1 ) )
            // InternalSecDFD.g:2152:2: ( rule__AttackerProfile__NameAssignment_1 )
            {
             before(grammarAccess.getAttackerProfileAccess().getNameAssignment_1()); 
            // InternalSecDFD.g:2153:2: ( rule__AttackerProfile__NameAssignment_1 )
            // InternalSecDFD.g:2153:3: rule__AttackerProfile__NameAssignment_1
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
    // InternalSecDFD.g:2161:1: rule__AttackerProfile__Group__2 : rule__AttackerProfile__Group__2__Impl rule__AttackerProfile__Group__3 ;
    public final void rule__AttackerProfile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2165:1: ( rule__AttackerProfile__Group__2__Impl rule__AttackerProfile__Group__3 )
            // InternalSecDFD.g:2166:2: rule__AttackerProfile__Group__2__Impl rule__AttackerProfile__Group__3
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
    // InternalSecDFD.g:2173:1: rule__AttackerProfile__Group__2__Impl : ( '[' ) ;
    public final void rule__AttackerProfile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2177:1: ( ( '[' ) )
            // InternalSecDFD.g:2178:1: ( '[' )
            {
            // InternalSecDFD.g:2178:1: ( '[' )
            // InternalSecDFD.g:2179:2: '['
            {
             before(grammarAccess.getAttackerProfileAccess().getLeftSquareBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:2188:1: rule__AttackerProfile__Group__3 : rule__AttackerProfile__Group__3__Impl rule__AttackerProfile__Group__4 ;
    public final void rule__AttackerProfile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2192:1: ( rule__AttackerProfile__Group__3__Impl rule__AttackerProfile__Group__4 )
            // InternalSecDFD.g:2193:2: rule__AttackerProfile__Group__3__Impl rule__AttackerProfile__Group__4
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
    // InternalSecDFD.g:2200:1: rule__AttackerProfile__Group__3__Impl : ( ( rule__AttackerProfile__Group_3__0 )? ) ;
    public final void rule__AttackerProfile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2204:1: ( ( ( rule__AttackerProfile__Group_3__0 )? ) )
            // InternalSecDFD.g:2205:1: ( ( rule__AttackerProfile__Group_3__0 )? )
            {
            // InternalSecDFD.g:2205:1: ( ( rule__AttackerProfile__Group_3__0 )? )
            // InternalSecDFD.g:2206:2: ( rule__AttackerProfile__Group_3__0 )?
            {
             before(grammarAccess.getAttackerProfileAccess().getGroup_3()); 
            // InternalSecDFD.g:2207:2: ( rule__AttackerProfile__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==54) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalSecDFD.g:2207:3: rule__AttackerProfile__Group_3__0
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
    // InternalSecDFD.g:2215:1: rule__AttackerProfile__Group__4 : rule__AttackerProfile__Group__4__Impl ;
    public final void rule__AttackerProfile__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2219:1: ( rule__AttackerProfile__Group__4__Impl )
            // InternalSecDFD.g:2220:2: rule__AttackerProfile__Group__4__Impl
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
    // InternalSecDFD.g:2226:1: rule__AttackerProfile__Group__4__Impl : ( ']' ) ;
    public final void rule__AttackerProfile__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2230:1: ( ( ']' ) )
            // InternalSecDFD.g:2231:1: ( ']' )
            {
            // InternalSecDFD.g:2231:1: ( ']' )
            // InternalSecDFD.g:2232:2: ']'
            {
             before(grammarAccess.getAttackerProfileAccess().getRightSquareBracketKeyword_4()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:2242:1: rule__AttackerProfile__Group_3__0 : rule__AttackerProfile__Group_3__0__Impl rule__AttackerProfile__Group_3__1 ;
    public final void rule__AttackerProfile__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2246:1: ( rule__AttackerProfile__Group_3__0__Impl rule__AttackerProfile__Group_3__1 )
            // InternalSecDFD.g:2247:2: rule__AttackerProfile__Group_3__0__Impl rule__AttackerProfile__Group_3__1
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
    // InternalSecDFD.g:2254:1: rule__AttackerProfile__Group_3__0__Impl : ( 'observation:' ) ;
    public final void rule__AttackerProfile__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2258:1: ( ( 'observation:' ) )
            // InternalSecDFD.g:2259:1: ( 'observation:' )
            {
            // InternalSecDFD.g:2259:1: ( 'observation:' )
            // InternalSecDFD.g:2260:2: 'observation:'
            {
             before(grammarAccess.getAttackerProfileAccess().getObservationKeyword_3_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalSecDFD.g:2269:1: rule__AttackerProfile__Group_3__1 : rule__AttackerProfile__Group_3__1__Impl ;
    public final void rule__AttackerProfile__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2273:1: ( rule__AttackerProfile__Group_3__1__Impl )
            // InternalSecDFD.g:2274:2: rule__AttackerProfile__Group_3__1__Impl
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
    // InternalSecDFD.g:2280:1: rule__AttackerProfile__Group_3__1__Impl : ( ( rule__AttackerProfile__ObservationAssignment_3_1 ) ) ;
    public final void rule__AttackerProfile__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2284:1: ( ( ( rule__AttackerProfile__ObservationAssignment_3_1 ) ) )
            // InternalSecDFD.g:2285:1: ( ( rule__AttackerProfile__ObservationAssignment_3_1 ) )
            {
            // InternalSecDFD.g:2285:1: ( ( rule__AttackerProfile__ObservationAssignment_3_1 ) )
            // InternalSecDFD.g:2286:2: ( rule__AttackerProfile__ObservationAssignment_3_1 )
            {
             before(grammarAccess.getAttackerProfileAccess().getObservationAssignment_3_1()); 
            // InternalSecDFD.g:2287:2: ( rule__AttackerProfile__ObservationAssignment_3_1 )
            // InternalSecDFD.g:2287:3: rule__AttackerProfile__ObservationAssignment_3_1
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
    // InternalSecDFD.g:2296:1: rule__Asset__Group__0 : rule__Asset__Group__0__Impl rule__Asset__Group__1 ;
    public final void rule__Asset__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2300:1: ( rule__Asset__Group__0__Impl rule__Asset__Group__1 )
            // InternalSecDFD.g:2301:2: rule__Asset__Group__0__Impl rule__Asset__Group__1
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
    // InternalSecDFD.g:2308:1: rule__Asset__Group__0__Impl : ( () ) ;
    public final void rule__Asset__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2312:1: ( ( () ) )
            // InternalSecDFD.g:2313:1: ( () )
            {
            // InternalSecDFD.g:2313:1: ( () )
            // InternalSecDFD.g:2314:2: ()
            {
             before(grammarAccess.getAssetAccess().getAssetAction_0()); 
            // InternalSecDFD.g:2315:2: ()
            // InternalSecDFD.g:2315:3: 
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
    // InternalSecDFD.g:2323:1: rule__Asset__Group__1 : rule__Asset__Group__1__Impl rule__Asset__Group__2 ;
    public final void rule__Asset__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2327:1: ( rule__Asset__Group__1__Impl rule__Asset__Group__2 )
            // InternalSecDFD.g:2328:2: rule__Asset__Group__1__Impl rule__Asset__Group__2
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
    // InternalSecDFD.g:2335:1: rule__Asset__Group__1__Impl : ( 'Asset' ) ;
    public final void rule__Asset__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2339:1: ( ( 'Asset' ) )
            // InternalSecDFD.g:2340:1: ( 'Asset' )
            {
            // InternalSecDFD.g:2340:1: ( 'Asset' )
            // InternalSecDFD.g:2341:2: 'Asset'
            {
             before(grammarAccess.getAssetAccess().getAssetKeyword_1()); 
            match(input,55,FOLLOW_2); 
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
    // InternalSecDFD.g:2350:1: rule__Asset__Group__2 : rule__Asset__Group__2__Impl rule__Asset__Group__3 ;
    public final void rule__Asset__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2354:1: ( rule__Asset__Group__2__Impl rule__Asset__Group__3 )
            // InternalSecDFD.g:2355:2: rule__Asset__Group__2__Impl rule__Asset__Group__3
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
    // InternalSecDFD.g:2362:1: rule__Asset__Group__2__Impl : ( ( rule__Asset__NameAssignment_2 ) ) ;
    public final void rule__Asset__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2366:1: ( ( ( rule__Asset__NameAssignment_2 ) ) )
            // InternalSecDFD.g:2367:1: ( ( rule__Asset__NameAssignment_2 ) )
            {
            // InternalSecDFD.g:2367:1: ( ( rule__Asset__NameAssignment_2 ) )
            // InternalSecDFD.g:2368:2: ( rule__Asset__NameAssignment_2 )
            {
             before(grammarAccess.getAssetAccess().getNameAssignment_2()); 
            // InternalSecDFD.g:2369:2: ( rule__Asset__NameAssignment_2 )
            // InternalSecDFD.g:2369:3: rule__Asset__NameAssignment_2
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
    // InternalSecDFD.g:2377:1: rule__Asset__Group__3 : rule__Asset__Group__3__Impl rule__Asset__Group__4 ;
    public final void rule__Asset__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2381:1: ( rule__Asset__Group__3__Impl rule__Asset__Group__4 )
            // InternalSecDFD.g:2382:2: rule__Asset__Group__3__Impl rule__Asset__Group__4
            {
            pushFollow(FOLLOW_17);
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
    // InternalSecDFD.g:2389:1: rule__Asset__Group__3__Impl : ( 'type:' ) ;
    public final void rule__Asset__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2393:1: ( ( 'type:' ) )
            // InternalSecDFD.g:2394:1: ( 'type:' )
            {
            // InternalSecDFD.g:2394:1: ( 'type:' )
            // InternalSecDFD.g:2395:2: 'type:'
            {
             before(grammarAccess.getAssetAccess().getTypeKeyword_3()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getTypeKeyword_3()); 

            }


            }

        }
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
    // InternalSecDFD.g:2404:1: rule__Asset__Group__4 : rule__Asset__Group__4__Impl rule__Asset__Group__5 ;
    public final void rule__Asset__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2408:1: ( rule__Asset__Group__4__Impl rule__Asset__Group__5 )
            // InternalSecDFD.g:2409:2: rule__Asset__Group__4__Impl rule__Asset__Group__5
            {
            pushFollow(FOLLOW_18);
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
    // InternalSecDFD.g:2416:1: rule__Asset__Group__4__Impl : ( ( rule__Asset__TypeAssignment_4 ) ) ;
    public final void rule__Asset__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2420:1: ( ( ( rule__Asset__TypeAssignment_4 ) ) )
            // InternalSecDFD.g:2421:1: ( ( rule__Asset__TypeAssignment_4 ) )
            {
            // InternalSecDFD.g:2421:1: ( ( rule__Asset__TypeAssignment_4 ) )
            // InternalSecDFD.g:2422:2: ( rule__Asset__TypeAssignment_4 )
            {
             before(grammarAccess.getAssetAccess().getTypeAssignment_4()); 
            // InternalSecDFD.g:2423:2: ( rule__Asset__TypeAssignment_4 )
            // InternalSecDFD.g:2423:3: rule__Asset__TypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Asset__TypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getTypeAssignment_4()); 

            }


            }

        }
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
    // InternalSecDFD.g:2431:1: rule__Asset__Group__5 : rule__Asset__Group__5__Impl rule__Asset__Group__6 ;
    public final void rule__Asset__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2435:1: ( rule__Asset__Group__5__Impl rule__Asset__Group__6 )
            // InternalSecDFD.g:2436:2: rule__Asset__Group__5__Impl rule__Asset__Group__6
            {
            pushFollow(FOLLOW_18);
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
    // InternalSecDFD.g:2443:1: rule__Asset__Group__5__Impl : ( ( rule__Asset__Group_5__0 )? ) ;
    public final void rule__Asset__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2447:1: ( ( ( rule__Asset__Group_5__0 )? ) )
            // InternalSecDFD.g:2448:1: ( ( rule__Asset__Group_5__0 )? )
            {
            // InternalSecDFD.g:2448:1: ( ( rule__Asset__Group_5__0 )? )
            // InternalSecDFD.g:2449:2: ( rule__Asset__Group_5__0 )?
            {
             before(grammarAccess.getAssetAccess().getGroup_5()); 
            // InternalSecDFD.g:2450:2: ( rule__Asset__Group_5__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==59) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalSecDFD.g:2450:3: rule__Asset__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Asset__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssetAccess().getGroup_5()); 

            }


            }

        }
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
    // InternalSecDFD.g:2458:1: rule__Asset__Group__6 : rule__Asset__Group__6__Impl rule__Asset__Group__7 ;
    public final void rule__Asset__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2462:1: ( rule__Asset__Group__6__Impl rule__Asset__Group__7 )
            // InternalSecDFD.g:2463:2: rule__Asset__Group__6__Impl rule__Asset__Group__7
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
    // InternalSecDFD.g:2470:1: rule__Asset__Group__6__Impl : ( 'source:' ) ;
    public final void rule__Asset__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2474:1: ( ( 'source:' ) )
            // InternalSecDFD.g:2475:1: ( 'source:' )
            {
            // InternalSecDFD.g:2475:1: ( 'source:' )
            // InternalSecDFD.g:2476:2: 'source:'
            {
             before(grammarAccess.getAssetAccess().getSourceKeyword_6()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getSourceKeyword_6()); 

            }


            }

        }
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
    // InternalSecDFD.g:2485:1: rule__Asset__Group__7 : rule__Asset__Group__7__Impl rule__Asset__Group__8 ;
    public final void rule__Asset__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2489:1: ( rule__Asset__Group__7__Impl rule__Asset__Group__8 )
            // InternalSecDFD.g:2490:2: rule__Asset__Group__7__Impl rule__Asset__Group__8
            {
            pushFollow(FOLLOW_19);
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
    // InternalSecDFD.g:2497:1: rule__Asset__Group__7__Impl : ( ( rule__Asset__SourceAssignment_7 ) ) ;
    public final void rule__Asset__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2501:1: ( ( ( rule__Asset__SourceAssignment_7 ) ) )
            // InternalSecDFD.g:2502:1: ( ( rule__Asset__SourceAssignment_7 ) )
            {
            // InternalSecDFD.g:2502:1: ( ( rule__Asset__SourceAssignment_7 ) )
            // InternalSecDFD.g:2503:2: ( rule__Asset__SourceAssignment_7 )
            {
             before(grammarAccess.getAssetAccess().getSourceAssignment_7()); 
            // InternalSecDFD.g:2504:2: ( rule__Asset__SourceAssignment_7 )
            // InternalSecDFD.g:2504:3: rule__Asset__SourceAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Asset__SourceAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getSourceAssignment_7()); 

            }


            }

        }
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
    // InternalSecDFD.g:2512:1: rule__Asset__Group__8 : rule__Asset__Group__8__Impl rule__Asset__Group__9 ;
    public final void rule__Asset__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2516:1: ( rule__Asset__Group__8__Impl rule__Asset__Group__9 )
            // InternalSecDFD.g:2517:2: rule__Asset__Group__8__Impl rule__Asset__Group__9
            {
            pushFollow(FOLLOW_4);
            rule__Asset__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__9();

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
    // InternalSecDFD.g:2524:1: rule__Asset__Group__8__Impl : ( 'targets:' ) ;
    public final void rule__Asset__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2528:1: ( ( 'targets:' ) )
            // InternalSecDFD.g:2529:1: ( 'targets:' )
            {
            // InternalSecDFD.g:2529:1: ( 'targets:' )
            // InternalSecDFD.g:2530:2: 'targets:'
            {
             before(grammarAccess.getAssetAccess().getTargetsKeyword_8()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getTargetsKeyword_8()); 

            }


            }

        }
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


    // $ANTLR start "rule__Asset__Group__9"
    // InternalSecDFD.g:2539:1: rule__Asset__Group__9 : rule__Asset__Group__9__Impl rule__Asset__Group__10 ;
    public final void rule__Asset__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2543:1: ( rule__Asset__Group__9__Impl rule__Asset__Group__10 )
            // InternalSecDFD.g:2544:2: rule__Asset__Group__9__Impl rule__Asset__Group__10
            {
            pushFollow(FOLLOW_8);
            rule__Asset__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group__10();

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
    // $ANTLR end "rule__Asset__Group__9"


    // $ANTLR start "rule__Asset__Group__9__Impl"
    // InternalSecDFD.g:2551:1: rule__Asset__Group__9__Impl : ( ( rule__Asset__TargetsAssignment_9 ) ) ;
    public final void rule__Asset__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2555:1: ( ( ( rule__Asset__TargetsAssignment_9 ) ) )
            // InternalSecDFD.g:2556:1: ( ( rule__Asset__TargetsAssignment_9 ) )
            {
            // InternalSecDFD.g:2556:1: ( ( rule__Asset__TargetsAssignment_9 ) )
            // InternalSecDFD.g:2557:2: ( rule__Asset__TargetsAssignment_9 )
            {
             before(grammarAccess.getAssetAccess().getTargetsAssignment_9()); 
            // InternalSecDFD.g:2558:2: ( rule__Asset__TargetsAssignment_9 )
            // InternalSecDFD.g:2558:3: rule__Asset__TargetsAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Asset__TargetsAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getTargetsAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__9__Impl"


    // $ANTLR start "rule__Asset__Group__10"
    // InternalSecDFD.g:2566:1: rule__Asset__Group__10 : rule__Asset__Group__10__Impl ;
    public final void rule__Asset__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2570:1: ( rule__Asset__Group__10__Impl )
            // InternalSecDFD.g:2571:2: rule__Asset__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Asset__Group__10__Impl();

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
    // $ANTLR end "rule__Asset__Group__10"


    // $ANTLR start "rule__Asset__Group__10__Impl"
    // InternalSecDFD.g:2577:1: rule__Asset__Group__10__Impl : ( ( rule__Asset__Group_10__0 )* ) ;
    public final void rule__Asset__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2581:1: ( ( ( rule__Asset__Group_10__0 )* ) )
            // InternalSecDFD.g:2582:1: ( ( rule__Asset__Group_10__0 )* )
            {
            // InternalSecDFD.g:2582:1: ( ( rule__Asset__Group_10__0 )* )
            // InternalSecDFD.g:2583:2: ( rule__Asset__Group_10__0 )*
            {
             before(grammarAccess.getAssetAccess().getGroup_10()); 
            // InternalSecDFD.g:2584:2: ( rule__Asset__Group_10__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==47) ) {
                    int LA24_2 = input.LA(2);

                    if ( ((LA24_2>=RULE_STRING && LA24_2<=RULE_ID)) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // InternalSecDFD.g:2584:3: rule__Asset__Group_10__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Asset__Group_10__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getAssetAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group__10__Impl"


    // $ANTLR start "rule__Asset__Group_5__0"
    // InternalSecDFD.g:2593:1: rule__Asset__Group_5__0 : rule__Asset__Group_5__0__Impl rule__Asset__Group_5__1 ;
    public final void rule__Asset__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2597:1: ( rule__Asset__Group_5__0__Impl rule__Asset__Group_5__1 )
            // InternalSecDFD.g:2598:2: rule__Asset__Group_5__0__Impl rule__Asset__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__Asset__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group_5__1();

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
    // $ANTLR end "rule__Asset__Group_5__0"


    // $ANTLR start "rule__Asset__Group_5__0__Impl"
    // InternalSecDFD.g:2605:1: rule__Asset__Group_5__0__Impl : ( 'values:' ) ;
    public final void rule__Asset__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2609:1: ( ( 'values:' ) )
            // InternalSecDFD.g:2610:1: ( 'values:' )
            {
            // InternalSecDFD.g:2610:1: ( 'values:' )
            // InternalSecDFD.g:2611:2: 'values:'
            {
             before(grammarAccess.getAssetAccess().getValuesKeyword_5_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getValuesKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_5__0__Impl"


    // $ANTLR start "rule__Asset__Group_5__1"
    // InternalSecDFD.g:2620:1: rule__Asset__Group_5__1 : rule__Asset__Group_5__1__Impl rule__Asset__Group_5__2 ;
    public final void rule__Asset__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2624:1: ( rule__Asset__Group_5__1__Impl rule__Asset__Group_5__2 )
            // InternalSecDFD.g:2625:2: rule__Asset__Group_5__1__Impl rule__Asset__Group_5__2
            {
            pushFollow(FOLLOW_8);
            rule__Asset__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group_5__2();

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
    // $ANTLR end "rule__Asset__Group_5__1"


    // $ANTLR start "rule__Asset__Group_5__1__Impl"
    // InternalSecDFD.g:2632:1: rule__Asset__Group_5__1__Impl : ( ( rule__Asset__ValueAssignment_5_1 ) ) ;
    public final void rule__Asset__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2636:1: ( ( ( rule__Asset__ValueAssignment_5_1 ) ) )
            // InternalSecDFD.g:2637:1: ( ( rule__Asset__ValueAssignment_5_1 ) )
            {
            // InternalSecDFD.g:2637:1: ( ( rule__Asset__ValueAssignment_5_1 ) )
            // InternalSecDFD.g:2638:2: ( rule__Asset__ValueAssignment_5_1 )
            {
             before(grammarAccess.getAssetAccess().getValueAssignment_5_1()); 
            // InternalSecDFD.g:2639:2: ( rule__Asset__ValueAssignment_5_1 )
            // InternalSecDFD.g:2639:3: rule__Asset__ValueAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Asset__ValueAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getValueAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_5__1__Impl"


    // $ANTLR start "rule__Asset__Group_5__2"
    // InternalSecDFD.g:2647:1: rule__Asset__Group_5__2 : rule__Asset__Group_5__2__Impl ;
    public final void rule__Asset__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2651:1: ( rule__Asset__Group_5__2__Impl )
            // InternalSecDFD.g:2652:2: rule__Asset__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Asset__Group_5__2__Impl();

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
    // $ANTLR end "rule__Asset__Group_5__2"


    // $ANTLR start "rule__Asset__Group_5__2__Impl"
    // InternalSecDFD.g:2658:1: rule__Asset__Group_5__2__Impl : ( ( rule__Asset__Group_5_2__0 )* ) ;
    public final void rule__Asset__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2662:1: ( ( ( rule__Asset__Group_5_2__0 )* ) )
            // InternalSecDFD.g:2663:1: ( ( rule__Asset__Group_5_2__0 )* )
            {
            // InternalSecDFD.g:2663:1: ( ( rule__Asset__Group_5_2__0 )* )
            // InternalSecDFD.g:2664:2: ( rule__Asset__Group_5_2__0 )*
            {
             before(grammarAccess.getAssetAccess().getGroup_5_2()); 
            // InternalSecDFD.g:2665:2: ( rule__Asset__Group_5_2__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==47) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSecDFD.g:2665:3: rule__Asset__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Asset__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getAssetAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_5__2__Impl"


    // $ANTLR start "rule__Asset__Group_5_2__0"
    // InternalSecDFD.g:2674:1: rule__Asset__Group_5_2__0 : rule__Asset__Group_5_2__0__Impl rule__Asset__Group_5_2__1 ;
    public final void rule__Asset__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2678:1: ( rule__Asset__Group_5_2__0__Impl rule__Asset__Group_5_2__1 )
            // InternalSecDFD.g:2679:2: rule__Asset__Group_5_2__0__Impl rule__Asset__Group_5_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Asset__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group_5_2__1();

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
    // $ANTLR end "rule__Asset__Group_5_2__0"


    // $ANTLR start "rule__Asset__Group_5_2__0__Impl"
    // InternalSecDFD.g:2686:1: rule__Asset__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__Asset__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2690:1: ( ( ',' ) )
            // InternalSecDFD.g:2691:1: ( ',' )
            {
            // InternalSecDFD.g:2691:1: ( ',' )
            // InternalSecDFD.g:2692:2: ','
            {
             before(grammarAccess.getAssetAccess().getCommaKeyword_5_2_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getCommaKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_5_2__0__Impl"


    // $ANTLR start "rule__Asset__Group_5_2__1"
    // InternalSecDFD.g:2701:1: rule__Asset__Group_5_2__1 : rule__Asset__Group_5_2__1__Impl ;
    public final void rule__Asset__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2705:1: ( rule__Asset__Group_5_2__1__Impl )
            // InternalSecDFD.g:2706:2: rule__Asset__Group_5_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Asset__Group_5_2__1__Impl();

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
    // $ANTLR end "rule__Asset__Group_5_2__1"


    // $ANTLR start "rule__Asset__Group_5_2__1__Impl"
    // InternalSecDFD.g:2712:1: rule__Asset__Group_5_2__1__Impl : ( ( rule__Asset__ValueAssignment_5_2_1 ) ) ;
    public final void rule__Asset__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2716:1: ( ( ( rule__Asset__ValueAssignment_5_2_1 ) ) )
            // InternalSecDFD.g:2717:1: ( ( rule__Asset__ValueAssignment_5_2_1 ) )
            {
            // InternalSecDFD.g:2717:1: ( ( rule__Asset__ValueAssignment_5_2_1 ) )
            // InternalSecDFD.g:2718:2: ( rule__Asset__ValueAssignment_5_2_1 )
            {
             before(grammarAccess.getAssetAccess().getValueAssignment_5_2_1()); 
            // InternalSecDFD.g:2719:2: ( rule__Asset__ValueAssignment_5_2_1 )
            // InternalSecDFD.g:2719:3: rule__Asset__ValueAssignment_5_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Asset__ValueAssignment_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getValueAssignment_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_5_2__1__Impl"


    // $ANTLR start "rule__Asset__Group_10__0"
    // InternalSecDFD.g:2728:1: rule__Asset__Group_10__0 : rule__Asset__Group_10__0__Impl rule__Asset__Group_10__1 ;
    public final void rule__Asset__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2732:1: ( rule__Asset__Group_10__0__Impl rule__Asset__Group_10__1 )
            // InternalSecDFD.g:2733:2: rule__Asset__Group_10__0__Impl rule__Asset__Group_10__1
            {
            pushFollow(FOLLOW_4);
            rule__Asset__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Asset__Group_10__1();

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
    // $ANTLR end "rule__Asset__Group_10__0"


    // $ANTLR start "rule__Asset__Group_10__0__Impl"
    // InternalSecDFD.g:2740:1: rule__Asset__Group_10__0__Impl : ( ',' ) ;
    public final void rule__Asset__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2744:1: ( ( ',' ) )
            // InternalSecDFD.g:2745:1: ( ',' )
            {
            // InternalSecDFD.g:2745:1: ( ',' )
            // InternalSecDFD.g:2746:2: ','
            {
             before(grammarAccess.getAssetAccess().getCommaKeyword_10_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getAssetAccess().getCommaKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_10__0__Impl"


    // $ANTLR start "rule__Asset__Group_10__1"
    // InternalSecDFD.g:2755:1: rule__Asset__Group_10__1 : rule__Asset__Group_10__1__Impl ;
    public final void rule__Asset__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2759:1: ( rule__Asset__Group_10__1__Impl )
            // InternalSecDFD.g:2760:2: rule__Asset__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Asset__Group_10__1__Impl();

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
    // $ANTLR end "rule__Asset__Group_10__1"


    // $ANTLR start "rule__Asset__Group_10__1__Impl"
    // InternalSecDFD.g:2766:1: rule__Asset__Group_10__1__Impl : ( ( rule__Asset__TargetsAssignment_10_1 ) ) ;
    public final void rule__Asset__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2770:1: ( ( ( rule__Asset__TargetsAssignment_10_1 ) ) )
            // InternalSecDFD.g:2771:1: ( ( rule__Asset__TargetsAssignment_10_1 ) )
            {
            // InternalSecDFD.g:2771:1: ( ( rule__Asset__TargetsAssignment_10_1 ) )
            // InternalSecDFD.g:2772:2: ( rule__Asset__TargetsAssignment_10_1 )
            {
             before(grammarAccess.getAssetAccess().getTargetsAssignment_10_1()); 
            // InternalSecDFD.g:2773:2: ( rule__Asset__TargetsAssignment_10_1 )
            // InternalSecDFD.g:2773:3: rule__Asset__TargetsAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Asset__TargetsAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getAssetAccess().getTargetsAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__Group_10__1__Impl"


    // $ANTLR start "rule__Process__Group__0"
    // InternalSecDFD.g:2782:1: rule__Process__Group__0 : rule__Process__Group__0__Impl rule__Process__Group__1 ;
    public final void rule__Process__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2786:1: ( rule__Process__Group__0__Impl rule__Process__Group__1 )
            // InternalSecDFD.g:2787:2: rule__Process__Group__0__Impl rule__Process__Group__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalSecDFD.g:2794:1: rule__Process__Group__0__Impl : ( () ) ;
    public final void rule__Process__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2798:1: ( ( () ) )
            // InternalSecDFD.g:2799:1: ( () )
            {
            // InternalSecDFD.g:2799:1: ( () )
            // InternalSecDFD.g:2800:2: ()
            {
             before(grammarAccess.getProcessAccess().getProcessAction_0()); 
            // InternalSecDFD.g:2801:2: ()
            // InternalSecDFD.g:2801:3: 
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
    // InternalSecDFD.g:2809:1: rule__Process__Group__1 : rule__Process__Group__1__Impl rule__Process__Group__2 ;
    public final void rule__Process__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2813:1: ( rule__Process__Group__1__Impl rule__Process__Group__2 )
            // InternalSecDFD.g:2814:2: rule__Process__Group__1__Impl rule__Process__Group__2
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
    // InternalSecDFD.g:2821:1: rule__Process__Group__1__Impl : ( 'Process' ) ;
    public final void rule__Process__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2825:1: ( ( 'Process' ) )
            // InternalSecDFD.g:2826:1: ( 'Process' )
            {
            // InternalSecDFD.g:2826:1: ( 'Process' )
            // InternalSecDFD.g:2827:2: 'Process'
            {
             before(grammarAccess.getProcessAccess().getProcessKeyword_1()); 
            match(input,60,FOLLOW_2); 
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
    // InternalSecDFD.g:2836:1: rule__Process__Group__2 : rule__Process__Group__2__Impl rule__Process__Group__3 ;
    public final void rule__Process__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2840:1: ( rule__Process__Group__2__Impl rule__Process__Group__3 )
            // InternalSecDFD.g:2841:2: rule__Process__Group__2__Impl rule__Process__Group__3
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
    // InternalSecDFD.g:2848:1: rule__Process__Group__2__Impl : ( ( rule__Process__NameAssignment_2 ) ) ;
    public final void rule__Process__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2852:1: ( ( ( rule__Process__NameAssignment_2 ) ) )
            // InternalSecDFD.g:2853:1: ( ( rule__Process__NameAssignment_2 ) )
            {
            // InternalSecDFD.g:2853:1: ( ( rule__Process__NameAssignment_2 ) )
            // InternalSecDFD.g:2854:2: ( rule__Process__NameAssignment_2 )
            {
             before(grammarAccess.getProcessAccess().getNameAssignment_2()); 
            // InternalSecDFD.g:2855:2: ( rule__Process__NameAssignment_2 )
            // InternalSecDFD.g:2855:3: rule__Process__NameAssignment_2
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
    // InternalSecDFD.g:2863:1: rule__Process__Group__3 : rule__Process__Group__3__Impl rule__Process__Group__4 ;
    public final void rule__Process__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2867:1: ( rule__Process__Group__3__Impl rule__Process__Group__4 )
            // InternalSecDFD.g:2868:2: rule__Process__Group__3__Impl rule__Process__Group__4
            {
            pushFollow(FOLLOW_21);
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
    // InternalSecDFD.g:2875:1: rule__Process__Group__3__Impl : ( '[' ) ;
    public final void rule__Process__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2879:1: ( ( '[' ) )
            // InternalSecDFD.g:2880:1: ( '[' )
            {
            // InternalSecDFD.g:2880:1: ( '[' )
            // InternalSecDFD.g:2881:2: '['
            {
             before(grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_3()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:2890:1: rule__Process__Group__4 : rule__Process__Group__4__Impl rule__Process__Group__5 ;
    public final void rule__Process__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2894:1: ( rule__Process__Group__4__Impl rule__Process__Group__5 )
            // InternalSecDFD.g:2895:2: rule__Process__Group__4__Impl rule__Process__Group__5
            {
            pushFollow(FOLLOW_21);
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
    // InternalSecDFD.g:2902:1: rule__Process__Group__4__Impl : ( ( rule__Process__Group_4__0 )? ) ;
    public final void rule__Process__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2906:1: ( ( ( rule__Process__Group_4__0 )? ) )
            // InternalSecDFD.g:2907:1: ( ( rule__Process__Group_4__0 )? )
            {
            // InternalSecDFD.g:2907:1: ( ( rule__Process__Group_4__0 )? )
            // InternalSecDFD.g:2908:2: ( rule__Process__Group_4__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_4()); 
            // InternalSecDFD.g:2909:2: ( rule__Process__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==61) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSecDFD.g:2909:3: rule__Process__Group_4__0
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
    // InternalSecDFD.g:2917:1: rule__Process__Group__5 : rule__Process__Group__5__Impl rule__Process__Group__6 ;
    public final void rule__Process__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2921:1: ( rule__Process__Group__5__Impl rule__Process__Group__6 )
            // InternalSecDFD.g:2922:2: rule__Process__Group__5__Impl rule__Process__Group__6
            {
            pushFollow(FOLLOW_21);
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
    // InternalSecDFD.g:2929:1: rule__Process__Group__5__Impl : ( ( rule__Process__Group_5__0 )? ) ;
    public final void rule__Process__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2933:1: ( ( ( rule__Process__Group_5__0 )? ) )
            // InternalSecDFD.g:2934:1: ( ( rule__Process__Group_5__0 )? )
            {
            // InternalSecDFD.g:2934:1: ( ( rule__Process__Group_5__0 )? )
            // InternalSecDFD.g:2935:2: ( rule__Process__Group_5__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_5()); 
            // InternalSecDFD.g:2936:2: ( rule__Process__Group_5__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==46) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSecDFD.g:2936:3: rule__Process__Group_5__0
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
    // InternalSecDFD.g:2944:1: rule__Process__Group__6 : rule__Process__Group__6__Impl rule__Process__Group__7 ;
    public final void rule__Process__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2948:1: ( rule__Process__Group__6__Impl rule__Process__Group__7 )
            // InternalSecDFD.g:2949:2: rule__Process__Group__6__Impl rule__Process__Group__7
            {
            pushFollow(FOLLOW_21);
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
    // InternalSecDFD.g:2956:1: rule__Process__Group__6__Impl : ( ( rule__Process__Group_6__0 )? ) ;
    public final void rule__Process__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2960:1: ( ( ( rule__Process__Group_6__0 )? ) )
            // InternalSecDFD.g:2961:1: ( ( rule__Process__Group_6__0 )? )
            {
            // InternalSecDFD.g:2961:1: ( ( rule__Process__Group_6__0 )? )
            // InternalSecDFD.g:2962:2: ( rule__Process__Group_6__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_6()); 
            // InternalSecDFD.g:2963:2: ( rule__Process__Group_6__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==62) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalSecDFD.g:2963:3: rule__Process__Group_6__0
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
    // InternalSecDFD.g:2971:1: rule__Process__Group__7 : rule__Process__Group__7__Impl rule__Process__Group__8 ;
    public final void rule__Process__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2975:1: ( rule__Process__Group__7__Impl rule__Process__Group__8 )
            // InternalSecDFD.g:2976:2: rule__Process__Group__7__Impl rule__Process__Group__8
            {
            pushFollow(FOLLOW_21);
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
    // InternalSecDFD.g:2983:1: rule__Process__Group__7__Impl : ( ( rule__Process__Group_7__0 )? ) ;
    public final void rule__Process__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:2987:1: ( ( ( rule__Process__Group_7__0 )? ) )
            // InternalSecDFD.g:2988:1: ( ( rule__Process__Group_7__0 )? )
            {
            // InternalSecDFD.g:2988:1: ( ( rule__Process__Group_7__0 )? )
            // InternalSecDFD.g:2989:2: ( rule__Process__Group_7__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_7()); 
            // InternalSecDFD.g:2990:2: ( rule__Process__Group_7__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==63) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalSecDFD.g:2990:3: rule__Process__Group_7__0
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
    // InternalSecDFD.g:2998:1: rule__Process__Group__8 : rule__Process__Group__8__Impl rule__Process__Group__9 ;
    public final void rule__Process__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3002:1: ( rule__Process__Group__8__Impl rule__Process__Group__9 )
            // InternalSecDFD.g:3003:2: rule__Process__Group__8__Impl rule__Process__Group__9
            {
            pushFollow(FOLLOW_21);
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
    // InternalSecDFD.g:3010:1: rule__Process__Group__8__Impl : ( ( rule__Process__Group_8__0 )? ) ;
    public final void rule__Process__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3014:1: ( ( ( rule__Process__Group_8__0 )? ) )
            // InternalSecDFD.g:3015:1: ( ( rule__Process__Group_8__0 )? )
            {
            // InternalSecDFD.g:3015:1: ( ( rule__Process__Group_8__0 )? )
            // InternalSecDFD.g:3016:2: ( rule__Process__Group_8__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_8()); 
            // InternalSecDFD.g:3017:2: ( rule__Process__Group_8__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==65) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalSecDFD.g:3017:3: rule__Process__Group_8__0
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
    // InternalSecDFD.g:3025:1: rule__Process__Group__9 : rule__Process__Group__9__Impl rule__Process__Group__10 ;
    public final void rule__Process__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3029:1: ( rule__Process__Group__9__Impl rule__Process__Group__10 )
            // InternalSecDFD.g:3030:2: rule__Process__Group__9__Impl rule__Process__Group__10
            {
            pushFollow(FOLLOW_21);
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
    // InternalSecDFD.g:3037:1: rule__Process__Group__9__Impl : ( ( rule__Process__Group_9__0 )? ) ;
    public final void rule__Process__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3041:1: ( ( ( rule__Process__Group_9__0 )? ) )
            // InternalSecDFD.g:3042:1: ( ( rule__Process__Group_9__0 )? )
            {
            // InternalSecDFD.g:3042:1: ( ( rule__Process__Group_9__0 )? )
            // InternalSecDFD.g:3043:2: ( rule__Process__Group_9__0 )?
            {
             before(grammarAccess.getProcessAccess().getGroup_9()); 
            // InternalSecDFD.g:3044:2: ( rule__Process__Group_9__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==66) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalSecDFD.g:3044:3: rule__Process__Group_9__0
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
    // InternalSecDFD.g:3052:1: rule__Process__Group__10 : rule__Process__Group__10__Impl ;
    public final void rule__Process__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3056:1: ( rule__Process__Group__10__Impl )
            // InternalSecDFD.g:3057:2: rule__Process__Group__10__Impl
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
    // InternalSecDFD.g:3063:1: rule__Process__Group__10__Impl : ( ']' ) ;
    public final void rule__Process__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3067:1: ( ( ']' ) )
            // InternalSecDFD.g:3068:1: ( ']' )
            {
            // InternalSecDFD.g:3068:1: ( ']' )
            // InternalSecDFD.g:3069:2: ']'
            {
             before(grammarAccess.getProcessAccess().getRightSquareBracketKeyword_10()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:3079:1: rule__Process__Group_4__0 : rule__Process__Group_4__0__Impl rule__Process__Group_4__1 ;
    public final void rule__Process__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3083:1: ( rule__Process__Group_4__0__Impl rule__Process__Group_4__1 )
            // InternalSecDFD.g:3084:2: rule__Process__Group_4__0__Impl rule__Process__Group_4__1
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
    // InternalSecDFD.g:3091:1: rule__Process__Group_4__0__Impl : ( 'responsibilities:' ) ;
    public final void rule__Process__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3095:1: ( ( 'responsibilities:' ) )
            // InternalSecDFD.g:3096:1: ( 'responsibilities:' )
            {
            // InternalSecDFD.g:3096:1: ( 'responsibilities:' )
            // InternalSecDFD.g:3097:2: 'responsibilities:'
            {
             before(grammarAccess.getProcessAccess().getResponsibilitiesKeyword_4_0()); 
            match(input,61,FOLLOW_2); 
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
    // InternalSecDFD.g:3106:1: rule__Process__Group_4__1 : rule__Process__Group_4__1__Impl rule__Process__Group_4__2 ;
    public final void rule__Process__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3110:1: ( rule__Process__Group_4__1__Impl rule__Process__Group_4__2 )
            // InternalSecDFD.g:3111:2: rule__Process__Group_4__1__Impl rule__Process__Group_4__2
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
    // InternalSecDFD.g:3118:1: rule__Process__Group_4__1__Impl : ( ( rule__Process__ResponsibilityAssignment_4_1 ) ) ;
    public final void rule__Process__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3122:1: ( ( ( rule__Process__ResponsibilityAssignment_4_1 ) ) )
            // InternalSecDFD.g:3123:1: ( ( rule__Process__ResponsibilityAssignment_4_1 ) )
            {
            // InternalSecDFD.g:3123:1: ( ( rule__Process__ResponsibilityAssignment_4_1 ) )
            // InternalSecDFD.g:3124:2: ( rule__Process__ResponsibilityAssignment_4_1 )
            {
             before(grammarAccess.getProcessAccess().getResponsibilityAssignment_4_1()); 
            // InternalSecDFD.g:3125:2: ( rule__Process__ResponsibilityAssignment_4_1 )
            // InternalSecDFD.g:3125:3: rule__Process__ResponsibilityAssignment_4_1
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
    // InternalSecDFD.g:3133:1: rule__Process__Group_4__2 : rule__Process__Group_4__2__Impl ;
    public final void rule__Process__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3137:1: ( rule__Process__Group_4__2__Impl )
            // InternalSecDFD.g:3138:2: rule__Process__Group_4__2__Impl
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
    // InternalSecDFD.g:3144:1: rule__Process__Group_4__2__Impl : ( ( rule__Process__Group_4_2__0 )* ) ;
    public final void rule__Process__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3148:1: ( ( ( rule__Process__Group_4_2__0 )* ) )
            // InternalSecDFD.g:3149:1: ( ( rule__Process__Group_4_2__0 )* )
            {
            // InternalSecDFD.g:3149:1: ( ( rule__Process__Group_4_2__0 )* )
            // InternalSecDFD.g:3150:2: ( rule__Process__Group_4_2__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_4_2()); 
            // InternalSecDFD.g:3151:2: ( rule__Process__Group_4_2__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==47) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalSecDFD.g:3151:3: rule__Process__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalSecDFD.g:3160:1: rule__Process__Group_4_2__0 : rule__Process__Group_4_2__0__Impl rule__Process__Group_4_2__1 ;
    public final void rule__Process__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3164:1: ( rule__Process__Group_4_2__0__Impl rule__Process__Group_4_2__1 )
            // InternalSecDFD.g:3165:2: rule__Process__Group_4_2__0__Impl rule__Process__Group_4_2__1
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
    // InternalSecDFD.g:3172:1: rule__Process__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3176:1: ( ( ',' ) )
            // InternalSecDFD.g:3177:1: ( ',' )
            {
            // InternalSecDFD.g:3177:1: ( ',' )
            // InternalSecDFD.g:3178:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_4_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:3187:1: rule__Process__Group_4_2__1 : rule__Process__Group_4_2__1__Impl ;
    public final void rule__Process__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3191:1: ( rule__Process__Group_4_2__1__Impl )
            // InternalSecDFD.g:3192:2: rule__Process__Group_4_2__1__Impl
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
    // InternalSecDFD.g:3198:1: rule__Process__Group_4_2__1__Impl : ( ( rule__Process__ResponsibilityAssignment_4_2_1 ) ) ;
    public final void rule__Process__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3202:1: ( ( ( rule__Process__ResponsibilityAssignment_4_2_1 ) ) )
            // InternalSecDFD.g:3203:1: ( ( rule__Process__ResponsibilityAssignment_4_2_1 ) )
            {
            // InternalSecDFD.g:3203:1: ( ( rule__Process__ResponsibilityAssignment_4_2_1 ) )
            // InternalSecDFD.g:3204:2: ( rule__Process__ResponsibilityAssignment_4_2_1 )
            {
             before(grammarAccess.getProcessAccess().getResponsibilityAssignment_4_2_1()); 
            // InternalSecDFD.g:3205:2: ( rule__Process__ResponsibilityAssignment_4_2_1 )
            // InternalSecDFD.g:3205:3: rule__Process__ResponsibilityAssignment_4_2_1
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
    // InternalSecDFD.g:3214:1: rule__Process__Group_5__0 : rule__Process__Group_5__0__Impl rule__Process__Group_5__1 ;
    public final void rule__Process__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3218:1: ( rule__Process__Group_5__0__Impl rule__Process__Group_5__1 )
            // InternalSecDFD.g:3219:2: rule__Process__Group_5__0__Impl rule__Process__Group_5__1
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
    // InternalSecDFD.g:3226:1: rule__Process__Group_5__0__Impl : ( 'assets:' ) ;
    public final void rule__Process__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3230:1: ( ( 'assets:' ) )
            // InternalSecDFD.g:3231:1: ( 'assets:' )
            {
            // InternalSecDFD.g:3231:1: ( 'assets:' )
            // InternalSecDFD.g:3232:2: 'assets:'
            {
             before(grammarAccess.getProcessAccess().getAssetsKeyword_5_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalSecDFD.g:3241:1: rule__Process__Group_5__1 : rule__Process__Group_5__1__Impl rule__Process__Group_5__2 ;
    public final void rule__Process__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3245:1: ( rule__Process__Group_5__1__Impl rule__Process__Group_5__2 )
            // InternalSecDFD.g:3246:2: rule__Process__Group_5__1__Impl rule__Process__Group_5__2
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
    // InternalSecDFD.g:3253:1: rule__Process__Group_5__1__Impl : ( ( rule__Process__AssetsAssignment_5_1 ) ) ;
    public final void rule__Process__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3257:1: ( ( ( rule__Process__AssetsAssignment_5_1 ) ) )
            // InternalSecDFD.g:3258:1: ( ( rule__Process__AssetsAssignment_5_1 ) )
            {
            // InternalSecDFD.g:3258:1: ( ( rule__Process__AssetsAssignment_5_1 ) )
            // InternalSecDFD.g:3259:2: ( rule__Process__AssetsAssignment_5_1 )
            {
             before(grammarAccess.getProcessAccess().getAssetsAssignment_5_1()); 
            // InternalSecDFD.g:3260:2: ( rule__Process__AssetsAssignment_5_1 )
            // InternalSecDFD.g:3260:3: rule__Process__AssetsAssignment_5_1
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
    // InternalSecDFD.g:3268:1: rule__Process__Group_5__2 : rule__Process__Group_5__2__Impl ;
    public final void rule__Process__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3272:1: ( rule__Process__Group_5__2__Impl )
            // InternalSecDFD.g:3273:2: rule__Process__Group_5__2__Impl
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
    // InternalSecDFD.g:3279:1: rule__Process__Group_5__2__Impl : ( ( rule__Process__Group_5_2__0 )* ) ;
    public final void rule__Process__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3283:1: ( ( ( rule__Process__Group_5_2__0 )* ) )
            // InternalSecDFD.g:3284:1: ( ( rule__Process__Group_5_2__0 )* )
            {
            // InternalSecDFD.g:3284:1: ( ( rule__Process__Group_5_2__0 )* )
            // InternalSecDFD.g:3285:2: ( rule__Process__Group_5_2__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_5_2()); 
            // InternalSecDFD.g:3286:2: ( rule__Process__Group_5_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==47) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalSecDFD.g:3286:3: rule__Process__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalSecDFD.g:3295:1: rule__Process__Group_5_2__0 : rule__Process__Group_5_2__0__Impl rule__Process__Group_5_2__1 ;
    public final void rule__Process__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3299:1: ( rule__Process__Group_5_2__0__Impl rule__Process__Group_5_2__1 )
            // InternalSecDFD.g:3300:2: rule__Process__Group_5_2__0__Impl rule__Process__Group_5_2__1
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
    // InternalSecDFD.g:3307:1: rule__Process__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3311:1: ( ( ',' ) )
            // InternalSecDFD.g:3312:1: ( ',' )
            {
            // InternalSecDFD.g:3312:1: ( ',' )
            // InternalSecDFD.g:3313:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_5_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:3322:1: rule__Process__Group_5_2__1 : rule__Process__Group_5_2__1__Impl ;
    public final void rule__Process__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3326:1: ( rule__Process__Group_5_2__1__Impl )
            // InternalSecDFD.g:3327:2: rule__Process__Group_5_2__1__Impl
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
    // InternalSecDFD.g:3333:1: rule__Process__Group_5_2__1__Impl : ( ( rule__Process__AssetsAssignment_5_2_1 ) ) ;
    public final void rule__Process__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3337:1: ( ( ( rule__Process__AssetsAssignment_5_2_1 ) ) )
            // InternalSecDFD.g:3338:1: ( ( rule__Process__AssetsAssignment_5_2_1 ) )
            {
            // InternalSecDFD.g:3338:1: ( ( rule__Process__AssetsAssignment_5_2_1 ) )
            // InternalSecDFD.g:3339:2: ( rule__Process__AssetsAssignment_5_2_1 )
            {
             before(grammarAccess.getProcessAccess().getAssetsAssignment_5_2_1()); 
            // InternalSecDFD.g:3340:2: ( rule__Process__AssetsAssignment_5_2_1 )
            // InternalSecDFD.g:3340:3: rule__Process__AssetsAssignment_5_2_1
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
    // InternalSecDFD.g:3349:1: rule__Process__Group_6__0 : rule__Process__Group_6__0__Impl rule__Process__Group_6__1 ;
    public final void rule__Process__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3353:1: ( rule__Process__Group_6__0__Impl rule__Process__Group_6__1 )
            // InternalSecDFD.g:3354:2: rule__Process__Group_6__0__Impl rule__Process__Group_6__1
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
    // InternalSecDFD.g:3361:1: rule__Process__Group_6__0__Impl : ( 'assumption:' ) ;
    public final void rule__Process__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3365:1: ( ( 'assumption:' ) )
            // InternalSecDFD.g:3366:1: ( 'assumption:' )
            {
            // InternalSecDFD.g:3366:1: ( 'assumption:' )
            // InternalSecDFD.g:3367:2: 'assumption:'
            {
             before(grammarAccess.getProcessAccess().getAssumptionKeyword_6_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalSecDFD.g:3376:1: rule__Process__Group_6__1 : rule__Process__Group_6__1__Impl rule__Process__Group_6__2 ;
    public final void rule__Process__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3380:1: ( rule__Process__Group_6__1__Impl rule__Process__Group_6__2 )
            // InternalSecDFD.g:3381:2: rule__Process__Group_6__1__Impl rule__Process__Group_6__2
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
    // InternalSecDFD.g:3388:1: rule__Process__Group_6__1__Impl : ( ( rule__Process__AssumptionAssignment_6_1 ) ) ;
    public final void rule__Process__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3392:1: ( ( ( rule__Process__AssumptionAssignment_6_1 ) ) )
            // InternalSecDFD.g:3393:1: ( ( rule__Process__AssumptionAssignment_6_1 ) )
            {
            // InternalSecDFD.g:3393:1: ( ( rule__Process__AssumptionAssignment_6_1 ) )
            // InternalSecDFD.g:3394:2: ( rule__Process__AssumptionAssignment_6_1 )
            {
             before(grammarAccess.getProcessAccess().getAssumptionAssignment_6_1()); 
            // InternalSecDFD.g:3395:2: ( rule__Process__AssumptionAssignment_6_1 )
            // InternalSecDFD.g:3395:3: rule__Process__AssumptionAssignment_6_1
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
    // InternalSecDFD.g:3403:1: rule__Process__Group_6__2 : rule__Process__Group_6__2__Impl ;
    public final void rule__Process__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3407:1: ( rule__Process__Group_6__2__Impl )
            // InternalSecDFD.g:3408:2: rule__Process__Group_6__2__Impl
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
    // InternalSecDFD.g:3414:1: rule__Process__Group_6__2__Impl : ( ( rule__Process__Group_6_2__0 )* ) ;
    public final void rule__Process__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3418:1: ( ( ( rule__Process__Group_6_2__0 )* ) )
            // InternalSecDFD.g:3419:1: ( ( rule__Process__Group_6_2__0 )* )
            {
            // InternalSecDFD.g:3419:1: ( ( rule__Process__Group_6_2__0 )* )
            // InternalSecDFD.g:3420:2: ( rule__Process__Group_6_2__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_6_2()); 
            // InternalSecDFD.g:3421:2: ( rule__Process__Group_6_2__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==47) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalSecDFD.g:3421:3: rule__Process__Group_6_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_6_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalSecDFD.g:3430:1: rule__Process__Group_6_2__0 : rule__Process__Group_6_2__0__Impl rule__Process__Group_6_2__1 ;
    public final void rule__Process__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3434:1: ( rule__Process__Group_6_2__0__Impl rule__Process__Group_6_2__1 )
            // InternalSecDFD.g:3435:2: rule__Process__Group_6_2__0__Impl rule__Process__Group_6_2__1
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
    // InternalSecDFD.g:3442:1: rule__Process__Group_6_2__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3446:1: ( ( ',' ) )
            // InternalSecDFD.g:3447:1: ( ',' )
            {
            // InternalSecDFD.g:3447:1: ( ',' )
            // InternalSecDFD.g:3448:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_6_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:3457:1: rule__Process__Group_6_2__1 : rule__Process__Group_6_2__1__Impl ;
    public final void rule__Process__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3461:1: ( rule__Process__Group_6_2__1__Impl )
            // InternalSecDFD.g:3462:2: rule__Process__Group_6_2__1__Impl
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
    // InternalSecDFD.g:3468:1: rule__Process__Group_6_2__1__Impl : ( ( rule__Process__AssumptionAssignment_6_2_1 ) ) ;
    public final void rule__Process__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3472:1: ( ( ( rule__Process__AssumptionAssignment_6_2_1 ) ) )
            // InternalSecDFD.g:3473:1: ( ( rule__Process__AssumptionAssignment_6_2_1 ) )
            {
            // InternalSecDFD.g:3473:1: ( ( rule__Process__AssumptionAssignment_6_2_1 ) )
            // InternalSecDFD.g:3474:2: ( rule__Process__AssumptionAssignment_6_2_1 )
            {
             before(grammarAccess.getProcessAccess().getAssumptionAssignment_6_2_1()); 
            // InternalSecDFD.g:3475:2: ( rule__Process__AssumptionAssignment_6_2_1 )
            // InternalSecDFD.g:3475:3: rule__Process__AssumptionAssignment_6_2_1
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
    // InternalSecDFD.g:3484:1: rule__Process__Group_7__0 : rule__Process__Group_7__0__Impl rule__Process__Group_7__1 ;
    public final void rule__Process__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3488:1: ( rule__Process__Group_7__0__Impl rule__Process__Group_7__1 )
            // InternalSecDFD.g:3489:2: rule__Process__Group_7__0__Impl rule__Process__Group_7__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalSecDFD.g:3496:1: rule__Process__Group_7__0__Impl : ( 'incoming' ) ;
    public final void rule__Process__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3500:1: ( ( 'incoming' ) )
            // InternalSecDFD.g:3501:1: ( 'incoming' )
            {
            // InternalSecDFD.g:3501:1: ( 'incoming' )
            // InternalSecDFD.g:3502:2: 'incoming'
            {
             before(grammarAccess.getProcessAccess().getIncomingKeyword_7_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalSecDFD.g:3511:1: rule__Process__Group_7__1 : rule__Process__Group_7__1__Impl rule__Process__Group_7__2 ;
    public final void rule__Process__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3515:1: ( rule__Process__Group_7__1__Impl rule__Process__Group_7__2 )
            // InternalSecDFD.g:3516:2: rule__Process__Group_7__1__Impl rule__Process__Group_7__2
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
    // InternalSecDFD.g:3523:1: rule__Process__Group_7__1__Impl : ( 'flows:' ) ;
    public final void rule__Process__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3527:1: ( ( 'flows:' ) )
            // InternalSecDFD.g:3528:1: ( 'flows:' )
            {
            // InternalSecDFD.g:3528:1: ( 'flows:' )
            // InternalSecDFD.g:3529:2: 'flows:'
            {
             before(grammarAccess.getProcessAccess().getFlowsKeyword_7_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalSecDFD.g:3538:1: rule__Process__Group_7__2 : rule__Process__Group_7__2__Impl rule__Process__Group_7__3 ;
    public final void rule__Process__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3542:1: ( rule__Process__Group_7__2__Impl rule__Process__Group_7__3 )
            // InternalSecDFD.g:3543:2: rule__Process__Group_7__2__Impl rule__Process__Group_7__3
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
    // InternalSecDFD.g:3550:1: rule__Process__Group_7__2__Impl : ( ( rule__Process__InflowsAssignment_7_2 ) ) ;
    public final void rule__Process__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3554:1: ( ( ( rule__Process__InflowsAssignment_7_2 ) ) )
            // InternalSecDFD.g:3555:1: ( ( rule__Process__InflowsAssignment_7_2 ) )
            {
            // InternalSecDFD.g:3555:1: ( ( rule__Process__InflowsAssignment_7_2 ) )
            // InternalSecDFD.g:3556:2: ( rule__Process__InflowsAssignment_7_2 )
            {
             before(grammarAccess.getProcessAccess().getInflowsAssignment_7_2()); 
            // InternalSecDFD.g:3557:2: ( rule__Process__InflowsAssignment_7_2 )
            // InternalSecDFD.g:3557:3: rule__Process__InflowsAssignment_7_2
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
    // InternalSecDFD.g:3565:1: rule__Process__Group_7__3 : rule__Process__Group_7__3__Impl ;
    public final void rule__Process__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3569:1: ( rule__Process__Group_7__3__Impl )
            // InternalSecDFD.g:3570:2: rule__Process__Group_7__3__Impl
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
    // InternalSecDFD.g:3576:1: rule__Process__Group_7__3__Impl : ( ( rule__Process__Group_7_3__0 )* ) ;
    public final void rule__Process__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3580:1: ( ( ( rule__Process__Group_7_3__0 )* ) )
            // InternalSecDFD.g:3581:1: ( ( rule__Process__Group_7_3__0 )* )
            {
            // InternalSecDFD.g:3581:1: ( ( rule__Process__Group_7_3__0 )* )
            // InternalSecDFD.g:3582:2: ( rule__Process__Group_7_3__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_7_3()); 
            // InternalSecDFD.g:3583:2: ( rule__Process__Group_7_3__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==47) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalSecDFD.g:3583:3: rule__Process__Group_7_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_7_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalSecDFD.g:3592:1: rule__Process__Group_7_3__0 : rule__Process__Group_7_3__0__Impl rule__Process__Group_7_3__1 ;
    public final void rule__Process__Group_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3596:1: ( rule__Process__Group_7_3__0__Impl rule__Process__Group_7_3__1 )
            // InternalSecDFD.g:3597:2: rule__Process__Group_7_3__0__Impl rule__Process__Group_7_3__1
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
    // InternalSecDFD.g:3604:1: rule__Process__Group_7_3__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3608:1: ( ( ',' ) )
            // InternalSecDFD.g:3609:1: ( ',' )
            {
            // InternalSecDFD.g:3609:1: ( ',' )
            // InternalSecDFD.g:3610:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_7_3_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:3619:1: rule__Process__Group_7_3__1 : rule__Process__Group_7_3__1__Impl ;
    public final void rule__Process__Group_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3623:1: ( rule__Process__Group_7_3__1__Impl )
            // InternalSecDFD.g:3624:2: rule__Process__Group_7_3__1__Impl
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
    // InternalSecDFD.g:3630:1: rule__Process__Group_7_3__1__Impl : ( ( rule__Process__InflowsAssignment_7_3_1 ) ) ;
    public final void rule__Process__Group_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3634:1: ( ( ( rule__Process__InflowsAssignment_7_3_1 ) ) )
            // InternalSecDFD.g:3635:1: ( ( rule__Process__InflowsAssignment_7_3_1 ) )
            {
            // InternalSecDFD.g:3635:1: ( ( rule__Process__InflowsAssignment_7_3_1 ) )
            // InternalSecDFD.g:3636:2: ( rule__Process__InflowsAssignment_7_3_1 )
            {
             before(grammarAccess.getProcessAccess().getInflowsAssignment_7_3_1()); 
            // InternalSecDFD.g:3637:2: ( rule__Process__InflowsAssignment_7_3_1 )
            // InternalSecDFD.g:3637:3: rule__Process__InflowsAssignment_7_3_1
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
    // InternalSecDFD.g:3646:1: rule__Process__Group_8__0 : rule__Process__Group_8__0__Impl rule__Process__Group_8__1 ;
    public final void rule__Process__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3650:1: ( rule__Process__Group_8__0__Impl rule__Process__Group_8__1 )
            // InternalSecDFD.g:3651:2: rule__Process__Group_8__0__Impl rule__Process__Group_8__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalSecDFD.g:3658:1: rule__Process__Group_8__0__Impl : ( 'outgoing' ) ;
    public final void rule__Process__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3662:1: ( ( 'outgoing' ) )
            // InternalSecDFD.g:3663:1: ( 'outgoing' )
            {
            // InternalSecDFD.g:3663:1: ( 'outgoing' )
            // InternalSecDFD.g:3664:2: 'outgoing'
            {
             before(grammarAccess.getProcessAccess().getOutgoingKeyword_8_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalSecDFD.g:3673:1: rule__Process__Group_8__1 : rule__Process__Group_8__1__Impl rule__Process__Group_8__2 ;
    public final void rule__Process__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3677:1: ( rule__Process__Group_8__1__Impl rule__Process__Group_8__2 )
            // InternalSecDFD.g:3678:2: rule__Process__Group_8__1__Impl rule__Process__Group_8__2
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
    // InternalSecDFD.g:3685:1: rule__Process__Group_8__1__Impl : ( 'flows:' ) ;
    public final void rule__Process__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3689:1: ( ( 'flows:' ) )
            // InternalSecDFD.g:3690:1: ( 'flows:' )
            {
            // InternalSecDFD.g:3690:1: ( 'flows:' )
            // InternalSecDFD.g:3691:2: 'flows:'
            {
             before(grammarAccess.getProcessAccess().getFlowsKeyword_8_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalSecDFD.g:3700:1: rule__Process__Group_8__2 : rule__Process__Group_8__2__Impl rule__Process__Group_8__3 ;
    public final void rule__Process__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3704:1: ( rule__Process__Group_8__2__Impl rule__Process__Group_8__3 )
            // InternalSecDFD.g:3705:2: rule__Process__Group_8__2__Impl rule__Process__Group_8__3
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
    // InternalSecDFD.g:3712:1: rule__Process__Group_8__2__Impl : ( ( rule__Process__OutflowsAssignment_8_2 ) ) ;
    public final void rule__Process__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3716:1: ( ( ( rule__Process__OutflowsAssignment_8_2 ) ) )
            // InternalSecDFD.g:3717:1: ( ( rule__Process__OutflowsAssignment_8_2 ) )
            {
            // InternalSecDFD.g:3717:1: ( ( rule__Process__OutflowsAssignment_8_2 ) )
            // InternalSecDFD.g:3718:2: ( rule__Process__OutflowsAssignment_8_2 )
            {
             before(grammarAccess.getProcessAccess().getOutflowsAssignment_8_2()); 
            // InternalSecDFD.g:3719:2: ( rule__Process__OutflowsAssignment_8_2 )
            // InternalSecDFD.g:3719:3: rule__Process__OutflowsAssignment_8_2
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
    // InternalSecDFD.g:3727:1: rule__Process__Group_8__3 : rule__Process__Group_8__3__Impl ;
    public final void rule__Process__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3731:1: ( rule__Process__Group_8__3__Impl )
            // InternalSecDFD.g:3732:2: rule__Process__Group_8__3__Impl
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
    // InternalSecDFD.g:3738:1: rule__Process__Group_8__3__Impl : ( ( rule__Process__Group_8_3__0 )* ) ;
    public final void rule__Process__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3742:1: ( ( ( rule__Process__Group_8_3__0 )* ) )
            // InternalSecDFD.g:3743:1: ( ( rule__Process__Group_8_3__0 )* )
            {
            // InternalSecDFD.g:3743:1: ( ( rule__Process__Group_8_3__0 )* )
            // InternalSecDFD.g:3744:2: ( rule__Process__Group_8_3__0 )*
            {
             before(grammarAccess.getProcessAccess().getGroup_8_3()); 
            // InternalSecDFD.g:3745:2: ( rule__Process__Group_8_3__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==47) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalSecDFD.g:3745:3: rule__Process__Group_8_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Process__Group_8_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalSecDFD.g:3754:1: rule__Process__Group_8_3__0 : rule__Process__Group_8_3__0__Impl rule__Process__Group_8_3__1 ;
    public final void rule__Process__Group_8_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3758:1: ( rule__Process__Group_8_3__0__Impl rule__Process__Group_8_3__1 )
            // InternalSecDFD.g:3759:2: rule__Process__Group_8_3__0__Impl rule__Process__Group_8_3__1
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
    // InternalSecDFD.g:3766:1: rule__Process__Group_8_3__0__Impl : ( ',' ) ;
    public final void rule__Process__Group_8_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3770:1: ( ( ',' ) )
            // InternalSecDFD.g:3771:1: ( ',' )
            {
            // InternalSecDFD.g:3771:1: ( ',' )
            // InternalSecDFD.g:3772:2: ','
            {
             before(grammarAccess.getProcessAccess().getCommaKeyword_8_3_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:3781:1: rule__Process__Group_8_3__1 : rule__Process__Group_8_3__1__Impl ;
    public final void rule__Process__Group_8_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3785:1: ( rule__Process__Group_8_3__1__Impl )
            // InternalSecDFD.g:3786:2: rule__Process__Group_8_3__1__Impl
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
    // InternalSecDFD.g:3792:1: rule__Process__Group_8_3__1__Impl : ( ( rule__Process__OutflowsAssignment_8_3_1 ) ) ;
    public final void rule__Process__Group_8_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3796:1: ( ( ( rule__Process__OutflowsAssignment_8_3_1 ) ) )
            // InternalSecDFD.g:3797:1: ( ( rule__Process__OutflowsAssignment_8_3_1 ) )
            {
            // InternalSecDFD.g:3797:1: ( ( rule__Process__OutflowsAssignment_8_3_1 ) )
            // InternalSecDFD.g:3798:2: ( rule__Process__OutflowsAssignment_8_3_1 )
            {
             before(grammarAccess.getProcessAccess().getOutflowsAssignment_8_3_1()); 
            // InternalSecDFD.g:3799:2: ( rule__Process__OutflowsAssignment_8_3_1 )
            // InternalSecDFD.g:3799:3: rule__Process__OutflowsAssignment_8_3_1
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
    // InternalSecDFD.g:3808:1: rule__Process__Group_9__0 : rule__Process__Group_9__0__Impl rule__Process__Group_9__1 ;
    public final void rule__Process__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3812:1: ( rule__Process__Group_9__0__Impl rule__Process__Group_9__1 )
            // InternalSecDFD.g:3813:2: rule__Process__Group_9__0__Impl rule__Process__Group_9__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalSecDFD.g:3820:1: rule__Process__Group_9__0__Impl : ( 'attacker:' ) ;
    public final void rule__Process__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3824:1: ( ( 'attacker:' ) )
            // InternalSecDFD.g:3825:1: ( 'attacker:' )
            {
            // InternalSecDFD.g:3825:1: ( 'attacker:' )
            // InternalSecDFD.g:3826:2: 'attacker:'
            {
             before(grammarAccess.getProcessAccess().getAttackerKeyword_9_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalSecDFD.g:3835:1: rule__Process__Group_9__1 : rule__Process__Group_9__1__Impl ;
    public final void rule__Process__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3839:1: ( rule__Process__Group_9__1__Impl )
            // InternalSecDFD.g:3840:2: rule__Process__Group_9__1__Impl
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
    // InternalSecDFD.g:3846:1: rule__Process__Group_9__1__Impl : ( ( rule__Process__AttackerAssignment_9_1 ) ) ;
    public final void rule__Process__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3850:1: ( ( ( rule__Process__AttackerAssignment_9_1 ) ) )
            // InternalSecDFD.g:3851:1: ( ( rule__Process__AttackerAssignment_9_1 ) )
            {
            // InternalSecDFD.g:3851:1: ( ( rule__Process__AttackerAssignment_9_1 ) )
            // InternalSecDFD.g:3852:2: ( rule__Process__AttackerAssignment_9_1 )
            {
             before(grammarAccess.getProcessAccess().getAttackerAssignment_9_1()); 
            // InternalSecDFD.g:3853:2: ( rule__Process__AttackerAssignment_9_1 )
            // InternalSecDFD.g:3853:3: rule__Process__AttackerAssignment_9_1
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
    // InternalSecDFD.g:3862:1: rule__Responsibility__Group__0 : rule__Responsibility__Group__0__Impl rule__Responsibility__Group__1 ;
    public final void rule__Responsibility__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3866:1: ( rule__Responsibility__Group__0__Impl rule__Responsibility__Group__1 )
            // InternalSecDFD.g:3867:2: rule__Responsibility__Group__0__Impl rule__Responsibility__Group__1
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
    // InternalSecDFD.g:3874:1: rule__Responsibility__Group__0__Impl : ( () ) ;
    public final void rule__Responsibility__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3878:1: ( ( () ) )
            // InternalSecDFD.g:3879:1: ( () )
            {
            // InternalSecDFD.g:3879:1: ( () )
            // InternalSecDFD.g:3880:2: ()
            {
             before(grammarAccess.getResponsibilityAccess().getResponsibilityAction_0()); 
            // InternalSecDFD.g:3881:2: ()
            // InternalSecDFD.g:3881:3: 
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
    // InternalSecDFD.g:3889:1: rule__Responsibility__Group__1 : rule__Responsibility__Group__1__Impl rule__Responsibility__Group__2 ;
    public final void rule__Responsibility__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3893:1: ( rule__Responsibility__Group__1__Impl rule__Responsibility__Group__2 )
            // InternalSecDFD.g:3894:2: rule__Responsibility__Group__1__Impl rule__Responsibility__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalSecDFD.g:3901:1: rule__Responsibility__Group__1__Impl : ( '[' ) ;
    public final void rule__Responsibility__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3905:1: ( ( '[' ) )
            // InternalSecDFD.g:3906:1: ( '[' )
            {
            // InternalSecDFD.g:3906:1: ( '[' )
            // InternalSecDFD.g:3907:2: '['
            {
             before(grammarAccess.getResponsibilityAccess().getLeftSquareBracketKeyword_1()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:3916:1: rule__Responsibility__Group__2 : rule__Responsibility__Group__2__Impl rule__Responsibility__Group__3 ;
    public final void rule__Responsibility__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3920:1: ( rule__Responsibility__Group__2__Impl rule__Responsibility__Group__3 )
            // InternalSecDFD.g:3921:2: rule__Responsibility__Group__2__Impl rule__Responsibility__Group__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalSecDFD.g:3928:1: rule__Responsibility__Group__2__Impl : ( ( rule__Responsibility__Group_2__0 )? ) ;
    public final void rule__Responsibility__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3932:1: ( ( ( rule__Responsibility__Group_2__0 )? ) )
            // InternalSecDFD.g:3933:1: ( ( rule__Responsibility__Group_2__0 )? )
            {
            // InternalSecDFD.g:3933:1: ( ( rule__Responsibility__Group_2__0 )? )
            // InternalSecDFD.g:3934:2: ( rule__Responsibility__Group_2__0 )?
            {
             before(grammarAccess.getResponsibilityAccess().getGroup_2()); 
            // InternalSecDFD.g:3935:2: ( rule__Responsibility__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_STRING && LA37_0<=RULE_ID)||(LA37_0>=23 && LA37_0<=35)||LA37_0==47) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalSecDFD.g:3935:3: rule__Responsibility__Group_2__0
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
    // InternalSecDFD.g:3943:1: rule__Responsibility__Group__3 : rule__Responsibility__Group__3__Impl ;
    public final void rule__Responsibility__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3947:1: ( rule__Responsibility__Group__3__Impl )
            // InternalSecDFD.g:3948:2: rule__Responsibility__Group__3__Impl
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
    // InternalSecDFD.g:3954:1: rule__Responsibility__Group__3__Impl : ( ']' ) ;
    public final void rule__Responsibility__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3958:1: ( ( ']' ) )
            // InternalSecDFD.g:3959:1: ( ']' )
            {
            // InternalSecDFD.g:3959:1: ( ']' )
            // InternalSecDFD.g:3960:2: ']'
            {
             before(grammarAccess.getResponsibilityAccess().getRightSquareBracketKeyword_3()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:3970:1: rule__Responsibility__Group_2__0 : rule__Responsibility__Group_2__0__Impl rule__Responsibility__Group_2__1 ;
    public final void rule__Responsibility__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3974:1: ( rule__Responsibility__Group_2__0__Impl rule__Responsibility__Group_2__1 )
            // InternalSecDFD.g:3975:2: rule__Responsibility__Group_2__0__Impl rule__Responsibility__Group_2__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalSecDFD.g:3982:1: rule__Responsibility__Group_2__0__Impl : ( ( rule__Responsibility__IncomeassetsAssignment_2_0 )? ) ;
    public final void rule__Responsibility__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:3986:1: ( ( ( rule__Responsibility__IncomeassetsAssignment_2_0 )? ) )
            // InternalSecDFD.g:3987:1: ( ( rule__Responsibility__IncomeassetsAssignment_2_0 )? )
            {
            // InternalSecDFD.g:3987:1: ( ( rule__Responsibility__IncomeassetsAssignment_2_0 )? )
            // InternalSecDFD.g:3988:2: ( rule__Responsibility__IncomeassetsAssignment_2_0 )?
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssignment_2_0()); 
            // InternalSecDFD.g:3989:2: ( rule__Responsibility__IncomeassetsAssignment_2_0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_ID)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalSecDFD.g:3989:3: rule__Responsibility__IncomeassetsAssignment_2_0
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
    // InternalSecDFD.g:3997:1: rule__Responsibility__Group_2__1 : rule__Responsibility__Group_2__1__Impl rule__Responsibility__Group_2__2 ;
    public final void rule__Responsibility__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4001:1: ( rule__Responsibility__Group_2__1__Impl rule__Responsibility__Group_2__2 )
            // InternalSecDFD.g:4002:2: rule__Responsibility__Group_2__1__Impl rule__Responsibility__Group_2__2
            {
            pushFollow(FOLLOW_25);
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
    // InternalSecDFD.g:4009:1: rule__Responsibility__Group_2__1__Impl : ( ( rule__Responsibility__Group_2_1__0 )* ) ;
    public final void rule__Responsibility__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4013:1: ( ( ( rule__Responsibility__Group_2_1__0 )* ) )
            // InternalSecDFD.g:4014:1: ( ( rule__Responsibility__Group_2_1__0 )* )
            {
            // InternalSecDFD.g:4014:1: ( ( rule__Responsibility__Group_2_1__0 )* )
            // InternalSecDFD.g:4015:2: ( rule__Responsibility__Group_2_1__0 )*
            {
             before(grammarAccess.getResponsibilityAccess().getGroup_2_1()); 
            // InternalSecDFD.g:4016:2: ( rule__Responsibility__Group_2_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==47) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalSecDFD.g:4016:3: rule__Responsibility__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Responsibility__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalSecDFD.g:4024:1: rule__Responsibility__Group_2__2 : rule__Responsibility__Group_2__2__Impl rule__Responsibility__Group_2__3 ;
    public final void rule__Responsibility__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4028:1: ( rule__Responsibility__Group_2__2__Impl rule__Responsibility__Group_2__3 )
            // InternalSecDFD.g:4029:2: rule__Responsibility__Group_2__2__Impl rule__Responsibility__Group_2__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalSecDFD.g:4036:1: rule__Responsibility__Group_2__2__Impl : ( ( rule__Responsibility__ActionAssignment_2_2 ) ) ;
    public final void rule__Responsibility__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4040:1: ( ( ( rule__Responsibility__ActionAssignment_2_2 ) ) )
            // InternalSecDFD.g:4041:1: ( ( rule__Responsibility__ActionAssignment_2_2 ) )
            {
            // InternalSecDFD.g:4041:1: ( ( rule__Responsibility__ActionAssignment_2_2 ) )
            // InternalSecDFD.g:4042:2: ( rule__Responsibility__ActionAssignment_2_2 )
            {
             before(grammarAccess.getResponsibilityAccess().getActionAssignment_2_2()); 
            // InternalSecDFD.g:4043:2: ( rule__Responsibility__ActionAssignment_2_2 )
            // InternalSecDFD.g:4043:3: rule__Responsibility__ActionAssignment_2_2
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
    // InternalSecDFD.g:4051:1: rule__Responsibility__Group_2__3 : rule__Responsibility__Group_2__3__Impl rule__Responsibility__Group_2__4 ;
    public final void rule__Responsibility__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4055:1: ( rule__Responsibility__Group_2__3__Impl rule__Responsibility__Group_2__4 )
            // InternalSecDFD.g:4056:2: rule__Responsibility__Group_2__3__Impl rule__Responsibility__Group_2__4
            {
            pushFollow(FOLLOW_27);
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
    // InternalSecDFD.g:4063:1: rule__Responsibility__Group_2__3__Impl : ( '::' ) ;
    public final void rule__Responsibility__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4067:1: ( ( '::' ) )
            // InternalSecDFD.g:4068:1: ( '::' )
            {
            // InternalSecDFD.g:4068:1: ( '::' )
            // InternalSecDFD.g:4069:2: '::'
            {
             before(grammarAccess.getResponsibilityAccess().getColonColonKeyword_2_3()); 
            match(input,67,FOLLOW_2); 
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
    // InternalSecDFD.g:4078:1: rule__Responsibility__Group_2__4 : rule__Responsibility__Group_2__4__Impl rule__Responsibility__Group_2__5 ;
    public final void rule__Responsibility__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4082:1: ( rule__Responsibility__Group_2__4__Impl rule__Responsibility__Group_2__5 )
            // InternalSecDFD.g:4083:2: rule__Responsibility__Group_2__4__Impl rule__Responsibility__Group_2__5
            {
            pushFollow(FOLLOW_27);
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
    // InternalSecDFD.g:4090:1: rule__Responsibility__Group_2__4__Impl : ( ( rule__Responsibility__OutcomeassetsAssignment_2_4 )? ) ;
    public final void rule__Responsibility__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4094:1: ( ( ( rule__Responsibility__OutcomeassetsAssignment_2_4 )? ) )
            // InternalSecDFD.g:4095:1: ( ( rule__Responsibility__OutcomeassetsAssignment_2_4 )? )
            {
            // InternalSecDFD.g:4095:1: ( ( rule__Responsibility__OutcomeassetsAssignment_2_4 )? )
            // InternalSecDFD.g:4096:2: ( rule__Responsibility__OutcomeassetsAssignment_2_4 )?
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssignment_2_4()); 
            // InternalSecDFD.g:4097:2: ( rule__Responsibility__OutcomeassetsAssignment_2_4 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalSecDFD.g:4097:3: rule__Responsibility__OutcomeassetsAssignment_2_4
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
    // InternalSecDFD.g:4105:1: rule__Responsibility__Group_2__5 : rule__Responsibility__Group_2__5__Impl ;
    public final void rule__Responsibility__Group_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4109:1: ( rule__Responsibility__Group_2__5__Impl )
            // InternalSecDFD.g:4110:2: rule__Responsibility__Group_2__5__Impl
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
    // InternalSecDFD.g:4116:1: rule__Responsibility__Group_2__5__Impl : ( ( rule__Responsibility__Group_2_5__0 )* ) ;
    public final void rule__Responsibility__Group_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4120:1: ( ( ( rule__Responsibility__Group_2_5__0 )* ) )
            // InternalSecDFD.g:4121:1: ( ( rule__Responsibility__Group_2_5__0 )* )
            {
            // InternalSecDFD.g:4121:1: ( ( rule__Responsibility__Group_2_5__0 )* )
            // InternalSecDFD.g:4122:2: ( rule__Responsibility__Group_2_5__0 )*
            {
             before(grammarAccess.getResponsibilityAccess().getGroup_2_5()); 
            // InternalSecDFD.g:4123:2: ( rule__Responsibility__Group_2_5__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==47) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalSecDFD.g:4123:3: rule__Responsibility__Group_2_5__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Responsibility__Group_2_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalSecDFD.g:4132:1: rule__Responsibility__Group_2_1__0 : rule__Responsibility__Group_2_1__0__Impl rule__Responsibility__Group_2_1__1 ;
    public final void rule__Responsibility__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4136:1: ( rule__Responsibility__Group_2_1__0__Impl rule__Responsibility__Group_2_1__1 )
            // InternalSecDFD.g:4137:2: rule__Responsibility__Group_2_1__0__Impl rule__Responsibility__Group_2_1__1
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
    // InternalSecDFD.g:4144:1: rule__Responsibility__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__Responsibility__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4148:1: ( ( ',' ) )
            // InternalSecDFD.g:4149:1: ( ',' )
            {
            // InternalSecDFD.g:4149:1: ( ',' )
            // InternalSecDFD.g:4150:2: ','
            {
             before(grammarAccess.getResponsibilityAccess().getCommaKeyword_2_1_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:4159:1: rule__Responsibility__Group_2_1__1 : rule__Responsibility__Group_2_1__1__Impl ;
    public final void rule__Responsibility__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4163:1: ( rule__Responsibility__Group_2_1__1__Impl )
            // InternalSecDFD.g:4164:2: rule__Responsibility__Group_2_1__1__Impl
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
    // InternalSecDFD.g:4170:1: rule__Responsibility__Group_2_1__1__Impl : ( ( rule__Responsibility__IncomeassetsAssignment_2_1_1 ) ) ;
    public final void rule__Responsibility__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4174:1: ( ( ( rule__Responsibility__IncomeassetsAssignment_2_1_1 ) ) )
            // InternalSecDFD.g:4175:1: ( ( rule__Responsibility__IncomeassetsAssignment_2_1_1 ) )
            {
            // InternalSecDFD.g:4175:1: ( ( rule__Responsibility__IncomeassetsAssignment_2_1_1 ) )
            // InternalSecDFD.g:4176:2: ( rule__Responsibility__IncomeassetsAssignment_2_1_1 )
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssignment_2_1_1()); 
            // InternalSecDFD.g:4177:2: ( rule__Responsibility__IncomeassetsAssignment_2_1_1 )
            // InternalSecDFD.g:4177:3: rule__Responsibility__IncomeassetsAssignment_2_1_1
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
    // InternalSecDFD.g:4186:1: rule__Responsibility__Group_2_5__0 : rule__Responsibility__Group_2_5__0__Impl rule__Responsibility__Group_2_5__1 ;
    public final void rule__Responsibility__Group_2_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4190:1: ( rule__Responsibility__Group_2_5__0__Impl rule__Responsibility__Group_2_5__1 )
            // InternalSecDFD.g:4191:2: rule__Responsibility__Group_2_5__0__Impl rule__Responsibility__Group_2_5__1
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
    // InternalSecDFD.g:4198:1: rule__Responsibility__Group_2_5__0__Impl : ( ',' ) ;
    public final void rule__Responsibility__Group_2_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4202:1: ( ( ',' ) )
            // InternalSecDFD.g:4203:1: ( ',' )
            {
            // InternalSecDFD.g:4203:1: ( ',' )
            // InternalSecDFD.g:4204:2: ','
            {
             before(grammarAccess.getResponsibilityAccess().getCommaKeyword_2_5_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:4213:1: rule__Responsibility__Group_2_5__1 : rule__Responsibility__Group_2_5__1__Impl ;
    public final void rule__Responsibility__Group_2_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4217:1: ( rule__Responsibility__Group_2_5__1__Impl )
            // InternalSecDFD.g:4218:2: rule__Responsibility__Group_2_5__1__Impl
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
    // InternalSecDFD.g:4224:1: rule__Responsibility__Group_2_5__1__Impl : ( ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 ) ) ;
    public final void rule__Responsibility__Group_2_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4228:1: ( ( ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 ) ) )
            // InternalSecDFD.g:4229:1: ( ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 ) )
            {
            // InternalSecDFD.g:4229:1: ( ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 ) )
            // InternalSecDFD.g:4230:2: ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 )
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssignment_2_5_1()); 
            // InternalSecDFD.g:4231:2: ( rule__Responsibility__OutcomeassetsAssignment_2_5_1 )
            // InternalSecDFD.g:4231:3: rule__Responsibility__OutcomeassetsAssignment_2_5_1
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
    // InternalSecDFD.g:4240:1: rule__ExternalEntity__Group__0 : rule__ExternalEntity__Group__0__Impl rule__ExternalEntity__Group__1 ;
    public final void rule__ExternalEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4244:1: ( rule__ExternalEntity__Group__0__Impl rule__ExternalEntity__Group__1 )
            // InternalSecDFD.g:4245:2: rule__ExternalEntity__Group__0__Impl rule__ExternalEntity__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalSecDFD.g:4252:1: rule__ExternalEntity__Group__0__Impl : ( () ) ;
    public final void rule__ExternalEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4256:1: ( ( () ) )
            // InternalSecDFD.g:4257:1: ( () )
            {
            // InternalSecDFD.g:4257:1: ( () )
            // InternalSecDFD.g:4258:2: ()
            {
             before(grammarAccess.getExternalEntityAccess().getExternalEntityAction_0()); 
            // InternalSecDFD.g:4259:2: ()
            // InternalSecDFD.g:4259:3: 
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
    // InternalSecDFD.g:4267:1: rule__ExternalEntity__Group__1 : rule__ExternalEntity__Group__1__Impl rule__ExternalEntity__Group__2 ;
    public final void rule__ExternalEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4271:1: ( rule__ExternalEntity__Group__1__Impl rule__ExternalEntity__Group__2 )
            // InternalSecDFD.g:4272:2: rule__ExternalEntity__Group__1__Impl rule__ExternalEntity__Group__2
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
    // InternalSecDFD.g:4279:1: rule__ExternalEntity__Group__1__Impl : ( 'ExternalEntity' ) ;
    public final void rule__ExternalEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4283:1: ( ( 'ExternalEntity' ) )
            // InternalSecDFD.g:4284:1: ( 'ExternalEntity' )
            {
            // InternalSecDFD.g:4284:1: ( 'ExternalEntity' )
            // InternalSecDFD.g:4285:2: 'ExternalEntity'
            {
             before(grammarAccess.getExternalEntityAccess().getExternalEntityKeyword_1()); 
            match(input,68,FOLLOW_2); 
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
    // InternalSecDFD.g:4294:1: rule__ExternalEntity__Group__2 : rule__ExternalEntity__Group__2__Impl rule__ExternalEntity__Group__3 ;
    public final void rule__ExternalEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4298:1: ( rule__ExternalEntity__Group__2__Impl rule__ExternalEntity__Group__3 )
            // InternalSecDFD.g:4299:2: rule__ExternalEntity__Group__2__Impl rule__ExternalEntity__Group__3
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
    // InternalSecDFD.g:4306:1: rule__ExternalEntity__Group__2__Impl : ( ( rule__ExternalEntity__NameAssignment_2 ) ) ;
    public final void rule__ExternalEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4310:1: ( ( ( rule__ExternalEntity__NameAssignment_2 ) ) )
            // InternalSecDFD.g:4311:1: ( ( rule__ExternalEntity__NameAssignment_2 ) )
            {
            // InternalSecDFD.g:4311:1: ( ( rule__ExternalEntity__NameAssignment_2 ) )
            // InternalSecDFD.g:4312:2: ( rule__ExternalEntity__NameAssignment_2 )
            {
             before(grammarAccess.getExternalEntityAccess().getNameAssignment_2()); 
            // InternalSecDFD.g:4313:2: ( rule__ExternalEntity__NameAssignment_2 )
            // InternalSecDFD.g:4313:3: rule__ExternalEntity__NameAssignment_2
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
    // InternalSecDFD.g:4321:1: rule__ExternalEntity__Group__3 : rule__ExternalEntity__Group__3__Impl rule__ExternalEntity__Group__4 ;
    public final void rule__ExternalEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4325:1: ( rule__ExternalEntity__Group__3__Impl rule__ExternalEntity__Group__4 )
            // InternalSecDFD.g:4326:2: rule__ExternalEntity__Group__3__Impl rule__ExternalEntity__Group__4
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:4333:1: rule__ExternalEntity__Group__3__Impl : ( '[' ) ;
    public final void rule__ExternalEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4337:1: ( ( '[' ) )
            // InternalSecDFD.g:4338:1: ( '[' )
            {
            // InternalSecDFD.g:4338:1: ( '[' )
            // InternalSecDFD.g:4339:2: '['
            {
             before(grammarAccess.getExternalEntityAccess().getLeftSquareBracketKeyword_3()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:4348:1: rule__ExternalEntity__Group__4 : rule__ExternalEntity__Group__4__Impl rule__ExternalEntity__Group__5 ;
    public final void rule__ExternalEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4352:1: ( rule__ExternalEntity__Group__4__Impl rule__ExternalEntity__Group__5 )
            // InternalSecDFD.g:4353:2: rule__ExternalEntity__Group__4__Impl rule__ExternalEntity__Group__5
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:4360:1: rule__ExternalEntity__Group__4__Impl : ( ( rule__ExternalEntity__Group_4__0 )? ) ;
    public final void rule__ExternalEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4364:1: ( ( ( rule__ExternalEntity__Group_4__0 )? ) )
            // InternalSecDFD.g:4365:1: ( ( rule__ExternalEntity__Group_4__0 )? )
            {
            // InternalSecDFD.g:4365:1: ( ( rule__ExternalEntity__Group_4__0 )? )
            // InternalSecDFD.g:4366:2: ( rule__ExternalEntity__Group_4__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_4()); 
            // InternalSecDFD.g:4367:2: ( rule__ExternalEntity__Group_4__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==46) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalSecDFD.g:4367:3: rule__ExternalEntity__Group_4__0
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
    // InternalSecDFD.g:4375:1: rule__ExternalEntity__Group__5 : rule__ExternalEntity__Group__5__Impl rule__ExternalEntity__Group__6 ;
    public final void rule__ExternalEntity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4379:1: ( rule__ExternalEntity__Group__5__Impl rule__ExternalEntity__Group__6 )
            // InternalSecDFD.g:4380:2: rule__ExternalEntity__Group__5__Impl rule__ExternalEntity__Group__6
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:4387:1: rule__ExternalEntity__Group__5__Impl : ( ( rule__ExternalEntity__Group_5__0 )? ) ;
    public final void rule__ExternalEntity__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4391:1: ( ( ( rule__ExternalEntity__Group_5__0 )? ) )
            // InternalSecDFD.g:4392:1: ( ( rule__ExternalEntity__Group_5__0 )? )
            {
            // InternalSecDFD.g:4392:1: ( ( rule__ExternalEntity__Group_5__0 )? )
            // InternalSecDFD.g:4393:2: ( rule__ExternalEntity__Group_5__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_5()); 
            // InternalSecDFD.g:4394:2: ( rule__ExternalEntity__Group_5__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==62) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalSecDFD.g:4394:3: rule__ExternalEntity__Group_5__0
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
    // InternalSecDFD.g:4402:1: rule__ExternalEntity__Group__6 : rule__ExternalEntity__Group__6__Impl rule__ExternalEntity__Group__7 ;
    public final void rule__ExternalEntity__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4406:1: ( rule__ExternalEntity__Group__6__Impl rule__ExternalEntity__Group__7 )
            // InternalSecDFD.g:4407:2: rule__ExternalEntity__Group__6__Impl rule__ExternalEntity__Group__7
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:4414:1: rule__ExternalEntity__Group__6__Impl : ( ( rule__ExternalEntity__Group_6__0 )? ) ;
    public final void rule__ExternalEntity__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4418:1: ( ( ( rule__ExternalEntity__Group_6__0 )? ) )
            // InternalSecDFD.g:4419:1: ( ( rule__ExternalEntity__Group_6__0 )? )
            {
            // InternalSecDFD.g:4419:1: ( ( rule__ExternalEntity__Group_6__0 )? )
            // InternalSecDFD.g:4420:2: ( rule__ExternalEntity__Group_6__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_6()); 
            // InternalSecDFD.g:4421:2: ( rule__ExternalEntity__Group_6__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==63) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalSecDFD.g:4421:3: rule__ExternalEntity__Group_6__0
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
    // InternalSecDFD.g:4429:1: rule__ExternalEntity__Group__7 : rule__ExternalEntity__Group__7__Impl rule__ExternalEntity__Group__8 ;
    public final void rule__ExternalEntity__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4433:1: ( rule__ExternalEntity__Group__7__Impl rule__ExternalEntity__Group__8 )
            // InternalSecDFD.g:4434:2: rule__ExternalEntity__Group__7__Impl rule__ExternalEntity__Group__8
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:4441:1: rule__ExternalEntity__Group__7__Impl : ( ( rule__ExternalEntity__Group_7__0 )? ) ;
    public final void rule__ExternalEntity__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4445:1: ( ( ( rule__ExternalEntity__Group_7__0 )? ) )
            // InternalSecDFD.g:4446:1: ( ( rule__ExternalEntity__Group_7__0 )? )
            {
            // InternalSecDFD.g:4446:1: ( ( rule__ExternalEntity__Group_7__0 )? )
            // InternalSecDFD.g:4447:2: ( rule__ExternalEntity__Group_7__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_7()); 
            // InternalSecDFD.g:4448:2: ( rule__ExternalEntity__Group_7__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==65) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalSecDFD.g:4448:3: rule__ExternalEntity__Group_7__0
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
    // InternalSecDFD.g:4456:1: rule__ExternalEntity__Group__8 : rule__ExternalEntity__Group__8__Impl rule__ExternalEntity__Group__9 ;
    public final void rule__ExternalEntity__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4460:1: ( rule__ExternalEntity__Group__8__Impl rule__ExternalEntity__Group__9 )
            // InternalSecDFD.g:4461:2: rule__ExternalEntity__Group__8__Impl rule__ExternalEntity__Group__9
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:4468:1: rule__ExternalEntity__Group__8__Impl : ( ( rule__ExternalEntity__Group_8__0 )? ) ;
    public final void rule__ExternalEntity__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4472:1: ( ( ( rule__ExternalEntity__Group_8__0 )? ) )
            // InternalSecDFD.g:4473:1: ( ( rule__ExternalEntity__Group_8__0 )? )
            {
            // InternalSecDFD.g:4473:1: ( ( rule__ExternalEntity__Group_8__0 )? )
            // InternalSecDFD.g:4474:2: ( rule__ExternalEntity__Group_8__0 )?
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_8()); 
            // InternalSecDFD.g:4475:2: ( rule__ExternalEntity__Group_8__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==66) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalSecDFD.g:4475:3: rule__ExternalEntity__Group_8__0
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
    // InternalSecDFD.g:4483:1: rule__ExternalEntity__Group__9 : rule__ExternalEntity__Group__9__Impl ;
    public final void rule__ExternalEntity__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4487:1: ( rule__ExternalEntity__Group__9__Impl )
            // InternalSecDFD.g:4488:2: rule__ExternalEntity__Group__9__Impl
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
    // InternalSecDFD.g:4494:1: rule__ExternalEntity__Group__9__Impl : ( ']' ) ;
    public final void rule__ExternalEntity__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4498:1: ( ( ']' ) )
            // InternalSecDFD.g:4499:1: ( ']' )
            {
            // InternalSecDFD.g:4499:1: ( ']' )
            // InternalSecDFD.g:4500:2: ']'
            {
             before(grammarAccess.getExternalEntityAccess().getRightSquareBracketKeyword_9()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:4510:1: rule__ExternalEntity__Group_4__0 : rule__ExternalEntity__Group_4__0__Impl rule__ExternalEntity__Group_4__1 ;
    public final void rule__ExternalEntity__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4514:1: ( rule__ExternalEntity__Group_4__0__Impl rule__ExternalEntity__Group_4__1 )
            // InternalSecDFD.g:4515:2: rule__ExternalEntity__Group_4__0__Impl rule__ExternalEntity__Group_4__1
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
    // InternalSecDFD.g:4522:1: rule__ExternalEntity__Group_4__0__Impl : ( 'assets:' ) ;
    public final void rule__ExternalEntity__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4526:1: ( ( 'assets:' ) )
            // InternalSecDFD.g:4527:1: ( 'assets:' )
            {
            // InternalSecDFD.g:4527:1: ( 'assets:' )
            // InternalSecDFD.g:4528:2: 'assets:'
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsKeyword_4_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalSecDFD.g:4537:1: rule__ExternalEntity__Group_4__1 : rule__ExternalEntity__Group_4__1__Impl rule__ExternalEntity__Group_4__2 ;
    public final void rule__ExternalEntity__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4541:1: ( rule__ExternalEntity__Group_4__1__Impl rule__ExternalEntity__Group_4__2 )
            // InternalSecDFD.g:4542:2: rule__ExternalEntity__Group_4__1__Impl rule__ExternalEntity__Group_4__2
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
    // InternalSecDFD.g:4549:1: rule__ExternalEntity__Group_4__1__Impl : ( ( rule__ExternalEntity__AssetsAssignment_4_1 ) ) ;
    public final void rule__ExternalEntity__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4553:1: ( ( ( rule__ExternalEntity__AssetsAssignment_4_1 ) ) )
            // InternalSecDFD.g:4554:1: ( ( rule__ExternalEntity__AssetsAssignment_4_1 ) )
            {
            // InternalSecDFD.g:4554:1: ( ( rule__ExternalEntity__AssetsAssignment_4_1 ) )
            // InternalSecDFD.g:4555:2: ( rule__ExternalEntity__AssetsAssignment_4_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssignment_4_1()); 
            // InternalSecDFD.g:4556:2: ( rule__ExternalEntity__AssetsAssignment_4_1 )
            // InternalSecDFD.g:4556:3: rule__ExternalEntity__AssetsAssignment_4_1
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
    // InternalSecDFD.g:4564:1: rule__ExternalEntity__Group_4__2 : rule__ExternalEntity__Group_4__2__Impl ;
    public final void rule__ExternalEntity__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4568:1: ( rule__ExternalEntity__Group_4__2__Impl )
            // InternalSecDFD.g:4569:2: rule__ExternalEntity__Group_4__2__Impl
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
    // InternalSecDFD.g:4575:1: rule__ExternalEntity__Group_4__2__Impl : ( ( rule__ExternalEntity__Group_4_2__0 )* ) ;
    public final void rule__ExternalEntity__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4579:1: ( ( ( rule__ExternalEntity__Group_4_2__0 )* ) )
            // InternalSecDFD.g:4580:1: ( ( rule__ExternalEntity__Group_4_2__0 )* )
            {
            // InternalSecDFD.g:4580:1: ( ( rule__ExternalEntity__Group_4_2__0 )* )
            // InternalSecDFD.g:4581:2: ( rule__ExternalEntity__Group_4_2__0 )*
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_4_2()); 
            // InternalSecDFD.g:4582:2: ( rule__ExternalEntity__Group_4_2__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==47) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalSecDFD.g:4582:3: rule__ExternalEntity__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ExternalEntity__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // InternalSecDFD.g:4591:1: rule__ExternalEntity__Group_4_2__0 : rule__ExternalEntity__Group_4_2__0__Impl rule__ExternalEntity__Group_4_2__1 ;
    public final void rule__ExternalEntity__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4595:1: ( rule__ExternalEntity__Group_4_2__0__Impl rule__ExternalEntity__Group_4_2__1 )
            // InternalSecDFD.g:4596:2: rule__ExternalEntity__Group_4_2__0__Impl rule__ExternalEntity__Group_4_2__1
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
    // InternalSecDFD.g:4603:1: rule__ExternalEntity__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__ExternalEntity__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4607:1: ( ( ',' ) )
            // InternalSecDFD.g:4608:1: ( ',' )
            {
            // InternalSecDFD.g:4608:1: ( ',' )
            // InternalSecDFD.g:4609:2: ','
            {
             before(grammarAccess.getExternalEntityAccess().getCommaKeyword_4_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:4618:1: rule__ExternalEntity__Group_4_2__1 : rule__ExternalEntity__Group_4_2__1__Impl ;
    public final void rule__ExternalEntity__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4622:1: ( rule__ExternalEntity__Group_4_2__1__Impl )
            // InternalSecDFD.g:4623:2: rule__ExternalEntity__Group_4_2__1__Impl
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
    // InternalSecDFD.g:4629:1: rule__ExternalEntity__Group_4_2__1__Impl : ( ( rule__ExternalEntity__AssetsAssignment_4_2_1 ) ) ;
    public final void rule__ExternalEntity__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4633:1: ( ( ( rule__ExternalEntity__AssetsAssignment_4_2_1 ) ) )
            // InternalSecDFD.g:4634:1: ( ( rule__ExternalEntity__AssetsAssignment_4_2_1 ) )
            {
            // InternalSecDFD.g:4634:1: ( ( rule__ExternalEntity__AssetsAssignment_4_2_1 ) )
            // InternalSecDFD.g:4635:2: ( rule__ExternalEntity__AssetsAssignment_4_2_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssignment_4_2_1()); 
            // InternalSecDFD.g:4636:2: ( rule__ExternalEntity__AssetsAssignment_4_2_1 )
            // InternalSecDFD.g:4636:3: rule__ExternalEntity__AssetsAssignment_4_2_1
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
    // InternalSecDFD.g:4645:1: rule__ExternalEntity__Group_5__0 : rule__ExternalEntity__Group_5__0__Impl rule__ExternalEntity__Group_5__1 ;
    public final void rule__ExternalEntity__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4649:1: ( rule__ExternalEntity__Group_5__0__Impl rule__ExternalEntity__Group_5__1 )
            // InternalSecDFD.g:4650:2: rule__ExternalEntity__Group_5__0__Impl rule__ExternalEntity__Group_5__1
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
    // InternalSecDFD.g:4657:1: rule__ExternalEntity__Group_5__0__Impl : ( 'assumption:' ) ;
    public final void rule__ExternalEntity__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4661:1: ( ( 'assumption:' ) )
            // InternalSecDFD.g:4662:1: ( 'assumption:' )
            {
            // InternalSecDFD.g:4662:1: ( 'assumption:' )
            // InternalSecDFD.g:4663:2: 'assumption:'
            {
             before(grammarAccess.getExternalEntityAccess().getAssumptionKeyword_5_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalSecDFD.g:4672:1: rule__ExternalEntity__Group_5__1 : rule__ExternalEntity__Group_5__1__Impl rule__ExternalEntity__Group_5__2 ;
    public final void rule__ExternalEntity__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4676:1: ( rule__ExternalEntity__Group_5__1__Impl rule__ExternalEntity__Group_5__2 )
            // InternalSecDFD.g:4677:2: rule__ExternalEntity__Group_5__1__Impl rule__ExternalEntity__Group_5__2
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
    // InternalSecDFD.g:4684:1: rule__ExternalEntity__Group_5__1__Impl : ( ( rule__ExternalEntity__AssumptionAssignment_5_1 ) ) ;
    public final void rule__ExternalEntity__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4688:1: ( ( ( rule__ExternalEntity__AssumptionAssignment_5_1 ) ) )
            // InternalSecDFD.g:4689:1: ( ( rule__ExternalEntity__AssumptionAssignment_5_1 ) )
            {
            // InternalSecDFD.g:4689:1: ( ( rule__ExternalEntity__AssumptionAssignment_5_1 ) )
            // InternalSecDFD.g:4690:2: ( rule__ExternalEntity__AssumptionAssignment_5_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAssumptionAssignment_5_1()); 
            // InternalSecDFD.g:4691:2: ( rule__ExternalEntity__AssumptionAssignment_5_1 )
            // InternalSecDFD.g:4691:3: rule__ExternalEntity__AssumptionAssignment_5_1
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
    // InternalSecDFD.g:4699:1: rule__ExternalEntity__Group_5__2 : rule__ExternalEntity__Group_5__2__Impl ;
    public final void rule__ExternalEntity__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4703:1: ( rule__ExternalEntity__Group_5__2__Impl )
            // InternalSecDFD.g:4704:2: rule__ExternalEntity__Group_5__2__Impl
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
    // InternalSecDFD.g:4710:1: rule__ExternalEntity__Group_5__2__Impl : ( ( rule__ExternalEntity__Group_5_2__0 )* ) ;
    public final void rule__ExternalEntity__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4714:1: ( ( ( rule__ExternalEntity__Group_5_2__0 )* ) )
            // InternalSecDFD.g:4715:1: ( ( rule__ExternalEntity__Group_5_2__0 )* )
            {
            // InternalSecDFD.g:4715:1: ( ( rule__ExternalEntity__Group_5_2__0 )* )
            // InternalSecDFD.g:4716:2: ( rule__ExternalEntity__Group_5_2__0 )*
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_5_2()); 
            // InternalSecDFD.g:4717:2: ( rule__ExternalEntity__Group_5_2__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==47) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalSecDFD.g:4717:3: rule__ExternalEntity__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ExternalEntity__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
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
    // InternalSecDFD.g:4726:1: rule__ExternalEntity__Group_5_2__0 : rule__ExternalEntity__Group_5_2__0__Impl rule__ExternalEntity__Group_5_2__1 ;
    public final void rule__ExternalEntity__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4730:1: ( rule__ExternalEntity__Group_5_2__0__Impl rule__ExternalEntity__Group_5_2__1 )
            // InternalSecDFD.g:4731:2: rule__ExternalEntity__Group_5_2__0__Impl rule__ExternalEntity__Group_5_2__1
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
    // InternalSecDFD.g:4738:1: rule__ExternalEntity__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__ExternalEntity__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4742:1: ( ( ',' ) )
            // InternalSecDFD.g:4743:1: ( ',' )
            {
            // InternalSecDFD.g:4743:1: ( ',' )
            // InternalSecDFD.g:4744:2: ','
            {
             before(grammarAccess.getExternalEntityAccess().getCommaKeyword_5_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:4753:1: rule__ExternalEntity__Group_5_2__1 : rule__ExternalEntity__Group_5_2__1__Impl ;
    public final void rule__ExternalEntity__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4757:1: ( rule__ExternalEntity__Group_5_2__1__Impl )
            // InternalSecDFD.g:4758:2: rule__ExternalEntity__Group_5_2__1__Impl
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
    // InternalSecDFD.g:4764:1: rule__ExternalEntity__Group_5_2__1__Impl : ( ( rule__ExternalEntity__AssumptionAssignment_5_2_1 ) ) ;
    public final void rule__ExternalEntity__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4768:1: ( ( ( rule__ExternalEntity__AssumptionAssignment_5_2_1 ) ) )
            // InternalSecDFD.g:4769:1: ( ( rule__ExternalEntity__AssumptionAssignment_5_2_1 ) )
            {
            // InternalSecDFD.g:4769:1: ( ( rule__ExternalEntity__AssumptionAssignment_5_2_1 ) )
            // InternalSecDFD.g:4770:2: ( rule__ExternalEntity__AssumptionAssignment_5_2_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAssumptionAssignment_5_2_1()); 
            // InternalSecDFD.g:4771:2: ( rule__ExternalEntity__AssumptionAssignment_5_2_1 )
            // InternalSecDFD.g:4771:3: rule__ExternalEntity__AssumptionAssignment_5_2_1
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
    // InternalSecDFD.g:4780:1: rule__ExternalEntity__Group_6__0 : rule__ExternalEntity__Group_6__0__Impl rule__ExternalEntity__Group_6__1 ;
    public final void rule__ExternalEntity__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4784:1: ( rule__ExternalEntity__Group_6__0__Impl rule__ExternalEntity__Group_6__1 )
            // InternalSecDFD.g:4785:2: rule__ExternalEntity__Group_6__0__Impl rule__ExternalEntity__Group_6__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalSecDFD.g:4792:1: rule__ExternalEntity__Group_6__0__Impl : ( 'incoming' ) ;
    public final void rule__ExternalEntity__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4796:1: ( ( 'incoming' ) )
            // InternalSecDFD.g:4797:1: ( 'incoming' )
            {
            // InternalSecDFD.g:4797:1: ( 'incoming' )
            // InternalSecDFD.g:4798:2: 'incoming'
            {
             before(grammarAccess.getExternalEntityAccess().getIncomingKeyword_6_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalSecDFD.g:4807:1: rule__ExternalEntity__Group_6__1 : rule__ExternalEntity__Group_6__1__Impl rule__ExternalEntity__Group_6__2 ;
    public final void rule__ExternalEntity__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4811:1: ( rule__ExternalEntity__Group_6__1__Impl rule__ExternalEntity__Group_6__2 )
            // InternalSecDFD.g:4812:2: rule__ExternalEntity__Group_6__1__Impl rule__ExternalEntity__Group_6__2
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
    // InternalSecDFD.g:4819:1: rule__ExternalEntity__Group_6__1__Impl : ( 'flows:' ) ;
    public final void rule__ExternalEntity__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4823:1: ( ( 'flows:' ) )
            // InternalSecDFD.g:4824:1: ( 'flows:' )
            {
            // InternalSecDFD.g:4824:1: ( 'flows:' )
            // InternalSecDFD.g:4825:2: 'flows:'
            {
             before(grammarAccess.getExternalEntityAccess().getFlowsKeyword_6_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalSecDFD.g:4834:1: rule__ExternalEntity__Group_6__2 : rule__ExternalEntity__Group_6__2__Impl rule__ExternalEntity__Group_6__3 ;
    public final void rule__ExternalEntity__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4838:1: ( rule__ExternalEntity__Group_6__2__Impl rule__ExternalEntity__Group_6__3 )
            // InternalSecDFD.g:4839:2: rule__ExternalEntity__Group_6__2__Impl rule__ExternalEntity__Group_6__3
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
    // InternalSecDFD.g:4846:1: rule__ExternalEntity__Group_6__2__Impl : ( ( rule__ExternalEntity__InflowsAssignment_6_2 ) ) ;
    public final void rule__ExternalEntity__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4850:1: ( ( ( rule__ExternalEntity__InflowsAssignment_6_2 ) ) )
            // InternalSecDFD.g:4851:1: ( ( rule__ExternalEntity__InflowsAssignment_6_2 ) )
            {
            // InternalSecDFD.g:4851:1: ( ( rule__ExternalEntity__InflowsAssignment_6_2 ) )
            // InternalSecDFD.g:4852:2: ( rule__ExternalEntity__InflowsAssignment_6_2 )
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsAssignment_6_2()); 
            // InternalSecDFD.g:4853:2: ( rule__ExternalEntity__InflowsAssignment_6_2 )
            // InternalSecDFD.g:4853:3: rule__ExternalEntity__InflowsAssignment_6_2
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
    // InternalSecDFD.g:4861:1: rule__ExternalEntity__Group_6__3 : rule__ExternalEntity__Group_6__3__Impl ;
    public final void rule__ExternalEntity__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4865:1: ( rule__ExternalEntity__Group_6__3__Impl )
            // InternalSecDFD.g:4866:2: rule__ExternalEntity__Group_6__3__Impl
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
    // InternalSecDFD.g:4872:1: rule__ExternalEntity__Group_6__3__Impl : ( ( rule__ExternalEntity__Group_6_3__0 )* ) ;
    public final void rule__ExternalEntity__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4876:1: ( ( ( rule__ExternalEntity__Group_6_3__0 )* ) )
            // InternalSecDFD.g:4877:1: ( ( rule__ExternalEntity__Group_6_3__0 )* )
            {
            // InternalSecDFD.g:4877:1: ( ( rule__ExternalEntity__Group_6_3__0 )* )
            // InternalSecDFD.g:4878:2: ( rule__ExternalEntity__Group_6_3__0 )*
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_6_3()); 
            // InternalSecDFD.g:4879:2: ( rule__ExternalEntity__Group_6_3__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==47) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalSecDFD.g:4879:3: rule__ExternalEntity__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ExternalEntity__Group_6_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
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
    // InternalSecDFD.g:4888:1: rule__ExternalEntity__Group_6_3__0 : rule__ExternalEntity__Group_6_3__0__Impl rule__ExternalEntity__Group_6_3__1 ;
    public final void rule__ExternalEntity__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4892:1: ( rule__ExternalEntity__Group_6_3__0__Impl rule__ExternalEntity__Group_6_3__1 )
            // InternalSecDFD.g:4893:2: rule__ExternalEntity__Group_6_3__0__Impl rule__ExternalEntity__Group_6_3__1
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
    // InternalSecDFD.g:4900:1: rule__ExternalEntity__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__ExternalEntity__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4904:1: ( ( ',' ) )
            // InternalSecDFD.g:4905:1: ( ',' )
            {
            // InternalSecDFD.g:4905:1: ( ',' )
            // InternalSecDFD.g:4906:2: ','
            {
             before(grammarAccess.getExternalEntityAccess().getCommaKeyword_6_3_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:4915:1: rule__ExternalEntity__Group_6_3__1 : rule__ExternalEntity__Group_6_3__1__Impl ;
    public final void rule__ExternalEntity__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4919:1: ( rule__ExternalEntity__Group_6_3__1__Impl )
            // InternalSecDFD.g:4920:2: rule__ExternalEntity__Group_6_3__1__Impl
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
    // InternalSecDFD.g:4926:1: rule__ExternalEntity__Group_6_3__1__Impl : ( ( rule__ExternalEntity__InflowsAssignment_6_3_1 ) ) ;
    public final void rule__ExternalEntity__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4930:1: ( ( ( rule__ExternalEntity__InflowsAssignment_6_3_1 ) ) )
            // InternalSecDFD.g:4931:1: ( ( rule__ExternalEntity__InflowsAssignment_6_3_1 ) )
            {
            // InternalSecDFD.g:4931:1: ( ( rule__ExternalEntity__InflowsAssignment_6_3_1 ) )
            // InternalSecDFD.g:4932:2: ( rule__ExternalEntity__InflowsAssignment_6_3_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsAssignment_6_3_1()); 
            // InternalSecDFD.g:4933:2: ( rule__ExternalEntity__InflowsAssignment_6_3_1 )
            // InternalSecDFD.g:4933:3: rule__ExternalEntity__InflowsAssignment_6_3_1
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
    // InternalSecDFD.g:4942:1: rule__ExternalEntity__Group_7__0 : rule__ExternalEntity__Group_7__0__Impl rule__ExternalEntity__Group_7__1 ;
    public final void rule__ExternalEntity__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4946:1: ( rule__ExternalEntity__Group_7__0__Impl rule__ExternalEntity__Group_7__1 )
            // InternalSecDFD.g:4947:2: rule__ExternalEntity__Group_7__0__Impl rule__ExternalEntity__Group_7__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalSecDFD.g:4954:1: rule__ExternalEntity__Group_7__0__Impl : ( 'outgoing' ) ;
    public final void rule__ExternalEntity__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4958:1: ( ( 'outgoing' ) )
            // InternalSecDFD.g:4959:1: ( 'outgoing' )
            {
            // InternalSecDFD.g:4959:1: ( 'outgoing' )
            // InternalSecDFD.g:4960:2: 'outgoing'
            {
             before(grammarAccess.getExternalEntityAccess().getOutgoingKeyword_7_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalSecDFD.g:4969:1: rule__ExternalEntity__Group_7__1 : rule__ExternalEntity__Group_7__1__Impl rule__ExternalEntity__Group_7__2 ;
    public final void rule__ExternalEntity__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4973:1: ( rule__ExternalEntity__Group_7__1__Impl rule__ExternalEntity__Group_7__2 )
            // InternalSecDFD.g:4974:2: rule__ExternalEntity__Group_7__1__Impl rule__ExternalEntity__Group_7__2
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
    // InternalSecDFD.g:4981:1: rule__ExternalEntity__Group_7__1__Impl : ( 'flows:' ) ;
    public final void rule__ExternalEntity__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:4985:1: ( ( 'flows:' ) )
            // InternalSecDFD.g:4986:1: ( 'flows:' )
            {
            // InternalSecDFD.g:4986:1: ( 'flows:' )
            // InternalSecDFD.g:4987:2: 'flows:'
            {
             before(grammarAccess.getExternalEntityAccess().getFlowsKeyword_7_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalSecDFD.g:4996:1: rule__ExternalEntity__Group_7__2 : rule__ExternalEntity__Group_7__2__Impl rule__ExternalEntity__Group_7__3 ;
    public final void rule__ExternalEntity__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5000:1: ( rule__ExternalEntity__Group_7__2__Impl rule__ExternalEntity__Group_7__3 )
            // InternalSecDFD.g:5001:2: rule__ExternalEntity__Group_7__2__Impl rule__ExternalEntity__Group_7__3
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
    // InternalSecDFD.g:5008:1: rule__ExternalEntity__Group_7__2__Impl : ( ( rule__ExternalEntity__OutflowsAssignment_7_2 ) ) ;
    public final void rule__ExternalEntity__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5012:1: ( ( ( rule__ExternalEntity__OutflowsAssignment_7_2 ) ) )
            // InternalSecDFD.g:5013:1: ( ( rule__ExternalEntity__OutflowsAssignment_7_2 ) )
            {
            // InternalSecDFD.g:5013:1: ( ( rule__ExternalEntity__OutflowsAssignment_7_2 ) )
            // InternalSecDFD.g:5014:2: ( rule__ExternalEntity__OutflowsAssignment_7_2 )
            {
             before(grammarAccess.getExternalEntityAccess().getOutflowsAssignment_7_2()); 
            // InternalSecDFD.g:5015:2: ( rule__ExternalEntity__OutflowsAssignment_7_2 )
            // InternalSecDFD.g:5015:3: rule__ExternalEntity__OutflowsAssignment_7_2
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
    // InternalSecDFD.g:5023:1: rule__ExternalEntity__Group_7__3 : rule__ExternalEntity__Group_7__3__Impl ;
    public final void rule__ExternalEntity__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5027:1: ( rule__ExternalEntity__Group_7__3__Impl )
            // InternalSecDFD.g:5028:2: rule__ExternalEntity__Group_7__3__Impl
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
    // InternalSecDFD.g:5034:1: rule__ExternalEntity__Group_7__3__Impl : ( ( rule__ExternalEntity__Group_7_3__0 )* ) ;
    public final void rule__ExternalEntity__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5038:1: ( ( ( rule__ExternalEntity__Group_7_3__0 )* ) )
            // InternalSecDFD.g:5039:1: ( ( rule__ExternalEntity__Group_7_3__0 )* )
            {
            // InternalSecDFD.g:5039:1: ( ( rule__ExternalEntity__Group_7_3__0 )* )
            // InternalSecDFD.g:5040:2: ( rule__ExternalEntity__Group_7_3__0 )*
            {
             before(grammarAccess.getExternalEntityAccess().getGroup_7_3()); 
            // InternalSecDFD.g:5041:2: ( rule__ExternalEntity__Group_7_3__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==47) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalSecDFD.g:5041:3: rule__ExternalEntity__Group_7_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__ExternalEntity__Group_7_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalSecDFD.g:5050:1: rule__ExternalEntity__Group_7_3__0 : rule__ExternalEntity__Group_7_3__0__Impl rule__ExternalEntity__Group_7_3__1 ;
    public final void rule__ExternalEntity__Group_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5054:1: ( rule__ExternalEntity__Group_7_3__0__Impl rule__ExternalEntity__Group_7_3__1 )
            // InternalSecDFD.g:5055:2: rule__ExternalEntity__Group_7_3__0__Impl rule__ExternalEntity__Group_7_3__1
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
    // InternalSecDFD.g:5062:1: rule__ExternalEntity__Group_7_3__0__Impl : ( ',' ) ;
    public final void rule__ExternalEntity__Group_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5066:1: ( ( ',' ) )
            // InternalSecDFD.g:5067:1: ( ',' )
            {
            // InternalSecDFD.g:5067:1: ( ',' )
            // InternalSecDFD.g:5068:2: ','
            {
             before(grammarAccess.getExternalEntityAccess().getCommaKeyword_7_3_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:5077:1: rule__ExternalEntity__Group_7_3__1 : rule__ExternalEntity__Group_7_3__1__Impl ;
    public final void rule__ExternalEntity__Group_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5081:1: ( rule__ExternalEntity__Group_7_3__1__Impl )
            // InternalSecDFD.g:5082:2: rule__ExternalEntity__Group_7_3__1__Impl
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
    // InternalSecDFD.g:5088:1: rule__ExternalEntity__Group_7_3__1__Impl : ( ( rule__ExternalEntity__OutflowsAssignment_7_3_1 ) ) ;
    public final void rule__ExternalEntity__Group_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5092:1: ( ( ( rule__ExternalEntity__OutflowsAssignment_7_3_1 ) ) )
            // InternalSecDFD.g:5093:1: ( ( rule__ExternalEntity__OutflowsAssignment_7_3_1 ) )
            {
            // InternalSecDFD.g:5093:1: ( ( rule__ExternalEntity__OutflowsAssignment_7_3_1 ) )
            // InternalSecDFD.g:5094:2: ( rule__ExternalEntity__OutflowsAssignment_7_3_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getOutflowsAssignment_7_3_1()); 
            // InternalSecDFD.g:5095:2: ( rule__ExternalEntity__OutflowsAssignment_7_3_1 )
            // InternalSecDFD.g:5095:3: rule__ExternalEntity__OutflowsAssignment_7_3_1
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
    // InternalSecDFD.g:5104:1: rule__ExternalEntity__Group_8__0 : rule__ExternalEntity__Group_8__0__Impl rule__ExternalEntity__Group_8__1 ;
    public final void rule__ExternalEntity__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5108:1: ( rule__ExternalEntity__Group_8__0__Impl rule__ExternalEntity__Group_8__1 )
            // InternalSecDFD.g:5109:2: rule__ExternalEntity__Group_8__0__Impl rule__ExternalEntity__Group_8__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalSecDFD.g:5116:1: rule__ExternalEntity__Group_8__0__Impl : ( 'attacker:' ) ;
    public final void rule__ExternalEntity__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5120:1: ( ( 'attacker:' ) )
            // InternalSecDFD.g:5121:1: ( 'attacker:' )
            {
            // InternalSecDFD.g:5121:1: ( 'attacker:' )
            // InternalSecDFD.g:5122:2: 'attacker:'
            {
             before(grammarAccess.getExternalEntityAccess().getAttackerKeyword_8_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalSecDFD.g:5131:1: rule__ExternalEntity__Group_8__1 : rule__ExternalEntity__Group_8__1__Impl ;
    public final void rule__ExternalEntity__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5135:1: ( rule__ExternalEntity__Group_8__1__Impl )
            // InternalSecDFD.g:5136:2: rule__ExternalEntity__Group_8__1__Impl
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
    // InternalSecDFD.g:5142:1: rule__ExternalEntity__Group_8__1__Impl : ( ( rule__ExternalEntity__AttackerAssignment_8_1 ) ) ;
    public final void rule__ExternalEntity__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5146:1: ( ( ( rule__ExternalEntity__AttackerAssignment_8_1 ) ) )
            // InternalSecDFD.g:5147:1: ( ( rule__ExternalEntity__AttackerAssignment_8_1 ) )
            {
            // InternalSecDFD.g:5147:1: ( ( rule__ExternalEntity__AttackerAssignment_8_1 ) )
            // InternalSecDFD.g:5148:2: ( rule__ExternalEntity__AttackerAssignment_8_1 )
            {
             before(grammarAccess.getExternalEntityAccess().getAttackerAssignment_8_1()); 
            // InternalSecDFD.g:5149:2: ( rule__ExternalEntity__AttackerAssignment_8_1 )
            // InternalSecDFD.g:5149:3: rule__ExternalEntity__AttackerAssignment_8_1
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
    // InternalSecDFD.g:5158:1: rule__Flow__Group__0 : rule__Flow__Group__0__Impl rule__Flow__Group__1 ;
    public final void rule__Flow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5162:1: ( rule__Flow__Group__0__Impl rule__Flow__Group__1 )
            // InternalSecDFD.g:5163:2: rule__Flow__Group__0__Impl rule__Flow__Group__1
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
    // InternalSecDFD.g:5170:1: rule__Flow__Group__0__Impl : ( () ) ;
    public final void rule__Flow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5174:1: ( ( () ) )
            // InternalSecDFD.g:5175:1: ( () )
            {
            // InternalSecDFD.g:5175:1: ( () )
            // InternalSecDFD.g:5176:2: ()
            {
             before(grammarAccess.getFlowAccess().getFlowAction_0()); 
            // InternalSecDFD.g:5177:2: ()
            // InternalSecDFD.g:5177:3: 
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
    // InternalSecDFD.g:5185:1: rule__Flow__Group__1 : rule__Flow__Group__1__Impl rule__Flow__Group__2 ;
    public final void rule__Flow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5189:1: ( rule__Flow__Group__1__Impl rule__Flow__Group__2 )
            // InternalSecDFD.g:5190:2: rule__Flow__Group__1__Impl rule__Flow__Group__2
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
    // InternalSecDFD.g:5197:1: rule__Flow__Group__1__Impl : ( ( rule__Flow__NameAssignment_1 ) ) ;
    public final void rule__Flow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5201:1: ( ( ( rule__Flow__NameAssignment_1 ) ) )
            // InternalSecDFD.g:5202:1: ( ( rule__Flow__NameAssignment_1 ) )
            {
            // InternalSecDFD.g:5202:1: ( ( rule__Flow__NameAssignment_1 ) )
            // InternalSecDFD.g:5203:2: ( rule__Flow__NameAssignment_1 )
            {
             before(grammarAccess.getFlowAccess().getNameAssignment_1()); 
            // InternalSecDFD.g:5204:2: ( rule__Flow__NameAssignment_1 )
            // InternalSecDFD.g:5204:3: rule__Flow__NameAssignment_1
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
    // InternalSecDFD.g:5212:1: rule__Flow__Group__2 : rule__Flow__Group__2__Impl rule__Flow__Group__3 ;
    public final void rule__Flow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5216:1: ( rule__Flow__Group__2__Impl rule__Flow__Group__3 )
            // InternalSecDFD.g:5217:2: rule__Flow__Group__2__Impl rule__Flow__Group__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalSecDFD.g:5224:1: rule__Flow__Group__2__Impl : ( '[' ) ;
    public final void rule__Flow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5228:1: ( ( '[' ) )
            // InternalSecDFD.g:5229:1: ( '[' )
            {
            // InternalSecDFD.g:5229:1: ( '[' )
            // InternalSecDFD.g:5230:2: '['
            {
             before(grammarAccess.getFlowAccess().getLeftSquareBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:5239:1: rule__Flow__Group__3 : rule__Flow__Group__3__Impl rule__Flow__Group__4 ;
    public final void rule__Flow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5243:1: ( rule__Flow__Group__3__Impl rule__Flow__Group__4 )
            // InternalSecDFD.g:5244:2: rule__Flow__Group__3__Impl rule__Flow__Group__4
            {
            pushFollow(FOLLOW_30);
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
    // InternalSecDFD.g:5251:1: rule__Flow__Group__3__Impl : ( ( rule__Flow__Group_3__0 )? ) ;
    public final void rule__Flow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5255:1: ( ( ( rule__Flow__Group_3__0 )? ) )
            // InternalSecDFD.g:5256:1: ( ( rule__Flow__Group_3__0 )? )
            {
            // InternalSecDFD.g:5256:1: ( ( rule__Flow__Group_3__0 )? )
            // InternalSecDFD.g:5257:2: ( rule__Flow__Group_3__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_3()); 
            // InternalSecDFD.g:5258:2: ( rule__Flow__Group_3__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==69) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalSecDFD.g:5258:3: rule__Flow__Group_3__0
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
    // InternalSecDFD.g:5266:1: rule__Flow__Group__4 : rule__Flow__Group__4__Impl rule__Flow__Group__5 ;
    public final void rule__Flow__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5270:1: ( rule__Flow__Group__4__Impl rule__Flow__Group__5 )
            // InternalSecDFD.g:5271:2: rule__Flow__Group__4__Impl rule__Flow__Group__5
            {
            pushFollow(FOLLOW_30);
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
    // InternalSecDFD.g:5278:1: rule__Flow__Group__4__Impl : ( ( rule__Flow__Group_4__0 )? ) ;
    public final void rule__Flow__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5282:1: ( ( ( rule__Flow__Group_4__0 )? ) )
            // InternalSecDFD.g:5283:1: ( ( rule__Flow__Group_4__0 )? )
            {
            // InternalSecDFD.g:5283:1: ( ( rule__Flow__Group_4__0 )? )
            // InternalSecDFD.g:5284:2: ( rule__Flow__Group_4__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_4()); 
            // InternalSecDFD.g:5285:2: ( rule__Flow__Group_4__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==46) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalSecDFD.g:5285:3: rule__Flow__Group_4__0
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
    // InternalSecDFD.g:5293:1: rule__Flow__Group__5 : rule__Flow__Group__5__Impl rule__Flow__Group__6 ;
    public final void rule__Flow__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5297:1: ( rule__Flow__Group__5__Impl rule__Flow__Group__6 )
            // InternalSecDFD.g:5298:2: rule__Flow__Group__5__Impl rule__Flow__Group__6
            {
            pushFollow(FOLLOW_30);
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
    // InternalSecDFD.g:5305:1: rule__Flow__Group__5__Impl : ( ( rule__Flow__Group_5__0 )? ) ;
    public final void rule__Flow__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5309:1: ( ( ( rule__Flow__Group_5__0 )? ) )
            // InternalSecDFD.g:5310:1: ( ( rule__Flow__Group_5__0 )? )
            {
            // InternalSecDFD.g:5310:1: ( ( rule__Flow__Group_5__0 )? )
            // InternalSecDFD.g:5311:2: ( rule__Flow__Group_5__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_5()); 
            // InternalSecDFD.g:5312:2: ( rule__Flow__Group_5__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==57) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalSecDFD.g:5312:3: rule__Flow__Group_5__0
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
    // InternalSecDFD.g:5320:1: rule__Flow__Group__6 : rule__Flow__Group__6__Impl rule__Flow__Group__7 ;
    public final void rule__Flow__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5324:1: ( rule__Flow__Group__6__Impl rule__Flow__Group__7 )
            // InternalSecDFD.g:5325:2: rule__Flow__Group__6__Impl rule__Flow__Group__7
            {
            pushFollow(FOLLOW_30);
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
    // InternalSecDFD.g:5332:1: rule__Flow__Group__6__Impl : ( ( rule__Flow__Group_6__0 )? ) ;
    public final void rule__Flow__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5336:1: ( ( ( rule__Flow__Group_6__0 )? ) )
            // InternalSecDFD.g:5337:1: ( ( rule__Flow__Group_6__0 )? )
            {
            // InternalSecDFD.g:5337:1: ( ( rule__Flow__Group_6__0 )? )
            // InternalSecDFD.g:5338:2: ( rule__Flow__Group_6__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_6()); 
            // InternalSecDFD.g:5339:2: ( rule__Flow__Group_6__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==58) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalSecDFD.g:5339:3: rule__Flow__Group_6__0
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
    // InternalSecDFD.g:5347:1: rule__Flow__Group__7 : rule__Flow__Group__7__Impl rule__Flow__Group__8 ;
    public final void rule__Flow__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5351:1: ( rule__Flow__Group__7__Impl rule__Flow__Group__8 )
            // InternalSecDFD.g:5352:2: rule__Flow__Group__7__Impl rule__Flow__Group__8
            {
            pushFollow(FOLLOW_30);
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
    // InternalSecDFD.g:5359:1: rule__Flow__Group__7__Impl : ( ( rule__Flow__Group_7__0 )? ) ;
    public final void rule__Flow__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5363:1: ( ( ( rule__Flow__Group_7__0 )? ) )
            // InternalSecDFD.g:5364:1: ( ( rule__Flow__Group_7__0 )? )
            {
            // InternalSecDFD.g:5364:1: ( ( rule__Flow__Group_7__0 )? )
            // InternalSecDFD.g:5365:2: ( rule__Flow__Group_7__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_7()); 
            // InternalSecDFD.g:5366:2: ( rule__Flow__Group_7__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==70) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalSecDFD.g:5366:3: rule__Flow__Group_7__0
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
    // InternalSecDFD.g:5374:1: rule__Flow__Group__8 : rule__Flow__Group__8__Impl rule__Flow__Group__9 ;
    public final void rule__Flow__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5378:1: ( rule__Flow__Group__8__Impl rule__Flow__Group__9 )
            // InternalSecDFD.g:5379:2: rule__Flow__Group__8__Impl rule__Flow__Group__9
            {
            pushFollow(FOLLOW_30);
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
    // InternalSecDFD.g:5386:1: rule__Flow__Group__8__Impl : ( ( rule__Flow__Group_8__0 )? ) ;
    public final void rule__Flow__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5390:1: ( ( ( rule__Flow__Group_8__0 )? ) )
            // InternalSecDFD.g:5391:1: ( ( rule__Flow__Group_8__0 )? )
            {
            // InternalSecDFD.g:5391:1: ( ( rule__Flow__Group_8__0 )? )
            // InternalSecDFD.g:5392:2: ( rule__Flow__Group_8__0 )?
            {
             before(grammarAccess.getFlowAccess().getGroup_8()); 
            // InternalSecDFD.g:5393:2: ( rule__Flow__Group_8__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==62) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalSecDFD.g:5393:3: rule__Flow__Group_8__0
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
    // InternalSecDFD.g:5401:1: rule__Flow__Group__9 : rule__Flow__Group__9__Impl ;
    public final void rule__Flow__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5405:1: ( rule__Flow__Group__9__Impl )
            // InternalSecDFD.g:5406:2: rule__Flow__Group__9__Impl
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
    // InternalSecDFD.g:5412:1: rule__Flow__Group__9__Impl : ( ']' ) ;
    public final void rule__Flow__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5416:1: ( ( ']' ) )
            // InternalSecDFD.g:5417:1: ( ']' )
            {
            // InternalSecDFD.g:5417:1: ( ']' )
            // InternalSecDFD.g:5418:2: ']'
            {
             before(grammarAccess.getFlowAccess().getRightSquareBracketKeyword_9()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:5428:1: rule__Flow__Group_3__0 : rule__Flow__Group_3__0__Impl rule__Flow__Group_3__1 ;
    public final void rule__Flow__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5432:1: ( rule__Flow__Group_3__0__Impl rule__Flow__Group_3__1 )
            // InternalSecDFD.g:5433:2: rule__Flow__Group_3__0__Impl rule__Flow__Group_3__1
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
    // InternalSecDFD.g:5440:1: rule__Flow__Group_3__0__Impl : ( 'num:' ) ;
    public final void rule__Flow__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5444:1: ( ( 'num:' ) )
            // InternalSecDFD.g:5445:1: ( 'num:' )
            {
            // InternalSecDFD.g:5445:1: ( 'num:' )
            // InternalSecDFD.g:5446:2: 'num:'
            {
             before(grammarAccess.getFlowAccess().getNumKeyword_3_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalSecDFD.g:5455:1: rule__Flow__Group_3__1 : rule__Flow__Group_3__1__Impl ;
    public final void rule__Flow__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5459:1: ( rule__Flow__Group_3__1__Impl )
            // InternalSecDFD.g:5460:2: rule__Flow__Group_3__1__Impl
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
    // InternalSecDFD.g:5466:1: rule__Flow__Group_3__1__Impl : ( ( rule__Flow__NumberAssignment_3_1 ) ) ;
    public final void rule__Flow__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5470:1: ( ( ( rule__Flow__NumberAssignment_3_1 ) ) )
            // InternalSecDFD.g:5471:1: ( ( rule__Flow__NumberAssignment_3_1 ) )
            {
            // InternalSecDFD.g:5471:1: ( ( rule__Flow__NumberAssignment_3_1 ) )
            // InternalSecDFD.g:5472:2: ( rule__Flow__NumberAssignment_3_1 )
            {
             before(grammarAccess.getFlowAccess().getNumberAssignment_3_1()); 
            // InternalSecDFD.g:5473:2: ( rule__Flow__NumberAssignment_3_1 )
            // InternalSecDFD.g:5473:3: rule__Flow__NumberAssignment_3_1
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
    // InternalSecDFD.g:5482:1: rule__Flow__Group_4__0 : rule__Flow__Group_4__0__Impl rule__Flow__Group_4__1 ;
    public final void rule__Flow__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5486:1: ( rule__Flow__Group_4__0__Impl rule__Flow__Group_4__1 )
            // InternalSecDFD.g:5487:2: rule__Flow__Group_4__0__Impl rule__Flow__Group_4__1
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
    // InternalSecDFD.g:5494:1: rule__Flow__Group_4__0__Impl : ( 'assets:' ) ;
    public final void rule__Flow__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5498:1: ( ( 'assets:' ) )
            // InternalSecDFD.g:5499:1: ( 'assets:' )
            {
            // InternalSecDFD.g:5499:1: ( 'assets:' )
            // InternalSecDFD.g:5500:2: 'assets:'
            {
             before(grammarAccess.getFlowAccess().getAssetsKeyword_4_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalSecDFD.g:5509:1: rule__Flow__Group_4__1 : rule__Flow__Group_4__1__Impl rule__Flow__Group_4__2 ;
    public final void rule__Flow__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5513:1: ( rule__Flow__Group_4__1__Impl rule__Flow__Group_4__2 )
            // InternalSecDFD.g:5514:2: rule__Flow__Group_4__1__Impl rule__Flow__Group_4__2
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
    // InternalSecDFD.g:5521:1: rule__Flow__Group_4__1__Impl : ( ( rule__Flow__AssetsAssignment_4_1 ) ) ;
    public final void rule__Flow__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5525:1: ( ( ( rule__Flow__AssetsAssignment_4_1 ) ) )
            // InternalSecDFD.g:5526:1: ( ( rule__Flow__AssetsAssignment_4_1 ) )
            {
            // InternalSecDFD.g:5526:1: ( ( rule__Flow__AssetsAssignment_4_1 ) )
            // InternalSecDFD.g:5527:2: ( rule__Flow__AssetsAssignment_4_1 )
            {
             before(grammarAccess.getFlowAccess().getAssetsAssignment_4_1()); 
            // InternalSecDFD.g:5528:2: ( rule__Flow__AssetsAssignment_4_1 )
            // InternalSecDFD.g:5528:3: rule__Flow__AssetsAssignment_4_1
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
    // InternalSecDFD.g:5536:1: rule__Flow__Group_4__2 : rule__Flow__Group_4__2__Impl ;
    public final void rule__Flow__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5540:1: ( rule__Flow__Group_4__2__Impl )
            // InternalSecDFD.g:5541:2: rule__Flow__Group_4__2__Impl
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
    // InternalSecDFD.g:5547:1: rule__Flow__Group_4__2__Impl : ( ( rule__Flow__Group_4_2__0 )* ) ;
    public final void rule__Flow__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5551:1: ( ( ( rule__Flow__Group_4_2__0 )* ) )
            // InternalSecDFD.g:5552:1: ( ( rule__Flow__Group_4_2__0 )* )
            {
            // InternalSecDFD.g:5552:1: ( ( rule__Flow__Group_4_2__0 )* )
            // InternalSecDFD.g:5553:2: ( rule__Flow__Group_4_2__0 )*
            {
             before(grammarAccess.getFlowAccess().getGroup_4_2()); 
            // InternalSecDFD.g:5554:2: ( rule__Flow__Group_4_2__0 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==47) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalSecDFD.g:5554:3: rule__Flow__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Flow__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
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
    // InternalSecDFD.g:5563:1: rule__Flow__Group_4_2__0 : rule__Flow__Group_4_2__0__Impl rule__Flow__Group_4_2__1 ;
    public final void rule__Flow__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5567:1: ( rule__Flow__Group_4_2__0__Impl rule__Flow__Group_4_2__1 )
            // InternalSecDFD.g:5568:2: rule__Flow__Group_4_2__0__Impl rule__Flow__Group_4_2__1
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
    // InternalSecDFD.g:5575:1: rule__Flow__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Flow__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5579:1: ( ( ',' ) )
            // InternalSecDFD.g:5580:1: ( ',' )
            {
            // InternalSecDFD.g:5580:1: ( ',' )
            // InternalSecDFD.g:5581:2: ','
            {
             before(grammarAccess.getFlowAccess().getCommaKeyword_4_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:5590:1: rule__Flow__Group_4_2__1 : rule__Flow__Group_4_2__1__Impl ;
    public final void rule__Flow__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5594:1: ( rule__Flow__Group_4_2__1__Impl )
            // InternalSecDFD.g:5595:2: rule__Flow__Group_4_2__1__Impl
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
    // InternalSecDFD.g:5601:1: rule__Flow__Group_4_2__1__Impl : ( ( rule__Flow__AssetsAssignment_4_2_1 ) ) ;
    public final void rule__Flow__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5605:1: ( ( ( rule__Flow__AssetsAssignment_4_2_1 ) ) )
            // InternalSecDFD.g:5606:1: ( ( rule__Flow__AssetsAssignment_4_2_1 ) )
            {
            // InternalSecDFD.g:5606:1: ( ( rule__Flow__AssetsAssignment_4_2_1 ) )
            // InternalSecDFD.g:5607:2: ( rule__Flow__AssetsAssignment_4_2_1 )
            {
             before(grammarAccess.getFlowAccess().getAssetsAssignment_4_2_1()); 
            // InternalSecDFD.g:5608:2: ( rule__Flow__AssetsAssignment_4_2_1 )
            // InternalSecDFD.g:5608:3: rule__Flow__AssetsAssignment_4_2_1
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
    // InternalSecDFD.g:5617:1: rule__Flow__Group_5__0 : rule__Flow__Group_5__0__Impl rule__Flow__Group_5__1 ;
    public final void rule__Flow__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5621:1: ( rule__Flow__Group_5__0__Impl rule__Flow__Group_5__1 )
            // InternalSecDFD.g:5622:2: rule__Flow__Group_5__0__Impl rule__Flow__Group_5__1
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
    // InternalSecDFD.g:5629:1: rule__Flow__Group_5__0__Impl : ( 'source:' ) ;
    public final void rule__Flow__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5633:1: ( ( 'source:' ) )
            // InternalSecDFD.g:5634:1: ( 'source:' )
            {
            // InternalSecDFD.g:5634:1: ( 'source:' )
            // InternalSecDFD.g:5635:2: 'source:'
            {
             before(grammarAccess.getFlowAccess().getSourceKeyword_5_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalSecDFD.g:5644:1: rule__Flow__Group_5__1 : rule__Flow__Group_5__1__Impl ;
    public final void rule__Flow__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5648:1: ( rule__Flow__Group_5__1__Impl )
            // InternalSecDFD.g:5649:2: rule__Flow__Group_5__1__Impl
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
    // InternalSecDFD.g:5655:1: rule__Flow__Group_5__1__Impl : ( ( rule__Flow__SourceAssignment_5_1 ) ) ;
    public final void rule__Flow__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5659:1: ( ( ( rule__Flow__SourceAssignment_5_1 ) ) )
            // InternalSecDFD.g:5660:1: ( ( rule__Flow__SourceAssignment_5_1 ) )
            {
            // InternalSecDFD.g:5660:1: ( ( rule__Flow__SourceAssignment_5_1 ) )
            // InternalSecDFD.g:5661:2: ( rule__Flow__SourceAssignment_5_1 )
            {
             before(grammarAccess.getFlowAccess().getSourceAssignment_5_1()); 
            // InternalSecDFD.g:5662:2: ( rule__Flow__SourceAssignment_5_1 )
            // InternalSecDFD.g:5662:3: rule__Flow__SourceAssignment_5_1
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
    // InternalSecDFD.g:5671:1: rule__Flow__Group_6__0 : rule__Flow__Group_6__0__Impl rule__Flow__Group_6__1 ;
    public final void rule__Flow__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5675:1: ( rule__Flow__Group_6__0__Impl rule__Flow__Group_6__1 )
            // InternalSecDFD.g:5676:2: rule__Flow__Group_6__0__Impl rule__Flow__Group_6__1
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
    // InternalSecDFD.g:5683:1: rule__Flow__Group_6__0__Impl : ( 'targets:' ) ;
    public final void rule__Flow__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5687:1: ( ( 'targets:' ) )
            // InternalSecDFD.g:5688:1: ( 'targets:' )
            {
            // InternalSecDFD.g:5688:1: ( 'targets:' )
            // InternalSecDFD.g:5689:2: 'targets:'
            {
             before(grammarAccess.getFlowAccess().getTargetsKeyword_6_0()); 
            match(input,58,FOLLOW_2); 
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
    // InternalSecDFD.g:5698:1: rule__Flow__Group_6__1 : rule__Flow__Group_6__1__Impl rule__Flow__Group_6__2 ;
    public final void rule__Flow__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5702:1: ( rule__Flow__Group_6__1__Impl rule__Flow__Group_6__2 )
            // InternalSecDFD.g:5703:2: rule__Flow__Group_6__1__Impl rule__Flow__Group_6__2
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
    // InternalSecDFD.g:5710:1: rule__Flow__Group_6__1__Impl : ( ( rule__Flow__TargetAssignment_6_1 ) ) ;
    public final void rule__Flow__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5714:1: ( ( ( rule__Flow__TargetAssignment_6_1 ) ) )
            // InternalSecDFD.g:5715:1: ( ( rule__Flow__TargetAssignment_6_1 ) )
            {
            // InternalSecDFD.g:5715:1: ( ( rule__Flow__TargetAssignment_6_1 ) )
            // InternalSecDFD.g:5716:2: ( rule__Flow__TargetAssignment_6_1 )
            {
             before(grammarAccess.getFlowAccess().getTargetAssignment_6_1()); 
            // InternalSecDFD.g:5717:2: ( rule__Flow__TargetAssignment_6_1 )
            // InternalSecDFD.g:5717:3: rule__Flow__TargetAssignment_6_1
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
    // InternalSecDFD.g:5725:1: rule__Flow__Group_6__2 : rule__Flow__Group_6__2__Impl ;
    public final void rule__Flow__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5729:1: ( rule__Flow__Group_6__2__Impl )
            // InternalSecDFD.g:5730:2: rule__Flow__Group_6__2__Impl
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
    // InternalSecDFD.g:5736:1: rule__Flow__Group_6__2__Impl : ( ( rule__Flow__Group_6_2__0 )* ) ;
    public final void rule__Flow__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5740:1: ( ( ( rule__Flow__Group_6_2__0 )* ) )
            // InternalSecDFD.g:5741:1: ( ( rule__Flow__Group_6_2__0 )* )
            {
            // InternalSecDFD.g:5741:1: ( ( rule__Flow__Group_6_2__0 )* )
            // InternalSecDFD.g:5742:2: ( rule__Flow__Group_6_2__0 )*
            {
             before(grammarAccess.getFlowAccess().getGroup_6_2()); 
            // InternalSecDFD.g:5743:2: ( rule__Flow__Group_6_2__0 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==47) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalSecDFD.g:5743:3: rule__Flow__Group_6_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Flow__Group_6_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
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
    // InternalSecDFD.g:5752:1: rule__Flow__Group_6_2__0 : rule__Flow__Group_6_2__0__Impl rule__Flow__Group_6_2__1 ;
    public final void rule__Flow__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5756:1: ( rule__Flow__Group_6_2__0__Impl rule__Flow__Group_6_2__1 )
            // InternalSecDFD.g:5757:2: rule__Flow__Group_6_2__0__Impl rule__Flow__Group_6_2__1
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
    // InternalSecDFD.g:5764:1: rule__Flow__Group_6_2__0__Impl : ( ',' ) ;
    public final void rule__Flow__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5768:1: ( ( ',' ) )
            // InternalSecDFD.g:5769:1: ( ',' )
            {
            // InternalSecDFD.g:5769:1: ( ',' )
            // InternalSecDFD.g:5770:2: ','
            {
             before(grammarAccess.getFlowAccess().getCommaKeyword_6_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:5779:1: rule__Flow__Group_6_2__1 : rule__Flow__Group_6_2__1__Impl ;
    public final void rule__Flow__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5783:1: ( rule__Flow__Group_6_2__1__Impl )
            // InternalSecDFD.g:5784:2: rule__Flow__Group_6_2__1__Impl
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
    // InternalSecDFD.g:5790:1: rule__Flow__Group_6_2__1__Impl : ( ( rule__Flow__TargetAssignment_6_2_1 ) ) ;
    public final void rule__Flow__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5794:1: ( ( ( rule__Flow__TargetAssignment_6_2_1 ) ) )
            // InternalSecDFD.g:5795:1: ( ( rule__Flow__TargetAssignment_6_2_1 ) )
            {
            // InternalSecDFD.g:5795:1: ( ( rule__Flow__TargetAssignment_6_2_1 ) )
            // InternalSecDFD.g:5796:2: ( rule__Flow__TargetAssignment_6_2_1 )
            {
             before(grammarAccess.getFlowAccess().getTargetAssignment_6_2_1()); 
            // InternalSecDFD.g:5797:2: ( rule__Flow__TargetAssignment_6_2_1 )
            // InternalSecDFD.g:5797:3: rule__Flow__TargetAssignment_6_2_1
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
    // InternalSecDFD.g:5806:1: rule__Flow__Group_7__0 : rule__Flow__Group_7__0__Impl rule__Flow__Group_7__1 ;
    public final void rule__Flow__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5810:1: ( rule__Flow__Group_7__0__Impl rule__Flow__Group_7__1 )
            // InternalSecDFD.g:5811:2: rule__Flow__Group_7__0__Impl rule__Flow__Group_7__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalSecDFD.g:5818:1: rule__Flow__Group_7__0__Impl : ( 'channel' ) ;
    public final void rule__Flow__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5822:1: ( ( 'channel' ) )
            // InternalSecDFD.g:5823:1: ( 'channel' )
            {
            // InternalSecDFD.g:5823:1: ( 'channel' )
            // InternalSecDFD.g:5824:2: 'channel'
            {
             before(grammarAccess.getFlowAccess().getChannelKeyword_7_0()); 
            match(input,70,FOLLOW_2); 
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
    // InternalSecDFD.g:5833:1: rule__Flow__Group_7__1 : rule__Flow__Group_7__1__Impl ;
    public final void rule__Flow__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5837:1: ( rule__Flow__Group_7__1__Impl )
            // InternalSecDFD.g:5838:2: rule__Flow__Group_7__1__Impl
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
    // InternalSecDFD.g:5844:1: rule__Flow__Group_7__1__Impl : ( ( rule__Flow__ChannelAssignment_7_1 ) ) ;
    public final void rule__Flow__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5848:1: ( ( ( rule__Flow__ChannelAssignment_7_1 ) ) )
            // InternalSecDFD.g:5849:1: ( ( rule__Flow__ChannelAssignment_7_1 ) )
            {
            // InternalSecDFD.g:5849:1: ( ( rule__Flow__ChannelAssignment_7_1 ) )
            // InternalSecDFD.g:5850:2: ( rule__Flow__ChannelAssignment_7_1 )
            {
             before(grammarAccess.getFlowAccess().getChannelAssignment_7_1()); 
            // InternalSecDFD.g:5851:2: ( rule__Flow__ChannelAssignment_7_1 )
            // InternalSecDFD.g:5851:3: rule__Flow__ChannelAssignment_7_1
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
    // InternalSecDFD.g:5860:1: rule__Flow__Group_8__0 : rule__Flow__Group_8__0__Impl rule__Flow__Group_8__1 ;
    public final void rule__Flow__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5864:1: ( rule__Flow__Group_8__0__Impl rule__Flow__Group_8__1 )
            // InternalSecDFD.g:5865:2: rule__Flow__Group_8__0__Impl rule__Flow__Group_8__1
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
    // InternalSecDFD.g:5872:1: rule__Flow__Group_8__0__Impl : ( 'assumption:' ) ;
    public final void rule__Flow__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5876:1: ( ( 'assumption:' ) )
            // InternalSecDFD.g:5877:1: ( 'assumption:' )
            {
            // InternalSecDFD.g:5877:1: ( 'assumption:' )
            // InternalSecDFD.g:5878:2: 'assumption:'
            {
             before(grammarAccess.getFlowAccess().getAssumptionKeyword_8_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalSecDFD.g:5887:1: rule__Flow__Group_8__1 : rule__Flow__Group_8__1__Impl rule__Flow__Group_8__2 ;
    public final void rule__Flow__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5891:1: ( rule__Flow__Group_8__1__Impl rule__Flow__Group_8__2 )
            // InternalSecDFD.g:5892:2: rule__Flow__Group_8__1__Impl rule__Flow__Group_8__2
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
    // InternalSecDFD.g:5899:1: rule__Flow__Group_8__1__Impl : ( ( rule__Flow__AssumptionAssignment_8_1 ) ) ;
    public final void rule__Flow__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5903:1: ( ( ( rule__Flow__AssumptionAssignment_8_1 ) ) )
            // InternalSecDFD.g:5904:1: ( ( rule__Flow__AssumptionAssignment_8_1 ) )
            {
            // InternalSecDFD.g:5904:1: ( ( rule__Flow__AssumptionAssignment_8_1 ) )
            // InternalSecDFD.g:5905:2: ( rule__Flow__AssumptionAssignment_8_1 )
            {
             before(grammarAccess.getFlowAccess().getAssumptionAssignment_8_1()); 
            // InternalSecDFD.g:5906:2: ( rule__Flow__AssumptionAssignment_8_1 )
            // InternalSecDFD.g:5906:3: rule__Flow__AssumptionAssignment_8_1
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
    // InternalSecDFD.g:5914:1: rule__Flow__Group_8__2 : rule__Flow__Group_8__2__Impl ;
    public final void rule__Flow__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5918:1: ( rule__Flow__Group_8__2__Impl )
            // InternalSecDFD.g:5919:2: rule__Flow__Group_8__2__Impl
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
    // InternalSecDFD.g:5925:1: rule__Flow__Group_8__2__Impl : ( ( rule__Flow__Group_8_2__0 )* ) ;
    public final void rule__Flow__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5929:1: ( ( ( rule__Flow__Group_8_2__0 )* ) )
            // InternalSecDFD.g:5930:1: ( ( rule__Flow__Group_8_2__0 )* )
            {
            // InternalSecDFD.g:5930:1: ( ( rule__Flow__Group_8_2__0 )* )
            // InternalSecDFD.g:5931:2: ( rule__Flow__Group_8_2__0 )*
            {
             before(grammarAccess.getFlowAccess().getGroup_8_2()); 
            // InternalSecDFD.g:5932:2: ( rule__Flow__Group_8_2__0 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==47) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalSecDFD.g:5932:3: rule__Flow__Group_8_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Flow__Group_8_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
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
    // InternalSecDFD.g:5941:1: rule__Flow__Group_8_2__0 : rule__Flow__Group_8_2__0__Impl rule__Flow__Group_8_2__1 ;
    public final void rule__Flow__Group_8_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5945:1: ( rule__Flow__Group_8_2__0__Impl rule__Flow__Group_8_2__1 )
            // InternalSecDFD.g:5946:2: rule__Flow__Group_8_2__0__Impl rule__Flow__Group_8_2__1
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
    // InternalSecDFD.g:5953:1: rule__Flow__Group_8_2__0__Impl : ( ',' ) ;
    public final void rule__Flow__Group_8_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5957:1: ( ( ',' ) )
            // InternalSecDFD.g:5958:1: ( ',' )
            {
            // InternalSecDFD.g:5958:1: ( ',' )
            // InternalSecDFD.g:5959:2: ','
            {
             before(grammarAccess.getFlowAccess().getCommaKeyword_8_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:5968:1: rule__Flow__Group_8_2__1 : rule__Flow__Group_8_2__1__Impl ;
    public final void rule__Flow__Group_8_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5972:1: ( rule__Flow__Group_8_2__1__Impl )
            // InternalSecDFD.g:5973:2: rule__Flow__Group_8_2__1__Impl
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
    // InternalSecDFD.g:5979:1: rule__Flow__Group_8_2__1__Impl : ( ( rule__Flow__AssumptionAssignment_8_2_1 ) ) ;
    public final void rule__Flow__Group_8_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5983:1: ( ( ( rule__Flow__AssumptionAssignment_8_2_1 ) ) )
            // InternalSecDFD.g:5984:1: ( ( rule__Flow__AssumptionAssignment_8_2_1 ) )
            {
            // InternalSecDFD.g:5984:1: ( ( rule__Flow__AssumptionAssignment_8_2_1 ) )
            // InternalSecDFD.g:5985:2: ( rule__Flow__AssumptionAssignment_8_2_1 )
            {
             before(grammarAccess.getFlowAccess().getAssumptionAssignment_8_2_1()); 
            // InternalSecDFD.g:5986:2: ( rule__Flow__AssumptionAssignment_8_2_1 )
            // InternalSecDFD.g:5986:3: rule__Flow__AssumptionAssignment_8_2_1
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
    // InternalSecDFD.g:5995:1: rule__DataStore__Group__0 : rule__DataStore__Group__0__Impl rule__DataStore__Group__1 ;
    public final void rule__DataStore__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:5999:1: ( rule__DataStore__Group__0__Impl rule__DataStore__Group__1 )
            // InternalSecDFD.g:6000:2: rule__DataStore__Group__0__Impl rule__DataStore__Group__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalSecDFD.g:6007:1: rule__DataStore__Group__0__Impl : ( () ) ;
    public final void rule__DataStore__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6011:1: ( ( () ) )
            // InternalSecDFD.g:6012:1: ( () )
            {
            // InternalSecDFD.g:6012:1: ( () )
            // InternalSecDFD.g:6013:2: ()
            {
             before(grammarAccess.getDataStoreAccess().getDataStoreAction_0()); 
            // InternalSecDFD.g:6014:2: ()
            // InternalSecDFD.g:6014:3: 
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
    // InternalSecDFD.g:6022:1: rule__DataStore__Group__1 : rule__DataStore__Group__1__Impl rule__DataStore__Group__2 ;
    public final void rule__DataStore__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6026:1: ( rule__DataStore__Group__1__Impl rule__DataStore__Group__2 )
            // InternalSecDFD.g:6027:2: rule__DataStore__Group__1__Impl rule__DataStore__Group__2
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
    // InternalSecDFD.g:6034:1: rule__DataStore__Group__1__Impl : ( 'DataStore' ) ;
    public final void rule__DataStore__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6038:1: ( ( 'DataStore' ) )
            // InternalSecDFD.g:6039:1: ( 'DataStore' )
            {
            // InternalSecDFD.g:6039:1: ( 'DataStore' )
            // InternalSecDFD.g:6040:2: 'DataStore'
            {
             before(grammarAccess.getDataStoreAccess().getDataStoreKeyword_1()); 
            match(input,71,FOLLOW_2); 
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
    // InternalSecDFD.g:6049:1: rule__DataStore__Group__2 : rule__DataStore__Group__2__Impl rule__DataStore__Group__3 ;
    public final void rule__DataStore__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6053:1: ( rule__DataStore__Group__2__Impl rule__DataStore__Group__3 )
            // InternalSecDFD.g:6054:2: rule__DataStore__Group__2__Impl rule__DataStore__Group__3
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
    // InternalSecDFD.g:6061:1: rule__DataStore__Group__2__Impl : ( ( rule__DataStore__NameAssignment_2 ) ) ;
    public final void rule__DataStore__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6065:1: ( ( ( rule__DataStore__NameAssignment_2 ) ) )
            // InternalSecDFD.g:6066:1: ( ( rule__DataStore__NameAssignment_2 ) )
            {
            // InternalSecDFD.g:6066:1: ( ( rule__DataStore__NameAssignment_2 ) )
            // InternalSecDFD.g:6067:2: ( rule__DataStore__NameAssignment_2 )
            {
             before(grammarAccess.getDataStoreAccess().getNameAssignment_2()); 
            // InternalSecDFD.g:6068:2: ( rule__DataStore__NameAssignment_2 )
            // InternalSecDFD.g:6068:3: rule__DataStore__NameAssignment_2
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
    // InternalSecDFD.g:6076:1: rule__DataStore__Group__3 : rule__DataStore__Group__3__Impl rule__DataStore__Group__4 ;
    public final void rule__DataStore__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6080:1: ( rule__DataStore__Group__3__Impl rule__DataStore__Group__4 )
            // InternalSecDFD.g:6081:2: rule__DataStore__Group__3__Impl rule__DataStore__Group__4
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:6088:1: rule__DataStore__Group__3__Impl : ( '[' ) ;
    public final void rule__DataStore__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6092:1: ( ( '[' ) )
            // InternalSecDFD.g:6093:1: ( '[' )
            {
            // InternalSecDFD.g:6093:1: ( '[' )
            // InternalSecDFD.g:6094:2: '['
            {
             before(grammarAccess.getDataStoreAccess().getLeftSquareBracketKeyword_3()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:6103:1: rule__DataStore__Group__4 : rule__DataStore__Group__4__Impl rule__DataStore__Group__5 ;
    public final void rule__DataStore__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6107:1: ( rule__DataStore__Group__4__Impl rule__DataStore__Group__5 )
            // InternalSecDFD.g:6108:2: rule__DataStore__Group__4__Impl rule__DataStore__Group__5
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:6115:1: rule__DataStore__Group__4__Impl : ( ( rule__DataStore__Group_4__0 )? ) ;
    public final void rule__DataStore__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6119:1: ( ( ( rule__DataStore__Group_4__0 )? ) )
            // InternalSecDFD.g:6120:1: ( ( rule__DataStore__Group_4__0 )? )
            {
            // InternalSecDFD.g:6120:1: ( ( rule__DataStore__Group_4__0 )? )
            // InternalSecDFD.g:6121:2: ( rule__DataStore__Group_4__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_4()); 
            // InternalSecDFD.g:6122:2: ( rule__DataStore__Group_4__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==46) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalSecDFD.g:6122:3: rule__DataStore__Group_4__0
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
    // InternalSecDFD.g:6130:1: rule__DataStore__Group__5 : rule__DataStore__Group__5__Impl rule__DataStore__Group__6 ;
    public final void rule__DataStore__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6134:1: ( rule__DataStore__Group__5__Impl rule__DataStore__Group__6 )
            // InternalSecDFD.g:6135:2: rule__DataStore__Group__5__Impl rule__DataStore__Group__6
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:6142:1: rule__DataStore__Group__5__Impl : ( ( rule__DataStore__Group_5__0 )? ) ;
    public final void rule__DataStore__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6146:1: ( ( ( rule__DataStore__Group_5__0 )? ) )
            // InternalSecDFD.g:6147:1: ( ( rule__DataStore__Group_5__0 )? )
            {
            // InternalSecDFD.g:6147:1: ( ( rule__DataStore__Group_5__0 )? )
            // InternalSecDFD.g:6148:2: ( rule__DataStore__Group_5__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_5()); 
            // InternalSecDFD.g:6149:2: ( rule__DataStore__Group_5__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==62) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalSecDFD.g:6149:3: rule__DataStore__Group_5__0
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
    // InternalSecDFD.g:6157:1: rule__DataStore__Group__6 : rule__DataStore__Group__6__Impl rule__DataStore__Group__7 ;
    public final void rule__DataStore__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6161:1: ( rule__DataStore__Group__6__Impl rule__DataStore__Group__7 )
            // InternalSecDFD.g:6162:2: rule__DataStore__Group__6__Impl rule__DataStore__Group__7
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:6169:1: rule__DataStore__Group__6__Impl : ( ( rule__DataStore__Group_6__0 )? ) ;
    public final void rule__DataStore__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6173:1: ( ( ( rule__DataStore__Group_6__0 )? ) )
            // InternalSecDFD.g:6174:1: ( ( rule__DataStore__Group_6__0 )? )
            {
            // InternalSecDFD.g:6174:1: ( ( rule__DataStore__Group_6__0 )? )
            // InternalSecDFD.g:6175:2: ( rule__DataStore__Group_6__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_6()); 
            // InternalSecDFD.g:6176:2: ( rule__DataStore__Group_6__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==63) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalSecDFD.g:6176:3: rule__DataStore__Group_6__0
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
    // InternalSecDFD.g:6184:1: rule__DataStore__Group__7 : rule__DataStore__Group__7__Impl rule__DataStore__Group__8 ;
    public final void rule__DataStore__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6188:1: ( rule__DataStore__Group__7__Impl rule__DataStore__Group__8 )
            // InternalSecDFD.g:6189:2: rule__DataStore__Group__7__Impl rule__DataStore__Group__8
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:6196:1: rule__DataStore__Group__7__Impl : ( ( rule__DataStore__Group_7__0 )? ) ;
    public final void rule__DataStore__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6200:1: ( ( ( rule__DataStore__Group_7__0 )? ) )
            // InternalSecDFD.g:6201:1: ( ( rule__DataStore__Group_7__0 )? )
            {
            // InternalSecDFD.g:6201:1: ( ( rule__DataStore__Group_7__0 )? )
            // InternalSecDFD.g:6202:2: ( rule__DataStore__Group_7__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_7()); 
            // InternalSecDFD.g:6203:2: ( rule__DataStore__Group_7__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==65) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalSecDFD.g:6203:3: rule__DataStore__Group_7__0
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
    // InternalSecDFD.g:6211:1: rule__DataStore__Group__8 : rule__DataStore__Group__8__Impl rule__DataStore__Group__9 ;
    public final void rule__DataStore__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6215:1: ( rule__DataStore__Group__8__Impl rule__DataStore__Group__9 )
            // InternalSecDFD.g:6216:2: rule__DataStore__Group__8__Impl rule__DataStore__Group__9
            {
            pushFollow(FOLLOW_29);
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
    // InternalSecDFD.g:6223:1: rule__DataStore__Group__8__Impl : ( ( rule__DataStore__Group_8__0 )? ) ;
    public final void rule__DataStore__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6227:1: ( ( ( rule__DataStore__Group_8__0 )? ) )
            // InternalSecDFD.g:6228:1: ( ( rule__DataStore__Group_8__0 )? )
            {
            // InternalSecDFD.g:6228:1: ( ( rule__DataStore__Group_8__0 )? )
            // InternalSecDFD.g:6229:2: ( rule__DataStore__Group_8__0 )?
            {
             before(grammarAccess.getDataStoreAccess().getGroup_8()); 
            // InternalSecDFD.g:6230:2: ( rule__DataStore__Group_8__0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==66) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalSecDFD.g:6230:3: rule__DataStore__Group_8__0
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
    // InternalSecDFD.g:6238:1: rule__DataStore__Group__9 : rule__DataStore__Group__9__Impl ;
    public final void rule__DataStore__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6242:1: ( rule__DataStore__Group__9__Impl )
            // InternalSecDFD.g:6243:2: rule__DataStore__Group__9__Impl
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
    // InternalSecDFD.g:6249:1: rule__DataStore__Group__9__Impl : ( ']' ) ;
    public final void rule__DataStore__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6253:1: ( ( ']' ) )
            // InternalSecDFD.g:6254:1: ( ']' )
            {
            // InternalSecDFD.g:6254:1: ( ']' )
            // InternalSecDFD.g:6255:2: ']'
            {
             before(grammarAccess.getDataStoreAccess().getRightSquareBracketKeyword_9()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:6265:1: rule__DataStore__Group_4__0 : rule__DataStore__Group_4__0__Impl rule__DataStore__Group_4__1 ;
    public final void rule__DataStore__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6269:1: ( rule__DataStore__Group_4__0__Impl rule__DataStore__Group_4__1 )
            // InternalSecDFD.g:6270:2: rule__DataStore__Group_4__0__Impl rule__DataStore__Group_4__1
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
    // InternalSecDFD.g:6277:1: rule__DataStore__Group_4__0__Impl : ( 'assets:' ) ;
    public final void rule__DataStore__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6281:1: ( ( 'assets:' ) )
            // InternalSecDFD.g:6282:1: ( 'assets:' )
            {
            // InternalSecDFD.g:6282:1: ( 'assets:' )
            // InternalSecDFD.g:6283:2: 'assets:'
            {
             before(grammarAccess.getDataStoreAccess().getAssetsKeyword_4_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalSecDFD.g:6292:1: rule__DataStore__Group_4__1 : rule__DataStore__Group_4__1__Impl rule__DataStore__Group_4__2 ;
    public final void rule__DataStore__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6296:1: ( rule__DataStore__Group_4__1__Impl rule__DataStore__Group_4__2 )
            // InternalSecDFD.g:6297:2: rule__DataStore__Group_4__1__Impl rule__DataStore__Group_4__2
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
    // InternalSecDFD.g:6304:1: rule__DataStore__Group_4__1__Impl : ( ( rule__DataStore__AssetsAssignment_4_1 ) ) ;
    public final void rule__DataStore__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6308:1: ( ( ( rule__DataStore__AssetsAssignment_4_1 ) ) )
            // InternalSecDFD.g:6309:1: ( ( rule__DataStore__AssetsAssignment_4_1 ) )
            {
            // InternalSecDFD.g:6309:1: ( ( rule__DataStore__AssetsAssignment_4_1 ) )
            // InternalSecDFD.g:6310:2: ( rule__DataStore__AssetsAssignment_4_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssignment_4_1()); 
            // InternalSecDFD.g:6311:2: ( rule__DataStore__AssetsAssignment_4_1 )
            // InternalSecDFD.g:6311:3: rule__DataStore__AssetsAssignment_4_1
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
    // InternalSecDFD.g:6319:1: rule__DataStore__Group_4__2 : rule__DataStore__Group_4__2__Impl ;
    public final void rule__DataStore__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6323:1: ( rule__DataStore__Group_4__2__Impl )
            // InternalSecDFD.g:6324:2: rule__DataStore__Group_4__2__Impl
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
    // InternalSecDFD.g:6330:1: rule__DataStore__Group_4__2__Impl : ( ( rule__DataStore__Group_4_2__0 )* ) ;
    public final void rule__DataStore__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6334:1: ( ( ( rule__DataStore__Group_4_2__0 )* ) )
            // InternalSecDFD.g:6335:1: ( ( rule__DataStore__Group_4_2__0 )* )
            {
            // InternalSecDFD.g:6335:1: ( ( rule__DataStore__Group_4_2__0 )* )
            // InternalSecDFD.g:6336:2: ( rule__DataStore__Group_4_2__0 )*
            {
             before(grammarAccess.getDataStoreAccess().getGroup_4_2()); 
            // InternalSecDFD.g:6337:2: ( rule__DataStore__Group_4_2__0 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==47) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalSecDFD.g:6337:3: rule__DataStore__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataStore__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop65;
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
    // InternalSecDFD.g:6346:1: rule__DataStore__Group_4_2__0 : rule__DataStore__Group_4_2__0__Impl rule__DataStore__Group_4_2__1 ;
    public final void rule__DataStore__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6350:1: ( rule__DataStore__Group_4_2__0__Impl rule__DataStore__Group_4_2__1 )
            // InternalSecDFD.g:6351:2: rule__DataStore__Group_4_2__0__Impl rule__DataStore__Group_4_2__1
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
    // InternalSecDFD.g:6358:1: rule__DataStore__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__DataStore__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6362:1: ( ( ',' ) )
            // InternalSecDFD.g:6363:1: ( ',' )
            {
            // InternalSecDFD.g:6363:1: ( ',' )
            // InternalSecDFD.g:6364:2: ','
            {
             before(grammarAccess.getDataStoreAccess().getCommaKeyword_4_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:6373:1: rule__DataStore__Group_4_2__1 : rule__DataStore__Group_4_2__1__Impl ;
    public final void rule__DataStore__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6377:1: ( rule__DataStore__Group_4_2__1__Impl )
            // InternalSecDFD.g:6378:2: rule__DataStore__Group_4_2__1__Impl
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
    // InternalSecDFD.g:6384:1: rule__DataStore__Group_4_2__1__Impl : ( ( rule__DataStore__AssetsAssignment_4_2_1 ) ) ;
    public final void rule__DataStore__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6388:1: ( ( ( rule__DataStore__AssetsAssignment_4_2_1 ) ) )
            // InternalSecDFD.g:6389:1: ( ( rule__DataStore__AssetsAssignment_4_2_1 ) )
            {
            // InternalSecDFD.g:6389:1: ( ( rule__DataStore__AssetsAssignment_4_2_1 ) )
            // InternalSecDFD.g:6390:2: ( rule__DataStore__AssetsAssignment_4_2_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssignment_4_2_1()); 
            // InternalSecDFD.g:6391:2: ( rule__DataStore__AssetsAssignment_4_2_1 )
            // InternalSecDFD.g:6391:3: rule__DataStore__AssetsAssignment_4_2_1
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
    // InternalSecDFD.g:6400:1: rule__DataStore__Group_5__0 : rule__DataStore__Group_5__0__Impl rule__DataStore__Group_5__1 ;
    public final void rule__DataStore__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6404:1: ( rule__DataStore__Group_5__0__Impl rule__DataStore__Group_5__1 )
            // InternalSecDFD.g:6405:2: rule__DataStore__Group_5__0__Impl rule__DataStore__Group_5__1
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
    // InternalSecDFD.g:6412:1: rule__DataStore__Group_5__0__Impl : ( 'assumption:' ) ;
    public final void rule__DataStore__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6416:1: ( ( 'assumption:' ) )
            // InternalSecDFD.g:6417:1: ( 'assumption:' )
            {
            // InternalSecDFD.g:6417:1: ( 'assumption:' )
            // InternalSecDFD.g:6418:2: 'assumption:'
            {
             before(grammarAccess.getDataStoreAccess().getAssumptionKeyword_5_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalSecDFD.g:6427:1: rule__DataStore__Group_5__1 : rule__DataStore__Group_5__1__Impl rule__DataStore__Group_5__2 ;
    public final void rule__DataStore__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6431:1: ( rule__DataStore__Group_5__1__Impl rule__DataStore__Group_5__2 )
            // InternalSecDFD.g:6432:2: rule__DataStore__Group_5__1__Impl rule__DataStore__Group_5__2
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
    // InternalSecDFD.g:6439:1: rule__DataStore__Group_5__1__Impl : ( ( rule__DataStore__AssumptionAssignment_5_1 ) ) ;
    public final void rule__DataStore__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6443:1: ( ( ( rule__DataStore__AssumptionAssignment_5_1 ) ) )
            // InternalSecDFD.g:6444:1: ( ( rule__DataStore__AssumptionAssignment_5_1 ) )
            {
            // InternalSecDFD.g:6444:1: ( ( rule__DataStore__AssumptionAssignment_5_1 ) )
            // InternalSecDFD.g:6445:2: ( rule__DataStore__AssumptionAssignment_5_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAssumptionAssignment_5_1()); 
            // InternalSecDFD.g:6446:2: ( rule__DataStore__AssumptionAssignment_5_1 )
            // InternalSecDFD.g:6446:3: rule__DataStore__AssumptionAssignment_5_1
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
    // InternalSecDFD.g:6454:1: rule__DataStore__Group_5__2 : rule__DataStore__Group_5__2__Impl ;
    public final void rule__DataStore__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6458:1: ( rule__DataStore__Group_5__2__Impl )
            // InternalSecDFD.g:6459:2: rule__DataStore__Group_5__2__Impl
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
    // InternalSecDFD.g:6465:1: rule__DataStore__Group_5__2__Impl : ( ( rule__DataStore__Group_5_2__0 )* ) ;
    public final void rule__DataStore__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6469:1: ( ( ( rule__DataStore__Group_5_2__0 )* ) )
            // InternalSecDFD.g:6470:1: ( ( rule__DataStore__Group_5_2__0 )* )
            {
            // InternalSecDFD.g:6470:1: ( ( rule__DataStore__Group_5_2__0 )* )
            // InternalSecDFD.g:6471:2: ( rule__DataStore__Group_5_2__0 )*
            {
             before(grammarAccess.getDataStoreAccess().getGroup_5_2()); 
            // InternalSecDFD.g:6472:2: ( rule__DataStore__Group_5_2__0 )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==47) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalSecDFD.g:6472:3: rule__DataStore__Group_5_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataStore__Group_5_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop66;
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
    // InternalSecDFD.g:6481:1: rule__DataStore__Group_5_2__0 : rule__DataStore__Group_5_2__0__Impl rule__DataStore__Group_5_2__1 ;
    public final void rule__DataStore__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6485:1: ( rule__DataStore__Group_5_2__0__Impl rule__DataStore__Group_5_2__1 )
            // InternalSecDFD.g:6486:2: rule__DataStore__Group_5_2__0__Impl rule__DataStore__Group_5_2__1
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
    // InternalSecDFD.g:6493:1: rule__DataStore__Group_5_2__0__Impl : ( ',' ) ;
    public final void rule__DataStore__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6497:1: ( ( ',' ) )
            // InternalSecDFD.g:6498:1: ( ',' )
            {
            // InternalSecDFD.g:6498:1: ( ',' )
            // InternalSecDFD.g:6499:2: ','
            {
             before(grammarAccess.getDataStoreAccess().getCommaKeyword_5_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:6508:1: rule__DataStore__Group_5_2__1 : rule__DataStore__Group_5_2__1__Impl ;
    public final void rule__DataStore__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6512:1: ( rule__DataStore__Group_5_2__1__Impl )
            // InternalSecDFD.g:6513:2: rule__DataStore__Group_5_2__1__Impl
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
    // InternalSecDFD.g:6519:1: rule__DataStore__Group_5_2__1__Impl : ( ( rule__DataStore__AssumptionAssignment_5_2_1 ) ) ;
    public final void rule__DataStore__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6523:1: ( ( ( rule__DataStore__AssumptionAssignment_5_2_1 ) ) )
            // InternalSecDFD.g:6524:1: ( ( rule__DataStore__AssumptionAssignment_5_2_1 ) )
            {
            // InternalSecDFD.g:6524:1: ( ( rule__DataStore__AssumptionAssignment_5_2_1 ) )
            // InternalSecDFD.g:6525:2: ( rule__DataStore__AssumptionAssignment_5_2_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAssumptionAssignment_5_2_1()); 
            // InternalSecDFD.g:6526:2: ( rule__DataStore__AssumptionAssignment_5_2_1 )
            // InternalSecDFD.g:6526:3: rule__DataStore__AssumptionAssignment_5_2_1
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
    // InternalSecDFD.g:6535:1: rule__DataStore__Group_6__0 : rule__DataStore__Group_6__0__Impl rule__DataStore__Group_6__1 ;
    public final void rule__DataStore__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6539:1: ( rule__DataStore__Group_6__0__Impl rule__DataStore__Group_6__1 )
            // InternalSecDFD.g:6540:2: rule__DataStore__Group_6__0__Impl rule__DataStore__Group_6__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalSecDFD.g:6547:1: rule__DataStore__Group_6__0__Impl : ( 'incoming' ) ;
    public final void rule__DataStore__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6551:1: ( ( 'incoming' ) )
            // InternalSecDFD.g:6552:1: ( 'incoming' )
            {
            // InternalSecDFD.g:6552:1: ( 'incoming' )
            // InternalSecDFD.g:6553:2: 'incoming'
            {
             before(grammarAccess.getDataStoreAccess().getIncomingKeyword_6_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalSecDFD.g:6562:1: rule__DataStore__Group_6__1 : rule__DataStore__Group_6__1__Impl rule__DataStore__Group_6__2 ;
    public final void rule__DataStore__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6566:1: ( rule__DataStore__Group_6__1__Impl rule__DataStore__Group_6__2 )
            // InternalSecDFD.g:6567:2: rule__DataStore__Group_6__1__Impl rule__DataStore__Group_6__2
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
    // InternalSecDFD.g:6574:1: rule__DataStore__Group_6__1__Impl : ( 'flows:' ) ;
    public final void rule__DataStore__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6578:1: ( ( 'flows:' ) )
            // InternalSecDFD.g:6579:1: ( 'flows:' )
            {
            // InternalSecDFD.g:6579:1: ( 'flows:' )
            // InternalSecDFD.g:6580:2: 'flows:'
            {
             before(grammarAccess.getDataStoreAccess().getFlowsKeyword_6_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalSecDFD.g:6589:1: rule__DataStore__Group_6__2 : rule__DataStore__Group_6__2__Impl rule__DataStore__Group_6__3 ;
    public final void rule__DataStore__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6593:1: ( rule__DataStore__Group_6__2__Impl rule__DataStore__Group_6__3 )
            // InternalSecDFD.g:6594:2: rule__DataStore__Group_6__2__Impl rule__DataStore__Group_6__3
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
    // InternalSecDFD.g:6601:1: rule__DataStore__Group_6__2__Impl : ( ( rule__DataStore__InflowsAssignment_6_2 ) ) ;
    public final void rule__DataStore__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6605:1: ( ( ( rule__DataStore__InflowsAssignment_6_2 ) ) )
            // InternalSecDFD.g:6606:1: ( ( rule__DataStore__InflowsAssignment_6_2 ) )
            {
            // InternalSecDFD.g:6606:1: ( ( rule__DataStore__InflowsAssignment_6_2 ) )
            // InternalSecDFD.g:6607:2: ( rule__DataStore__InflowsAssignment_6_2 )
            {
             before(grammarAccess.getDataStoreAccess().getInflowsAssignment_6_2()); 
            // InternalSecDFD.g:6608:2: ( rule__DataStore__InflowsAssignment_6_2 )
            // InternalSecDFD.g:6608:3: rule__DataStore__InflowsAssignment_6_2
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
    // InternalSecDFD.g:6616:1: rule__DataStore__Group_6__3 : rule__DataStore__Group_6__3__Impl ;
    public final void rule__DataStore__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6620:1: ( rule__DataStore__Group_6__3__Impl )
            // InternalSecDFD.g:6621:2: rule__DataStore__Group_6__3__Impl
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
    // InternalSecDFD.g:6627:1: rule__DataStore__Group_6__3__Impl : ( ( rule__DataStore__Group_6_3__0 )* ) ;
    public final void rule__DataStore__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6631:1: ( ( ( rule__DataStore__Group_6_3__0 )* ) )
            // InternalSecDFD.g:6632:1: ( ( rule__DataStore__Group_6_3__0 )* )
            {
            // InternalSecDFD.g:6632:1: ( ( rule__DataStore__Group_6_3__0 )* )
            // InternalSecDFD.g:6633:2: ( rule__DataStore__Group_6_3__0 )*
            {
             before(grammarAccess.getDataStoreAccess().getGroup_6_3()); 
            // InternalSecDFD.g:6634:2: ( rule__DataStore__Group_6_3__0 )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==47) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalSecDFD.g:6634:3: rule__DataStore__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataStore__Group_6_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop67;
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
    // InternalSecDFD.g:6643:1: rule__DataStore__Group_6_3__0 : rule__DataStore__Group_6_3__0__Impl rule__DataStore__Group_6_3__1 ;
    public final void rule__DataStore__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6647:1: ( rule__DataStore__Group_6_3__0__Impl rule__DataStore__Group_6_3__1 )
            // InternalSecDFD.g:6648:2: rule__DataStore__Group_6_3__0__Impl rule__DataStore__Group_6_3__1
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
    // InternalSecDFD.g:6655:1: rule__DataStore__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__DataStore__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6659:1: ( ( ',' ) )
            // InternalSecDFD.g:6660:1: ( ',' )
            {
            // InternalSecDFD.g:6660:1: ( ',' )
            // InternalSecDFD.g:6661:2: ','
            {
             before(grammarAccess.getDataStoreAccess().getCommaKeyword_6_3_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:6670:1: rule__DataStore__Group_6_3__1 : rule__DataStore__Group_6_3__1__Impl ;
    public final void rule__DataStore__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6674:1: ( rule__DataStore__Group_6_3__1__Impl )
            // InternalSecDFD.g:6675:2: rule__DataStore__Group_6_3__1__Impl
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
    // InternalSecDFD.g:6681:1: rule__DataStore__Group_6_3__1__Impl : ( ( rule__DataStore__InflowsAssignment_6_3_1 ) ) ;
    public final void rule__DataStore__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6685:1: ( ( ( rule__DataStore__InflowsAssignment_6_3_1 ) ) )
            // InternalSecDFD.g:6686:1: ( ( rule__DataStore__InflowsAssignment_6_3_1 ) )
            {
            // InternalSecDFD.g:6686:1: ( ( rule__DataStore__InflowsAssignment_6_3_1 ) )
            // InternalSecDFD.g:6687:2: ( rule__DataStore__InflowsAssignment_6_3_1 )
            {
             before(grammarAccess.getDataStoreAccess().getInflowsAssignment_6_3_1()); 
            // InternalSecDFD.g:6688:2: ( rule__DataStore__InflowsAssignment_6_3_1 )
            // InternalSecDFD.g:6688:3: rule__DataStore__InflowsAssignment_6_3_1
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
    // InternalSecDFD.g:6697:1: rule__DataStore__Group_7__0 : rule__DataStore__Group_7__0__Impl rule__DataStore__Group_7__1 ;
    public final void rule__DataStore__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6701:1: ( rule__DataStore__Group_7__0__Impl rule__DataStore__Group_7__1 )
            // InternalSecDFD.g:6702:2: rule__DataStore__Group_7__0__Impl rule__DataStore__Group_7__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalSecDFD.g:6709:1: rule__DataStore__Group_7__0__Impl : ( 'outgoing' ) ;
    public final void rule__DataStore__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6713:1: ( ( 'outgoing' ) )
            // InternalSecDFD.g:6714:1: ( 'outgoing' )
            {
            // InternalSecDFD.g:6714:1: ( 'outgoing' )
            // InternalSecDFD.g:6715:2: 'outgoing'
            {
             before(grammarAccess.getDataStoreAccess().getOutgoingKeyword_7_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalSecDFD.g:6724:1: rule__DataStore__Group_7__1 : rule__DataStore__Group_7__1__Impl rule__DataStore__Group_7__2 ;
    public final void rule__DataStore__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6728:1: ( rule__DataStore__Group_7__1__Impl rule__DataStore__Group_7__2 )
            // InternalSecDFD.g:6729:2: rule__DataStore__Group_7__1__Impl rule__DataStore__Group_7__2
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
    // InternalSecDFD.g:6736:1: rule__DataStore__Group_7__1__Impl : ( 'flows:' ) ;
    public final void rule__DataStore__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6740:1: ( ( 'flows:' ) )
            // InternalSecDFD.g:6741:1: ( 'flows:' )
            {
            // InternalSecDFD.g:6741:1: ( 'flows:' )
            // InternalSecDFD.g:6742:2: 'flows:'
            {
             before(grammarAccess.getDataStoreAccess().getFlowsKeyword_7_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalSecDFD.g:6751:1: rule__DataStore__Group_7__2 : rule__DataStore__Group_7__2__Impl rule__DataStore__Group_7__3 ;
    public final void rule__DataStore__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6755:1: ( rule__DataStore__Group_7__2__Impl rule__DataStore__Group_7__3 )
            // InternalSecDFD.g:6756:2: rule__DataStore__Group_7__2__Impl rule__DataStore__Group_7__3
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
    // InternalSecDFD.g:6763:1: rule__DataStore__Group_7__2__Impl : ( ( rule__DataStore__OutflowsAssignment_7_2 ) ) ;
    public final void rule__DataStore__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6767:1: ( ( ( rule__DataStore__OutflowsAssignment_7_2 ) ) )
            // InternalSecDFD.g:6768:1: ( ( rule__DataStore__OutflowsAssignment_7_2 ) )
            {
            // InternalSecDFD.g:6768:1: ( ( rule__DataStore__OutflowsAssignment_7_2 ) )
            // InternalSecDFD.g:6769:2: ( rule__DataStore__OutflowsAssignment_7_2 )
            {
             before(grammarAccess.getDataStoreAccess().getOutflowsAssignment_7_2()); 
            // InternalSecDFD.g:6770:2: ( rule__DataStore__OutflowsAssignment_7_2 )
            // InternalSecDFD.g:6770:3: rule__DataStore__OutflowsAssignment_7_2
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
    // InternalSecDFD.g:6778:1: rule__DataStore__Group_7__3 : rule__DataStore__Group_7__3__Impl ;
    public final void rule__DataStore__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6782:1: ( rule__DataStore__Group_7__3__Impl )
            // InternalSecDFD.g:6783:2: rule__DataStore__Group_7__3__Impl
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
    // InternalSecDFD.g:6789:1: rule__DataStore__Group_7__3__Impl : ( ( rule__DataStore__Group_7_3__0 )* ) ;
    public final void rule__DataStore__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6793:1: ( ( ( rule__DataStore__Group_7_3__0 )* ) )
            // InternalSecDFD.g:6794:1: ( ( rule__DataStore__Group_7_3__0 )* )
            {
            // InternalSecDFD.g:6794:1: ( ( rule__DataStore__Group_7_3__0 )* )
            // InternalSecDFD.g:6795:2: ( rule__DataStore__Group_7_3__0 )*
            {
             before(grammarAccess.getDataStoreAccess().getGroup_7_3()); 
            // InternalSecDFD.g:6796:2: ( rule__DataStore__Group_7_3__0 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==47) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalSecDFD.g:6796:3: rule__DataStore__Group_7_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__DataStore__Group_7_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop68;
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
    // InternalSecDFD.g:6805:1: rule__DataStore__Group_7_3__0 : rule__DataStore__Group_7_3__0__Impl rule__DataStore__Group_7_3__1 ;
    public final void rule__DataStore__Group_7_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6809:1: ( rule__DataStore__Group_7_3__0__Impl rule__DataStore__Group_7_3__1 )
            // InternalSecDFD.g:6810:2: rule__DataStore__Group_7_3__0__Impl rule__DataStore__Group_7_3__1
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
    // InternalSecDFD.g:6817:1: rule__DataStore__Group_7_3__0__Impl : ( ',' ) ;
    public final void rule__DataStore__Group_7_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6821:1: ( ( ',' ) )
            // InternalSecDFD.g:6822:1: ( ',' )
            {
            // InternalSecDFD.g:6822:1: ( ',' )
            // InternalSecDFD.g:6823:2: ','
            {
             before(grammarAccess.getDataStoreAccess().getCommaKeyword_7_3_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:6832:1: rule__DataStore__Group_7_3__1 : rule__DataStore__Group_7_3__1__Impl ;
    public final void rule__DataStore__Group_7_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6836:1: ( rule__DataStore__Group_7_3__1__Impl )
            // InternalSecDFD.g:6837:2: rule__DataStore__Group_7_3__1__Impl
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
    // InternalSecDFD.g:6843:1: rule__DataStore__Group_7_3__1__Impl : ( ( rule__DataStore__OutflowsAssignment_7_3_1 ) ) ;
    public final void rule__DataStore__Group_7_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6847:1: ( ( ( rule__DataStore__OutflowsAssignment_7_3_1 ) ) )
            // InternalSecDFD.g:6848:1: ( ( rule__DataStore__OutflowsAssignment_7_3_1 ) )
            {
            // InternalSecDFD.g:6848:1: ( ( rule__DataStore__OutflowsAssignment_7_3_1 ) )
            // InternalSecDFD.g:6849:2: ( rule__DataStore__OutflowsAssignment_7_3_1 )
            {
             before(grammarAccess.getDataStoreAccess().getOutflowsAssignment_7_3_1()); 
            // InternalSecDFD.g:6850:2: ( rule__DataStore__OutflowsAssignment_7_3_1 )
            // InternalSecDFD.g:6850:3: rule__DataStore__OutflowsAssignment_7_3_1
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
    // InternalSecDFD.g:6859:1: rule__DataStore__Group_8__0 : rule__DataStore__Group_8__0__Impl rule__DataStore__Group_8__1 ;
    public final void rule__DataStore__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6863:1: ( rule__DataStore__Group_8__0__Impl rule__DataStore__Group_8__1 )
            // InternalSecDFD.g:6864:2: rule__DataStore__Group_8__0__Impl rule__DataStore__Group_8__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalSecDFD.g:6871:1: rule__DataStore__Group_8__0__Impl : ( 'attacker:' ) ;
    public final void rule__DataStore__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6875:1: ( ( 'attacker:' ) )
            // InternalSecDFD.g:6876:1: ( 'attacker:' )
            {
            // InternalSecDFD.g:6876:1: ( 'attacker:' )
            // InternalSecDFD.g:6877:2: 'attacker:'
            {
             before(grammarAccess.getDataStoreAccess().getAttackerKeyword_8_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalSecDFD.g:6886:1: rule__DataStore__Group_8__1 : rule__DataStore__Group_8__1__Impl ;
    public final void rule__DataStore__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6890:1: ( rule__DataStore__Group_8__1__Impl )
            // InternalSecDFD.g:6891:2: rule__DataStore__Group_8__1__Impl
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
    // InternalSecDFD.g:6897:1: rule__DataStore__Group_8__1__Impl : ( ( rule__DataStore__AttackerAssignment_8_1 ) ) ;
    public final void rule__DataStore__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6901:1: ( ( ( rule__DataStore__AttackerAssignment_8_1 ) ) )
            // InternalSecDFD.g:6902:1: ( ( rule__DataStore__AttackerAssignment_8_1 ) )
            {
            // InternalSecDFD.g:6902:1: ( ( rule__DataStore__AttackerAssignment_8_1 ) )
            // InternalSecDFD.g:6903:2: ( rule__DataStore__AttackerAssignment_8_1 )
            {
             before(grammarAccess.getDataStoreAccess().getAttackerAssignment_8_1()); 
            // InternalSecDFD.g:6904:2: ( rule__DataStore__AttackerAssignment_8_1 )
            // InternalSecDFD.g:6904:3: rule__DataStore__AttackerAssignment_8_1
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
    // InternalSecDFD.g:6913:1: rule__Value__Group__0 : rule__Value__Group__0__Impl rule__Value__Group__1 ;
    public final void rule__Value__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6917:1: ( rule__Value__Group__0__Impl rule__Value__Group__1 )
            // InternalSecDFD.g:6918:2: rule__Value__Group__0__Impl rule__Value__Group__1
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
    // InternalSecDFD.g:6925:1: rule__Value__Group__0__Impl : ( () ) ;
    public final void rule__Value__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6929:1: ( ( () ) )
            // InternalSecDFD.g:6930:1: ( () )
            {
            // InternalSecDFD.g:6930:1: ( () )
            // InternalSecDFD.g:6931:2: ()
            {
             before(grammarAccess.getValueAccess().getValueAction_0()); 
            // InternalSecDFD.g:6932:2: ()
            // InternalSecDFD.g:6932:3: 
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
    // InternalSecDFD.g:6940:1: rule__Value__Group__1 : rule__Value__Group__1__Impl rule__Value__Group__2 ;
    public final void rule__Value__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6944:1: ( rule__Value__Group__1__Impl rule__Value__Group__2 )
            // InternalSecDFD.g:6945:2: rule__Value__Group__1__Impl rule__Value__Group__2
            {
            pushFollow(FOLLOW_33);
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
    // InternalSecDFD.g:6952:1: rule__Value__Group__1__Impl : ( '[' ) ;
    public final void rule__Value__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6956:1: ( ( '[' ) )
            // InternalSecDFD.g:6957:1: ( '[' )
            {
            // InternalSecDFD.g:6957:1: ( '[' )
            // InternalSecDFD.g:6958:2: '['
            {
             before(grammarAccess.getValueAccess().getLeftSquareBracketKeyword_1()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:6967:1: rule__Value__Group__2 : rule__Value__Group__2__Impl rule__Value__Group__3 ;
    public final void rule__Value__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6971:1: ( rule__Value__Group__2__Impl rule__Value__Group__3 )
            // InternalSecDFD.g:6972:2: rule__Value__Group__2__Impl rule__Value__Group__3
            {
            pushFollow(FOLLOW_33);
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
    // InternalSecDFD.g:6979:1: rule__Value__Group__2__Impl : ( ( rule__Value__PriorityAssignment_2 )? ) ;
    public final void rule__Value__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6983:1: ( ( ( rule__Value__PriorityAssignment_2 )? ) )
            // InternalSecDFD.g:6984:1: ( ( rule__Value__PriorityAssignment_2 )? )
            {
            // InternalSecDFD.g:6984:1: ( ( rule__Value__PriorityAssignment_2 )? )
            // InternalSecDFD.g:6985:2: ( rule__Value__PriorityAssignment_2 )?
            {
             before(grammarAccess.getValueAccess().getPriorityAssignment_2()); 
            // InternalSecDFD.g:6986:2: ( rule__Value__PriorityAssignment_2 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=13 && LA69_0<=15)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalSecDFD.g:6986:3: rule__Value__PriorityAssignment_2
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
    // InternalSecDFD.g:6994:1: rule__Value__Group__3 : rule__Value__Group__3__Impl rule__Value__Group__4 ;
    public final void rule__Value__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:6998:1: ( rule__Value__Group__3__Impl rule__Value__Group__4 )
            // InternalSecDFD.g:6999:2: rule__Value__Group__3__Impl rule__Value__Group__4
            {
            pushFollow(FOLLOW_33);
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
    // InternalSecDFD.g:7006:1: rule__Value__Group__3__Impl : ( ( rule__Value__ObjectiveAssignment_3 )? ) ;
    public final void rule__Value__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7010:1: ( ( ( rule__Value__ObjectiveAssignment_3 )? ) )
            // InternalSecDFD.g:7011:1: ( ( rule__Value__ObjectiveAssignment_3 )? )
            {
            // InternalSecDFD.g:7011:1: ( ( rule__Value__ObjectiveAssignment_3 )? )
            // InternalSecDFD.g:7012:2: ( rule__Value__ObjectiveAssignment_3 )?
            {
             before(grammarAccess.getValueAccess().getObjectiveAssignment_3()); 
            // InternalSecDFD.g:7013:2: ( rule__Value__ObjectiveAssignment_3 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=16 && LA70_0<=19)) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalSecDFD.g:7013:3: rule__Value__ObjectiveAssignment_3
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
    // InternalSecDFD.g:7021:1: rule__Value__Group__4 : rule__Value__Group__4__Impl ;
    public final void rule__Value__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7025:1: ( rule__Value__Group__4__Impl )
            // InternalSecDFD.g:7026:2: rule__Value__Group__4__Impl
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
    // InternalSecDFD.g:7032:1: rule__Value__Group__4__Impl : ( ']' ) ;
    public final void rule__Value__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7036:1: ( ( ']' ) )
            // InternalSecDFD.g:7037:1: ( ']' )
            {
            // InternalSecDFD.g:7037:1: ( ']' )
            // InternalSecDFD.g:7038:2: ']'
            {
             before(grammarAccess.getValueAccess().getRightSquareBracketKeyword_4()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:7048:1: rule__Assumption__Group__0 : rule__Assumption__Group__0__Impl rule__Assumption__Group__1 ;
    public final void rule__Assumption__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7052:1: ( rule__Assumption__Group__0__Impl rule__Assumption__Group__1 )
            // InternalSecDFD.g:7053:2: rule__Assumption__Group__0__Impl rule__Assumption__Group__1
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
    // InternalSecDFD.g:7060:1: rule__Assumption__Group__0__Impl : ( () ) ;
    public final void rule__Assumption__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7064:1: ( ( () ) )
            // InternalSecDFD.g:7065:1: ( () )
            {
            // InternalSecDFD.g:7065:1: ( () )
            // InternalSecDFD.g:7066:2: ()
            {
             before(grammarAccess.getAssumptionAccess().getAssumptionAction_0()); 
            // InternalSecDFD.g:7067:2: ()
            // InternalSecDFD.g:7067:3: 
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
    // InternalSecDFD.g:7075:1: rule__Assumption__Group__1 : rule__Assumption__Group__1__Impl rule__Assumption__Group__2 ;
    public final void rule__Assumption__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7079:1: ( rule__Assumption__Group__1__Impl rule__Assumption__Group__2 )
            // InternalSecDFD.g:7080:2: rule__Assumption__Group__1__Impl rule__Assumption__Group__2
            {
            pushFollow(FOLLOW_34);
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
    // InternalSecDFD.g:7087:1: rule__Assumption__Group__1__Impl : ( '[' ) ;
    public final void rule__Assumption__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7091:1: ( ( '[' ) )
            // InternalSecDFD.g:7092:1: ( '[' )
            {
            // InternalSecDFD.g:7092:1: ( '[' )
            // InternalSecDFD.g:7093:2: '['
            {
             before(grammarAccess.getAssumptionAccess().getLeftSquareBracketKeyword_1()); 
            match(input,44,FOLLOW_2); 
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
    // InternalSecDFD.g:7102:1: rule__Assumption__Group__2 : rule__Assumption__Group__2__Impl rule__Assumption__Group__3 ;
    public final void rule__Assumption__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7106:1: ( rule__Assumption__Group__2__Impl rule__Assumption__Group__3 )
            // InternalSecDFD.g:7107:2: rule__Assumption__Group__2__Impl rule__Assumption__Group__3
            {
            pushFollow(FOLLOW_34);
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
    // InternalSecDFD.g:7114:1: rule__Assumption__Group__2__Impl : ( ( rule__Assumption__Group_2__0 )? ) ;
    public final void rule__Assumption__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7118:1: ( ( ( rule__Assumption__Group_2__0 )? ) )
            // InternalSecDFD.g:7119:1: ( ( rule__Assumption__Group_2__0 )? )
            {
            // InternalSecDFD.g:7119:1: ( ( rule__Assumption__Group_2__0 )? )
            // InternalSecDFD.g:7120:2: ( rule__Assumption__Group_2__0 )?
            {
             before(grammarAccess.getAssumptionAccess().getGroup_2()); 
            // InternalSecDFD.g:7121:2: ( rule__Assumption__Group_2__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=16 && LA71_0<=19)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalSecDFD.g:7121:3: rule__Assumption__Group_2__0
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
    // InternalSecDFD.g:7129:1: rule__Assumption__Group__3 : rule__Assumption__Group__3__Impl rule__Assumption__Group__4 ;
    public final void rule__Assumption__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7133:1: ( rule__Assumption__Group__3__Impl rule__Assumption__Group__4 )
            // InternalSecDFD.g:7134:2: rule__Assumption__Group__3__Impl rule__Assumption__Group__4
            {
            pushFollow(FOLLOW_34);
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
    // InternalSecDFD.g:7141:1: rule__Assumption__Group__3__Impl : ( ( rule__Assumption__Group_3__0 )? ) ;
    public final void rule__Assumption__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7145:1: ( ( ( rule__Assumption__Group_3__0 )? ) )
            // InternalSecDFD.g:7146:1: ( ( rule__Assumption__Group_3__0 )? )
            {
            // InternalSecDFD.g:7146:1: ( ( rule__Assumption__Group_3__0 )? )
            // InternalSecDFD.g:7147:2: ( rule__Assumption__Group_3__0 )?
            {
             before(grammarAccess.getAssumptionAccess().getGroup_3()); 
            // InternalSecDFD.g:7148:2: ( rule__Assumption__Group_3__0 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==72) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalSecDFD.g:7148:3: rule__Assumption__Group_3__0
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
    // InternalSecDFD.g:7156:1: rule__Assumption__Group__4 : rule__Assumption__Group__4__Impl ;
    public final void rule__Assumption__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7160:1: ( rule__Assumption__Group__4__Impl )
            // InternalSecDFD.g:7161:2: rule__Assumption__Group__4__Impl
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
    // InternalSecDFD.g:7167:1: rule__Assumption__Group__4__Impl : ( ']' ) ;
    public final void rule__Assumption__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7171:1: ( ( ']' ) )
            // InternalSecDFD.g:7172:1: ( ']' )
            {
            // InternalSecDFD.g:7172:1: ( ']' )
            // InternalSecDFD.g:7173:2: ']'
            {
             before(grammarAccess.getAssumptionAccess().getRightSquareBracketKeyword_4()); 
            match(input,45,FOLLOW_2); 
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
    // InternalSecDFD.g:7183:1: rule__Assumption__Group_2__0 : rule__Assumption__Group_2__0__Impl rule__Assumption__Group_2__1 ;
    public final void rule__Assumption__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7187:1: ( rule__Assumption__Group_2__0__Impl rule__Assumption__Group_2__1 )
            // InternalSecDFD.g:7188:2: rule__Assumption__Group_2__0__Impl rule__Assumption__Group_2__1
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
    // InternalSecDFD.g:7195:1: rule__Assumption__Group_2__0__Impl : ( ( rule__Assumption__ObjectiveAssignment_2_0 ) ) ;
    public final void rule__Assumption__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7199:1: ( ( ( rule__Assumption__ObjectiveAssignment_2_0 ) ) )
            // InternalSecDFD.g:7200:1: ( ( rule__Assumption__ObjectiveAssignment_2_0 ) )
            {
            // InternalSecDFD.g:7200:1: ( ( rule__Assumption__ObjectiveAssignment_2_0 ) )
            // InternalSecDFD.g:7201:2: ( rule__Assumption__ObjectiveAssignment_2_0 )
            {
             before(grammarAccess.getAssumptionAccess().getObjectiveAssignment_2_0()); 
            // InternalSecDFD.g:7202:2: ( rule__Assumption__ObjectiveAssignment_2_0 )
            // InternalSecDFD.g:7202:3: rule__Assumption__ObjectiveAssignment_2_0
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
    // InternalSecDFD.g:7210:1: rule__Assumption__Group_2__1 : rule__Assumption__Group_2__1__Impl ;
    public final void rule__Assumption__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7214:1: ( rule__Assumption__Group_2__1__Impl )
            // InternalSecDFD.g:7215:2: rule__Assumption__Group_2__1__Impl
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
    // InternalSecDFD.g:7221:1: rule__Assumption__Group_2__1__Impl : ( ( rule__Assumption__Group_2_1__0 )* ) ;
    public final void rule__Assumption__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7225:1: ( ( ( rule__Assumption__Group_2_1__0 )* ) )
            // InternalSecDFD.g:7226:1: ( ( rule__Assumption__Group_2_1__0 )* )
            {
            // InternalSecDFD.g:7226:1: ( ( rule__Assumption__Group_2_1__0 )* )
            // InternalSecDFD.g:7227:2: ( rule__Assumption__Group_2_1__0 )*
            {
             before(grammarAccess.getAssumptionAccess().getGroup_2_1()); 
            // InternalSecDFD.g:7228:2: ( rule__Assumption__Group_2_1__0 )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==47) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalSecDFD.g:7228:3: rule__Assumption__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Assumption__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop73;
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
    // InternalSecDFD.g:7237:1: rule__Assumption__Group_2_1__0 : rule__Assumption__Group_2_1__0__Impl rule__Assumption__Group_2_1__1 ;
    public final void rule__Assumption__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7241:1: ( rule__Assumption__Group_2_1__0__Impl rule__Assumption__Group_2_1__1 )
            // InternalSecDFD.g:7242:2: rule__Assumption__Group_2_1__0__Impl rule__Assumption__Group_2_1__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalSecDFD.g:7249:1: rule__Assumption__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__Assumption__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7253:1: ( ( ',' ) )
            // InternalSecDFD.g:7254:1: ( ',' )
            {
            // InternalSecDFD.g:7254:1: ( ',' )
            // InternalSecDFD.g:7255:2: ','
            {
             before(grammarAccess.getAssumptionAccess().getCommaKeyword_2_1_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalSecDFD.g:7264:1: rule__Assumption__Group_2_1__1 : rule__Assumption__Group_2_1__1__Impl ;
    public final void rule__Assumption__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7268:1: ( rule__Assumption__Group_2_1__1__Impl )
            // InternalSecDFD.g:7269:2: rule__Assumption__Group_2_1__1__Impl
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
    // InternalSecDFD.g:7275:1: rule__Assumption__Group_2_1__1__Impl : ( ( rule__Assumption__ObjectiveAssignment_2_1_1 ) ) ;
    public final void rule__Assumption__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7279:1: ( ( ( rule__Assumption__ObjectiveAssignment_2_1_1 ) ) )
            // InternalSecDFD.g:7280:1: ( ( rule__Assumption__ObjectiveAssignment_2_1_1 ) )
            {
            // InternalSecDFD.g:7280:1: ( ( rule__Assumption__ObjectiveAssignment_2_1_1 ) )
            // InternalSecDFD.g:7281:2: ( rule__Assumption__ObjectiveAssignment_2_1_1 )
            {
             before(grammarAccess.getAssumptionAccess().getObjectiveAssignment_2_1_1()); 
            // InternalSecDFD.g:7282:2: ( rule__Assumption__ObjectiveAssignment_2_1_1 )
            // InternalSecDFD.g:7282:3: rule__Assumption__ObjectiveAssignment_2_1_1
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
    // InternalSecDFD.g:7291:1: rule__Assumption__Group_3__0 : rule__Assumption__Group_3__0__Impl rule__Assumption__Group_3__1 ;
    public final void rule__Assumption__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7295:1: ( rule__Assumption__Group_3__0__Impl rule__Assumption__Group_3__1 )
            // InternalSecDFD.g:7296:2: rule__Assumption__Group_3__0__Impl rule__Assumption__Group_3__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalSecDFD.g:7303:1: rule__Assumption__Group_3__0__Impl : ( 'layer:' ) ;
    public final void rule__Assumption__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7307:1: ( ( 'layer:' ) )
            // InternalSecDFD.g:7308:1: ( 'layer:' )
            {
            // InternalSecDFD.g:7308:1: ( 'layer:' )
            // InternalSecDFD.g:7309:2: 'layer:'
            {
             before(grammarAccess.getAssumptionAccess().getLayerKeyword_3_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalSecDFD.g:7318:1: rule__Assumption__Group_3__1 : rule__Assumption__Group_3__1__Impl ;
    public final void rule__Assumption__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7322:1: ( rule__Assumption__Group_3__1__Impl )
            // InternalSecDFD.g:7323:2: rule__Assumption__Group_3__1__Impl
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
    // InternalSecDFD.g:7329:1: rule__Assumption__Group_3__1__Impl : ( ( rule__Assumption__LayerAssignment_3_1 ) ) ;
    public final void rule__Assumption__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7333:1: ( ( ( rule__Assumption__LayerAssignment_3_1 ) ) )
            // InternalSecDFD.g:7334:1: ( ( rule__Assumption__LayerAssignment_3_1 ) )
            {
            // InternalSecDFD.g:7334:1: ( ( rule__Assumption__LayerAssignment_3_1 ) )
            // InternalSecDFD.g:7335:2: ( rule__Assumption__LayerAssignment_3_1 )
            {
             before(grammarAccess.getAssumptionAccess().getLayerAssignment_3_1()); 
            // InternalSecDFD.g:7336:2: ( rule__Assumption__LayerAssignment_3_1 )
            // InternalSecDFD.g:7336:3: rule__Assumption__LayerAssignment_3_1
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
    // InternalSecDFD.g:7345:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7349:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalSecDFD.g:7350:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
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
    // InternalSecDFD.g:7357:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7361:1: ( ( ( '-' )? ) )
            // InternalSecDFD.g:7362:1: ( ( '-' )? )
            {
            // InternalSecDFD.g:7362:1: ( ( '-' )? )
            // InternalSecDFD.g:7363:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalSecDFD.g:7364:2: ( '-' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==73) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalSecDFD.g:7364:3: '-'
                    {
                    match(input,73,FOLLOW_2); 

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
    // InternalSecDFD.g:7372:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7376:1: ( rule__EInt__Group__1__Impl )
            // InternalSecDFD.g:7377:2: rule__EInt__Group__1__Impl
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
    // InternalSecDFD.g:7383:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7387:1: ( ( RULE_INT ) )
            // InternalSecDFD.g:7388:1: ( RULE_INT )
            {
            // InternalSecDFD.g:7388:1: ( RULE_INT )
            // InternalSecDFD.g:7389:2: RULE_INT
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
    // InternalSecDFD.g:7399:1: rule__EDFD__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__EDFD__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7403:1: ( ( ruleEString ) )
            // InternalSecDFD.g:7404:2: ( ruleEString )
            {
            // InternalSecDFD.g:7404:2: ( ruleEString )
            // InternalSecDFD.g:7405:3: ruleEString
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
    // InternalSecDFD.g:7414:1: rule__EDFD__AssetAssignment_4_1 : ( ruleAsset ) ;
    public final void rule__EDFD__AssetAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7418:1: ( ( ruleAsset ) )
            // InternalSecDFD.g:7419:2: ( ruleAsset )
            {
            // InternalSecDFD.g:7419:2: ( ruleAsset )
            // InternalSecDFD.g:7420:3: ruleAsset
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
    // InternalSecDFD.g:7429:1: rule__EDFD__AssetAssignment_4_2_1 : ( ruleAsset ) ;
    public final void rule__EDFD__AssetAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7433:1: ( ( ruleAsset ) )
            // InternalSecDFD.g:7434:2: ( ruleAsset )
            {
            // InternalSecDFD.g:7434:2: ( ruleAsset )
            // InternalSecDFD.g:7435:3: ruleAsset
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
    // InternalSecDFD.g:7444:1: rule__EDFD__ElementsAssignment_5_1 : ( ruleElement ) ;
    public final void rule__EDFD__ElementsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7448:1: ( ( ruleElement ) )
            // InternalSecDFD.g:7449:2: ( ruleElement )
            {
            // InternalSecDFD.g:7449:2: ( ruleElement )
            // InternalSecDFD.g:7450:3: ruleElement
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
    // InternalSecDFD.g:7459:1: rule__EDFD__ElementsAssignment_5_2_1 : ( ruleElement ) ;
    public final void rule__EDFD__ElementsAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7463:1: ( ( ruleElement ) )
            // InternalSecDFD.g:7464:2: ( ruleElement )
            {
            // InternalSecDFD.g:7464:2: ( ruleElement )
            // InternalSecDFD.g:7465:3: ruleElement
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
    // InternalSecDFD.g:7474:1: rule__EDFD__TrustzonesAssignment_6_2 : ( ruleTrustZone ) ;
    public final void rule__EDFD__TrustzonesAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7478:1: ( ( ruleTrustZone ) )
            // InternalSecDFD.g:7479:2: ( ruleTrustZone )
            {
            // InternalSecDFD.g:7479:2: ( ruleTrustZone )
            // InternalSecDFD.g:7480:3: ruleTrustZone
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
    // InternalSecDFD.g:7489:1: rule__EDFD__TrustzonesAssignment_6_3_1 : ( ruleTrustZone ) ;
    public final void rule__EDFD__TrustzonesAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7493:1: ( ( ruleTrustZone ) )
            // InternalSecDFD.g:7494:2: ( ruleTrustZone )
            {
            // InternalSecDFD.g:7494:2: ( ruleTrustZone )
            // InternalSecDFD.g:7495:3: ruleTrustZone
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
    // InternalSecDFD.g:7504:1: rule__TrustZone__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__TrustZone__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7508:1: ( ( ruleEString ) )
            // InternalSecDFD.g:7509:2: ( ruleEString )
            {
            // InternalSecDFD.g:7509:2: ( ruleEString )
            // InternalSecDFD.g:7510:3: ruleEString
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
    // InternalSecDFD.g:7519:1: rule__TrustZone__AttackerprofileAssignment_3_2 : ( ruleAttackerProfile ) ;
    public final void rule__TrustZone__AttackerprofileAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7523:1: ( ( ruleAttackerProfile ) )
            // InternalSecDFD.g:7524:2: ( ruleAttackerProfile )
            {
            // InternalSecDFD.g:7524:2: ( ruleAttackerProfile )
            // InternalSecDFD.g:7525:3: ruleAttackerProfile
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
    // InternalSecDFD.g:7534:1: rule__TrustZone__AttackerprofileAssignment_3_3_1 : ( ruleAttackerProfile ) ;
    public final void rule__TrustZone__AttackerprofileAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7538:1: ( ( ruleAttackerProfile ) )
            // InternalSecDFD.g:7539:2: ( ruleAttackerProfile )
            {
            // InternalSecDFD.g:7539:2: ( ruleAttackerProfile )
            // InternalSecDFD.g:7540:3: ruleAttackerProfile
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
    // InternalSecDFD.g:7549:1: rule__TrustZone__ElementsAssignment_4_1 : ( ( ruleEString ) ) ;
    public final void rule__TrustZone__ElementsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7553:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7554:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7554:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7555:3: ( ruleEString )
            {
             before(grammarAccess.getTrustZoneAccess().getElementsElementCrossReference_4_1_0()); 
            // InternalSecDFD.g:7556:3: ( ruleEString )
            // InternalSecDFD.g:7557:4: ruleEString
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
    // InternalSecDFD.g:7568:1: rule__TrustZone__ElementsAssignment_4_2_1 : ( ( ruleEString ) ) ;
    public final void rule__TrustZone__ElementsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7572:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7573:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7573:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7574:3: ( ruleEString )
            {
             before(grammarAccess.getTrustZoneAccess().getElementsElementCrossReference_4_2_1_0()); 
            // InternalSecDFD.g:7575:3: ( ruleEString )
            // InternalSecDFD.g:7576:4: ruleEString
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
    // InternalSecDFD.g:7587:1: rule__TrustZone__SubzonesAssignment_5_1 : ( ruleTrustZone ) ;
    public final void rule__TrustZone__SubzonesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7591:1: ( ( ruleTrustZone ) )
            // InternalSecDFD.g:7592:2: ( ruleTrustZone )
            {
            // InternalSecDFD.g:7592:2: ( ruleTrustZone )
            // InternalSecDFD.g:7593:3: ruleTrustZone
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
    // InternalSecDFD.g:7602:1: rule__TrustZone__SubzonesAssignment_5_2_1 : ( ruleTrustZone ) ;
    public final void rule__TrustZone__SubzonesAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7606:1: ( ( ruleTrustZone ) )
            // InternalSecDFD.g:7607:2: ( ruleTrustZone )
            {
            // InternalSecDFD.g:7607:2: ( ruleTrustZone )
            // InternalSecDFD.g:7608:3: ruleTrustZone
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
    // InternalSecDFD.g:7617:1: rule__AttackerProfile__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__AttackerProfile__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7621:1: ( ( ruleEString ) )
            // InternalSecDFD.g:7622:2: ( ruleEString )
            {
            // InternalSecDFD.g:7622:2: ( ruleEString )
            // InternalSecDFD.g:7623:3: ruleEString
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
    // InternalSecDFD.g:7632:1: rule__AttackerProfile__ObservationAssignment_3_1 : ( ruleEInt ) ;
    public final void rule__AttackerProfile__ObservationAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7636:1: ( ( ruleEInt ) )
            // InternalSecDFD.g:7637:2: ( ruleEInt )
            {
            // InternalSecDFD.g:7637:2: ( ruleEInt )
            // InternalSecDFD.g:7638:3: ruleEInt
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
    // InternalSecDFD.g:7647:1: rule__Asset__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Asset__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7651:1: ( ( ruleEString ) )
            // InternalSecDFD.g:7652:2: ( ruleEString )
            {
            // InternalSecDFD.g:7652:2: ( ruleEString )
            // InternalSecDFD.g:7653:3: ruleEString
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


    // $ANTLR start "rule__Asset__TypeAssignment_4"
    // InternalSecDFD.g:7662:1: rule__Asset__TypeAssignment_4 : ( ruleAssetType ) ;
    public final void rule__Asset__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7666:1: ( ( ruleAssetType ) )
            // InternalSecDFD.g:7667:2: ( ruleAssetType )
            {
            // InternalSecDFD.g:7667:2: ( ruleAssetType )
            // InternalSecDFD.g:7668:3: ruleAssetType
            {
             before(grammarAccess.getAssetAccess().getTypeAssetTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleAssetType();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getTypeAssetTypeEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__TypeAssignment_4"


    // $ANTLR start "rule__Asset__ValueAssignment_5_1"
    // InternalSecDFD.g:7677:1: rule__Asset__ValueAssignment_5_1 : ( ruleValue ) ;
    public final void rule__Asset__ValueAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7681:1: ( ( ruleValue ) )
            // InternalSecDFD.g:7682:2: ( ruleValue )
            {
            // InternalSecDFD.g:7682:2: ( ruleValue )
            // InternalSecDFD.g:7683:3: ruleValue
            {
             before(grammarAccess.getAssetAccess().getValueValueParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getValueValueParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__ValueAssignment_5_1"


    // $ANTLR start "rule__Asset__ValueAssignment_5_2_1"
    // InternalSecDFD.g:7692:1: rule__Asset__ValueAssignment_5_2_1 : ( ruleValue ) ;
    public final void rule__Asset__ValueAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7696:1: ( ( ruleValue ) )
            // InternalSecDFD.g:7697:2: ( ruleValue )
            {
            // InternalSecDFD.g:7697:2: ( ruleValue )
            // InternalSecDFD.g:7698:3: ruleValue
            {
             before(grammarAccess.getAssetAccess().getValueValueParserRuleCall_5_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getValueValueParserRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__ValueAssignment_5_2_1"


    // $ANTLR start "rule__Asset__SourceAssignment_7"
    // InternalSecDFD.g:7707:1: rule__Asset__SourceAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__Asset__SourceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7711:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7712:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7712:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7713:3: ( ruleEString )
            {
             before(grammarAccess.getAssetAccess().getSourceElementCrossReference_7_0()); 
            // InternalSecDFD.g:7714:3: ( ruleEString )
            // InternalSecDFD.g:7715:4: ruleEString
            {
             before(grammarAccess.getAssetAccess().getSourceElementEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getSourceElementEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getAssetAccess().getSourceElementCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__SourceAssignment_7"


    // $ANTLR start "rule__Asset__TargetsAssignment_9"
    // InternalSecDFD.g:7726:1: rule__Asset__TargetsAssignment_9 : ( ( ruleEString ) ) ;
    public final void rule__Asset__TargetsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7730:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7731:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7731:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7732:3: ( ruleEString )
            {
             before(grammarAccess.getAssetAccess().getTargetsElementCrossReference_9_0()); 
            // InternalSecDFD.g:7733:3: ( ruleEString )
            // InternalSecDFD.g:7734:4: ruleEString
            {
             before(grammarAccess.getAssetAccess().getTargetsElementEStringParserRuleCall_9_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getTargetsElementEStringParserRuleCall_9_0_1()); 

            }

             after(grammarAccess.getAssetAccess().getTargetsElementCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__TargetsAssignment_9"


    // $ANTLR start "rule__Asset__TargetsAssignment_10_1"
    // InternalSecDFD.g:7745:1: rule__Asset__TargetsAssignment_10_1 : ( ( ruleEString ) ) ;
    public final void rule__Asset__TargetsAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7749:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7750:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7750:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7751:3: ( ruleEString )
            {
             before(grammarAccess.getAssetAccess().getTargetsElementCrossReference_10_1_0()); 
            // InternalSecDFD.g:7752:3: ( ruleEString )
            // InternalSecDFD.g:7753:4: ruleEString
            {
             before(grammarAccess.getAssetAccess().getTargetsElementEStringParserRuleCall_10_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssetAccess().getTargetsElementEStringParserRuleCall_10_1_0_1()); 

            }

             after(grammarAccess.getAssetAccess().getTargetsElementCrossReference_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Asset__TargetsAssignment_10_1"


    // $ANTLR start "rule__Process__NameAssignment_2"
    // InternalSecDFD.g:7764:1: rule__Process__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Process__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7768:1: ( ( ruleEString ) )
            // InternalSecDFD.g:7769:2: ( ruleEString )
            {
            // InternalSecDFD.g:7769:2: ( ruleEString )
            // InternalSecDFD.g:7770:3: ruleEString
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
    // InternalSecDFD.g:7779:1: rule__Process__ResponsibilityAssignment_4_1 : ( ruleResponsibility ) ;
    public final void rule__Process__ResponsibilityAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7783:1: ( ( ruleResponsibility ) )
            // InternalSecDFD.g:7784:2: ( ruleResponsibility )
            {
            // InternalSecDFD.g:7784:2: ( ruleResponsibility )
            // InternalSecDFD.g:7785:3: ruleResponsibility
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
    // InternalSecDFD.g:7794:1: rule__Process__ResponsibilityAssignment_4_2_1 : ( ruleResponsibility ) ;
    public final void rule__Process__ResponsibilityAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7798:1: ( ( ruleResponsibility ) )
            // InternalSecDFD.g:7799:2: ( ruleResponsibility )
            {
            // InternalSecDFD.g:7799:2: ( ruleResponsibility )
            // InternalSecDFD.g:7800:3: ruleResponsibility
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
    // InternalSecDFD.g:7809:1: rule__Process__AssetsAssignment_5_1 : ( ( ruleEString ) ) ;
    public final void rule__Process__AssetsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7813:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7814:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7814:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7815:3: ( ruleEString )
            {
             before(grammarAccess.getProcessAccess().getAssetsAssetCrossReference_5_1_0()); 
            // InternalSecDFD.g:7816:3: ( ruleEString )
            // InternalSecDFD.g:7817:4: ruleEString
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
    // InternalSecDFD.g:7828:1: rule__Process__AssetsAssignment_5_2_1 : ( ( ruleEString ) ) ;
    public final void rule__Process__AssetsAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7832:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7833:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7833:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7834:3: ( ruleEString )
            {
             before(grammarAccess.getProcessAccess().getAssetsAssetCrossReference_5_2_1_0()); 
            // InternalSecDFD.g:7835:3: ( ruleEString )
            // InternalSecDFD.g:7836:4: ruleEString
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
    // InternalSecDFD.g:7847:1: rule__Process__AssumptionAssignment_6_1 : ( ruleAssumption ) ;
    public final void rule__Process__AssumptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7851:1: ( ( ruleAssumption ) )
            // InternalSecDFD.g:7852:2: ( ruleAssumption )
            {
            // InternalSecDFD.g:7852:2: ( ruleAssumption )
            // InternalSecDFD.g:7853:3: ruleAssumption
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
    // InternalSecDFD.g:7862:1: rule__Process__AssumptionAssignment_6_2_1 : ( ruleAssumption ) ;
    public final void rule__Process__AssumptionAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7866:1: ( ( ruleAssumption ) )
            // InternalSecDFD.g:7867:2: ( ruleAssumption )
            {
            // InternalSecDFD.g:7867:2: ( ruleAssumption )
            // InternalSecDFD.g:7868:3: ruleAssumption
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
    // InternalSecDFD.g:7877:1: rule__Process__InflowsAssignment_7_2 : ( ( ruleEString ) ) ;
    public final void rule__Process__InflowsAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7881:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7882:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7882:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7883:3: ( ruleEString )
            {
             before(grammarAccess.getProcessAccess().getInflowsFlowCrossReference_7_2_0()); 
            // InternalSecDFD.g:7884:3: ( ruleEString )
            // InternalSecDFD.g:7885:4: ruleEString
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
    // InternalSecDFD.g:7896:1: rule__Process__InflowsAssignment_7_3_1 : ( ( ruleEString ) ) ;
    public final void rule__Process__InflowsAssignment_7_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7900:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7901:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7901:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7902:3: ( ruleEString )
            {
             before(grammarAccess.getProcessAccess().getInflowsFlowCrossReference_7_3_1_0()); 
            // InternalSecDFD.g:7903:3: ( ruleEString )
            // InternalSecDFD.g:7904:4: ruleEString
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
    // InternalSecDFD.g:7915:1: rule__Process__OutflowsAssignment_8_2 : ( ruleFlow ) ;
    public final void rule__Process__OutflowsAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7919:1: ( ( ruleFlow ) )
            // InternalSecDFD.g:7920:2: ( ruleFlow )
            {
            // InternalSecDFD.g:7920:2: ( ruleFlow )
            // InternalSecDFD.g:7921:3: ruleFlow
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
    // InternalSecDFD.g:7930:1: rule__Process__OutflowsAssignment_8_3_1 : ( ruleFlow ) ;
    public final void rule__Process__OutflowsAssignment_8_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7934:1: ( ( ruleFlow ) )
            // InternalSecDFD.g:7935:2: ( ruleFlow )
            {
            // InternalSecDFD.g:7935:2: ( ruleFlow )
            // InternalSecDFD.g:7936:3: ruleFlow
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
    // InternalSecDFD.g:7945:1: rule__Process__AttackerAssignment_9_1 : ( ruleEBoolean ) ;
    public final void rule__Process__AttackerAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7949:1: ( ( ruleEBoolean ) )
            // InternalSecDFD.g:7950:2: ( ruleEBoolean )
            {
            // InternalSecDFD.g:7950:2: ( ruleEBoolean )
            // InternalSecDFD.g:7951:3: ruleEBoolean
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
    // InternalSecDFD.g:7960:1: rule__Responsibility__IncomeassetsAssignment_2_0 : ( ( ruleEString ) ) ;
    public final void rule__Responsibility__IncomeassetsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7964:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7965:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7965:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7966:3: ( ruleEString )
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetCrossReference_2_0_0()); 
            // InternalSecDFD.g:7967:3: ( ruleEString )
            // InternalSecDFD.g:7968:4: ruleEString
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
    // InternalSecDFD.g:7979:1: rule__Responsibility__IncomeassetsAssignment_2_1_1 : ( ( ruleEString ) ) ;
    public final void rule__Responsibility__IncomeassetsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:7983:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:7984:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:7984:2: ( ( ruleEString ) )
            // InternalSecDFD.g:7985:3: ( ruleEString )
            {
             before(grammarAccess.getResponsibilityAccess().getIncomeassetsAssetCrossReference_2_1_1_0()); 
            // InternalSecDFD.g:7986:3: ( ruleEString )
            // InternalSecDFD.g:7987:4: ruleEString
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
    // InternalSecDFD.g:7998:1: rule__Responsibility__ActionAssignment_2_2 : ( ruleResponsibilityType ) ;
    public final void rule__Responsibility__ActionAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8002:1: ( ( ruleResponsibilityType ) )
            // InternalSecDFD.g:8003:2: ( ruleResponsibilityType )
            {
            // InternalSecDFD.g:8003:2: ( ruleResponsibilityType )
            // InternalSecDFD.g:8004:3: ruleResponsibilityType
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
    // InternalSecDFD.g:8013:1: rule__Responsibility__OutcomeassetsAssignment_2_4 : ( ( ruleEString ) ) ;
    public final void rule__Responsibility__OutcomeassetsAssignment_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8017:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8018:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8018:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8019:3: ( ruleEString )
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetCrossReference_2_4_0()); 
            // InternalSecDFD.g:8020:3: ( ruleEString )
            // InternalSecDFD.g:8021:4: ruleEString
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
    // InternalSecDFD.g:8032:1: rule__Responsibility__OutcomeassetsAssignment_2_5_1 : ( ( ruleEString ) ) ;
    public final void rule__Responsibility__OutcomeassetsAssignment_2_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8036:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8037:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8037:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8038:3: ( ruleEString )
            {
             before(grammarAccess.getResponsibilityAccess().getOutcomeassetsAssetCrossReference_2_5_1_0()); 
            // InternalSecDFD.g:8039:3: ( ruleEString )
            // InternalSecDFD.g:8040:4: ruleEString
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
    // InternalSecDFD.g:8051:1: rule__ExternalEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__ExternalEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8055:1: ( ( ruleEString ) )
            // InternalSecDFD.g:8056:2: ( ruleEString )
            {
            // InternalSecDFD.g:8056:2: ( ruleEString )
            // InternalSecDFD.g:8057:3: ruleEString
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
    // InternalSecDFD.g:8066:1: rule__ExternalEntity__AssetsAssignment_4_1 : ( ( ruleEString ) ) ;
    public final void rule__ExternalEntity__AssetsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8070:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8071:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8071:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8072:3: ( ruleEString )
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssetCrossReference_4_1_0()); 
            // InternalSecDFD.g:8073:3: ( ruleEString )
            // InternalSecDFD.g:8074:4: ruleEString
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
    // InternalSecDFD.g:8085:1: rule__ExternalEntity__AssetsAssignment_4_2_1 : ( ( ruleEString ) ) ;
    public final void rule__ExternalEntity__AssetsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8089:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8090:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8090:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8091:3: ( ruleEString )
            {
             before(grammarAccess.getExternalEntityAccess().getAssetsAssetCrossReference_4_2_1_0()); 
            // InternalSecDFD.g:8092:3: ( ruleEString )
            // InternalSecDFD.g:8093:4: ruleEString
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
    // InternalSecDFD.g:8104:1: rule__ExternalEntity__AssumptionAssignment_5_1 : ( ruleAssumption ) ;
    public final void rule__ExternalEntity__AssumptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8108:1: ( ( ruleAssumption ) )
            // InternalSecDFD.g:8109:2: ( ruleAssumption )
            {
            // InternalSecDFD.g:8109:2: ( ruleAssumption )
            // InternalSecDFD.g:8110:3: ruleAssumption
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
    // InternalSecDFD.g:8119:1: rule__ExternalEntity__AssumptionAssignment_5_2_1 : ( ruleAssumption ) ;
    public final void rule__ExternalEntity__AssumptionAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8123:1: ( ( ruleAssumption ) )
            // InternalSecDFD.g:8124:2: ( ruleAssumption )
            {
            // InternalSecDFD.g:8124:2: ( ruleAssumption )
            // InternalSecDFD.g:8125:3: ruleAssumption
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
    // InternalSecDFD.g:8134:1: rule__ExternalEntity__InflowsAssignment_6_2 : ( ( ruleEString ) ) ;
    public final void rule__ExternalEntity__InflowsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8138:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8139:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8139:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8140:3: ( ruleEString )
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsFlowCrossReference_6_2_0()); 
            // InternalSecDFD.g:8141:3: ( ruleEString )
            // InternalSecDFD.g:8142:4: ruleEString
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
    // InternalSecDFD.g:8153:1: rule__ExternalEntity__InflowsAssignment_6_3_1 : ( ( ruleEString ) ) ;
    public final void rule__ExternalEntity__InflowsAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8157:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8158:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8158:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8159:3: ( ruleEString )
            {
             before(grammarAccess.getExternalEntityAccess().getInflowsFlowCrossReference_6_3_1_0()); 
            // InternalSecDFD.g:8160:3: ( ruleEString )
            // InternalSecDFD.g:8161:4: ruleEString
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
    // InternalSecDFD.g:8172:1: rule__ExternalEntity__OutflowsAssignment_7_2 : ( ruleFlow ) ;
    public final void rule__ExternalEntity__OutflowsAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8176:1: ( ( ruleFlow ) )
            // InternalSecDFD.g:8177:2: ( ruleFlow )
            {
            // InternalSecDFD.g:8177:2: ( ruleFlow )
            // InternalSecDFD.g:8178:3: ruleFlow
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
    // InternalSecDFD.g:8187:1: rule__ExternalEntity__OutflowsAssignment_7_3_1 : ( ruleFlow ) ;
    public final void rule__ExternalEntity__OutflowsAssignment_7_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8191:1: ( ( ruleFlow ) )
            // InternalSecDFD.g:8192:2: ( ruleFlow )
            {
            // InternalSecDFD.g:8192:2: ( ruleFlow )
            // InternalSecDFD.g:8193:3: ruleFlow
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
    // InternalSecDFD.g:8202:1: rule__ExternalEntity__AttackerAssignment_8_1 : ( ruleEBoolean ) ;
    public final void rule__ExternalEntity__AttackerAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8206:1: ( ( ruleEBoolean ) )
            // InternalSecDFD.g:8207:2: ( ruleEBoolean )
            {
            // InternalSecDFD.g:8207:2: ( ruleEBoolean )
            // InternalSecDFD.g:8208:3: ruleEBoolean
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
    // InternalSecDFD.g:8217:1: rule__Flow__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Flow__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8221:1: ( ( ruleEString ) )
            // InternalSecDFD.g:8222:2: ( ruleEString )
            {
            // InternalSecDFD.g:8222:2: ( ruleEString )
            // InternalSecDFD.g:8223:3: ruleEString
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
    // InternalSecDFD.g:8232:1: rule__Flow__NumberAssignment_3_1 : ( ruleEInt ) ;
    public final void rule__Flow__NumberAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8236:1: ( ( ruleEInt ) )
            // InternalSecDFD.g:8237:2: ( ruleEInt )
            {
            // InternalSecDFD.g:8237:2: ( ruleEInt )
            // InternalSecDFD.g:8238:3: ruleEInt
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
    // InternalSecDFD.g:8247:1: rule__Flow__AssetsAssignment_4_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__AssetsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8251:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8252:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8252:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8253:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getAssetsAssetCrossReference_4_1_0()); 
            // InternalSecDFD.g:8254:3: ( ruleEString )
            // InternalSecDFD.g:8255:4: ruleEString
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
    // InternalSecDFD.g:8266:1: rule__Flow__AssetsAssignment_4_2_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__AssetsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8270:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8271:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8271:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8272:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getAssetsAssetCrossReference_4_2_1_0()); 
            // InternalSecDFD.g:8273:3: ( ruleEString )
            // InternalSecDFD.g:8274:4: ruleEString
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
    // InternalSecDFD.g:8285:1: rule__Flow__SourceAssignment_5_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__SourceAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8289:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8290:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8290:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8291:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getSourceElementCrossReference_5_1_0()); 
            // InternalSecDFD.g:8292:3: ( ruleEString )
            // InternalSecDFD.g:8293:4: ruleEString
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
    // InternalSecDFD.g:8304:1: rule__Flow__TargetAssignment_6_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__TargetAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8308:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8309:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8309:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8310:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getTargetElementCrossReference_6_1_0()); 
            // InternalSecDFD.g:8311:3: ( ruleEString )
            // InternalSecDFD.g:8312:4: ruleEString
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
    // InternalSecDFD.g:8323:1: rule__Flow__TargetAssignment_6_2_1 : ( ( ruleEString ) ) ;
    public final void rule__Flow__TargetAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8327:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8328:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8328:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8329:3: ( ruleEString )
            {
             before(grammarAccess.getFlowAccess().getTargetElementCrossReference_6_2_1_0()); 
            // InternalSecDFD.g:8330:3: ( ruleEString )
            // InternalSecDFD.g:8331:4: ruleEString
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
    // InternalSecDFD.g:8342:1: rule__Flow__ChannelAssignment_7_1 : ( ruleChannel ) ;
    public final void rule__Flow__ChannelAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8346:1: ( ( ruleChannel ) )
            // InternalSecDFD.g:8347:2: ( ruleChannel )
            {
            // InternalSecDFD.g:8347:2: ( ruleChannel )
            // InternalSecDFD.g:8348:3: ruleChannel
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
    // InternalSecDFD.g:8357:1: rule__Flow__AssumptionAssignment_8_1 : ( ruleAssumption ) ;
    public final void rule__Flow__AssumptionAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8361:1: ( ( ruleAssumption ) )
            // InternalSecDFD.g:8362:2: ( ruleAssumption )
            {
            // InternalSecDFD.g:8362:2: ( ruleAssumption )
            // InternalSecDFD.g:8363:3: ruleAssumption
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
    // InternalSecDFD.g:8372:1: rule__Flow__AssumptionAssignment_8_2_1 : ( ruleAssumption ) ;
    public final void rule__Flow__AssumptionAssignment_8_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8376:1: ( ( ruleAssumption ) )
            // InternalSecDFD.g:8377:2: ( ruleAssumption )
            {
            // InternalSecDFD.g:8377:2: ( ruleAssumption )
            // InternalSecDFD.g:8378:3: ruleAssumption
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
    // InternalSecDFD.g:8387:1: rule__DataStore__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__DataStore__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8391:1: ( ( ruleEString ) )
            // InternalSecDFD.g:8392:2: ( ruleEString )
            {
            // InternalSecDFD.g:8392:2: ( ruleEString )
            // InternalSecDFD.g:8393:3: ruleEString
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
    // InternalSecDFD.g:8402:1: rule__DataStore__AssetsAssignment_4_1 : ( ( ruleEString ) ) ;
    public final void rule__DataStore__AssetsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8406:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8407:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8407:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8408:3: ( ruleEString )
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssetCrossReference_4_1_0()); 
            // InternalSecDFD.g:8409:3: ( ruleEString )
            // InternalSecDFD.g:8410:4: ruleEString
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
    // InternalSecDFD.g:8421:1: rule__DataStore__AssetsAssignment_4_2_1 : ( ( ruleEString ) ) ;
    public final void rule__DataStore__AssetsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8425:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8426:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8426:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8427:3: ( ruleEString )
            {
             before(grammarAccess.getDataStoreAccess().getAssetsAssetCrossReference_4_2_1_0()); 
            // InternalSecDFD.g:8428:3: ( ruleEString )
            // InternalSecDFD.g:8429:4: ruleEString
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
    // InternalSecDFD.g:8440:1: rule__DataStore__AssumptionAssignment_5_1 : ( ruleAssumption ) ;
    public final void rule__DataStore__AssumptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8444:1: ( ( ruleAssumption ) )
            // InternalSecDFD.g:8445:2: ( ruleAssumption )
            {
            // InternalSecDFD.g:8445:2: ( ruleAssumption )
            // InternalSecDFD.g:8446:3: ruleAssumption
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
    // InternalSecDFD.g:8455:1: rule__DataStore__AssumptionAssignment_5_2_1 : ( ruleAssumption ) ;
    public final void rule__DataStore__AssumptionAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8459:1: ( ( ruleAssumption ) )
            // InternalSecDFD.g:8460:2: ( ruleAssumption )
            {
            // InternalSecDFD.g:8460:2: ( ruleAssumption )
            // InternalSecDFD.g:8461:3: ruleAssumption
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
    // InternalSecDFD.g:8470:1: rule__DataStore__InflowsAssignment_6_2 : ( ( ruleEString ) ) ;
    public final void rule__DataStore__InflowsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8474:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8475:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8475:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8476:3: ( ruleEString )
            {
             before(grammarAccess.getDataStoreAccess().getInflowsFlowCrossReference_6_2_0()); 
            // InternalSecDFD.g:8477:3: ( ruleEString )
            // InternalSecDFD.g:8478:4: ruleEString
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
    // InternalSecDFD.g:8489:1: rule__DataStore__InflowsAssignment_6_3_1 : ( ( ruleEString ) ) ;
    public final void rule__DataStore__InflowsAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8493:1: ( ( ( ruleEString ) ) )
            // InternalSecDFD.g:8494:2: ( ( ruleEString ) )
            {
            // InternalSecDFD.g:8494:2: ( ( ruleEString ) )
            // InternalSecDFD.g:8495:3: ( ruleEString )
            {
             before(grammarAccess.getDataStoreAccess().getInflowsFlowCrossReference_6_3_1_0()); 
            // InternalSecDFD.g:8496:3: ( ruleEString )
            // InternalSecDFD.g:8497:4: ruleEString
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
    // InternalSecDFD.g:8508:1: rule__DataStore__OutflowsAssignment_7_2 : ( ruleFlow ) ;
    public final void rule__DataStore__OutflowsAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8512:1: ( ( ruleFlow ) )
            // InternalSecDFD.g:8513:2: ( ruleFlow )
            {
            // InternalSecDFD.g:8513:2: ( ruleFlow )
            // InternalSecDFD.g:8514:3: ruleFlow
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
    // InternalSecDFD.g:8523:1: rule__DataStore__OutflowsAssignment_7_3_1 : ( ruleFlow ) ;
    public final void rule__DataStore__OutflowsAssignment_7_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8527:1: ( ( ruleFlow ) )
            // InternalSecDFD.g:8528:2: ( ruleFlow )
            {
            // InternalSecDFD.g:8528:2: ( ruleFlow )
            // InternalSecDFD.g:8529:3: ruleFlow
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
    // InternalSecDFD.g:8538:1: rule__DataStore__AttackerAssignment_8_1 : ( ruleEBoolean ) ;
    public final void rule__DataStore__AttackerAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8542:1: ( ( ruleEBoolean ) )
            // InternalSecDFD.g:8543:2: ( ruleEBoolean )
            {
            // InternalSecDFD.g:8543:2: ( ruleEBoolean )
            // InternalSecDFD.g:8544:3: ruleEBoolean
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
    // InternalSecDFD.g:8553:1: rule__Value__PriorityAssignment_2 : ( rulePriority ) ;
    public final void rule__Value__PriorityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8557:1: ( ( rulePriority ) )
            // InternalSecDFD.g:8558:2: ( rulePriority )
            {
            // InternalSecDFD.g:8558:2: ( rulePriority )
            // InternalSecDFD.g:8559:3: rulePriority
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
    // InternalSecDFD.g:8568:1: rule__Value__ObjectiveAssignment_3 : ( ruleObjective ) ;
    public final void rule__Value__ObjectiveAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8572:1: ( ( ruleObjective ) )
            // InternalSecDFD.g:8573:2: ( ruleObjective )
            {
            // InternalSecDFD.g:8573:2: ( ruleObjective )
            // InternalSecDFD.g:8574:3: ruleObjective
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
    // InternalSecDFD.g:8583:1: rule__Assumption__ObjectiveAssignment_2_0 : ( ruleObjective ) ;
    public final void rule__Assumption__ObjectiveAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8587:1: ( ( ruleObjective ) )
            // InternalSecDFD.g:8588:2: ( ruleObjective )
            {
            // InternalSecDFD.g:8588:2: ( ruleObjective )
            // InternalSecDFD.g:8589:3: ruleObjective
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
    // InternalSecDFD.g:8598:1: rule__Assumption__ObjectiveAssignment_2_1_1 : ( ruleObjective ) ;
    public final void rule__Assumption__ObjectiveAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8602:1: ( ( ruleObjective ) )
            // InternalSecDFD.g:8603:2: ( ruleObjective )
            {
            // InternalSecDFD.g:8603:2: ( ruleObjective )
            // InternalSecDFD.g:8604:3: ruleObjective
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
    // InternalSecDFD.g:8613:1: rule__Assumption__LayerAssignment_3_1 : ( ruleLayer ) ;
    public final void rule__Assumption__LayerAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSecDFD.g:8617:1: ( ( ruleLayer ) )
            // InternalSecDFD.g:8618:2: ( ruleLayer )
            {
            // InternalSecDFD.g:8618:2: ( ruleLayer )
            // InternalSecDFD.g:8619:3: ruleLayer
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0003600000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x1000000000000030L,0x0000000000000090L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0029200000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0040200000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000078000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0A00000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xE000600000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000A00FFF800030L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000800FFF800030L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000800000000030L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xC000600000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x4600600000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00002000000FE000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00002000000F0000L,0x0000000000000100L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000000000F0000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000700000L});

}